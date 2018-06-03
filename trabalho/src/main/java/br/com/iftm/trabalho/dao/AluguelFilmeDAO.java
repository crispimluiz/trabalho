package br.com.iftm.trabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.iftm.trabalho.model.AluguelFilme;

public class AluguelFilmeDAO {
	@PersistenceContext(name="trabalho")
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<AluguelFilme> getAluguelFilmes() {
		Query query = entityManager.createQuery("from AluguelFilme a");
		return query.getResultList();
	}
	
	public AluguelFilme getAluguelFilmeId(Integer id) {
		return entityManager.find(AluguelFilme.class,id);
	}
	
	@Transactional
	public void excluirAluguelFilme(Integer id) {
		AluguelFilme a = getAluguelFilmeId(id);
		entityManager.remove(a);
	}
	@Transactional
	public void inserirAluguelFilme(AluguelFilme aluguelFilme) {
		entityManager.persist(aluguelFilme);
	}
	@Transactional
	public void atualizarAluguelFilme(AluguelFilme aluguelFilme) {
		aluguelFilme= entityManager.merge(aluguelFilme);
		entityManager.persist(aluguelFilme);
	}
	
}
