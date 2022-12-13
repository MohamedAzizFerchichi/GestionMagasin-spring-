package tn.test.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.test.spring.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {



}

