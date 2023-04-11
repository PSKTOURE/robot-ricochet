package tab;
/**
 * Classe assurant l'assemblage des différents
 * élements pour former un plateau
 * @author toure215
 *
 */
public class Builder {
	
	public  Board board;
	public static final String[][] QUAD_1A = { { "NW", "N", "N", "N", "NE", "NW", "N", "N" }, { "W", "S", "X", "X", "X", "X", "SEYH", "W" },
			{ "WE", "NWGT", "X", "X", "X", "X", "N", "X" }, { "W", "X", "X", "X", "X", "X", "X", "X" },
			{ "W", "X", "X", "X", "X", "X", "S", "X" }, { "SW", "X", "X", "X", "X", "X", "NEBQ", "W" },
			{ "NW", "X", "E", "SWRC", "X", "X", "X", "S" }, { "W", "X", "X", "N", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_1B = { { "NW", "NE", "NW", "N", "NS", "N", "N", "N" },
			{ "W", "S", "X", "E", "NWRC", "X", "X", "X" }, { "W", "NEGT", "W", "X", "X", "X", "X", "X" },
			{ "W", "X", "X", "X", "X", "X", "SEYH", "W" }, { "W", "X", "X", "X", "X", "X", "N", "X" },
			{ "SW", "X", "X", "X", "X", "X", "X", "X" }, { "NW", "X", "E", "SWBQ", "X", "X", "X", "S" },
			{ "W", "X", "X", "N", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_2A = { { "NW", "N", "N", "NE", "NW", "N", "N", "N" }, { "W", "X", "X", "X", "X", "E", "SWBC", "X" },
			{ "W", "S", "X", "X", "X", "X", "N", "X" }, { "W", "NEYT", "W", "X", "X", "S", "X", "X" },
			{ "W", "X", "X", "X", "E", "NWGQ", "X", "X" }, { "W", "X", "SERH", "W", "X", "X", "X", "X" },
			{ "SW", "X", "N", "X", "X", "X", "X", "S" }, { "NW", "X", "X", "X", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_2B = { { "NW", "N", "N", "N", "NE", "NW", "N", "N" }, { "W", "X", "SERH", "W", "X", "X", "X", "X" },
			{ "W", "X", "N", "X", "X", "X", "X", "X" }, { "WE", "SWGQ", "X", "X", "X", "X", "S", "X" },
			{ "SW", "N", "X", "X", "X", "E", "NWYT", "X" }, { "NW", "X", "X", "X", "X", "S", "X", "X" },
			{ "W", "X", "X", "X", "X", "NEBC", "W", "S" }, { "W", "X", "X", "X", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_3A = { { "NW", "N", "N", "NE", "NW", "N", "N", "N" }, { "W", "X", "X", "X", "X", "SEGH", "W", "X" },
			{ "WE", "SWRQ", "X", "X", "X", "N", "X", "X" }, { "SW", "N", "X", "X", "X", "X", "S", "X" },
			{ "NW", "X", "X", "X", "X", "E", "NWYC", "X" }, { "W", "X", "S", "X", "X", "X", "X", "X" },
			{ "W", "X", "NEBT", "W", "X", "X", "X", "S" }, { "W", "X", "X", "X", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_3B = { { "NW", "N", "NS", "N", "NE", "NW", "N", "N" },
			{ "W", "E", "NWYC", "X", "X", "X", "X", "X" }, { "W", "X", "X", "X", "X", "X", "X", "X" },
			{ "W", "X", "X", "X", "X", "E", "SWBT", "X" }, { "SW", "X", "X", "X", "S", "X", "N", "X" },
			{ "NW", "X", "X", "X", "NERQ", "W", "X", "X" }, { "W", "SEGH", "W", "X", "X", "X", "X", "S" },
			{ "W", "N", "X", "X", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_4A = { { "NW", "N", "N", "NE", "NW", "N", "N", "N" }, { "W", "X", "X", "X", "X", "X", "X", "X" },
			{ "W", "X", "X", "X", "X", "SEBH", "W", "X" }, { "W", "X", "S", "X", "X", "N", "X", "X" },
			{ "SW", "X", "NEGC", "W", "X", "X", "X", "X" }, { "NW", "S", "X", "X", "X", "X", "E", "SWRT" },
			{ "WE", "NWYQ", "X", "X", "X", "X", "X", "NS" }, { "W", "X", "X", "X", "X", "X", "E", "NWX" }, };

	public static final String[][] QUAD_4B = { { "NW", "N", "N", "NE", "NW", "N", "N", "N" },
			{ "WE", "SWRT", "X", "X", "X", "X", "S", "X" }, { "W", "N", "X", "X", "X", "X", "NEGC", "W" },
			{ "W", "X", "X", "X", "X", "X", "X", "X" }, { "W", "X", "SEBH", "W", "X", "X", "X", "S" },
			{ "SW", "X", "N", "X", "X", "X", "E", "NWYQ" }, { "NW", "X", "X", "X", "X", "X", "X", "S" },
			{ "W", "X", "X", "X", "X", "X", "E", "NWX" }, };
	
	/**
	 * Constructeur
	 */
	public Builder() {
		
		
		Quarter QUAD1 = new Quarter(copy(Builder.QUAD_1A), copy(Builder.QUAD_1B));
		Quarter QUAD2 = new Quarter(copy(Builder.QUAD_2A), copy(Builder.QUAD_2B));
		Quarter QUAD3 = new Quarter(copy(Builder.QUAD_3A), copy(Builder.QUAD_3B));
		Quarter QUAD4 = new Quarter(copy(Builder.QUAD_4A), copy(Builder.QUAD_4B));
	
		Quarter[] quaters = {QUAD1, QUAD2, QUAD3, QUAD4};
		
		board = new Board(quaters);
		
	}
	
	/**
	 * Méthode pour copier une matrice
	 * @param matrix
	 * @return copy de matrix
	 */
	private String[][] copy(String[][] matrix){
		String[][]copy = new String[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0; j<8;j++) {
				copy[i][j] = matrix[i][j];
			}
		}
		return copy;
	}

}
