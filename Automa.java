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
    public Automa(Automa a){
        this(copiaStati(a.stati));
    }
    private static LinkedList<Stato> copiaStati(LinkedList<Stato> stati){
        LinkedList<Stato> ret = new LinkedList<>();
        for(Stato stato: stati){
            ret.add(new Stato(stato));
        }
        return ret;
    }
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
    @Override
    public String toString(){
        //TODO
    }
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
    public Minimizzatore minimizzatore(){
        int len = this.stati.size();
        ListIterator<Stato> iter = this.stati.listIterator();
        String[] nomiStati = new String[len];
        boolean[][] giaEquivalenti = new boolean[len][len];
        boolean[][] giaNotEquivalenti = new boolean[len][len];
        for(int i=0; i<len && iter.hasNext(); i++){
            nomiStati[i] = iter.next().getNome();
            for(int j=0; j<len; j++){
                giaEquivalenti[i][j] = false;
                giaNotEquivalenti[i][j] = false;
            }
        }
        return new Minimizzatore(giaEquivalenti,giaNotEquivalenti,nomiStati);
    }
    public void minimalizza(){
        //TODO
    }
    public HashMap<String, String[]> classiEquivalenza(){
        //TODO
    }

}
