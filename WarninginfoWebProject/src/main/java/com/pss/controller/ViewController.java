package com.pss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {
		
	@RequestMapping("/map")
	public String hell(){
		System.out.println("map");
		return "map";
	}
	
}
