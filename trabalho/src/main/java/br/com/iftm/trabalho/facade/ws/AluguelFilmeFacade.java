package br.com.iftm.trabalho.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.iftm.trabalho.dao.AluguelFilmeDAO;
import br.com.iftm.trabalho.model.AluguelFilme;

@WebService(serviceName = "ws/aluguelFilme")
public class AluguelFilmeFacade {
	@Inject
	private AluguelFilmeDAO aluguelFilmeDAO;

	@WebMethod
	public List<AluguelFilme> getAluguelFilmes() {
		List<AluguelFilme> aluguelFilmes = aluguelFilmeDAO.getAluguelFilmes();
		for (AluguelFilme a : aluguelFilmes) {
			a.setCliente(null);
			a.setFilme(null);
		}
		return aluguelFilmes;
	}

	@WebMethod
	public AluguelFilme getAluguelFilmeId(@WebParam(name = "idAluguelFilme") Integer id) {
		AluguelFilme a = aluguelFilmeDAO.getAluguelFilmeId(id);
		if (a != null) {
			a.setCliente(null);
			a.setFilme(null);
		}
		return a;
	}

	@WebMethod
	public void excluirAluguelFilme(@WebParam(name = "idAluguelFilme") Integer id) {
		aluguelFilmeDAO.excluirAluguelFilme(id);
	}

	@WebMethod
	public void atualizarAluguelFilme(@WebParam(name = "aluguelFilme") AluguelFilme aluguelFilme) {
		aluguelFilmeDAO.atualizarAluguelFilme(aluguelFilme);
		;
	}

	@WebMethod
	public void salvarAluguelFilme(@WebParam(name = "aluguelFilme") AluguelFilme aluguelFilme) {
		aluguelFilmeDAO.inserirAluguelFilme(aluguelFilme);
	}

}
