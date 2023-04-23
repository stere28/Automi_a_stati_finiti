import java.util.*;
import terminale.Terminale;
public class Automa {
    public LinkedList<Stato> stati;
    private Automa(LinkedList<Stato> stati){
        this.stati = stati;
    }
    public Automa(){
        this.stati = new LinkedList<>();
    }
    /*public Automa(Automa a){
        this.stati = copiaStati(a.stati);
    }
    private LinkedList<Stato> copiaStati(LinkedList<Stato> stati){
        //TODO
    }*/
    public static Automa inizializzaDaTerminale() {
        LinkedList<Stato> stati = new LinkedList<>();
        int nStatti = Terminale.richiediInt("Da quanti stati è composto l'automa? ");
        int nX = Terminale.richiediInt("Con quanti bit si codifica il segnale d'ingresso? ");
        for (int i = 0; i < nStatti; i++) {
            String nome = Terminale.richiediStringa("Qual'è il nome dello stato " + i + " ");
            stati.add(Stato.inizializza(nX, nome));
        }
        Set<String> xSet = stati.get(0).getXSet();
        for (Stato stato : stati) {
            for (String x : xSet) {
                stato.setz(x, Terminale.richiediInt("Qual'è luscita dello stato " + stato.getNome() +
                        " all'ingresso " + x + "? "));
                stato.setstatoOut(x, stati.get(Terminale.richiediInt("In quale stato andra? ")));
            }
        }
        return new Automa(stati);
    }
    /*
    @Override
    public String toString(){
        //TODO
    }*/
    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Stato))
            return false;
        Automa s = (Automa) obj;
        return this.stati.equals(s.stati);
    }
}
