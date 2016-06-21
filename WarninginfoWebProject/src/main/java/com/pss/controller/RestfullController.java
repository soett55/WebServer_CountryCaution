package com.pss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pss.object.Basicinfo;
import com.pss.object.Callinfo;
import com.pss.object.Warning;
import com.pss.repository.BasicinfoRepository;
import com.pss.repository.CallinfoRepository;
import com.pss.repository.WarningRepository;

@RestController
@RequestMapping("/")
public class RestfullController {

	@Autowired
	private WarningRepository warning_repository;
	@Autowired
	private BasicinfoRepository basicinfo_repository;
	@Autowired
	private CallinfoRepository callinfo_repository;

	@RequestMapping(value = "/warning", method = RequestMethod.GET)
	public Iterable<Warning> getwarningList(){		
		Iterable<Warning> myIterator = warning_repository.findAll();

		return myIterator;
	}
	
	@RequestMapping(value = "/warninginfo/{isocode}")
	public Iterable<Warning> getwarninginfoList(@PathVariable String isocode){		
		List<Warning> info = warning_repository.findByIsocode(isocode);

		return info;
	}

	@RequestMapping("/basicinfo/{isocode}")	
	public Iterable<Basicinfo> getbasicinfoList(@PathVariable String isocode){		
//		Iterable<Basicinfo> myIterator = basicinfo_repository.findAll();
		System.out.println(isocode);
		List<Basicinfo> info = basicinfo_repository.findByIsocode(isocode);
		
		return info;
	}

	@RequestMapping("/callinfo/{isocode}")
	public Iterable<Callinfo> getcallinfoList(@PathVariable String isocode){
//		Iterable<Callinfo> myIterator = callinfo_repository.findAll();
		List<Callinfo> info = callinfo_repository.findByIsocode(isocode);

		return info;
	}

}
