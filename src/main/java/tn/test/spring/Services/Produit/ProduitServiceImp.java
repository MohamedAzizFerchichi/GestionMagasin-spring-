package tn.test.spring.Services.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Services.GServiceImp;
import tn.test.spring.Services.Stock.StockService;

@Service
public class ProduitServiceImp extends GServiceImp<Produit, Long> implements ProduitService {
    @Autowired
    StockService stockServiceImp;

    @Override
    public void assignProduitToStock(Long idProduit, int idStock) {
        Produit produit = this.findById(idProduit);
        Stock stock = stockServiceImp.getStock(idStock);
        produit.setStock(stock);
        this.update(produit);
    }
}

