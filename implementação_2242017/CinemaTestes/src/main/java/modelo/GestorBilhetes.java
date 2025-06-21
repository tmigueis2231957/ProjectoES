package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorBilhetes {

    public Bilhete comprarBilhete(Sessao sessao, List<Lugar> lugaresDesejados) {
        List<Lugar> reservados = new ArrayList<>();

        for (Lugar lugar : lugaresDesejados) {
            if (sessao.lugarDisponivel(lugar)) {
                lugar.ocupar();
                reservados.add(lugar);
            } else {
                throw new IllegalArgumentException("Lugar " + lugar.getIdentificador() + " indisponível.");
            }
        }

        return new Bilhete(sessao, reservados);
    }
}