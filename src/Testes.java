import java.util.Scanner;

public class Testes {
	
	public static void main(String[] args) {
		ArvorePessoa arvore = new ArvorePessoa();
		GerarRelatorioCaracterizacao relatorio = new GerarRelatorioCaracterizacao();
		Scanner scan = new Scanner(System.in);
		int controle;
		String controleS;
		System.out.println();
		try {
			PessoaDAO dao = new PessoaDAO();

//			ListaPessoa lista = dao.buscarTodos();
//			lista.imprimir();

//			Pessoa pessoa = new Pessoa(999999L, "123 DE OLIVEIRA 4", "M", 27, "Urbana", "Solteiro", "Branca");
//			dao.adicionar(pessoa);

			Pessoa pessoa = dao.buscar(new Pessoa(5719401644L));
//			pessoa.setIdade(22);
//			pessoa.setNome("JON SNOW");

//			dao.atualizar(pessoa);

//			dao.remover(pessoa);

			System.out.println(pessoa.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO: " + e.getMessage());
		}

		// Menu para usu�rio
		do {
			System.out.println("Selecione a op��o desejada:");
			System.out.println("1 - Buscar uma pessoa");
			System.out.println("2 - Editar informa��es");
			System.out.println("3 - Gerar relat�rio");
			System.out.println("0 - Encerrar o programa");
			controle = scan.nextInt();

			// Op��o 1
			if (controle == 1) {
				do {
					System.out.println("Insira a identidade da pessoa a ser pesquisada e 2 para sair:");
					controle = scan.nextInt();
					if (controle != 2) {
						NodoPessoa retorno = arvore.pesquisar(controle);
						if (retorno == null) {
							System.out.println("N�o encontrado");
							System.out.println("Deseja pesquisar novamente?");
							System.out.println("1 - Sim");
							System.out.println("2 - Sair");
							controle = scan.nextInt();
						} else {
							do {
								System.out.println("1 - Nome");
								System.out.println("2 - Sexo");
								System.out.println("3 - Idade");
								System.out.println("4 - Regi�o de morada");
								System.out.println("5 - Estado civil");
								System.out.println("6 - Ra�a");
								System.out.println("0 - Sair");

								controle = scan.nextInt();

								if (controle == 1) {
									System.out.println(retorno.item.getNome());
								}
								if (controle == 2) {
									System.out.println(retorno.item.getSexo());
								}
								if (controle == 3) {
									System.out.println(retorno.item.getIdade());
								}
								if (controle == 4) {
									System.out.println(retorno.item.getMoradia());
								}
								if (controle == 5) {
									System.out.println(retorno.item.getCivil());
								}
								if (controle == 6) {
									System.out.println(retorno.item.getRaca());
								}
								
								//N�o me pergunte o porque desse if.
								if (controle != 0) {
									controle = 10;
								}
							} while (controle != 0);
						}
					}
				} while (controle != 2);
			}

			// Op��o 2
			if (controle == 2) {
				do {
					System.out.println("Insira a identidade da pessoa a ser modificada e 2 para sair:");
					controle = scan.nextInt();
					if (controle != 2) {
						NodoPessoa retorno = arvore.pesquisar(controle);
						if (retorno == null) {
							System.out.println("N�o encontrado");
							System.out.println("Deseja pesquisar novamente?");
							System.out.println("1 - Sim");
							System.out.println("2 - Sair");
							controle = scan.nextInt();
						} else {
							do {
								System.out.println("1 - Nome");
								System.out.println("2 - Sexo");
								System.out.println("3 - Idade");
								System.out.println("4 - Regi�o de morada");
								System.out.println("5 - Estado civil");
								System.out.println("6 - Ra�a");
								System.out.println("7 - Identidade");
								System.out.println("0 - Sair");

								controle = scan.nextInt();

								if (controle == 1) {
									System.out.println(retorno.item.getNome());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										retorno.item.setNome(controleS);
									}
								}
								if (controle == 2) {
									System.out.println(retorno.item.getSexo());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										retorno.item.setSexo(controleS);
									}
								}
								if (controle == 3) {
									System.out.println(retorno.item.getIdade());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										Integer result = Integer.valueOf(controleS);
										retorno.item.setIdade(result);
									}
								}

								if (controle == 4) {
									System.out.println(retorno.item.getMoradia());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										retorno.item.setMoradia(controleS);
									}
								}
								if (controle == 5) {
									System.out.println(retorno.item.getCivil());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										retorno.item.setCivil(controleS);
									}
								}
								if (controle == 6) {
									System.out.println(retorno.item.getRaca());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										retorno.item.setRaca(controleS);
									}
								}
								if (controle == 7) {
									System.out.println(retorno.item.getId());
									System.out.println("Digite o novo par�metro, e 0 para cancelar:");
									controleS = scan.nextLine();
									if (controleS != "0") {
										controleS = scan.nextLine();
										Long result = Long.parseLong(controleS);
										retorno.item.setId(result);
									}
								}

								if (controle != 0) {
									controle = 10;
								}

							} while (controle != 0);
						}
					}
				} while (controle != 2);
			}
			
			//Op��o 3
			if(controle==3) {
				do {
					int[] objeto = relatorio.CaracterizacaoSexo(arvore.raiz);
					int teste = objeto[0];
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
					System.out.println("___________________________");a
										
					
					System.out.println("7 - Estat�sticas de idade");
					System.out.println("8 - Sair");
				}while(controle!=8);
			}

		} while (controle != 0);

		scan.close();
	}

}
