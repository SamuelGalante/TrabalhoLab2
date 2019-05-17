
public class Pessoa {
		
		private int id;
		private String nome;
		private String sexo;
		private int idade;
		private String moradia;
		private String civil;
		private String raca;
		
		public Pessoa (int idPessoa, String nomePessoa, String sexoPessoa, int idadePessoa, String moradiaPessoa, String civilPessoa, String racaPessoa) {
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
		public void setId(int id) {
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
		public void setIdade(int idade) {
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
		
		
}
