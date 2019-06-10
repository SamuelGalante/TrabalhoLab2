public enum Sexo {
    FEMININO("Feminino"), MASCULINO("Masculino");

    private String valor;

    Sexo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
