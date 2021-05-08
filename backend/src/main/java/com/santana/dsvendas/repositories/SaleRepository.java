package com.santana.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santana.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
