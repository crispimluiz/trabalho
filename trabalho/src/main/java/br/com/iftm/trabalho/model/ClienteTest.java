package br.com.iftm.trabalho.model;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//Se usar o JUnit 5
class ClienteTest {

	 @BeforeAll
	    static void inicializarRecursosExternos() {
	   	 System.out.println("Inicializando os recursos externos...");
	    }

	    @BeforeEach
	    void inicializarObjetosMock() {
	   	 System.out.println("Inicializando objetos mock...");
	    }

	    @Test
	    void algumTeste() {
	   	 System.out.println("Executando algum teste...");
	   	 assertTrue(true);
	    }

	    @Test
	    void outroTeste() {
	   	 assumeTrue(true);

	   	 System.out.println("Executando outro teste...");
	   	 assertNotEquals(1, 42, "Porque estes valores não são iguais?");
	    }

	    private void assumeTrue(boolean b) {
			// TODO Auto-generated method stub
			
		}

		@Test
	    @Disabled
	    void disabilitarTeste() {
	   	 System.exit(1);
	    }

	    @AfterEach
	    void parando() {
	   	 System.out.println("Parando...");
	    }

	    @AfterAll
	    static void liberarRecursosExternos() {
	   	 System.out.println("Liberando os recursos externos...");
	    }

}
