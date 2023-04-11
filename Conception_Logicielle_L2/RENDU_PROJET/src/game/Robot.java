package game;
/**
 * Classe représentant un robot
 * Un robot est représenté par un nom et une coordonnée
 * @author toure215
 *
 */
public class Robot {
	private char name;
	private Coord coord;
	
	/**
	 * Constructeur
	 * @param name
	 * @param coord
	 */
	public Robot(char name, Coord coord) {
		super();
		this.name = name;
		this.coord = coord;
	}
	
	//GETTERS AND SETTERS
	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return "Robot [name=" + name + ", coord=" + coord.toString() + "]";
	}
	
	/**
	 * Méthode verifiant si deux robot sont égaux
	 * @param robot
	 * @return true if sameRobot else false
	 */
	public boolean isSameRobot(Robot robot) {
		boolean ok = false;
		if(robot.getName() == this.getName() && robot.getCoord().isSameCoord(this.getCoord())) {
			ok = true;
		}
		return ok;
	}
	
	

}
