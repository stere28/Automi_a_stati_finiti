import java.util.*;
import terminale.Terminale;
public class Automa {
    private ArrayList<Stato> stati;
    private Automa(ArrayList<Stato> stati){
        this.stati = stati;
    }
    public Automa(){
        this.stati = new ArrayList<>();
    }
    public Automa(Automa a){
        //TODO
    }
    public static Automa inizializza(){
        //TODO
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
    public void addStato(Stato s){
        //TODO
    }
}
