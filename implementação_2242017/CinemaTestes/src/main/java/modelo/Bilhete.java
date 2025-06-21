package modelo;

import java.util.List;

public class Bilhete {
    private Sessao sessao;
    private List<Lugar> lugares;

    public Bilhete(Sessao sessao, List<Lugar> lugares) {
        this.sessao = sessao;
        this.lugares = lugares;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public Sessao getSessao() {
        return sessao;
    }
}