package com.getNotas.getNotas.controller;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getNotas.getNotas.model.notasM;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/getNotas")
@RequiredArgsConstructor
public class Notas {

	private static final Logger logger = LoggerFactory.getLogger(Notas.class);
	private final RestTemplate restTemplate = new RestTemplate();
	
	
	
	@GetMapping("/hello")
	public Object getHola() {
	   return "Hola";
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{correo}")
	public Object getNotas(@PathVariable String correo) {
	    try {
	        String url = "https://script.google.com/macros/s/AKfycbwnh-khCEHy0hPwAcTSlBesGuNYzDcz6xth-n469y7i_f_2Ciix6MhlvjnRays6ypN9/exec?correo=" + correo;
	        logger.info(url);
	        Object resultado = restTemplate.getForObject(url, Object.class);
	        return resultado;
	    } catch (Exception e) {
	        throw e;
	    }
	}


	/*@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{correo}")
	public List<notasM> getNotas(@PathVariable String correo) {
	    try {
	        String url = "https://script.google.com/macros/s/AKfycbwnh-khCEHy0hPwAcTSlBesGuNYzDcz6xth-n469y7i_f_2Ciix6MhlvjnRays6ypN9/exec?correo=" + correo;
	        logger.info(url);
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode jsonNode = objectMapper.readTree(response.getBody());
	        logger.info(jsonNode.toString());
	        List<notasM> notasList = new ArrayList<>();
	        if (jsonNode.isArray()) {
	            for (JsonNode node : jsonNode) {
	                notasM notas = objectMapper.treeToValue(node, notasM.class);
	                notasList.add(notas);
	            }
	        }
	        logger.info("Todo salió bien");
	        return notasList;
	    } catch (Exception e) {
	        logger.error("Algo salió mal", e);
	        throw new RuntimeException("No se pudieron obtener las notas");
	    }
	}*/
	
	/*@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{correo}")
	public List<notasM> getNotas(@PathVariable String correo) {
	    try {
	        String url = "https://script.google.com/macros/s/AKfycbwnh-khCEHy0hPwAcTSlBesGuNYzDcz6xth-n469y7i_f_2Ciix6MhlvjnRays6ypN9/exec?correo=" + correo;
	        logger.info(url);
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode jsonNode = objectMapper.readTree(response.getBody());
	        logger.info(jsonNode.toString());
	        List<notasM> notasList = new ArrayList<>();
	        if (jsonNode.isArray()) {
	            for (JsonNode node : jsonNode) {
	                notasM notas = objectMapper.treeToValue(node, notasM.class);
	                notasList.add(notas);
	            }
	        }
	        logger.info("Todo salió bien");
	        return notasList;
	    } catch (HttpClientErrorException.BadRequest ex) {
	        logger.error("La solicitud es incorrecta. Correo: {}", correo, ex);
	        throw new RuntimeException("La solicitud es incorrecta. Por favor, verifique el correo ingresado");
	    } catch (HttpServerErrorException.InternalServerError ex) {
	        logger.error("Error interno del servidor. Correo: {}", correo, ex);
	        throw new RuntimeException("Error interno del servidor. Por favor, intente más tarde");
	    } catch (Exception e) {
	        logger.error("Error al obtener las notas. Correo: {}", correo, e);
	        throw new RuntimeException("No se pudieron obtener las notas. Por favor, intente más tarde");
	    }
	}*/


}
