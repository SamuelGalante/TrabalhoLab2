public enum TipoMoradia {
    RURAL("Rural"), URBANA("Urbana");

    private String valor;

    TipoMoradia(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
