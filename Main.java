import terminale.Terminale;
public class Main {
    public static void main(String[] args) {
        Automa aut = Automa.inizializzaDaTerminale();
        for(int i=0; i<13; i++){
            for(int j=i+1; j<13; j++){
                if(aut.stati.get(i).eequivalente(aut.stati.get(j))){
                    Terminale.stampa("lo stato " + aut.stati.get(i).getNome() +
                            " è equivalente a " + aut.stati.get(j).getNome() );
                }
            }
        }
    }
}
