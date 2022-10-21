package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.ClientDao;
import tn.iit.dao.CompteDao;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;

@Service
public class ClientService {

	private final ClientDao clientDao;

	@Autowired
	public ClientService(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}

	public void save(Client client) {
		clientDao.saveAndFlush(client);
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public void delete(String cin) {
		clientDao.deleteById(cin);
	}

	public void delete(Client client) {
		clientDao.delete(client);
	}

	public Client findById(String cin) {
		Optional<Client> clientOptinal = clientDao.findById(cin);
		if (clientOptinal.isPresent()) {
			return clientOptinal.get();
		} else {
			return null;
		}
	}

	public void update(Client client) {
		clientDao.saveAndFlush(client);

	}

}
