package br.com.iftm.trabalho.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.iftm.trabalho.dao.FilmeDAO;
import br.com.iftm.trabalho.model.Filme;

@WebService(serviceName="ws/filme")
public class FilmeFacade {
	@Inject
	private FilmeDAO filmeDAO;
	
	@WebMethod
	public List<Filme> getFilmes() {
		List<Filme> filmes = filmeDAO.getFilmes();
		for (Filme f: filmes) {
			f.setNomeFilme(null);
			f.setNomeFilme(null);
		}
		return filmes;
	}
	
	@WebMethod
	public Filme getFilmeId(@WebParam(name="idFilme") Integer id) {
		Filme f = filmeDAO.getFilmeId(id);
		if (f != null) {
			f.setNomeFilme(null);
			f.setGeneroFilme(null);	
		}
		return f;
	}
	
	@WebMethod
	public void excluirFilme(@WebParam(name="idFilme") Integer id) {
		filmeDAO.excluirFilme(id);
	}
	
	@WebMethod
	public void atualizarFilme(@WebParam(name="filme") Filme filme) {
		filmeDAO.atualizarFilme(filme);
	}
	
	@WebMethod
	public void salvarFilme(@WebParam(name = "filme") Filme filme) {
		filmeDAO.inserirFilme(filme);
	}

}
