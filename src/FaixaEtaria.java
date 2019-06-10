public enum FaixaEtaria {
    IDADE_0_A_12("0 a 12 anos"), IDADE_13_A_19("13 a 19 anos"), IDADE_20_A_25("20 a 25 anos"),
    IDADE_26_A_30("26 a 30 anos"), IDADE_31_A_45("31 a 45 anos"), IDADE_46_A_65("46 a 65 anos"),
    IDADE_MAIOR_DE_65("Maior de 65 anos");

    public String valor;

    FaixaEtaria(String valor) {
        this.valor = valor;
    }
}
