package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cliente;

public interface ClienteService {
	
	void guadar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Integer id);
	List<Cliente> listar();
	Cliente obtener(Integer id);

}
