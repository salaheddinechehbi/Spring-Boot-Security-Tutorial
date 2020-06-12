package com.sec.ma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.ma.entities.Client;
import com.sec.ma.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	

	public void save(Client client) {
		
		clientRepository.save(client);		
	}
	
	public void delete(int id) {
		
		clientRepository.deleteById(id);		
	}

	public List<Client> findAll() {
		
		return clientRepository.findAll();
	}
	
	public int countClient() {
		
		return clientRepository.countClient();
	}
	
	public List<Client> findByEntr(int idE){
		return clientRepository.clientByEntr(idE);
	}

}
