package Main;
import game.State;
import tab.Builder;
import view.GameGUI;


public class Demo {

	public static void main(String[] args) {
		
		Builder builder = new Builder();
		State state = new State(builder.board);
		long startTime = System.currentTimeMillis();
		GameGUI gui = new GameGUI(state);
		long endTime = System.currentTimeMillis();
		System.out.println("Solution found " + (endTime - startTime) + " milliseconds");
	}
}