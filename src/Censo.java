/**
 * Armazena e calcula dados de elementos da classe Pessoa
 */
public class Censo {

    private NodoPessoa raiz;

    public Censo(ArvorePessoa arvore) {
        raiz = arvore.raiz;
    }

    /**
     * Calcula a média de de idade de todas as pessoas
     */
    public double obterMediaIdadeGeral() {
        return obterMediaIdadeFiltro(null);
    }

    /**
     * Calcula a média de de idade das pessoas do sexo feminino cadastradas
     */
    public double obterMediaIdadeSexoFeminino() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.sexo = Sexo.FEMININO;
        return obterMediaIdadeFiltro(filtro);
    }

    /**
     * Calcula a média de de idade das pessoas do sexo masculino cadastradas
     */
    public double obterMediaIdadeSexoMasculino() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.sexo = Sexo.MASCULINO;
        return obterMediaIdadeFiltro(filtro);
    }

    /**
     * Calcula a média de de idade das pessoas solteiras cadastradas
     */
    public double obterMediaIdadeSolteiro() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.SOLTEIRO;
        return obterMediaIdadeFiltro(filtro);
    }

    /**
     * Calcula a média de de idade das pessoas casadas cadastradas
     */
    public double obterMediaIdadeCasado() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.CASADO;
        return obterMediaIdadeFiltro(filtro);
    }

    /**
     * Calcula o desvio padrão de idade das pessoas solteiras cadastradas
     */
    public double obterDesvioPadraoIdadeSolteiro() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.SOLTEIRO;
        return obterDesvioPadraoIdadeFiltro(filtro);
    }

    /**
     * Calcula o desvio padrão de idade das pessoas casadas cadastradas
     */
    public double obterDesvioPadraoIdadeCasado() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.CASADO;
        return obterDesvioPadraoIdadeFiltro(filtro);
    }

    /**
     * Calcula a média de idade daquelas pessoas nas quais o filtro se aplica
     *
     * @param filtro Filtro de características
     */
    private double obterMediaIdadeFiltro(OpcoesCenso filtro) {
        double resultado = 0;
        int totalPessoas = obterTotalPessoasFiltro(raiz, filtro);
        if (totalPessoas > 0) {
            int totalIdade = obterSomaIdadeFiltro(raiz, filtro);
            resultado = (double) totalIdade / totalPessoas;
        }
        return resultado;
    }

    /**
     * Obtém o total de pessoas das quais o filtro se aplica
     *
     * @param raiz   Elemento inicial para pesquisar
     * @param filtro Filtro de características para contar
     */
    private int obterTotalPessoasFiltro(NodoPessoa raiz, OpcoesCenso filtro) {
        int total = 0;
        if (raiz != null) {
            boolean filtroValido = aplicarFiltro(raiz, filtro);
            if (filtroValido) {
                total += 1;
            }
            total += obterTotalPessoasFiltro(raiz.direita, filtro);
            total += obterTotalPessoasFiltro(raiz.esquerda, filtro);
        }
        return total;
    }

    /**
     * Obtem a soma das idades de todas as pessoas nas quais o filtro se aplica.
     *
     * @param raiz   Elemento inicial para pesquisar
     * @param filtro Filtro de características para contar
     */
    private int obterSomaIdadeFiltro(NodoPessoa raiz, OpcoesCenso filtro) {
        int total = 0;
        if (raiz != null) {
            boolean filtroValido = aplicarFiltro(raiz, filtro);
            if (filtroValido) {
                total += raiz.item.getIdade();
            }
            total += obterSomaIdadeFiltro(raiz.direita, filtro);
            total += obterSomaIdadeFiltro(raiz.esquerda, filtro);
        }
        return total;
    }

    /**
     * Calcula o desvio padrão da característica especificada
     *
     * @param filtro Filtro de caracterísicas
     */
    private double obterDesvioPadraoIdadeFiltro(OpcoesCenso filtro) {
        double resultado = 0;
        int total = obterTotalPessoasFiltro(raiz, filtro);
        if (total > 0) {
            double mediaAritmetica = obterMediaIdadeFiltro(filtro);
            double soma = obterSomaDesvioPadraoFiltro(mediaAritmetica, raiz, filtro);
            resultado = Math.sqrt(soma / total);
        }
        return resultado;
    }

    /**
     * Multilica a idade de cada pessoa na qual o o filtro se aplica pela
     * mediaArimetica informada, para calcular o desvio padrão da caracteristica
     * filtrada e retorna a soma de todas as idades, para calcular o desvio padrão.
     * 
     * @param mediaAritmetica media para multiplicar cada idade
     * @param raiz            Elemento inicial
     * @param filtro          Filtro de características
     */
    private double obterSomaDesvioPadraoFiltro(double mediaAritmetica, NodoPessoa raiz, OpcoesCenso filtro) {
        int total = 0;
        if (raiz != null) {
            boolean filtroValido = aplicarFiltro(raiz, filtro);
            if (filtroValido) {
                total += Math.pow(raiz.item.getIdade() * mediaAritmetica, 2);
            }
            total += obterSomaIdadeFiltro(raiz.direita, filtro);
            total += obterSomaIdadeFiltro(raiz.esquerda, filtro);
        }
        return total;
    }

    /**
     * Verifica se os filtros se aplicam à raiz especificada.
     * 
     * @param raiz   Raíz da qual o elemento será testado
     * @param opcoes Opções para testar os filtros no elemento da raiz especificada
     * @return true caso o filtro se aplique, caso contrário, false
     */
    private boolean aplicarFiltro(NodoPessoa raiz, OpcoesCenso opcoes) {
        // Se um objeto de opções foi passado, verifica se o
        // NodoPessoa é valido e pode aplicar os filtros
        boolean condicao = opcoes == null || (raiz != null
                // Faixa etária indiferente ou igual ao filtro
                && (opcoes.faixaEtaria == null || raiz.item.getFaixaEtaria().equals(opcoes.faixaEtaria.getValor()))
                // Estado civil indiferente ou igual ao filtro
                && (opcoes.estadoCivil == null || raiz.item.getCivil().equals(opcoes.estadoCivil.getValor()))
                // Raça indiferente ou igual ao filtro
                && (opcoes.raca == null || raiz.item.getRaca().equals(opcoes.raca.getValor()))
                // Moradia indiferente ou igual ao filtro
                && (opcoes.moradia == null || raiz.item.getMoradia().equals(opcoes.moradia.getValor()))
                // Sexo indiferente ou igual ao filtro
                && (opcoes.sexo == null || raiz.item.getSexo().equals(opcoes.sexo.getValor())));
        return condicao;
    }
}
