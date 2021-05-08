package com.santana.dsvendas.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santana.dsvendas.dto.SaleDTO;
import com.santana.dsvendas.entities.Sale;
import com.santana.dsvendas.repositories.SaleRepository;
import com.santana.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly= true)
	public Page<SaleDTO> findAll(Pageable pagleable){
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pagleable);
		return result.map(x -> new SaleDTO(x));
	}
}
