package com.pss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pss.object.Callinfo;

public interface CallinfoRepository extends CrudRepository<Callinfo, Long>{

	List<Callinfo> findByIsocode(String isocode);
}
