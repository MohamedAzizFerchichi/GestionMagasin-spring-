package tn.test.spring.Controllers;

import io.swagger.v3.oas.annotations.security.OAuthFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.test.spring.Entity.DetailFacture;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Services.DetailFacture.DetailFactureService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/DetailFac")
@CrossOrigin(origins = "http://localhost:4200")
public class DetailFactureController {
    @Autowired
    DetailFactureService detailFactureService ;

    @GetMapping
    public List<DetailFacture> getAll() {
        return detailFactureService.retrieveAll();
    }


    @PostMapping("/add/{idFacture}")
    public DetailFacture addDetail(@PathVariable long idFacture,@RequestBody DetailFacture detailFacture){
        return  detailFactureService.addDetail(idFacture,detailFacture);
    }
    @GetMapping("/All/{id}")
    public Set<DetailFacture> getDetailProduit(@PathVariable(value = "id") long id) {

        return detailFactureService.findByFacture(id);


    }
    @GetMapping("/{id}")
    public DetailFacture getOneDetailProduit(@PathVariable(value = "id") long id) {

        return detailFactureService.findById(id);


    }
    @DeleteMapping("/del")
    public void deleteDetailF(@RequestBody DetailFacture detailFacture ) {
        detailFactureService.deleteD(detailFacture);
    }
    @PutMapping
    public DetailFacture updateDetailFacture(@RequestBody DetailFacture detailFacture){
        return  detailFactureService.update(detailFacture);
    }

@GetMapping("/idF/{id}")
    public Long idFacture(@PathVariable(value = "id")  long id){
        return detailFactureService.idFacture(id);
    }




}
