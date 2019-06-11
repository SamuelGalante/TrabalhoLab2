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
		GerarRelatorioCaracterizacao relatorio = new GerarRelatorioCaracterizacao(arvore);
		int[] sexo = relatorio.CaracterizacaoSexo();
		int[] estadoCivil = relatorio.CaracterizacaoEstadoCivil();
		int[] raca = relatorio.CaracterizacaoRaca();
		int[] moradia = relatorio.CaracterizacaoMoradia();
		int[] faixaEtaria = relatorio.CaracterizacaoFaixaEtaria();
		
		int populacaoTotal = relatorio.PopulacaoTotal();
		
		System.out.println("Relatório de categorização");
		System.out.println("___________________________");
		System.out.println("População total: " + populacaoTotal);
		System.out.println("___________________________");
		System.out.println("Sexo: ");
		System.out.println("Masculino: " + (sexo[0]*100d)/populacaoTotal + "%");
		System.out.println("Feminino: "+ (sexo[1]*100d)/populacaoTotal + "%");
		System.out.println("___________________________");
		System.out.println("Estado civil: ");
		System.out.println("Solteiro(a): " + (estadoCivil[0]*100d)/populacaoTotal + "%");
		System.out.println("Casado(a): " + (estadoCivil[1]*100d)/populacaoTotal + "%");
		System.out.println("Viúvo(a): " + (estadoCivil[2]*100d)/populacaoTotal + "%");
		System.out.println("Divorciado(a): " + (estadoCivil[3]*100d)/populacaoTotal + "%");
		System.out.println("___________________________");
		System.out.println("Raça:");
		System.out.println("Parda: " + (raca[0]*100d)/populacaoTotal + "%");
		System.out.println("Preta: " + (raca[1]*100d)/populacaoTotal + "%");
		System.out.println("Branca: " + (raca[2]*100d)/populacaoTotal + "%");
		System.out.println("Amarela: " + (raca[3]*100d)/populacaoTotal + "%");
		System.out.println("Indígena: " + (raca[4]*100d)/populacaoTotal + "%");
		System.out.println("___________________________");
		System.out.println("Moradia: ");
		System.out.println("Rural: " + (moradia[0]*100d)/populacaoTotal + "%");
		System.out.println("Urbana: " + (moradia[1]*100d)/populacaoTotal + "%");
		System.out.println("___________________________");
		System.out.println("Faixa etária");
		System.out.println("0 a 12 : " + (faixaEtaria[0]*100d)/populacaoTotal + "%");
		System.out.println("13 a 19 : " + (faixaEtaria[1]*100d)/populacaoTotal + "%");
		System.out.println("20 a 25 : " + (faixaEtaria[2]*100d)/populacaoTotal + "%");
		System.out.println("26 a 30 : " + (faixaEtaria[3]*100d)/populacaoTotal + "%");
		System.out.println("31 a 45 : " + (faixaEtaria[4]*100d)/populacaoTotal + "%");
		System.out.println("46 a 65 : " + (faixaEtaria[5]*100d)/populacaoTotal + "%");
		System.out.println("maiores de 65 : " + (faixaEtaria[6]*100d)/populacaoTotal + "%");
		System.out.println("___________________________");
		
		Censo censo = new Censo(arvore);

		double mediaIdadeGeral = censo.obterMediaIdadeGeral();
		double mediaIdadeSexoFeminino = censo.obterMediaIdadeSexoFeminino();
		double mediaIdadeSexoMasculino = censo.obterMediaIdadeSexoMasculino();
		double mediaIdadeZonaRural = censo.obterMediaIdadeZonaRural();
		double mediaIdadeZonaUrbana = censo.obterMediaIdadeZonaUrbana();
		double mediaIdadeSolteiros = censo.obterMediaIdadeSolteiro();
		double mediaIdadeCasados = censo.obterMediaIdadeCasado();
		double desvioPadraoIdadeSolteiro = censo.obterDesvioPadraoIdadeSolteiro();
		double desvioPadraoIdadeCasado = censo.obterDesvioPadraoIdadeCasado();

		System.out.println("\nRelatorio estatístico de idade");
		
		System.out.println("\n");
		System.out.println("Média de idade geral: \t" + mediaIdadeGeral);
		System.out.println("\n______________________________________________________________\n");
		
		System.out.println("Categorizada por sexo:");
		System.out.print("Feminino: " + mediaIdadeSexoFeminino);
		System.out.println("\tMasculino: " + mediaIdadeSexoMasculino);
		System.out.println("\n______________________________________________________________\n");
		
		System.out.println("Categorizada por moradia:");
		System.out.print("Rural: " + mediaIdadeZonaRural);
		System.out.println("\tUrbana: " + mediaIdadeZonaUrbana);
		System.out.println("\n______________________________________________________________\n");
		
		System.out.println("Solteiros e casados:");
		System.out.println("\t\tMedia de idade:\tDesvio padrão:");
		
		System.out.print("Solteiros: \t");
		System.out.print(mediaIdadeSolteiros + "\t");
		System.out.println(desvioPadraoIdadeSolteiro + "\t");

		System.out.print("Casados: \t");
		System.out.print(mediaIdadeCasados + "\t");
		System.out.println(desvioPadraoIdadeCasado);
		
		System.out.println("\nFIM DO RELATÓRIO_________________________________________________\n");
	}

}
