package tab;

import java.util.Arrays;
/**
 * Classe représentant un quartier 8x8
 * @author toure215
 *
 */
public class Quarter {

	private String[][] faceOne;
	private String[][] faceTwo;
	
	/**
	 * Constructeur
	 * @param faceOne
	 * @param faceTwo
	 */
	public Quarter(String[][] faceOne, String[][] faceTwo) {
		this.faceOne = faceOne;
		this.faceTwo = faceTwo;
	}

	/**
	 * Méthode faisant la rotation de 90° d'une face
	 * @param matrix
	 * @param n : nombre de fois que l'on applique la rotation
	 * @return matrice tourné n * 90°
	 */
	public String[][] rotateQuarter(String[][] matrix, int n) {

		// determines the transpose of the matrix
		for (int l = 1; l <= n; l++) {
			for (int i = 0; i < 8; i++) {
				for (int j = i; j < 8; j++) {
					String temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
			// then we reverse the elements of each row
			for (int k = 0; k < 8; k++) {
				// logic to reverse each row i.e 1D Array.
				int low = 0, high = 7;
				while (low < high) {
					String temp = matrix[k][low];
					matrix[k][low] = matrix[k][high];
					matrix[k][high] = temp;
					low++;
					high--;
				}
			}
			update(matrix);
		}
		return matrix;

	}
	 /**
	  * Méthode mettant à jour les faces apres une rotation
	  * @param matrix
	  * @return matrice mise à jour
	  */
	public String[][] update(String[][] matrix) {

		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				StringBuilder string = new StringBuilder(matrix[a][b]);
				for (int i = 0; i<string.length();i++) {
					char c = string.charAt(i);
					if (c == 'N') {
				        string.setCharAt(i, 'E');
					}
					if(c == 'E') {
						string.setCharAt(i, 'S');
					}
					if(c == 'S') {
						string.setCharAt(i, 'W');
					}
					if(c == 'W') {
						string.setCharAt(i, 'N');
					}
				}
				matrix[a][b] = string.toString();
			}
		}
		return matrix;
	}
	
	
	/**
	 * Méthode tirant un chiffre random
	 * @return une face au random
	 */
	public String[][] randomFace() {
		if (Math.random() < 0.5) {
			return faceOne;
		} else {
			return faceTwo;
		}
	}

	/**
	 * toString d'une face
	 */
	@Override
	public String toString() {
		
		String res = "";
		for (String[] row : faceOne) {
			res += Arrays.toString(row);
			res += "\n";
		}
		return res;
	}
	
	//GETTERS AND SETTERS

	/**
	 * @return the faceOne
	 */
	public String[][] getFaceOne() {
		return faceOne;
	}

	/**
	 * @param faceOne the faceOne to set
	 */
	public void setFaceOne(String[][] faceOne) {
		this.faceOne = faceOne;
	}

	/**
	 * @return the faceTwo
	 */
	public String[][] getFaceTwo() {
		return faceTwo;
	}

	/**
	 * @param faceTwo the faceTwo to set
	 */
	public void setFaceTwo(String[][] faceTwo) {
		this.faceTwo = faceTwo;
	}
}
