package tn.iit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.iit.dao.ClientDao;
import tn.iit.dao.CompteDao;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;

@SpringBootApplication
public class FirstSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CompteDao compteDao; 

	@Autowired
	private ClientDao clientDao;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	Client client = new Client("78", "Ellawz", "Ahmed");
		clientDao.saveAndFlush(client);
		
		Compte compte = new Compte();
		compte.setSolde(100);
		compte.setClient(client);
		compteDao.saveAndFlush(compte);
		Compte compte2 = new Compte();
		compte2.setSolde(500);
		compte2.setClient(client);
		compteDao.saveAndFlush(compte2);*/
		
		/*Client client = clientDao.getById("78");
		 List<Compte> comptes = compteDao.findByClientCin("78");
		System.out.println(comptes);*/
		

		
	}

}
