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

import br.com.iftm.trabalho.dao.FilmeDAO;
import br.com.iftm.trabalho.model.Filme;


@Path(value="/filme")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class FilmeFacade {
	@Inject
	private FilmeDAO filmeDAO;
	
	@GET
	public List<Filme> getFilmes() {
		List<Filme> filmes = filmeDAO.getFilmes();
		for (Filme f: filmes) {
			f.setGeneroFilme(null);
			f.setNomeFilme(null);
		}
		return filmes;
	}
	@GET
	@Path("/{id}")
	public Filme getFilmeId(@PathParam(value="id") Integer id) {
		return filmeDAO.getFilmeId(id);
	}
	@DELETE
	@Path("/{id}")
	public void excluirFilme(@PathParam(value="id") Integer id) {
		filmeDAO.excluirFilme(id);
	}
	@POST
	public void salvarFilme(Filme filme) {
		filmeDAO.inserirFilme(filme);
	}
	@PUT
	public void atualizarFilme(Filme filme) {
		filmeDAO.atualizarFilme(filme);
	}
}
