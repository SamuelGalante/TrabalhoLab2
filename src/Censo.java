/**
 * Censo
 */
public class Censo extends ArvorePessoa {

    public double obterMediaIdadeGeral() {
        return obterMediaIdadeFiltro(null);
    }

    public double obterMediaIdadeSexoFeminino() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.sexo = Sexo.FEMININO;
        return obterMediaIdadeFiltro(filtro);
    }

    public double obterMediaIdadeSexoMasculino() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.sexo = Sexo.MASCULINO;
        return obterMediaIdadeFiltro(filtro);
    }

    public double obterMediaIdadeSolteiro() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.SOLTEIRO;
        return obterMediaIdadeFiltro(filtro);
    }

    public double obterMediaIdadeCasado() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.CASADO;
        return obterMediaIdadeFiltro(filtro);
    }

    public double obterDesvioPadraoIdadeSolteiro() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.SOLTEIRO;
        return obterDesvioPadraoIdadeFiltro(filtro);
    }

    public double obterDesvioPadraoIdadeCasado() {
        OpcoesCenso filtro = new OpcoesCenso();
        filtro.estadoCivil = EstadoCivil.CASADO;
        return obterDesvioPadraoIdadeFiltro(filtro);
    }

    private double obterMediaIdadeFiltro(OpcoesCenso filtro) {
        int totalIdade = obterSomaIdadeFiltro(raiz, filtro);
        int totalPessoas = obterTotalPessoasFiltro(raiz, filtro);
        return totalIdade / totalPessoas;
    }

    private int obterTotalPessoasFiltro(NodoPessoa raiz, OpcoesCenso filtro) {
        int total = 0;
        if (raiz != null) {
            boolean filtroValido = aplicarFiltro(raiz, filtro);
            if (filtroValido) {
                total += 1;
                total += obterTotalPessoasFiltro(raiz.direita, filtro);
                total += obterTotalPessoasFiltro(raiz.esquerda, filtro);
            }
        }
        return total;
    }

    private double obterSomaIdadeFiltro(NodoPessoa raiz, OpcoesCenso filtro) {
        int total = 0;
        if (raiz != null) {
            boolean filtroValido = aplicarFiltro(raiz, filtro);
            if (filtroValido) {
                total += raiz.item.getIdade();
                total += obterSomaIdadeFiltro(raiz.direita, filtro);
                total += obterSomaIdadeFiltro(raiz.esquerda, filtro);
            }
        }
        return total;
    }

    private double obterDesvioPadraoIdadeFiltro(OpcoesCenso filtro) {
        double mediaAritmetica = obterMediaIdadeFiltro(filtro);
        double soma = obterSomaDesvioPadraoFiltro(mediaAritmetica, raiz, filtro);
        int total = obterTotalPessoasFiltro(raiz, filtro);
        double resultado = soma / total;
        return Math.sqrt(divisao);
    }

    private double obterSomaDesvioPadraoFiltro(double mediaAritmetica, NodoPessoa raiz, OpcoesCenso filtro) {
        int total = 0;
        if (raiz != null) {
            boolean filtroValido = aplicarFiltro(raiz, filtro);
            if (filtroValido) {
                total += Math.pow(raiz.item.getIdade() * mediaAritmetica, 2);
                total += obterSomaIdadeFiltro(raiz.direita, filtro);
                total += obterSomaIdadeFiltro(raiz.esquerda, filtro);
            }
        }
        return total;
    }

    private boolean aplicarFiltro(NodoPessoa raiz, OpcoesCenso opcoes) {
        boolean condicao = raiz != null && opcoes != null
                && (opcoes.faixaEtaria != null && raiz.item.getFaixaEtaria().equals(opcoes.faixaEtaria))
                && (opcoes.estadoCivil != null && raiz.item.getCivil().equals(opcoes.estadoCivil.valor))
                && (opcoes.raca != null && raiz.item.getRaca().equals(opcoes.raca.valor))
                && (opcoes.moradia != null && raiz.item.getMoradia().equals(opcoes.moradia.valor))
                && (opcoes.sexo != null && raiz.items.getSexo().equals(opcoes.sexo.valor));
        return condicao;
    }
}
