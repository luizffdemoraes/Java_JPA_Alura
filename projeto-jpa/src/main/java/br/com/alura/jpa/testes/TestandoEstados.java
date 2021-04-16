package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		
		/***
		 * Estado Transient para designar este tipo de objeto desvinculado. 
		 * Sua caracter�stica � uma conta que existe na mem�ria, possui informa��es e n�o tem Id nenhum, 
		 * mas pode se tornar Managed futuramente.
		 */
	
		//Transient
		Conta conta = new Conta();		
		conta.setTitular("Almiro");
		conta.setAgencia(123123);
		conta.setNumero(123123);
		conta.setSaldo(100.0);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	    EntityManager em = emf.createEntityManager();
		
	    /***
	     * Transient -> Managed - Quando executarmos a persist�ncia com este m�todo, 
	     * estaremos transformando um objeto Transient em Managed, 
	     * cuja caracter�stica � a sincroniza��o autom�tica com o banco de dados.
	     * 
	     * Removed - Caso queiramos remover a conta Managed, poderemos usar o m�todo remove() 
	     * passando uma conta que ser� deletada de seu contexto JPA, 
	     * o que gerar� a sincroniza��o e aplicar� um delete no banco de dados, 
	     * transformando-a em um estado Removed.
	     */
	    
	    
	    
	    em.getTransaction().begin();
	    
	    //Transient -> Managed
	    em.persist(conta);
	    
	    //Manged -> Removed
	    em.remove(conta);
	    
	    em.getTransaction().commit();
	    
	}

}
