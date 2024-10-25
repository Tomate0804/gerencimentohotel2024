public class Quartos {
    private int numero;
    private String tipo;
    private double precoDiario;
    private boolean disponivel;

    public Quartos(int numero, String tipo, double precoDiario, boolean disponivel) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = disponivel;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public double getPrecoDiario() { return precoDiario; }
    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}