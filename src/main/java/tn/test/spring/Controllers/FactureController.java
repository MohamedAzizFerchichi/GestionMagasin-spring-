package tn.test.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Reglement;
import tn.test.spring.Services.Facture.FactureService;

import java.util.List;

@RestController
@RequestMapping("/facture")
@CrossOrigin(origins = "http://localhost:4200")
public class FactureController {
    @Autowired
    FactureService factureService;

    @RequestMapping(value = "/add")
    public Facture save(@RequestBody Facture fa)  {
        return factureService.add(fa) ;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Facture> RetrieveAll() {
        try {
            return factureService.retrieveAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

            factureService.delete(id);


    }




    @GetMapping("/{id}")
    public Facture retrieveFacture(@PathVariable Long id) {

        return factureService.findById(id);
    }



    @PutMapping
    public Facture updateStock(@RequestBody Facture s) {

        return factureService.update(s);
    }








}
