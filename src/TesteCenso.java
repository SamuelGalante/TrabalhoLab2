import java.io.IOException;

public class TesteCenso {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArvorePessoa arvore = PessoaDAO.montarArvoreDeArquivo("arquivo_de_teste.txt");
		Censo censo = new Censo(arvore);

		System.out.println("obterMediaIdadeGeral: " + censo.obterMediaIdadeGeral());
		System.out.println("obterMediaIdadeSexoFeminino: " + censo.obterMediaIdadeSexoFeminino());
		System.out.println("obterMediaIdadeSexoMasculino: " + censo.obterMediaIdadeSexoMasculino());
		System.out.println("obterMediaIdadeSolteiro: " + censo.obterMediaIdadeSolteiro());
		System.out.println("obterMediaIdadeCasado: " + censo.obterMediaIdadeCasado());
		System.out.println("obterDesvioPadraoIdadeCasado: " + censo.obterDesvioPadraoIdadeCasado());
		System.out.println("obterDesvioPadraoIdadeSolteiro: " + censo.obterDesvioPadraoIdadeSolteiro());
	}
}
