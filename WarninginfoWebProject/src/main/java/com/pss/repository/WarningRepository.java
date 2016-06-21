package com.pss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.pss.object.Warning;

public interface WarningRepository extends CrudRepository<Warning, Long>{
	
	List<Warning> findByIsocode(String isocode);
}
