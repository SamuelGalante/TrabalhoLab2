
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
		
		public Long getId() {
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
		public String getSexoDesc() {
			return sexo.equalsIgnoreCase("m") ? "Masculino" : "Feminino";
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public Integer getIdade() {
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
		
		@Override
		public String toString() {
			return "Nome: " + this.getNome() + "\n" +
				   "Identidade: " + this.getId() + "\t" +
				   "Sexo: " + this.getSexoDesc() + "\t" +
				   "Idade: " + this.getIdade() + "\n" +
				   "Estado civil: " + this.getCivil() + "\t" +
				   "Raça: " + this.getRaca() + "\n" +
				   "Morador da Zona " + this.getMoradia() + "\n";
		}
		
}
