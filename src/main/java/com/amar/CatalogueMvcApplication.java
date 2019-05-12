package com.amar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amar.dao.ProduitRepository;
import com.amar.entities.Produit;

@SpringBootApplication
public class CatalogueMvcApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(CatalogueMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit(null, "PC 5648", 6000, 12));
		produitRepository.save(new Produit(null, "Imprimante HP 1234", 1200, 10));
		produitRepository.save(new Produit(null, "PC Asus", 10000, 1));
		produitRepository.save(new Produit(null, "Scanner", 1000, 5));
		produitRepository.findAll().forEach(p->{
			System.out.println(p.getDesignation());
		});
	}

}
