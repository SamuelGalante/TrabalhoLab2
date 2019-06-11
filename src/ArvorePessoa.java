
public class ArvorePessoa {
	NodoPessoa raiz;

	public ArvorePessoa() {
		raiz = null;
	}

	public Boolean arvoreVazia() {
		return raiz == null;
	}

	private NodoPessoa inserir(NodoPessoa raizArvore, Pessoa pessoaNova) {
		if (raizArvore == null) {
			raizArvore = new NodoPessoa(pessoaNova);
		} else {
			if (raizArvore.item.getId() > pessoaNova.getId()) {
				raizArvore.esquerda = inserir(raizArvore.esquerda, pessoaNova);
			} else {
				if (raizArvore.item.getId() < pessoaNova.getId()) {
					raizArvore.direita = inserir(raizArvore.direita, pessoaNova);
				} else {
					System.out.println(pessoaNova.getNome() + "já foi inserido anteriormente!");
				}
			}
		}
		return raizArvore;
	}

	public void inserir(Pessoa pessoaNova) {
		this.raiz = inserir(this.raiz, pessoaNova);
	}

	private Pessoa pesquisar(NodoPessoa raizArvore, Long id) {
		Pessoa pessoa = null;
		if (raizArvore != null) {
			if (raizArvore.item.getId() > id) {
				pessoa = pesquisar(raizArvore.esquerda, id);
			} else if (raizArvore.item.getId() < id) {
				pessoa = pesquisar(raizArvore.direita, id);
			} else {
				return raizArvore.item;
			}
		}
		return pessoa;
	}
	
	private NodoPessoa pesquisarNodoPessoa(NodoPessoa raizArvore, Long id) {
		NodoPessoa nodo = null;
		if (raizArvore != null) {
			if (raizArvore.item.getId() > id) {
				nodo = pesquisarNodoPessoa(raizArvore.esquerda, id);
			} else if (raizArvore.item.getId() < id) {
				nodo = pesquisarNodoPessoa(raizArvore.direita, id);
			} else {
				return raizArvore;
			}
		}
		return nodo;
	}

	public Pessoa pesquisar(Long id) {
		return pesquisar(raiz, id);
	}

	public NodoPessoa antecessor(NodoPessoa raizArvore, Long id) {
		if (raizArvore.item.getId() == id) {
			return null;
		} else {
			if (raizArvore.esquerda.item.getId() == id || raizArvore.direita.item.getId() == id) {
				return raizArvore;
			} else {
				if (raizArvore.item.getId() > id) {
					raizArvore.esquerda = antecessor(raizArvore.esquerda, id);
				} else {
					raizArvore.direita = antecessor(raizArvore.direita, id);
				}
			}
		}
		return raizArvore;
	}

	private Boolean remover(NodoPessoa raizArvore, NodoPessoa remover, NodoPessoa antecessor) {
		// Se estiver vazia
		if (raizArvore == null) {
			return false;
		} else {
			// Se for folha
			if (remover.direita == null && remover.esquerda == null) {
				if (antecessor.esquerda == remover) {
					antecessor.esquerda = null;
				} else if (antecessor.direita == remover) {
					antecessor.direita = null;
				}
			}

			// Se tiver um filho
			if ((remover.esquerda == null && remover.direita != null)
					|| (remover.esquerda != null && remover.direita == null)) {
				if (remover.esquerda == null) {
					if (antecessor.item.getId() > remover.item.getId()) {
						antecessor.esquerda = remover.direita;
					} else {
						antecessor.direita = remover.direita;
					}
				} else {
					if (antecessor.item.getId() > remover.item.getId()) {
						antecessor.esquerda = remover.esquerda;
					} else {
						antecessor.direita = remover.esquerda;
					}
				}
			}

			// Se tiver os dois filhos
			if (remover.esquerda != null && remover.direita != null) {
				NodoPessoa aux = remover.direita;
				while (aux.esquerda != null) {
					aux = aux.esquerda;
				}
				Long idAux = aux.item.getId();
				NodoPessoa aux2 = antecessor(raiz, idAux);

				if (antecessor != aux2) {
					aux2.esquerda = aux.direita;
				}
				if (antecessor.item.getId() > remover.item.getId()) {
					antecessor.esquerda = aux;
					aux.esquerda = remover.esquerda;
					if (aux.direita != remover.direita) {
						aux.direita = remover.direita;
					}
				} else {
					antecessor.direita = aux;
					aux.esquerda = remover.esquerda;
					if (aux.direita != remover.direita) {
						aux.direita = remover.direita;
					}
				}
			}
			return true;
		}
	}
	
	public String[] gerarListaArquivo() {
		StringBuilder sb = new StringBuilder();
		gerarListaArquivo(raiz, sb);
		return sb.toString().split("\n");
	}
	
	private void gerarListaArquivo(NodoPessoa raiz, StringBuilder sb) {
		if (raiz != null) {
			String linha = String.format("%s;%s;%s;%s;%s;%s;%s\n",
					raiz.item.getId(),
					raiz.item.getNome(),
					raiz.item.getSexo(),
					raiz.item.getIdade(),
					raiz.item.getMoradia(),
					raiz.item.getCivil(),
					raiz.item.getRaca());
			
			sb.append(linha);
			
			gerarListaArquivo(raiz.direita, sb);
			gerarListaArquivo(raiz.esquerda, sb);
		}
	}

	public void remover(Long id) {
		NodoPessoa aux = pesquisarNodoPessoa(raiz, id);
		remover(raiz, aux, antecessor(raiz, id));
	}
}