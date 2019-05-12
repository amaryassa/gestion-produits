package com.amar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amar.dao.ProduitRepository;
import com.amar.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	@GetMapping("/produits") 
	public String produits( Model model,
							@RequestParam(name="page", defaultValue="0") int page,
							@RequestParam(name="motCle", defaultValue="") String mc
							) {
//		Page<Produit> pageProduits=produitRepository.findAll(PageRequest.of(page, 6));
		Page<Produit> pageProduits=produitRepository.findByDesignationContains(mc, PageRequest.of(page, 6));
		
		model.addAttribute("listeProduits", pageProduits.getContent());
		model.addAttribute("allPages", new int [pageProduits.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	@GetMapping("/delete")
//	quand le nom de paramètre de l'url a le même nom que la variable ici (c'est id) on a pas besoin d'ajouter @RequestParam
	public String delete( Long id, int page, String motCle ) {
		produitRepository.deleteById(id);
		
		
		return "redirect:/produits?page="+page+"&motCle="+motCle;
	}
}
