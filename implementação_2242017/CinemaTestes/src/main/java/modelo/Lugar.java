package modelo;

public class Lugar {
    private String fila;
    private int numero;
    private boolean ocupado;

    public Lugar(String fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public String getIdentificador() {
        return fila + numero;
    }
}