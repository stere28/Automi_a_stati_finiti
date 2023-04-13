public class Stato {
	private int uscita0;
	private int uscita1;
	private Stato stato0;
	private Stato stato1;

	public Stato(int uscita0, int uscita1, Stato stato0, Stato stato1) {
		this.uscita0 = uscita0;
		this.uscita1 = uscita1;
		this.stato0 = stato0;
		this.stato1 = stato1;
	}

	@Override
	public String toString() {
		return "se riceve in input 1 restituisce: " + uscita1 + " e va nello stato " + stato1 + "\n" +
				"se riceve in input 0 restituisce: " + uscita0 + " e va nello stato " + stato0 + "\n";
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
		return this.uscita0 == s.uscita0 && this.uscita1 == s.uscita1 &&
				this.stato0.equals(s.stato0) && this.stato1.equals(s.stato1);
	}	
}