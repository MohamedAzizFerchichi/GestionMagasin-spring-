package tn.test.spring.Services.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Repository.StockRepository;
import tn.test.spring.Services.GServiceImp;
import tn.test.spring.Services.Produit.ProduitServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class StockServiceImp implements StockService {

    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProduitServiceImp produitServiceImp;

    @Override
    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void updateStock(Stock stock) {
        Stock stock1 = stockRepository.findById(stock.getIdStock()).get();
        stockRepository.save(stock);

    }

    @Override
    public void deleteStock(Integer id) {
        Stock stock = stockRepository.findById(id).get();
        stockRepository.delete(stock);

    }

    @Override
    public Stock getStock(Integer id) {
        Stock stock = stockRepository.findById(id).get();
        return stock;
    }

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getStockByProduit() {
        List<Produit> prods = produitServiceImp.retrieveAll();
        List<Stock> stocks = new ArrayList<>();
        for (Produit p : prods) {
            if (p.getStock() != null) {
                stocks.add(p.getStock());
            }
        }
    return stocks;
    }




    @Override
    @Scheduled(cron = " 0 00 22 ? * *" )
    public String retrieveStatusStock()  {
        String message  =" " ;
        List<Stock> stocks  = this.retrieveAllStocks() ;
        for(Stock stock :stocks) {
            if (stock.getQte() < stock.getQteMin()) {
                message = " la quantité disponible\n" +
                        "est inférieure à la quantité min toléré. \n"
                        + "pour le stock " + stock.getIdStock() + ":" + stock.getLibelleStock();
                System.out.println(message);
            }
        }

        return message ;
    }

    @Override
    public List<Produit> getProduitByStock(Integer idStock) {
        Stock stock = stockRepository.findById(idStock).get();
        Set<Produit> produits = stock.getProduits();
        List<Produit> produits1 = new ArrayList<>();
        for (Produit p : produits) {
            produits1.add(p);
        }
        return produits1;
    }

    @Override
    public List<Stock> getStockByFilter() {
      //get stock having qte > qteMin
        List<Stock> stocks = this.retrieveAllStocks();
        List<Stock> stocks1 = new ArrayList<>();
        for (Stock s : stocks) {
            if (s.getQte() > s.getQteMin()) {
                stocks1.add(s);
            }
        }
        return stocks1;
    }

    @Override
    public List<Stock> getStockByFilterInf() {
        //get stock having qte > qteMin
        List<Stock> stocks = this.retrieveAllStocks();
        List<Stock> stocks1 = new ArrayList<>();
        for (Stock s : stocks) {
            if (s.getQte() < s.getQteMin()) {
                stocks1.add(s);
            }
        }
        return stocks1;
    }


    @Override
    public List<Stock> getStockByFilter0() {
        //get stock having qte > qteMin
        List<Stock> stocks = this.retrieveAllStocks();
        List<Stock> stocks1 = new ArrayList<>();
        for (Stock s : stocks) {
            if (s.getQte()  == 0) {
                stocks1.add(s);
            }
        }
        return stocks1;
    }

}

