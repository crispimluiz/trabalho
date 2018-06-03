package trabalho;

import java.sql.SQLException;

import org.junit.Test;

import br.com.iftm.trabalho.dao.ClienteDAO;
import br.com.iftm.trabalho.model.Cliente;

//Se usar o JUnit 4
final class ClienteTest {
	@Test
	public void salvar() throws SQLException{
		Cliente c = new Cliente();
		c.setNomeCli("CRISPIM LUIZ");
		c.setEndereco("RUA DAS BATATAS");
		
		ClienteDAO dao = new ClienteDAO();
		dao.inserirCLiente(c);
		
	}

}
