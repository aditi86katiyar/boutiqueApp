package com.example.boutiqueapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boutiqueapp.repository.DesignRepository;
import com.example.boutiqueapp.vo.Design;
import com.example.boutiqueapp.vo.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/designs")
public class DesignController {
	
	@Autowired
	public DesignRepository designRepository;
	
	 @GetMapping("/hello")
	 public String helloWorld() {
	    return "Hello, World!";
	 }
	
	@PostMapping
    public Design createItem(@RequestBody Design item) {
        return designRepository.save(item);
    }
	
	@GetMapping("/{designType}")
	public Page<Design> getDesignsByType(
	    @PathVariable String designType,
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "10") int pageSize
	) throws Exception {
	    Pageable pageable = PageRequest.of(page, pageSize);
	    Page<Design> designs = designRepository.findByDesignType(designType, pageable);
	    return designs;
	}


	    @GetMapping
	    public List<Design> getAllItems() {
	        return designRepository.findAll();
	    }
    
	@PutMapping("/{id}")
    public Design updateItem(@PathVariable Long id, @RequestBody Design itemDetails) {
        Design item = null;
		try {
			item = designRepository.findById(id).orElseThrow(() -> new Exception("Item not found with id: " + id));
			item.setDesignType(itemDetails.getDesignType());
	        item.setColour(itemDetails.getColour());
	        item.setImageLink(itemDetails.getImageLink());

	        return designRepository.save(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;

        
    }
	
	
	
	public static void main(String args[]) throws JsonProcessingException {
		List<Product> links=new ArrayList<>();
		Product product1=new Product();
		product1.setDescription("Yellow duppata with kurta");

		product1.setDimensions("12 x 12");
		product1.setImageUrl("https://images-boutiqueapp.s3.amazonaws.com/yelow/yellowkurta.jpeg");
		product1.setPrice(BigDecimal.valueOf(500));

		links.add(product1);
		ObjectMapper obj=new ObjectMapper();
		Design design=new Design("Salwar Suit", "Yellow", links);
		System.out.println(obj.writeValueAsString(design));
	}

}
