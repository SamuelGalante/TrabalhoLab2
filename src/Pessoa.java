
public class Pessoa {

	private Long id;
	private String nome;
	private String sexo;
	private Integer idade;
	private String moradia;
	private String civil;
	private String raca;

	public Pessoa() {
	}

	public Pessoa(Long idPessoa) {
		setId(idPessoa);
	}

	public Pessoa (Long idPessoa, String nomePessoa, String sexoPessoa, Integer idadePessoa, String moradiaPessoa, String civilPessoa, String racaPessoa) {
		setId(idPessoa);
		setNome(nomePessoa);
		setSexo(sexoPessoa);
		setIdade(idadePessoa);
		setMoradia(moradiaPessoa);
		setCivil(civilPessoa);
		setRaca(racaPessoa);
	}

	public int getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getMoradia() {
		return moradia;
	}

	public void setMoradia(String moradia) {
		this.moradia = moradia;
	}

	public String getCivil() {
		return civil;
	}

	public void setCivil(String civil) {
		this.civil = civil;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getFaixaEtaria() {
		FaixaEtaria faixa;
		if (this.idade > 65) {
			faixa = FaixaEtaria.IDADE_MAIOR_DE_65;
		} else if (this.idade > 45) {
			faixa = FaixaEtaria.IDADE_46_A_65;
		} else if (this.idade > 30) {
			faixa = FaixaEtaria.IDADE_31_A_45;
		} else if (this.idade > 25) {
			faixa = FaixaEtaria.IDADE_26_A_30;
		} else if (this.idade > 19) {
			faixa = FaixaEtaria.IDADE_20_A_25;
		} else if (this.idade > 12) {
			faixa = FaixaEtaria.IDADE_13_A_19;
		} else {
			faixa = FaixaEtaria.IDADE_0_A_12;
		}
		return faixa.getValor();
	}
}
