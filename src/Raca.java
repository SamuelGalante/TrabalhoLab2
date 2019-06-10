public enum Raca {

    PARDA("Parda"), PRETA("Preta"), BRANCA("Branca"), AMARELA("Amarela"), INDIGENA("Indigena");

    private String valor;

    Raca(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
