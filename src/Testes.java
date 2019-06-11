import java.io.IOException;
import java.util.Scanner;

public class Testes {

	static Scanner scan = new Scanner(System.in);
	static ArvorePessoa arvore;
	static String arquivo;

	public static void main(String[] args) throws IOException {

		System.out.println("Digite o nome do arquivo:");

		// arquivo = scan.nextLine();
		arquivo = "arquivo_de_teste.txt";
		arvore = PessoaDAO.montarArvoreDeArquivo(arquivo);

		System.out.println();

		menuPrincipal();

		System.out.println("Deseja salvar suas altera��es? S/N");

		String salvar;

		scan.nextLine();
		salvar = scan.nextLine();

		if (salvar.equalsIgnoreCase("s")) {
			try {
				PessoaDAO.salvarListaArquivo(arvore, arquivo);
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao tentar salvar o arquivo: " + e.getMessage());
			}
		}

	}

	static void menuPrincipal() {
		int controle;

		do {
			System.out.println("\nSelecione a op��o desejada:");
			System.out.println("1 - Buscar uma pessoa");
			System.out.println("2 - Editar informa��es");
			System.out.println("3 - Gerar relat�rio");
			System.out.println("0 - Encerrar o programa");

			controle = scan.nextInt();

			switch (controle) {
			case 1:
				buscarPessoa();
				break;
			case 2:
				editarInfo();
				break;
			case 3:
				imprimirRelatorio();
				break;
			case 0:
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}

		} while (controle != 0);
	}

	static void buscarPessoa() {
		Long id;
		do {
			System.out.println("Insira a identidade da pessoa a ser pesquisada ou 0 para sair:");
			id = scan.nextLong();

			if (id != 0) {
				Pessoa retorno = arvore.pesquisar(id);

				if (retorno == null) {
					System.out.println("N�o encontrado");
					System.out.println("Deseja pesquisar novamente?");
					System.out.println("1 - Sim");
					System.out.println("0 - Sair");

					id = scan.nextLong();
				} else {
					System.out.println(retorno.toString());
				}
			}
		} while (id != 0);
	}

	static void editarInfo() {
		int controle;
		Long id;
		String controleS;

		do {
			System.out.println("");
			System.out.println("Insira a identidade da pessoa a ser modificada e 0 para sair:");

			id = scan.nextLong();

			if (id != 0) {
				Pessoa pessoa = arvore.pesquisar(id);
				if (pessoa == null) {
					System.out.println("N�o encontrado");
					System.out.println("Deseja pesquisar novamente?");
					System.out.println("1 - Sim");
					System.out.println("0 - Sair");
					id = scan.nextLong();
				} else {
					do {

						System.out.println(pessoa.toString());

						System.out.println("Selecione o par�metro de altera��o: ");
						System.out.println("1 - Nome");
						System.out.println("2 - Sexo");
						System.out.println("3 - Idade");
						System.out.println("4 - Regi�o de morada");
						System.out.println("5 - Estado civil");
						System.out.println("6 - Ra�a");
						System.out.println("0 - Sair");

						controle = scan.nextInt();

						if (controle == 1) {
							System.out.println(pessoa.getNome());
							System.out.println("Digite o novo par�metro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setNome(controleS);
							}
						} else if (controle == 2) {
							System.out.println(pessoa.getSexo());
							System.out.println("Digite o novo par�metro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setSexo(controleS);
							}
						} else if (controle == 3) {
							System.out.println(pessoa.getIdade());
							System.out.println("Digite o novo par�metro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								Integer result = Integer.valueOf(controleS);
								pessoa.setIdade(result);
							}
						}

						else if (controle == 4) {
							System.out.println(pessoa.getMoradia());
							System.out.println("Digite o novo par�metro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setMoradia(controleS);
							}
						} else if (controle == 5) {
							System.out.println(pessoa.getCivil());
							System.out.println("Digite o novo par�metro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setCivil(controleS);
							}
						} else if (controle == 6) {
							System.out.println(pessoa.getRaca());
							System.out.println("Digite o novo par�metro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setRaca(controleS);
							}
						}
					} while (controle != 0);
				}
			}
		} while (id != 0);

	}

	static void imprimirRelatorio() {
		int controle;
		System.out.println("1 - Relat�rio de popula��o total");
		System.out.println("2 - Relat�rio de sexo");
		System.out.println("3 - Relat�rio de estado civil");
		System.out.println("4 - Relat�rio de ra�a");
		System.out.println("5 - Relat�rio de moradia");
		System.out.println("6 - Relat�rio de faixa et�ria");
		System.out.println("7 - Estat�sticas de idade");
		System.out.println("8 - Sair");
		controle = scan.nextInt();
	}

}
