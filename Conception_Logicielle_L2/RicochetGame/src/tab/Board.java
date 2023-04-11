package tab;

import java.util.ArrayList;
import java.util.Collections;

import game.Coord;
import game.Target;
/**
 * Classe réprésentant le plateau du jeu
 * @author toure215
 *
 */
public class Board {
	private Quarter[] quarters = new Quarter[4];
	private String[][] gameBoard = new String[16][16];

	/**
	 * Constructeur
	 * @param quarters
	 */
	public Board(Quarter[] quarters) {
		this.quarters = quarters;
		String[][] quaterOne = quarters[0].randomFace();
		String[][] quaterTwo = quarters[1].randomFace();
		String[][] quaterThree = quarters[2].randomFace();
		String[][] quaterFour = quarters[3].randomFace();

		ArrayList<String[][]> list = new ArrayList<>();
		list.add(quaterOne);
		list.add(quaterTwo);
		list.add(quaterThree);
		list.add(quaterFour);
		Collections.shuffle(list);

		for (int i = 1; i <= 3; i++) {
			quarters[0].rotateQuarter(list.get(i), i);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				gameBoard[i][j] = list.get(0)[i][j];
				gameBoard[i][j + 8] = list.get(1)[i][j];
				gameBoard[i + 8][j + 8] = list.get(2)[i][j];
				gameBoard[i + 8][j] = list.get(3)[i][j];
			}
		}

	}
	/**
	 * Second constructeur 
	 */
	public Board() {
		
	}
	
	/*
	 * Méthode tournant l'ensemble des cibles présentes sur le plateau
	 */
	public ArrayList<Target> findTargets() {
		ArrayList<Target> list = new ArrayList<>();
		String[] string = { "RT", "GT", "YT", "BT", "RC", "GC", "YC", "BC", "RH", "GH", "YH", "BH", "RQ", "GQ", "YQ",
				"BQ" };
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (String s : string) {
					if (gameBoard[i][j].contains(s)) {
						Coord coord = new Coord(i, j);
						Target target = new Target(s.charAt(1), s.charAt(0), coord);
						list.add(target);
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * Méthode faisant une copy du plateau
	 * @return une copy
	 */
	public Board copyBoard() {
		Board copyBoard = new Board();
		String[][] copyGameBoard = new String[16][16];
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				copyGameBoard[i][j] = gameBoard[i][j];
			}
		}
		copyBoard.setGameBoard(copyGameBoard);
		return copyBoard;
	}

	//GETTERS AND SETTERS AND TOSTRING
	public Quarter[] getQuarters() {
		return quarters;
	}

	public void setQuarters(Quarter[] quarters) {
		this.quarters = quarters;
	}

	public String[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	
	public void printBoard() {
		for (String row[] : gameBoard) {
			System.out.print("|");
			for (String col : row) {
				System.out.print(col);
				System.out.print("| \t");
			}
			System.out.println();
		}

	}

}
