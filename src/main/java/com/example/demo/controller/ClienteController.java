package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;

import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	//guardar
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void>guardar(@RequestBody Cliente cliente){
		service.guadar(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//obtener por id
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id){
		Cliente cliente = service.obtener(id);
		
		if( cliente != null) {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Actualizar
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void>editar(@RequestBody Cliente cliente){
		Cliente c = service.obtener(cliente.getIdCliente());
		
		if(c != null) {
			service.actualizar(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Eliminar
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		Cliente cliente = service.obtener(id);
		
		if(cliente != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	


}
