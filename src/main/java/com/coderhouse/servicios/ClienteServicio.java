package com.coderhouse.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderhouse.modelos.Cliente;
import com.coderhouse.repositorios.ClienteRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio {
	
	@Autowired
	private ClienteRepositorio clienterepositorio;
	
	public List<Cliente> getAllCliente(){
		return clienterepositorio.findAll();
		
	}
	
	public Cliente findById(Long id) {
		return clienterepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado") );
		
	}
	
	public Cliente saveCliente (Cliente cliente) {
		return clienterepositorio.save(cliente);
	}
	
	@Transactional
	public Cliente updateCliente(Long id, Cliente clienteDetalle) {
		
		Cliente cliente = clienterepositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		
		cliente.setNombre(clienteDetalle.getNombre());
		cliente.setDireccion(clienteDetalle.getDireccion());
		cliente.setEmail(clienteDetalle.getEmail());
		cliente.setTelefono(clienteDetalle.getTelefono());
		cliente.setVentas(clienteDetalle.getVentas());
		
		return clienterepositorio.save(cliente);
		/*
		 * como hacer validacion
		 * if(clienteDetalle.getLegajo() !=null){
		 * cliente.setLegajo(clienteDetalle.getLegajo())}
		 * */
	}
	
	public void deleteCliente(Long id) {
		if(!clienterepositorio.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado") ;
		}
		clienterepositorio.deleteById(id);
	}

}
