public enum EstadoCivil {
    SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUVO("Viuvo");

    private String valor;

    EstadoCivil(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
