package tn.test.spring.Services.Facture;

import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Services.GService;

import java.util.List;

public interface FactureService {
    List<Facture> getFacturesByFournisseur(Long idFournisseur);



    List<Facture> retrieveAll();

    Facture add(Facture s);

    Facture update(Facture s);

    Facture findById(Long id);

    void delete(Long id);



}
