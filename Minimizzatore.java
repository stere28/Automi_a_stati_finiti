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
        //TODO
    }
    public boolean eGiaNotEquivalente(Stato s1, Stato s2){
        //TODO
    }
    public void setStatiEquivalenti(Stato s1, Stato s2){
        //TODO
    }
    public void setStatinotEquivalenti(Stato s1, Stato s2){
        //TODO
    }
    public boolean eCompletato(){
        //TODO
    }
}
