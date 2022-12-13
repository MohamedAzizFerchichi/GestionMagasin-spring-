package tn.test.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Services.Produit.ProduitService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    ProduitService produitServiceImp;


    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit produit) {

        return produitServiceImp.add(produit);
    }

    @GetMapping("/all")
    public List<Produit> getAll() {
        return produitServiceImp.retrieveAll();
    }

    @PutMapping("/edit")
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitServiceImp.update(produit);
    }

    @GetMapping("/retrieve/{id}")
    public Produit getProduit(@PathVariable(value = "id") long id) {
        return produitServiceImp.findById(id);
    }

    @GetMapping("/{idProduit}/{idStock}")
    public Produit addProduitToStock(@PathVariable(value = "idProduit") long idProduit, @PathVariable(value = "idStock") int idStock) {
        produitServiceImp.assignProduitToStock(idProduit, idStock);
        return produitServiceImp.findById(idProduit);
    }


}