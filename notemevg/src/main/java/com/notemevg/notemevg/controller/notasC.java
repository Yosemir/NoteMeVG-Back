package com.notemevg.notemevg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/getNotas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class notasC {

	private static final Logger logger = LoggerFactory.getLogger(notasC.class);
	private final RestTemplate restTemplate = new RestTemplate();
	
	
	@GetMapping("/get/{correo}")
	public Object getNotas(@PathVariable String correo) {
	    try {
	        String url = "https://script.google.com/macros/s/AKfycbwhx-PTfT9Wdz_8FmfYPLV-7Df42KoAjnmhLLYmj1DXpDpQSVVr1JxSi4KlLNKGu1cl/exec?correo=" + correo;
	        logger.info(url);
	        Object resultado = restTemplate.getForObject(url, Object.class);
	        return resultado;
	    } catch (Exception e) {
	        throw e;
	    }
	}
}
