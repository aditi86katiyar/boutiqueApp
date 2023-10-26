package com.example.boutiqueapp.vo;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "designs")
public class Design {

	//todo
    
	@jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "design_type")
    private String designType;

    @Column(name = "colour")
    private String colour;

    @Column(name = "colour")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> imageLink;

    // Constructors, getters, and setters

    public Design() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignType() {
		return designType;
	}

	public void setDesignType(String designType) {
		this.designType = designType;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public List<Product> getImageLink() {
		return imageLink;
	}

	public void setImageLink(List<Product> imageLink) {
		this.imageLink = imageLink;
	}

	public Design(String designType, String colour, List<Product> imageLink) {
		super(); 
		this.designType = designType;
		this.colour = colour;
		this.imageLink = imageLink;
	}

  

    
}
