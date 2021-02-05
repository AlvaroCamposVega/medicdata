package com.sinensia.medicdata.backend.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicdata")
public class AppController {

	@RequestMapping(value = { "/home", "/", "/index", "/inicio", "" })
	public String home() {
		return "index";
	}

}
