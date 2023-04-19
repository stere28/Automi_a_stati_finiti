import java.util.*;

/**
 * The type Stato.
 */
public class Stato {
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
	private Stato(HashMap<String, Integer> zOutput,HashMap<String, Stato> statoOutput) {
		this.zOutput = zOutput;
		this.statoOutput = statoOutput;
	}

	/**
	 * Inizializza stato.
	 * Un metodo statico che ci permette di creare un nuovo ogetto di tipo stato
	 *
	 * @param nX numero di segnali di ingresso
	 * @return the stato
	 */
	public static Stato inizializza(double nX){
		int nArchi = (int) Math.pow(2,nX);
		HashMap<String, Integer> zOutput = new HashMap<>();
		HashMap<String, Stato> statoOutput = new HashMap<>();
		for(int i=0; i<nArchi; i++){
			String bin = Integer.toBinaryString(i);
			zOutput.put(bin,0);
			statoOutput.put(bin,null);
		}
		return new Stato(zOutput,statoOutput);
	}

	/**
	 * COPY COSTRUCTOR.
	 *
	 * @param s stato da copiare
	 */
	public Stato(Stato s){
		//TODO
	}
	@Override
	public String toString() {
		//TODO
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
		return this.zOutput.equals(s.zOutput) && this.statoOutput.equals(s.statoOutput);
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
	 * Equivalente boolean.
	 *
	 * @return the boolean
	 */
	public boolean equivalente(){
		//TODO
	}
}