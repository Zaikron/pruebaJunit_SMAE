package votos.models;

import java.util.ArrayList;
import java.util.List;

public class Partido {

    private List<Urna> urnas;
    private String nombre;

    public Partido() {
        urnas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Urna> getUrnas() {
        return urnas;
    }

    public void setUrnas(List<Urna> urnas) {
        this.urnas = urnas;
    }


    public void addCandidato(Urna urna){
        urna.setPartido(this);
        urnas.add(urna);

    }

    public void votar(Urna cand, int monto){
        cand.votar(monto);
    }

}
