public class GerarRelatorioCaracterizacao {
	private int sexoF;
	private int sexoM;
	private int solteiro;
	private int casado;
	private int viuvo;
	private int divorciado;
	private int rural;
	private int urbana;
	private int parda;
	private int preta;
	private int branca;
	private int amarela;
	private int indigena;
	private int idade1;
	private int idade2;
	private int idade3;
	private int idade4;
	private int idade5;
	private int idade6;
	private int idade7;

	NodoPessoa raiz;

	public GerarRelatorioCaracterizacao(ArvorePessoa arvore) {
		this.raiz = arvore.raiz;
	}

	public int PopulacaoTotal() {
		return PopulacaoTotal(this.raiz);
	}

	private int PopulacaoTotal(NodoPessoa raiz) {
		int valor = 0;
		if (raiz != null) {
			valor += this.PopulacaoTotal(raiz.esquerda) + this.PopulacaoTotal(raiz.direita) + 1;
		}
		return valor;
	}

	public int[] CaracterizacaoSexo() {
		return CaracterizacaoSexo(this.raiz);
	}

	private int[] CaracterizacaoSexo(NodoPessoa raiz) {
		if (raiz != null) {
			String sexo = raiz.item.getSexo();
			if (sexo.equalsIgnoreCase("M")) {
				sexoM++;
			} else if (sexo.equalsIgnoreCase("F")) {
				sexoF++;
			}
			this.CaracterizacaoSexo(raiz.esquerda);
			this.CaracterizacaoSexo(raiz.direita);
		}
		return new int[] { sexoM, sexoF };
	}

	public int[] CaracterizacaoEstadoCivil() {
		return CaracterizacaoEstadoCivil(this.raiz);
	}

	private int[] CaracterizacaoEstadoCivil(NodoPessoa raiz) {
		if (raiz != null) {
			String civil = raiz.item.getCivil();

			if (civil.equalsIgnoreCase("solteiro")) {
				solteiro++;
			} else if (civil.equalsIgnoreCase("casado")) {
				casado++;
			} else if (civil.equalsIgnoreCase("viuvo")) {
				viuvo++;
			} else if (civil.equalsIgnoreCase("divorciado")) {
				divorciado++;
			}
			this.CaracterizacaoEstadoCivil(raiz.esquerda);
			this.CaracterizacaoEstadoCivil(raiz.direita);
		}
		return new int[] { solteiro, casado, viuvo, divorciado };
	}

	public int[] CaracterizacaoRaca() {
		return CaracterizacaoRaca(this.raiz);
	}

	private int[] CaracterizacaoRaca(NodoPessoa raiz) {
		if (raiz != null) {
			String raca = raiz.item.getRaca();

			if (raca.startsWith("parda")) {
				parda++;
			} else if (raca.equalsIgnoreCase("preta")) {
				preta++;
			} else if (raca.equalsIgnoreCase("branca")) {
				branca++;
			} else if (raca.equalsIgnoreCase("amarela")) {
				amarela++;
			} else if (raca.equalsIgnoreCase("indigena")) {
				indigena++;
			}

			this.CaracterizacaoRaca(raiz.esquerda);
			this.CaracterizacaoRaca(raiz.direita);
		}

		return new int[] { parda, preta, branca, amarela, indigena };
	}

	public int[] CaracterizacaoMoradia() {
		return CaracterizacaoMoradia(this.raiz);
	}

	private int[] CaracterizacaoMoradia(NodoPessoa raiz) {
		if (raiz != null) {
			String moradia = raiz.item.getMoradia();

			if (moradia.equalsIgnoreCase("rural")) {
				rural++;
			} else if (moradia.equalsIgnoreCase("urbana")) {
				urbana++;
			}

			this.CaracterizacaoMoradia(raiz.esquerda);
			this.CaracterizacaoMoradia(raiz.direita);
		}
		return new int[] { rural, urbana };
	}

	public int[] CaracterizacaoFaixaEtaria() {
		return CaracterizacaoFaixaEtaria(this.raiz);
	}

	private int[] CaracterizacaoFaixaEtaria(NodoPessoa raiz) {
		if (raiz != null) {
			int idade = raiz.item.getIdade();

			if (idade >= 0 && idade <= 12) {
				idade1++;
			} else if (idade > 13 && idade < 19) {
				idade2++;
			} else if (idade > 20 && idade < 25) {
				idade3++;
			} else if (idade > 26 && idade < 30) {
				idade4++;
			} else if (idade > 31 && idade < 45) {
				idade5++;
			} else if (idade > 46 && idade < 65) {
				idade6++;
			} else if (idade > 65) {
				idade7++;
			}

			this.CaracterizacaoFaixaEtaria(raiz.esquerda);
			this.CaracterizacaoFaixaEtaria(raiz.direita);
		}
		return new int[] { idade1, idade2, idade3, idade4, idade5, idade6, idade7 };
	}
}
