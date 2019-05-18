
public class Testes {

	public static void main(String[] args) {
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
        
	}

}
