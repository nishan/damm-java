package org.damm;

public class Damm {

	private static final int[][] QUASI = { 
			{ 0, 3, 1, 7, 5, 9, 8, 6, 4, 2 },
			{ 7, 0, 9, 2, 1, 5, 4, 8, 6, 3 }, 
			{ 4, 2, 0, 6, 8, 7, 1, 3, 5, 9 },
			{ 1, 7, 5, 0, 9, 8, 3, 4, 2, 6 }, 
			{ 6, 1, 2, 3, 0, 4, 5, 9, 7, 8 },
			{ 3, 6, 7, 4, 2, 0, 9, 5, 8, 1 }, 
			{ 5, 8, 6, 9, 7, 2, 0, 1, 3, 4 },
			{ 8, 9, 4, 5, 3, 6, 2, 0, 1, 7 }, 
			{ 9, 4, 3, 8, 6, 1, 7, 2, 0, 5 },
			{ 2, 5, 8, 1, 4, 3, 6, 7, 9, 0 } };

	/**
	 * Generate the check digit based on Damm algorithm [http://en.wikipedia.org/wiki/Damm_algorithm]
	 * 
	 * @param number
	 * @return
	 */
	public static int checkSum(String number) {
		number = number.trim();
		int rowIndex = 0;
		int colIndex = 0;
		for (int i = 0; i < number.length(); i++) {
			colIndex = Integer.parseInt(String.valueOf(number.charAt(i)));
			rowIndex = QUASI[rowIndex][colIndex];
		}
		return rowIndex;
	}

	/**
	 * Validate the number based on Damm algorithm
	 * @param number
	 * @return
	 */
	public static boolean validate (String number) {
		return checkSum(number) == 0;
	}
	
	public static void main(String[] a) {
		System.out.println(checkSum("572"));
		System.out.println(validate("5724"));
	}
}
