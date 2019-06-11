
public class GerarRelatorioCaracterizacao {
	private int valor;
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
	
	public int PopulacaoTotal(NodoPessoa raiz)
	{
		if(raiz != null) {
			valor = this.PopulacaoTotal(raiz.esquerda) + this.PopulacaoTotal(raiz.direita) + 1;
			return valor;
		}else {
			return valor;
		}
	}
	
	public int[] CaracterizacaoSexo(NodoPessoa raiz) {
		String sexo = raiz.item.getSexo();
		
		if(raiz != null) {
			if(sexo.startsWith("masculino")) {
				sexoM++;
			}else if(sexo.startsWith("feminino")) {
				sexoF++;
			}
			this.CaracterizacaoSexo(raiz.esquerda);
			this.CaracterizacaoSexo(raiz.direita);
		}				
		return new int[] {sexoM, sexoF};
	}
	
	public int[] CaracterizacaoEstadoCivil(NodoPessoa raiz) {
		String civil = raiz.item.getCivil();
		
		if(raiz != null) {
			if(civil.startsWith("solteiro")) {
				solteiro++;
			}else if(civil.startsWith("casado")) {
				casado++;
			}else if(civil.startsWith("viuvo")) {
				viuvo++;
			}else if(civil.startsWith("divorciado")) {
				divorciado++;
			}
			this.CaracterizacaoSexo(raiz.esquerda);
			this.CaracterizacaoSexo(raiz.direita);
		}
		return new int[] {solteiro,casado,viuvo,divorciado};
	}
	
	public int[] CaracterizacaoRaca(NodoPessoa raiz) {
		String raca = raiz.item.getRaca();
		
		if(raiz != null) {
			if(raca.startsWith("parda")) {
				parda++;
			}else if(raca.startsWith("preta")) {
				preta++;
			}else if(raca.startsWith("branca")) {
				branca++;
			}else if(raca.startsWith("amarela")) {
				amarela++;
			}else if(raca.startsWith("indigena")) {
				indigena++;
			}
			
			this.CaracterizacaoSexo(raiz.esquerda);
			this.CaracterizacaoSexo(raiz.direita);
		}
		
		return new int[] {parda,preta,branca,amarela,indigena};
	}
	
	public int[] CaracterizacaoMoradia(NodoPessoa raiz) {
		String moradia = raiz.item.getMoradia();
		
		if(raiz != null) {
			if(moradia.startsWith("rural")) {
				rural++;
			}else if(moradia.startsWith("urbana")) {
				urbana++;
			}
			
			this.CaracterizacaoSexo(raiz.esquerda);
			this.CaracterizacaoSexo(raiz.direita);
		}
		return new int[] {rural,urbana};
	}
	
	public int[] CaracterizacaoFaixaEtaria(NodoPessoa raiz) {
		int idade = raiz.item.getIdade();
		
		if(raiz != null) {
			if(idade >= 0 && idade <= 12) {
				idade1++;
			}else if(idade > 13 && idade < 19) {
				idade2++;
			} else if(idade > 20 && idade < 25) {
				idade3++;
			}else if(idade > 26 && idade < 30) {
				idade4++;
			}else if(idade > 31 && idade < 45) {
				idade5++;
			}else if(idade > 46 && idade < 65) {
				idade6++;
			}else if(idade > 65) {
				idade7++;
			}
			
			this.CaracterizacaoSexo(raiz.esquerda);
			this.CaracterizacaoSexo(raiz.direita);
		}
		return new int[] {idade1,idade2,idade3,idade4,idade5,idade6};
	}
}
