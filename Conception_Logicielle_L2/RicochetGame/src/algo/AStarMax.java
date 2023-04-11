package algo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import game.Coord;
import game.Move;
import game.Robot;
import game.State;
import game.Target;
/**
 * Classe représentant l'algorithme A*
 * hérite de AStar
 * @author toure215
 *
 */
public class AStarMax extends AStar {
	
	/**
	 * Constructeur
	 * @param state
	 */
	public AStarMax(State state) {
		super(state);
	}
	
	/**
	 * Méthode calculant la table des heuristiques
	 *  3 3 2 1 2 2 2 2 2 2 2 3 4 3 4 3 
		2 2 2 1 3 3 3 3 3 3 3 3 3 3 4 3 
		3 3 2 1 2 2 2 2 2 2 2 2 2 2 4 3 
		2 2 2 1 2 2 2 3 3 3 3 3 3 3 3 3 
		2 2 2 1 2 2 2 2 2 2 2 2 2 2 2 2 
		2 2 2 1 2 2 2 2 2 2 2 3 3 3 3 4 
		4 3 3 0 1 1 1 1 1 1 1 1 3 3 3 4 
		4 3 3 3 2 2 2 0 0 2 2 2 3 3 3 4 
		4 3 3 3 2 2 2 0 0 2 2 2 3 3 3 4 
		4 3 3 4 2 2 2 3 3 2 2 2 3 3 3 5 
		5 5 3 3 3 2 2 3 3 2 2 2 3 3 4 4 
		4 4 3 3 3 2 2 3 3 2 2 2 3 3 4 4 
		4 4 3 3 3 2 2 3 3 2 2 2 3 4 4 4 
		4 4 3 3 3 2 3 3 3 2 3 2 3 4 4 4 
		4 4 3 3 3 2 3 3 3 2 3 2 3 4 4 4 
		5 5 5 4 3 2 3 3 3 2 3 2 3 4 4 4 
	 * @param target :  la cible du jeu
	 * @return la table des heuristique ou chaque nombre représente le nombre de coups
	 * atteindre la cible
	 */
	public int[][] heuristicTable(Target target) {
		int n = 5;
		String[][] Board = state.getBoard().getGameBoard();
		ArrayList<ArrayList<Coord>> list = new ArrayList<>(n);
		int[][] table = new int[16][16];
		ArrayList<Coord> list0 = new ArrayList<>();
		ArrayList<Coord> list1 = new ArrayList<>();
		ArrayList<Coord> list2 = new ArrayList<>();
		ArrayList<Coord> list3 = new ArrayList<>();
		ArrayList<Coord> list4 = new ArrayList<>();
		ArrayList<Coord> list5 = new ArrayList<>();
		list0.add(target.getCoord());
		list.add(list0); list.add(list1); list.add(list2); list.add(list3); list.add(list4); list.add(list5);
		for (int k = 0; k < 5; k++) {
			for (Coord c : list.get(k)) {
				int xk = c.getX();
				int yk = c.getY();
				int xn = xk;
				int xs = xk;
				int ye = yk;
				int yw = yk;
				while (xs < 15 && Board[xs][yk].indexOf('S') == -1 && table[xs + 1][yk] == 0) {
					xs++;
					table[xs][yk] = k+1;
					list.get(k+1).add(new Coord(xs, yk));
				}
				while (xn > 0 && Board[xn][yk].indexOf('N') == -1 && table[xn - 1][yk] == 0) {
					xn--;
					table[xn][yk] = k+1;
					list.get(k+1).add(new Coord(xn, yk));
				}
				while (ye < 15 && Board[xk][ye].indexOf('E') == -1 && table[xk][ye + 1] == 0) {
					ye++;
					table[xk][ye] = k+1;
					list.get(k+1).add(new Coord(xk, ye));
				}
				while (yw > 0 && Board[xk][yw].indexOf('W') == -1 && table[xk][yw - 1] == 0) {
					yw--;
					table[xk][yw] = k+1;
					list.get(k+1).add(new Coord(xk, yw));
				}
			}
		}
		table[target.getCoord().getX()][target.getCoord().getY()] = 0;
		return table;
	}
	
	/**
	 * Algorithme A* deuxième version 
	 * @return le plus court trajet pour atteindre la cible pour le robot actif
	 * sous la forme d'une liste de coordonnées
	 */
	public List<Coord> aStarMax() {
		Coord start = state.getSpecialRobot().getCoord();
		Coord goal = state.getCurrentTarget().getCoord();
		int[][] table = this.heuristicTable(state.getCurrentTarget());
		int tentativeGScore;
		Comparator<Coord> comparator = getCoordComparator(fScore);
		PriorityQueue<Coord> openQueue = new NoDuplicateQueue<>(1, comparator);
		Set<Coord> openSet = new HashSet<>();
		openQueue.add(start);
		openSet.add(start);
		gScore.put(start, 0);
		fScore.put(start, table[start.getX()][start.getY()]);

		while (!openQueue.isEmpty()) {
			Coord current = openQueue.peek();
			if (current.isSameCoord(goal)) {
				System.out.println("Solution Found in " + (reconstructPath(cameFrom,current).size() - 1) + " moves!");
				return reconstructPath(cameFrom, current);
			}
			openQueue.remove(current);
			state.moveRobot(state.getSpecialRobot(), current);
			ArrayList<Move> listOfMoves = state.getOneRobotMoves(state.getSpecialRobot());
			ArrayList<Coord> listOfCoord = new ArrayList<Coord>();
			for (Move move : listOfMoves) {
				listOfCoord.add(move.getfinalCoord());
			}
			for (Coord neighbor : listOfCoord) {
				tentativeGScore = gScore.get(current) + 1;
				if (tentativeGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
					cameFrom.put(neighbor, current);
					gScore.put(neighbor, tentativeGScore);
					fScore.put(neighbor, tentativeGScore + table[neighbor.getX()][neighbor.getY()]);
					if(!openSet.contains(neighbor)) {
						openSet.add(neighbor);
						openSet.add(neighbor);
					}
					
				}
			}
		}

		System.out.println("No Solution");
		return Collections.emptyList();

	}

}
