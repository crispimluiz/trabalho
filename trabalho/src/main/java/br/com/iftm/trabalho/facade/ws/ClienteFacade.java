package br.com.iftm.trabalho.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.iftm.trabalho.dao.ClienteDAO;
import br.com.iftm.trabalho.model.Cliente;

@WebService(serviceName="ws/cliente")
public class ClienteFacade {
	@Inject
	private ClienteDAO clienteDAO;
	
	@WebMethod
	public List<Cliente> getClientes() {
		List<Cliente> clientes = clienteDAO.getClientes();
		for (Cliente c: clientes) {
			c.setNomeCli(null);
			c.setEndereco(null);
		}
		return clientes;
	}
	
	@WebMethod
	public Cliente getClienteId(@WebParam(name="idCliente") Integer id) {
		Cliente c = clienteDAO.getClienteId(id);
		if (c != null) {
			c.setNomeCli(null);
			c.setEndereco(null);	
		}
		return c;
	}
	
	@WebMethod
	public void excluirCliente(@WebParam(name="idCliente") Integer id) {
		clienteDAO.excluirCliente(id);
	}
	
	@WebMethod
	public void atualizarCliente(@WebParam(name="cliente") Cliente cliente) {
		clienteDAO.atualizarCLiente(cliente);
	}
	
	@WebMethod
	public void salvarCliente(@WebParam(name="cliente") Cliente cliente) {
		clienteDAO.inserirCLiente(cliente);
	}

}
