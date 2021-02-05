package com.sinensia.medicdata.backend.presentation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class AppController {

	@RequestMapping(value = { "/home", "/", "/index", "/inicio", "" })
	public String home() {
		return "index";
	}

}
