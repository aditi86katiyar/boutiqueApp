package com.example.boutiqueapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.boutiqueapp.vo.Design;

@Repository
public interface DesignRepository extends JpaRepository<Design, Long>{

    Page<Design> findByDesignType(String designType, Pageable pageable);
	
	}
