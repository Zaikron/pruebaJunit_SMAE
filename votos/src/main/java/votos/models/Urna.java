package votos.models;

public class Urna {

    private String candidato;
    private int votos;
    private Partido partido;

    public Urna(String candidato, int votos) {
        this.candidato = candidato;
        this.votos = votos;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    /*public void votar(BigDecimal monto){
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new DineroInsuficienteException("Dinero Insuficiente");
        }
        this.saldo = nuevoSaldo;
    }*/

    public void votar(int cant){
        this.votos = this.votos += cant;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Urna)){
            return false;
        }
        Urna c = (Urna) obj;
        if(this.candidato == null || this.votos == 0){
            return false;
        }

        return this.candidato.equals(c.getCandidato()) && this.votos == c.getVotos();
    }



}
