package com.santana.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santana.dsvendas.dto.SellerDTO;
import com.santana.dsvendas.services.SellerService;

@RestController
@RequestMapping(value="/sellers")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;

	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = sellerService.findAll();
		return ResponseEntity.ok(list);
	}
	
	
	
}
