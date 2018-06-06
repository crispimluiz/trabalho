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

import br.com.iftm.trabalho.dao.AluguelFilmeDAO;
import br.com.iftm.trabalho.model.AluguelFilme;

@Path(value="/aluguelfilme")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AluguelFilmeFacade {
	@Inject
	private AluguelFilmeDAO aluguelFilmeDAO;
	
	@GET
	public List<AluguelFilme> getAluguelFilmes() {
		List<AluguelFilme> aluguelFilmes = aluguelFilmeDAO.getAluguelFilmes();
		for (AluguelFilme a: aluguelFilmes) {
			a.setCliente(null);
			a.setFilme(null);
		}
		return aluguelFilmes;
	}
	@GET
	@Path("/{id}")
	public AluguelFilme getAluguelFilmeId(@PathParam(value="id") Integer id) {
		return aluguelFilmeDAO.getAluguelFilmeId(id);
	}
	@DELETE
	@Path("/{id}")
	public void excluirAluguelFilme(@PathParam(value="id") Integer id) {
		aluguelFilmeDAO.excluirAluguelFilme(id);
	}
	@POST
	public void salvarAluguelFilme(AluguelFilme aluguelFilme) {
		aluguelFilmeDAO.inserirAluguelFilme(aluguelFilme);
	}
	@PUT
	public void atualizarAluguelFilme(AluguelFilme aluguelFilme) {
		aluguelFilmeDAO.atualizarAluguelFilme(aluguelFilme);
	}
}
