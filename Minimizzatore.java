public class Minimizzatore {
    private boolean[][] giaEquivalenti;
    private boolean[][] giaNotEquivalenti;
    private String[] nomiStati;
    Minimizzatore(boolean[][] giaEquivalenti, boolean[][] giaNotEquivalenti, String[] nomiStati){
        this.giaEquivalenti = giaEquivalenti;
        this.giaNotEquivalenti = giaNotEquivalenti;
        this.nomiStati = nomiStati;
    }
    public boolean eGiaEquivalente(Stato s1, Stato s2){
        int indiceS1 = indexof(nomiStati, s1.getNome());
        int indiceS2 = indexof(nomiStati, s2.getNome());
        return giaEquivalenti[indiceS1][indiceS2] && giaEquivalenti[indiceS2][indiceS1];
    }
    public boolean eGiaNotEquivalente(Stato s1, Stato s2){
        int indiceS1 = indexof(nomiStati, s1.getNome());
        int indiceS2 = indexof(nomiStati, s2.getNome());
        return giaNotEquivalenti[indiceS1][indiceS2] && giaNotEquivalenti[indiceS2][indiceS1];
    }
    public void setStatiEquivalenti(Stato s1, Stato s2){
        int indiceS1 = indexof(nomiStati, s1.getNome());
        int indiceS2 = indexof(nomiStati, s2.getNome());
        giaEquivalenti[indiceS1][indiceS2] = true;
        giaEquivalenti[indiceS2][indiceS1] = true;
    }
    public void setStatinotEquivalenti(Stato s1, Stato s2){
        int indiceS1 = indexof(nomiStati, s1.getNome());
        int indiceS2 = indexof(nomiStati, s2.getNome());
        giaNotEquivalenti[indiceS1][indiceS2] = true;
        giaNotEquivalenti[indiceS2][indiceS1] = true;
    }
    public boolean eCompletato(){
        for(int i=0; i<giaEquivalenti.length; i++){
            for(int j=0; j<giaEquivalenti.length; j++){
                if(!(giaEquivalenti[i][j]||giaNotEquivalenti[i][j])) return false;
            }
        }
        return true;
    }
    private int indexof(String[] lista, String elemento ){
        for(int i=0; i<lista.length; i++){
            if(lista[i] == elemento){
                return i;
            }
        }
        return -1;
    }
}
