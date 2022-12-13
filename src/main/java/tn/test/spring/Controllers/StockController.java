package tn.test.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Services.Stock.StockServiceImp;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:4200")

public class StockController {


        @Autowired
        StockServiceImp stockServiceImp;

        @GetMapping
        @CrossOrigin(origins = "http://localhost:4200")
        public List<Stock> retrieveAll() {
            return stockServiceImp.retrieveAllStocks();
        }

        @PostMapping
        @CrossOrigin(origins = "http://localhost:4200")
        public void addStock(@RequestBody Stock s) {
            stockServiceImp.addStock(s);
        }

        @GetMapping("/{id}")
        public Stock retrieveStock(@PathVariable int id) {
            return stockServiceImp.getStock(id);
        }

        @DeleteMapping("/{id}")
        public void deleteStock(@PathVariable int id) {
            stockServiceImp.deleteStock(id);
        }

        @PutMapping
        public void updateStock(@RequestBody Stock s) {
            stockServiceImp.updateStock(s);
        }

        @GetMapping("/getStockByProd")
        @CrossOrigin(origins = "http://localhost:4200")
        public List<Stock> getStockByProd() {
            return stockServiceImp.getStockByProduit();
        }

        @GetMapping("/getProdByStock/{id}")
        @CrossOrigin(origins = "http://localhost:4200")
        public List<Produit> getProdByStock(@PathVariable int id) {
            return stockServiceImp.getProduitByStock(id);
        }

        @GetMapping
        @RequestMapping("/getStockByFilter")
       public List<Stock> getStockByFilter() {
            return stockServiceImp.getStockByFilter();
        }

        @GetMapping
        @RequestMapping("/getStockByFilterInf")
        public List<Stock> getStockByFilterInf() {
            return stockServiceImp.getStockByFilterInf();
        }

        @GetMapping
        @RequestMapping("/getStockByFilter0")
        public List<Stock> getStockByFilter0() {
            return stockServiceImp.getStockByFilter0();
        }

        @GetMapping
        @RequestMapping("/retrieveStatusStock")
        public String retrieveStatusStock() {
            return stockServiceImp.retrieveStatusStock();
        }


    }

