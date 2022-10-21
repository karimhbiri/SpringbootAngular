package tn.iit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.CompteDao;
import tn.iit.entity.Compte;

@Service
public class CompteService {

	private final CompteDao compteDao;

	@Autowired
	public CompteService(CompteDao compteDao) {
		super();
		this.compteDao = compteDao;
	}

	public void save(Compte compte) {
		compteDao.save(compte);
	}

	public List<Compte> findAll() {
		return compteDao.findAll();
	}

	public void delete(Long rib) {
		delete(findById(rib));
	}

	public void delete(Compte compte) {
		compteDao.delete(compte);
	}

	public Compte findById(Long rib) {
		return compteDao.findById(rib);
	}

	public void update(Compte compte) {
		// TODO Auto-generated method stub
		compteDao.update(compte);
		
	}
}
