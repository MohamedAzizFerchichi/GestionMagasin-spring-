package tn.test.spring.Services.Produit;

import tn.test.spring.Entity.Produit;
import tn.test.spring.Services.GService;

public interface ProduitService extends GService<Produit, Long> {
    void assignProduitToStock(Long idProduit, int idStock);

}
