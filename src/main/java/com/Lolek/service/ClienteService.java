package com.Lolek.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Lolek.model.Cliente;
import com.Lolek.repository.ClienteRepository;
import com.Lolek.repository.PassagemRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	private PassagemRepository passagemRepository;

	@Transactional
	public List <Cliente> buscarTodosCliente (){
		return clienteRepository.findAll();
				
	}
	
	
	@Transactional
	public Cliente buscarClienteId/*( @PathVariable (value = "id")*/ (Long id) {
	Optional<Cliente> cliente = this.clienteRepository.findById(id);
	return cliente.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
		//return clienteRepository.findById(id);
	}
	
	@Transactional
	public Cliente criar (Cliente cliente) {
		cliente.setId(null);
		cliente = this.clienteRepository.save(cliente);
		this.passagemRepository.saveAll(cliente.getPassagem());
		 return cliente;
	}
	
	
	public Cliente atualizar ( Cliente cliente) {
		Cliente newCliente = buscarClienteId(cliente.getId());
		newCliente.setNome(cliente.getNome());
		newCliente.setPassagem(cliente.getPassagem());
		newCliente.setTelefone(cliente.getTelefone());
		return clienteRepository.save(newCliente);
	}
	
	
	
	public void delete ( Long id ) {
		buscarClienteId(id);
		try {
			this.clienteRepository.deleteById(id);
						
		} catch (Exception e) {
			throw new RuntimeException("não é possivel excluir pois há entidades relacionadas");
		}
		
	}

}
