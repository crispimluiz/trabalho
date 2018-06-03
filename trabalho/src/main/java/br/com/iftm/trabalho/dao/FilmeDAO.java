package br.com.iftm.trabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.iftm.trabalho.model.Filme;

public class FilmeDAO {
	@PersistenceContext(name="trabalho")
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Filme> getFilmes() {
		Query query = entityManager.createQuery("from Filme f");
		return query.getResultList();
	}
	
	public Filme getFilmeId(Integer id) {
		return entityManager.find(Filme.class,id);
	}
	
	@Transactional
	public void excluirFilme(Integer id) {
		Filme f = getFilmeId(id);
		entityManager.remove(f);
	}
	@Transactional
	public void inserirFilme(Filme filme) {
		entityManager.persist(filme);
	}
	@Transactional
	public void atualizarFilme(Filme filme) {
		filme= entityManager.merge(filme);
		entityManager.persist(filme);
	}
	
}
