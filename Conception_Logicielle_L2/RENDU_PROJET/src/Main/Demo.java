package Main;
/**
 * Classe exécutable de l'application
 */
import algo.AStarFinalForm;
import game.Robot;
import game.State;
import tab.Board;
import tab.Builder;
import view.GameGUI;


public class Demo {

	public static void main(String[] args) {
		
		Builder builder = new Builder();
		State state = new State(builder.board);
		GameGUI gui = new GameGUI(state);

		
		
		
	}
}