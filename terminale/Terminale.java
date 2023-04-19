package terminale;

/**
 * The type Terminale.
 */
public class Terminale {
	private static java.util.Scanner keyboard = new java.util.Scanner(System.in);

	/**
	 * Richiedi stringa string.
	 *
	 * @param prompt the prompt
	 * @return the string
	 */
	public static String richiediStringa(String prompt)
	{	stampaNoCR(prompt);
		String v = keyboard.nextLine();
		return v;
	}

	/**
	 * Richiedi int int.
	 *
	 * @param prompt the prompt
	 * @return the int
	 */
	public static int richiediInt(String prompt)
	{	stampaNoCR(prompt);
		int v = keyboard.nextInt();
		keyboard.nextLine();
		return v;
	}

	/**
	 * Richiedi long long.
	 *
	 * @param prompt the prompt
	 * @return the long
	 */
	public static long richiediLong(String prompt)
	{	stampaNoCR(prompt);
		long v = keyboard.nextLong();
		keyboard.nextLine();
		return v;
	}

	/**
	 * Richiedi float float.
	 *
	 * @param prompt the prompt
	 * @return the float
	 */
	public static float richiediFloat(String prompt)
	{	stampaNoCR(prompt);
		float v = keyboard.nextFloat();
		keyboard.nextLine();
		return v;
	}

	/**
	 * Richiedi double double.
	 *
	 * @param prompt the prompt
	 * @return the double
	 */
	public static double richiediDouble(String prompt)
	{	stampaNoCR(prompt);
		double v = keyboard.nextDouble();
		keyboard.nextLine();
		return v;
	}

	/**
	 * Stampa linea vuota.
	 */
	public static void stampaLineaVuota()
	{	System.out.println();
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(Object s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(Object s)
	{	System.out.println(s);
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(int s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(int s)
	{	System.out.println(s);
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(long s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(long s)
	{	System.out.println(s);
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(float s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(float s)
	{	System.out.println(s);
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(double s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(double s)
	{	System.out.println(s);
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(char s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(char s)
	{	System.out.println(s);
	}

	/**
	 * Stampa no cr.
	 *
	 * @param s the s
	 */
	public static void stampaNoCR(boolean s)
	{	System.out.print(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(boolean s)
	{	System.out.println(s);
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(int[][] s) {
		int m = s.length;
		int n = s[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.printf("%4d", s[i][j]);
			}
			System.out.println("");
		}
	}

	/**
	 * Stampa.
	 *
	 * @param s the s
	 */
	public static void stampa(boolean[][] s) {
		int m = s.length;
		int n = s[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(s[i][j]);
				System.out.print("  ");
			}
			System.out.println("");
		}
	}
}

