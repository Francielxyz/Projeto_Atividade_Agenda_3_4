package resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Contato;

public class Agenda {
	Contato contatos;
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda-jpa");
	public static EntityManager man = emf.createEntityManager();

	public void adicionarConato(String nome, String telefone, String email) {
		contatos = new Contato(null, nome, telefone, email);
		man.getTransaction().begin();
		man.persist(contatos);
		man.getTransaction().commit();

	}

	public void buscaNome(String bNome) {
		String sql = "SELECT c FROM Contato c WHERE nome = :buscaNome ";
		String buscaNome = bNome;

		TypedQuery<Contato> query = man.createQuery(sql, Contato.class).setParameter("buscaNome", buscaNome);
		List<Contato> listaContato = query.getResultList();

		if (listaContato.size() == 0) {
			System.out.println(" ");
			System.out.println("Contato não existe, por favor digite outro");
		} else {
			for (Contato contato : listaContato) {
				System.out.println(contato.toString());

			}
		}
	}

	public void buscaTelefone(String bTelefone) {
		String sql = "SELECT c FROM Contato c WHERE telefone = :buscaTelefone ";
		String buscaTelefone = bTelefone;

		TypedQuery<Contato> query = man.createQuery(sql, Contato.class).setParameter("buscaTelefone", buscaTelefone);
		List<Contato> listaContato = query.getResultList();

		if (listaContato.size() == 0) {
			System.out.println(" ");
			System.out.println("Contato não existe, por favor digite outro");
		} else {
			for (Contato contato : listaContato) {
				System.out.println(contato.toString());

			}
		}
	}

	public void buscaEmail(String bEmail) {
		String sql = "SELECT c FROM Contato c WHERE email = :buscaEmail ";
		String buscaEmail = bEmail;

		TypedQuery<Contato> query = man.createQuery(sql, Contato.class).setParameter("buscaEmail", buscaEmail);
		List<Contato> listaContato = query.getResultList();

		if (listaContato.size() == 0) {
			System.out.println(" ");
			System.out.println("Contato não existe, por favor digite outro");
		} else {
			for (Contato contato : listaContato) {
				System.out.println(contato.toString());

			}
		}

	}

	public void deletarconato(String rNome) {
		String sql = "SELECT c FROM Contato c WHERE nome = :buscaNome ";
		String buscaNome = rNome;

		TypedQuery<Contato> query = man.createQuery(sql, Contato.class).setParameter("buscaNome", buscaNome);
		List<Contato> listaContato = query.getResultList();

		if (listaContato.size() == 0) {
			System.out.println(" ");
			System.out.println("Contato não existe, por favor digite outro");
		} else {
			String removeNome = rNome;
			man.getTransaction().begin();
			man.createQuery("DELETE FROM Contato c WHERE nome = :removeNome").setParameter("removeNome", removeNome)
					.executeUpdate();
			man.getTransaction().commit();

			System.out.println(" ");
			System.out.println("Contato Deletado com Sucesso");

		}
	}
}
