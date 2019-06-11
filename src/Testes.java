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

		System.out.println("Deseja salvar suas alterações? S/N");

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
			System.out.println("\nSelecione a opção desejada:");
			System.out.println("1 - Buscar uma pessoa");
			System.out.println("2 - Editar informações");
			System.out.println("3 - Gerar relatório");
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
				System.out.println("Opção inválida");
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
					System.out.println("Não encontrado");
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
					System.out.println("Não encontrado");
					System.out.println("Deseja pesquisar novamente?");
					System.out.println("1 - Sim");
					System.out.println("0 - Sair");
					id = scan.nextLong();
				} else {
					do {

						System.out.println(pessoa.toString());

						System.out.println("Selecione o parâmetro de alteração: ");
						System.out.println("1 - Nome");
						System.out.println("2 - Sexo");
						System.out.println("3 - Idade");
						System.out.println("4 - Região de morada");
						System.out.println("5 - Estado civil");
						System.out.println("6 - Raça");
						System.out.println("0 - Sair");

						controle = scan.nextInt();

						if (controle == 1) {
							System.out.println(pessoa.getNome());
							System.out.println("Digite o novo parâmetro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setNome(controleS);
							}
						} else if (controle == 2) {
							System.out.println(pessoa.getSexo());
							System.out.println("Digite o novo parâmetro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setSexo(controleS);
							}
						} else if (controle == 3) {
							System.out.println(pessoa.getIdade());
							System.out.println("Digite o novo parâmetro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								Integer result = Integer.valueOf(controleS);
								pessoa.setIdade(result);
							}
						}

						else if (controle == 4) {
							System.out.println(pessoa.getMoradia());
							System.out.println("Digite o novo parâmetro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setMoradia(controleS);
							}
						} else if (controle == 5) {
							System.out.println(pessoa.getCivil());
							System.out.println("Digite o novo parâmetro, e 0 para cancelar:");
							controleS = scan.nextLine();
							if (controleS != "0") {
								controleS = scan.nextLine();
								pessoa.setCivil(controleS);
							}
						} else if (controle == 6) {
							System.out.println(pessoa.getRaca());
							System.out.println("Digite o novo parâmetro, e 0 para cancelar:");
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
		GerarRelatorioCaracterizacao relatorio = new GerarRelatorioCaracterizacao();
		System.out.println("Relat�rio de categoriza��o");
		System.out.println("___________________________");
		System.out.println("Popula��o total: " + relatorio.PopulacaoTotal(arvore.raiz));
		System.out.println("___________________________"); 
		System.out.println("Sexo: ");
		System.out.println("Masculino: " + relatorio.CaracterizacaoSexo(arvore.raiz));
		System.out.println("Feminino: "+ relatorio.CaracterizacaoSexo(arvore.raiz));
		System.out.println("___________________________");
		System.out.println("Estado civil: " + relatorio.CaracterizacaoEstadoCivil(arvore.raiz));
		System.out.println("Solteiro(a): " + relatorio.CaracterizacaoEstadoCivil(arvore.raiz));
		System.out.println("Casado(a): " + relatorio.CaracterizacaoEstadoCivil(arvore.raiz));
		System.out.println("Divorciado(a): " + relatorio.CaracterizacaoEstadoCivil(arvore.raiz));
		System.out.println("Vi�vo(a): " + relatorio.CaracterizacaoEstadoCivil(arvore.raiz));
		System.out.println("___________________________");
		System.out.println("Ra�a:");
		System.out.println("Parda: " + relatorio.CaracterizacaoRaca(arvore.raiz));
		System.out.println("Preta: " + relatorio.CaracterizacaoRaca(arvore.raiz));
		System.out.println("Branca: " + relatorio.CaracterizacaoRaca(arvore.raiz));
		System.out.println("Amarela: " + relatorio.CaracterizacaoRaca(arvore.raiz));
		System.out.println("Ind�gena: " + relatorio.CaracterizacaoRaca(arvore.raiz));
		System.out.println("___________________________");
		System.out.println("Moradia: ");
		System.out.println("Rural: " + relatorio.CaracterizacaoMoradia(arvore.raiz));
		System.out.println("Urbana: " + relatorio.CaracterizacaoMoradia(arvore.raiz));
		System.out.println("___________________________");
		System.out.println("Faixa et�ria");
		System.out.println("0 a 12 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("13 a 19 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("20 a 25 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("26 a 30 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("31 a 45 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("46 a 65 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("maiores de 65 : " + relatorio.CaracterizacaoFaixaEtaria(arvore.raiz));
		System.out.println("___________________________");
							
		
		System.out.println("7 - Estat�sticas de idade");
//		System.out.println("8 - Sair");
//		System.out.println("1 - Relatório de população total");
//		System.out.println("2 - Relatório de sexo");
//		System.out.println("3 - Relatório de estado civil");
//		System.out.println("4 - Relatório de raça");
//		System.out.println("5 - Relatório de moradia");
//		System.out.println("6 - Relatório de faixa etária");
//		System.out.println("7 - Estatísticas de idade");
		System.out.println("8 - Sair");
		controle = scan.nextInt();
	}

}
