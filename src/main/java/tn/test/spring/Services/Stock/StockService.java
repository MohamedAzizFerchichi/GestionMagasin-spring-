package tn.test.spring.Services.Stock;

import tn.test.spring.Entity.Produit;
import tn.test.spring.Entity.Stock;

import java.util.List;

public interface StockService {
    void addStock(Stock stock);
    void updateStock(Stock stock);
    void deleteStock(Integer id);
    Stock getStock(Integer id);

    List<Stock> retrieveAllStocks();

    List<Stock> getStockByProduit();

    String retrieveStatusStock() ;


    List<Produit> getProduitByStock(Integer idStock);

    List<Stock> getStockByFilter();

    List<Stock> getStockByFilterInf();

    List<Stock> getStockByFilter0();

}
