package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	    EntityManager em = emf.createEntityManager();
	    
	    /***
	     * Pegar a conta e alterar o saldo usar o metodo find e passar para ele:
	     * Classe e a Chave Primaria do registro que quer resgatar
	     */
	    Conta contaDoLeonardo = em.find(Conta.class, 1L);
	    
	    System.out.println("Conta do Leonardo -> " + contaDoLeonardo.getTitular());
	    
	    em.getTransaction().begin();
	    contaDoLeonardo.setSaldo(20.0);
	    em.getTransaction().commit();
	    
	}

}
