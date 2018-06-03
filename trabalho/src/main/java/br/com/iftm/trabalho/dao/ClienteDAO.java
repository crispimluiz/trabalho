package br.com.iftm.trabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.iftm.trabalho.model.Cliente;


public class ClienteDAO {
	
	@PersistenceContext(name="trabalho")
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		Query query = entityManager.createQuery("from Cliente c");
		return query.getResultList();
	}
	
	public Cliente getClienteId(Integer id) {
		return entityManager.find(Cliente.class,id);
	}
	
	@Transactional
	public void excluirCliente(Integer id) {
		Cliente c = getClienteId(id);
		entityManager.remove(c);
	}
	@Transactional
	public void inserirCLiente(Cliente cliente) {
		entityManager.persist(cliente);
	}
	@Transactional
	public void atualizarCLiente(Cliente cliente) {
		cliente= entityManager.merge(cliente);
		entityManager.persist(cliente);
	}
	
}
