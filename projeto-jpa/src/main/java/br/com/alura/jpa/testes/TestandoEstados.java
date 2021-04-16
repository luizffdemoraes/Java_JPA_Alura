package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	public static void main(String[] args) {
		
		/***
		 * Estado Transient para designar este tipo de objeto desvinculado. 
		 * Sua característica é uma conta que existe na memória, possui informações e não tem Id nenhum, 
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
	     * Transient -> Managed - Quando executarmos a persistência com este método, 
	     * estaremos transformando um objeto Transient em Managed, 
	     * cuja característica é a sincronização automática com o banco de dados.
	     */
	    
	    em.getTransaction().begin();
	    
	    //Transient -> Managed
	    em.persist(conta);
	    
	    //Manged -> Removed
	    em.remove(conta);
	    
	    em.getTransaction().commit();
	    
	}

}
