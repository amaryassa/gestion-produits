package com.amar.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.amar.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	public Page<Produit> findByDesignationContains(String mc, Pageable pageable);

}
