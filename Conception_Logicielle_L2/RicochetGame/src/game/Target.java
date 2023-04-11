package game;

/**
 * Classe représentant une target
 * Une target est représenté par sa forme
 * sa couleur et ses coordonnées
 * @author toure215
 *
 */
public class Target {
	
	private char shape;
	private char color;
	private Coord coord;
	
	/**
	 * Constructeur
	 * @param shape
	 * @param color
	 * @param coord
	 */
	public Target(char shape, char color, Coord coord) {
		super();
		this.shape = shape;
		this.color = color;
		this.coord = coord;
	}
	
	//GETTERS AND SETTERS
	public char getShape() {
		return shape;
	}

	public void setShape(char shape) {
		this.shape = shape;
	}

	public char getcolor() {
		return color;
	}

	public void setcolor(char color) {
		this.color = color;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return "Target [shape=" + shape + ", color=" + color + ", coord=" + coord.toString() + "]";
	}
	
	
	

}
