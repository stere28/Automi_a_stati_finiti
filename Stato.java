import terminale.Terminale;

import java.util.*;

/**
 * The type Stato.
 */
public class Stato {
	private String nome;
	private HashMap<String, Integer> zOutput;
	private HashMap<String, Stato> statoOutput;

	/**
	 * METODO COSTRUTTORE.
	 * @param zOutput Hash map:
	 *                   key segnale di ingresso x
	 *                   valore segnale d'uscita z
	 * @param statoOutput Hash map:
	 *                    key segnale di ingresso x
	 *                    valore stato d'uscita statoOutput
	 */
	private Stato(String nome, HashMap<String,Integer> zOutput, HashMap<String, Stato> statoOutput) {
		this.nome = nome;
		this.zOutput = zOutput;
		this.statoOutput = statoOutput;
	}

	/**
	 * Inizializza stato.
	 * Un metodo statico che ci permette di creare un nuovo ogetto di tipo stato
	 *
	 * @param nX   numero di segnali di ingresso
	 * @param nome the nome
	 * @return the stato
	 */
	public static Stato inizializza(double nX, String nome){
		int nArchi = (int) Math.pow(2,nX);
		HashMap<String, Integer> zOutput = new HashMap<>();
		HashMap<String, Stato> statoOutput = new HashMap<>();
		for(int i=0; i<nArchi; i++){
			String bin = Integer.toBinaryString(i);
			zOutput.put(bin,0);
			statoOutput.put(bin,null);
		}
		return new Stato(nome, zOutput,statoOutput);
	}

	/**
	 * COPY COSTRUCTOR.
	 *
	 * @param s stato da copiare
	 */
	public Stato(Stato s){
		this.nome = s.nome;
		this.zOutput = new HashMap<>(s.zOutput);
		this.statoOutput = new HashMap<>(s.statoOutput);
	}
	@Override
	public String toString() {
		return this.nome + this.statoOutput.toString() + this.zOutput.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Stato))
			return false;
		Stato s = (Stato) obj;
		return this.nome.equals(s.nome) &&
				this.zOutput.equals(s.zOutput) &&
				this.statoOutput.equals(s.statoOutput);
	}

	/**
	 * Set nome.
	 *
	 * @param nome the nome
	 */
	public void setNome(String nome){
		this.nome = nome;
	}

	/**
	 * Gets nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Gets zOutputs.
	 *
	 * @return the zOutputs
	 */
	public HashMap<String, Integer> getzOutput() {
		return new HashMap<String, Integer>(zOutput);
	}

	/**
	 * Gets statoOutputs.
	 *
	 * @return the statoOutputs
	 */
	public HashMap<String, Stato> getstatoOutput() {
		return new HashMap<String, Stato>(statoOutput);
	}

	/**
	 * Gets z.
	 *
	 * @param x segnale d'ingresso.
	 * @return the z.
	 */
	public int getz(String x){
		return zOutput.get(x);
	}

	/**
	 * Set z.
	 *
	 * @param x the x
	 * @param z the z
	 */
	public void setz(String x, int z){
		zOutput.put(x,z);
	}

	/**
	 * Getstato out stato.
	 *
	 * @param x the x
	 * @return the stato
	 */
	public Stato getstatoOut(String x){
		return statoOutput.get(x);
	}

	/**
	 * Set stato out.
	 *
	 * @param x the x
	 * @param s the s
	 */
	public void setstatoOut(String x, Stato s){
		statoOutput.put(x,s);
	}

	/**
	 * Get x set set.
	 *
	 * @return the set
	 */
	public Set<String> getXSet(){
		return zOutput.keySet();
	}

	/**
	 * Equivalente boolean.
	 *
	 * @param s the stato s
	 * @return the boolean
	 */
	public boolean eEquivalente(Stato s){
		if(this.zDiverse(s)) return false;
		if(this.equals(s)) return true;
		return statoOutputEquivalenti(this,s);
	}
	public boolean eEquivalente(Stato s, Minimizzatore m){
		//Terminale.stampa(this.nome + s.nome);
		if(m.eGiaEquivalente(this, s)){
			m.setStatiEquivalenti(this, s);
			return true;
		}
		if(m.eGiaNotEquivalente(this, s)){
			m.setStatinotEquivalenti(this, s);
			return false;
		}
		if(this.zDiverse(s)){
			m.setStatinotEquivalenti(this, s);
			return false;
		}
		if(this.equals(s)){
			m.setStatiEquivalenti(this, s);
			return true;
		}
		return statoOutputEquivalenti(this, s, m);
	}
	private boolean zDiverse(Stato s){
		for (String key : this.zOutput.keySet()) {
			if(this.zOutput.get(key) != s.zOutput.get(key)) return true;
		}
		return false;
	}
	private static boolean statoOutputEquivalenti(Stato s1, Stato s2){
		for (String key : s1.statoOutput.keySet()) {
			Stato statoOutputS1 = s1.statoOutput.get(key);
			Stato statoOutputS2 = s2.statoOutput.get(key);
			if(statoOutputS1.equals(s2) && statoOutputS2.equals(s1)) continue;
			if(statoOutputS1.equals(s1) && statoOutputS2.equals(s2)) continue;
			if(!statoOutputS1.eEquivalente(statoOutputS2)) return false;
		}
		return true;
	}
	private static boolean statoOutputEquivalenti(Stato s1, Stato s2,Minimizzatore m){
		ArrayList<String> keys = new ArrayList<>(s1.statoOutput.keySet());
		Collections.shuffle(keys);
		for (String key : keys) {
			Stato statoOutputS1 = s1.statoOutput.get(key);
			Stato statoOutputS2 = s2.statoOutput.get(key);
			if(statoOutputS1.equals(s2) && statoOutputS2.equals(s1)) continue;
			if(statoOutputS1.equals(s1) && statoOutputS2.equals(s2)) continue;
			if(!statoOutputS1.eEquivalente(statoOutputS2, m)){
				m.setStatinotEquivalenti(s1,s2);
				return false;
			}
		}
		m.setStatiEquivalenti(s1,s2);
		return true;
	}
}