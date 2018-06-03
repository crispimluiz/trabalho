package br.com.iftm.trabalho.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.iftm.trabalho.dao.ClienteDAO;
import br.com.iftm.trabalho.model.Cliente;

@Path(value="/cliente")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ClienteFacade {
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@GET
	public List<Cliente> getClientes() {
		List<Cliente> clientes = clienteDAO.getClientes();
		for (Cliente c: clientes) {
			c.setNomeCli(null);
			c.setEndereco(null);
		}
		return clientes;
	}
	@GET
	@Path("/{id}")
	public Cliente getClienteId(@PathParam(value="id") Integer id) {
		return clienteDAO.getClienteId(id);
	}
	@DELETE
	@Path("/{id}")
	public void excluirCliente(@PathParam(value="id") Integer id) {
		clienteDAO.excluirCliente(id);
	}
	@POST
	public void salvarCliente(Cliente cliente) {
		clienteDAO.inserirCLiente(cliente);
	}
	@PUT
	public void atualizarCliente(Cliente cliente) {
		clienteDAO.atualizarCLiente(cliente);
	}
}
