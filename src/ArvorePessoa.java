
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
	

	private NodoPessoa pesquisar(NodoPessoa raizArvore, int id) {

		if (raizArvore == null) {
			System.out.println("Não foi possível encontrar a matrícula. Favor verificar o número digitado");
			return raizArvore;
		} else {
			if (raizArvore.item.getId() > id) {
				raizArvore.esquerda = pesquisar(raizArvore.esquerda, id);
			} else {
				if (raizArvore.item.getId() < id) {
					raizArvore.direita = pesquisar(raizArvore.direita, id);
				} else {
					return raizArvore;
				}
			}
		}
		return null;
	}
	

	public NodoPessoa pesquisar(int id) {
		NodoPessoa raizArvore = raiz;
		return pesquisar(raizArvore, id);
	}
	

	public NodoPessoa antecessor(NodoPessoa raizArvore, int id) {
		if(raizArvore.item.getId()==id) {
			System.out.println("Não possui antecessor, pois é a raiz.");
		}
		else {
			if(raizArvore.esquerda.item.getId()==id || raizArvore.direita.item.getId()==id) {
				return raizArvore;
			}
			else {
				if(raizArvore.item.getId()>id) {
					raizArvore.esquerda = antecessor(raizArvore.esquerda, id);
				}
				else {
					raizArvore.direita = antecessor(raizArvore.direita, id);
				}
			}
		}		
		return null;
	}

	private NodoPessoa remover(NodoPessoa raizArvore, int id) {
		if (raizArvore == null) {
			System.out.println("Não foi possível encontrar a matrícula. Favor verificar o número digitado");
			return raizArvore;
		} else {
			if (raizArvore.item.getId() == id) {

			}
		}
		return null;
	}

	public void remover (int id) {
		
	}
}