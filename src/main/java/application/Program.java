package application;

import java.util.Scanner;

import lib.ValidarEmail;
import resource.Agenda;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		
		while (true) {
			opcoes();
			int opcao = sc.nextInt();

			if (opcao == 0) {
				break;
			}

			if (opcao == 1) {
				while (true) {
					System.out.println("");
					System.out.print("Nome: ");
					sc.nextLine();
					String nome = sc.nextLine();

					if (nome.isEmpty()) {
						System.out.println("Nome não pode ser vazio, tente novamente");
						break;
					}

					System.out.print("Telefone de Contato: ");
					String telefone = sc.nextLine();

					if (telefone.isEmpty()) {
						System.out.println("Telefone não pode ser vazio, tente novamente");
						break;
					}

					System.out.print("Email de Contato: ");
					String email = sc.nextLine();

					if (email.isEmpty()) {
						System.out.println("Email não pode ser vazio, tente novamente");
						break;
					}

					if (ValidarEmail.validateEmail(email) == false) {
						System.out.println("");
						System.out.println("Formato de email Incorreto, tente novamente");
						break;
					} else {
						
						agenda.adicionarConato(nome, telefone, email);
						break;
					}

				}
			}

			if (opcao == 2) {
				System.out.println("");
				System.out.print("Nome do contato a Buscar: ");
				sc.nextLine();
				String buscaPorNome = sc.nextLine();
				
				agenda.buscaNome(buscaPorNome);

			}
			if (opcao == 3) {
				System.out.println("");
				System.out.print("Telefone do contato a Buscar: ");
				sc.nextLine();
				String buscaPorTel = sc.nextLine();

				agenda.buscaTelefone(buscaPorTel);
			}
			if (opcao == 4) {
				System.out.println("");
				System.out.print("Email do contato a Buscar: ");
				sc.nextLine();
				String buscaPorEmail = sc.nextLine();

				agenda.buscaEmail(buscaPorEmail);
			}

			if (opcao == 5) {
				System.out.println(" ");
				System.out.print("Nome do Contato a Remover: ");
				sc.nextLine();
				String nomeRemove = sc.nextLine();
				
				agenda.deletarconato(nomeRemove);
			}
		}
		sc.close();

	}

	public static void opcoes() {
		System.out.println("");
		System.out.println("- - - - -  Cadastro de Contato  - - - - -");
		System.out.println("-	1 - Adicionar Contato               -");
		System.out.println("-	2 - Listar Contatos por Nome        -");
		System.out.println("-	3 - Listar Contatos por Telefone    -");
		System.out.println("-	4 - Listar Contatos por Email       -");
		System.out.println("-	5 - Remover Contato por Nome        -");
		System.out.println("-	0 - Sair                            -");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");

		System.out.println("");
		System.out.print("Selecione uma Opçao: ");
	}
}
