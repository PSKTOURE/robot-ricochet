package game;

/**
 * Classe réprésentant un move
 * Un move est composé d'un robot et d'une coordonnée de destination
 * @author toure215
 *
 */
public class Move {
	private Robot robot;
	private Coord finalCoord;
	
	/**
	 * Constructeur
	 * @param robot
	 * @param finalCoord
	 */
	public Move(Robot robot, Coord finalCoord) {
		this.robot = robot;
		this.finalCoord = finalCoord;
	}
	
	/**
	 * Second constructeur
	 */
	public Move() {}
	
	//GETTERS AND SETTERS
	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public Coord getfinalCoord() {
		return finalCoord;
	}

	public void setfinalCoord(Coord finalCoord) {
		this.finalCoord = finalCoord;
	}

	@Override
	public String toString() {
		return "Move [robot=" + robot + ", finalCoord=" + finalCoord.toString() + "]";
	}
	
	
	

}
