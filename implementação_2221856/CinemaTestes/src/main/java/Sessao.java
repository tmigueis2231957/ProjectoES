import java.util.List;

public class Sessao {
    private int id;
    private List<Lugar> lugares;

    public Sessao(int id, List<Lugar> lugares) {
        this.id = id;
        this.lugares = lugares;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public boolean lugarDisponivel(Lugar lugar) {
        return lugares.contains(lugar) && !lugar.isOcupado();
    }
}