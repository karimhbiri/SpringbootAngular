package tn.iit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tn.iit.entity.Compte;

@Repository
@Transactional
public class CompteDao {

	@PersistenceContext
	private EntityManager em;

	public void save(Compte compte) {
		em.persist(compte);
	}

	public List<Compte> findAll() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}

	public void delete(Compte compte) {
		// TODO Auto-generated method stub
		em.remove(compte);
	}
	public Compte findById(Long rib) {
		return em.find(Compte.class, rib);
	}

	public void update(Compte compte) {
		// TODO Auto-generated method stub
		em.merge(compte);
	}
}
