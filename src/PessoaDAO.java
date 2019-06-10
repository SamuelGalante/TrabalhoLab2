import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class PessoaDAO {
	static final String ARQUIVO = "arquivo_de_teste.txt";
	
	public ListaPessoa buscarTodos() throws NumberFormatException, IOException {
		ListaPessoa lista = new ListaPessoa();
		BufferedReader leitura = new BufferedReader(new FileReader(ARQUIVO));
		String linha;
		
		while((linha = leitura.readLine()) != null) {
			String [] dados = linha.split(";");
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(Long.parseLong(dados[0])); 
			pessoa.setNome(dados[1]); 
			pessoa.setSexo(dados[2]); 
			pessoa.setIdade(Integer.parseInt(dados[3])); 
			pessoa.setMoradia(dados[4]); 
			pessoa.setCivil(dados[5]); 
			pessoa.setRaca(dados[6]);
			
			lista.inserirFinal(pessoa);			
		}		
		
		leitura.close();
		return lista;
	}
	
	public Pessoa buscar(Pessoa pesquisada) throws IOException {
		BufferedReader leitura = new BufferedReader(new FileReader(ARQUIVO));
		String linha;
		
		while((linha = leitura.readLine()) != null) {
			String [] dados = linha.split(";");
			Long id = Long.parseLong(dados[0]);
			
			if(id.equals(pesquisada.getId())) {
				Pessoa resultado = new Pessoa(
						Long.parseLong(dados[0]), 
						dados[1], 
						dados[2], 
						Integer.parseInt(dados[3]), 
						dados[4], 
						dados[5], 
						dados[6]);
				
				leitura.close();
				return resultado;
			}
		}		
		
		leitura.close();
		return null;
	}
	
	public void adicionar(Pessoa pessoa) throws Exception {
		BufferedWriter escrita = new BufferedWriter(new FileWriter(ARQUIVO, true));

		escrita.write(pessoa.getId() + ";");
		escrita.write(pessoa.getNome() + ";");
		escrita.write(pessoa.getSexo() + ";");
		escrita.write(pessoa.getIdade() + ";");
		escrita.write(pessoa.getMoradia() + ";");
		escrita.write(pessoa.getCivil() + ";");
		escrita.write(pessoa.getRaca());
		escrita.write(System.getProperty("line.separator"));
			
		escrita.flush();
		escrita.close();
	}
	
	public void atualizar(Pessoa pessoa) throws NumberFormatException, IOException {
		ListaPessoa listaArquivo = buscarTodos();
		Pessoa pesquisada = listaArquivo.localizar(pessoa.getId());
		
		if(pesquisada != null) {
			pesquisada.setNome(pessoa.getNome());
			pesquisada.setSexo(pessoa.getSexo());
			pesquisada.setIdade(pessoa.getIdade());
			pesquisada.setMoradia(pessoa.getMoradia());
			pesquisada.setCivil(pessoa.getCivil());
			pesquisada.setRaca(pessoa.getRaca());
			
			salvarListaArquivo(listaArquivo);
		}
	}
	
	public void remover(Pessoa pessoa) throws NumberFormatException, IOException {
		ListaPessoa listaArquivo = buscarTodos();
		Pessoa retirada = listaArquivo.retirar(pessoa.getId());
		
		if(retirada != null) {
			salvarListaArquivo(listaArquivo);
		}
	}
	
	public void salvarListaArquivo(ListaPessoa listaArquivo) throws IOException {
		BufferedWriter escrita = new BufferedWriter(new FileWriter(ARQUIVO, false));
		while(!listaArquivo.listaVazia()) {
			Pessoa pessoa = listaArquivo.retirarPrimeiro();
			
			escrita.write(pessoa.getId() + ";");
			escrita.write(pessoa.getNome() + ";");
			escrita.write(pessoa.getSexo() + ";");
			escrita.write(pessoa.getIdade() + ";");
			escrita.write(pessoa.getMoradia() + ";");
			escrita.write(pessoa.getCivil() + ";");
			escrita.write(pessoa.getRaca());
			escrita.write(System.getProperty("line.separator"));
			escrita.flush();
		}
		
		escrita.close();
	}
}
