package com.pss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pss.object.Basicinfo;

public interface BasicinfoRepository extends CrudRepository<Basicinfo, Long>{

	List<Basicinfo> findByIsocode(String isocode);
}
