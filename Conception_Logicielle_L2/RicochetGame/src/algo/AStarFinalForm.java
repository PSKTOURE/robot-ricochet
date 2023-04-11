package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import game.Coord;
import game.Move;
import game.Robot;
import game.State;
import game.Target;

/**
 * Classe représentant l'algorithme A* dans 
 * sa forme finale
 * @author toure215
 *
 */
public class AStarFinalForm extends AStarMax {

	protected HashMap<State, State> cameFrom = new HashMap<>();
	protected HashMap<State, Integer> gScore = new HashMap<>();
	protected HashMap<State, Integer> fScore = new HashMap<>();

	/**
	 * Constructeur
	 * @param state
	 */
	public AStarFinalForm(State state) {
		super(state);
	}
	
	/**
	 * Construit le trajet du robot
	 * @param cameFrom Map avec l'état suivant comme clé et la 
	 * précédente comme valeur
	 * @param current: état actuelle
	 * @return le trajet effectué par le robot sous la forme d'une liste d'états
	 */
	public List<State> reconstructPath(Map<State, State> cameFrom, State current) {
		ArrayList<State> totalPath = new ArrayList<>();
		totalPath.add(current);
		while (cameFrom.containsKey(current)) {
			current = cameFrom.get(current);
			totalPath.add(current);
		}
		return totalPath;
	}
	
	/**
	 * Utilisé pour instancié la priorityQueu, compare 
	 * les fscore de deux State
	 * @param fScore
	 * @return comparator of State
	 */	
	public Comparator<State> getStateComparator(HashMap<State, Integer> fScore) {
		return (State S1, State S2) -> {
			int fScoreS1 = fScore.get(S1);
			int fScoreS2 = fScore.get(S2);
			return Integer.compare(fScoreS1, fScoreS2);
		};
	}
	/**
	 * Algorithme A*
	 * @return le plus court chemin pour atteindre la cible
	 * sous la forme de liste de States
	 */
	public List<State> aStarFF() {
		State startingState = super.state;
		Robot specialRobot1 = state.getSpecialRobot();
		Coord start = specialRobot1.getCoord();
		Target target = state.getCurrentTarget();
		int tentativeGScore;
		Comparator<State> comparator = getStateComparator(fScore);
		PriorityQueue<State> openQueue = new PriorityQueue<>(1, comparator);
		Set<State> openSet = new HashSet<>();
		int[][] table = super.heuristicTable(target);
		openQueue.add(startingState);
		openSet.add(startingState);
		gScore.put(startingState, 0);
		fScore.put(startingState, table[start.getX()][start.getY()]);
		while (!openQueue.isEmpty()) {
			State currentState = openQueue.poll();
			if (currentState.isOver()) {
				System.out.println("Solution Found in " + (reconstructPath(cameFrom,currentState).size() - 1) + " moves!");
				return reconstructPath(cameFrom, currentState);
			}
			ArrayList<Move> listOfMoves = currentState.getValidMoves();
			for (Move move : listOfMoves) {
				Robot robot = move.getRobot();
				Coord coord = move.getfinalCoord();
				State newState = currentState.moveRobot2(robot, coord);
				tentativeGScore = gScore.get(currentState) + 1;
				if (tentativeGScore < gScore.getOrDefault(newState, Integer.MAX_VALUE)) {
					cameFrom.put(newState, currentState);
					gScore.put(newState, tentativeGScore);
					fScore.put(newState, tentativeGScore + table[newState.getSpecialRobot().getCoord().getX()][newState.getSpecialRobot().getCoord().getY()]);
					if(!openSet.contains(newState)) {
						openQueue.add(newState);
						openSet.add(newState);
					}
				}
			}
		}
		System.out.println("No Solution");
		return Collections.emptyList();
	}

}
