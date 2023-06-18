import java.util.*;
import terminale.Terminale;

/**
 * The type Automa.
 */
public class Automa{
    /**
     * The Stati.
     */
    public LinkedList<Stato> stati;
    private Automa(LinkedList<Stato> stati){
        this.stati = stati;
    }

    /**
     * Instantiates a new Automa.
     */
    public Automa(){
        this.stati = new LinkedList<>();
    }

    /**
     * Instantiates a new Automa.
     *
     * @param a the a
     */
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

    /**
     * Inizializza da terminale automa.
     *
     * @return the automa
     */
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
                stato.setstatoOut(x, stati.get(trovaPosizione(Terminale.richiediStringa("In quale stato andra? "), stati)));
            }
        }
        return new Automa(stati);
    }
    private static int trovaPosizione(String nome, LinkedList<Stato> stati){
        int ret = 0;
        for(Stato stato : stati){
            if(nome.equals(stato.getNome())) return ret;
            ret ++;
        }
        return ret;
    }
    public static Automa inizializzaRandom() {
        LinkedList<Stato> stati = new LinkedList<>();
        int nStatti = Terminale.richiediInt("Da quanti stati è composto l'automa? ");
        int nX = Terminale.richiediInt("Con quanti bit si codifica il segnale d'ingresso? ");
        for (int i = 0; i < nStatti; i++) {
            String nome = Terminale.richiediStringa("Qual'è il nome dello stato " + i + " ");
            stati.add(Stato.inizializza(nX, nome));
        }
        Set<String> xSet = stati.get(0).getXSet();
        Random random = new Random();
        for (Stato stato : stati) {
            for (String x : xSet) {
                stato.setz(x, random.nextInt(2));
                stato.setstatoOut(x, stati.get(random.nextInt(nStatti)));
            }
        }
        return new Automa(stati);
    }/*
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

    /**
     * Minimizzatore minimizzatore.
     *
     * @return the minimizzatore
     */
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
    }/*
    public Automa minimalizza(){
        //TODO
    }*/

    /**
     * Classi equivalenza hash map.
     *
     * @return the hash map
     */
    public HashMap<String, LinkedList<String>> classiEquivalenza(){
        HashMap<String, LinkedList<String>> ret = new HashMap<>();
        Minimizzatore min = this.minimizzatore();
        LinkedList<Stato> giaVisti = new LinkedList<>();
        for(int i=0; i<stati.size(); i++){
            if(giaVisti.indexOf(this.stati.get(i)) == -1){
                for(int j=i+1; j<stati.size(); j++){
                    if(this.stati.get(i).eEquivalente(this.stati.get(j),min)){
                        giaVisti.add(this.stati.get(j));
                        if(ret.containsKey(this.stati.get(i).getNome())){
                            ret.get(this.stati.get(i).getNome()).add(this.stati.get(j).getNome());
                        }
                        else {
                            ret.put(this.stati.get(i).getNome(), new LinkedList<>());
                            ret.get(this.stati.get(i).getNome()).add(this.stati.get(j).getNome());
                        }
                    }
                }
            }
        }
        return ret;
    }

}