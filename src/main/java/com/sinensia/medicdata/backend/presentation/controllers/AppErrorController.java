package com.sinensia.medicdata.backend.presentation.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		String paginaError = null;

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				paginaError = "errors/404";
			}

			if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				paginaError = "errors/500";
			}
		}

		return paginaError;

	}

	@Override
	public String getErrorPath() {
		return null;
	}

}
