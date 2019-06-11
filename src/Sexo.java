public enum Sexo {
    FEMININO("F"), MASCULINO("M");

    private String valor;

    Sexo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
