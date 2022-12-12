package tn.test.spring.Services.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Fournisseur;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Repository.FactureRepositrory;
import tn.test.spring.Services.Fournisseur.FournisseurService;
import tn.test.spring.Services.GServiceImp;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class FactureServiceImp  implements FactureService {

    @Autowired
    FactureRepositrory factureRepositrory;

    @Autowired
    FournisseurService fournisseurServiceImp;

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        Fournisseur fournisseur = fournisseurServiceImp.findById(idFournisseur);
        return factureRepositrory.getFacturesByFournisseur(fournisseur);
    }



    @Override
    public List<Facture> retrieveAll() {
        return factureRepositrory.findAll();
    }

    @Override
    public Facture add(Facture s) {

        return factureRepositrory.save(s);
    }

    @Override
    public Facture update(Facture s) {
        return factureRepositrory.save(s);
    }

    @Override
    public Facture findById(Long id) {
        return factureRepositrory.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
factureRepositrory.deleteById(id);
    }




}

