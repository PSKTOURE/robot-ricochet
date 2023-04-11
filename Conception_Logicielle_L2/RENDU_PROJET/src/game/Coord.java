package game;
/**
 * Classe réprésentant les coordonnées
 * @author toure215
 *
 */
public class Coord {
	private int x,y;
	
	/**
	 * Constructeur
	 * @param x
	 * @param y
	 */
	public Coord(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	//GETTERS AND SETTERS
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Méthode retournant si deux coordonnées sont égales
	 * @param other
	 * @return
	 */
	public boolean isSameCoord(Coord other) {
		return (this.x == other.getX() && this.y == other.getY());
	}
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	

}
