package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.Coord;
import game.Robot;
import game.State;
import util.Listener;

public class GameView  extends JPanel implements Listener {
	/**
	 * Classe assurant que la vue soit mise à
	 * jour à chaque fois que l'état change.
	 * Correspond à la partie vue de MVC
	 */
	private State state;
	private String moveLeft ;
	
	/**
	 * Constructeur
	 * @param state
	 */
	public GameView(State state) {
		this.state = state;
		state.addListener(this);
		setPreferredSize(new Dimension(16*40,16*40));
	}
	/**
	 * Méthode mettant à jour la vue à chaque que le modèle change
	 */
	@Override
	public void updateModel(Object s) {
		repaint();
	}
	
	/**
	 * Méthode pour dessiner les différents éléments  du plateau
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		char[] chars = {'R','B','G','Y'};
		Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
		Robot[] robots = state.getRobots();
		Coord[] coord = state.getRobotsCoord();
		g.setColor(Color.black);
		Font font = new Font("Arial", Font.BOLD, 18);
		g.setFont(font);
		g.drawString("FOUR Robots:", 670, 75);
		g.setColor(Color.RED);
		g.drawString("RED",690, 100);
		g.setColor(Color.BLUE);
		g.drawString("BLUE", 690, 125);
		g.setColor(Color.GREEN);
		g.drawString("GREEN", 690, 150);
		g.setColor(Color.YELLOW);
		g.drawString("YELLOW", 690, 175);
		g.setColor(Color.black);

			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Move left: " + moveLeft, 325, 680);
		

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 640, 640);
		g.setColor(Color.black);
		for (int i = 0; i <= 640; i += 40) { // chaque case fait 40x40
			g.drawLine(0, i, 640, i); // horizontale
			g.drawLine(i, 0, i, 640);// verticale
		}

		// ce code permet fait les murs
		g.setColor(Color.black);
		for (int ligne = 0; ligne < 16; ligne++) {
			for (int colonne = 0; colonne < 16; colonne++) {
				if (state.getBoard().getGameBoard()[ligne][colonne].matches(".*N.*"))
					g.fillRect(colonne * 40 - 2, ligne * 40 - 2, 44, 4);
				if (state.getBoard().getGameBoard()[ligne][colonne].matches(".*E.*"))
					g.fillRect(colonne * 40 + 38, ligne * 40 - 2, 4, 44);
				if (state.getBoard().getGameBoard()[ligne][colonne].matches(".*S.*"))
					g.fillRect(colonne * 40 - 2, ligne * 40 + 38, 44, 4);
				if (state.getBoard().getGameBoard()[ligne][colonne].matches(".*W.*"))
					g.fillRect(colonne * 40 - 2, ligne * 40 - 2, 4, 44);
			}
		}
		
		
		for(int i = 0; i < 4; i++) {
			if(state.getCurrentTarget().getcolor() == chars[i]) {
				g.setColor(colors[i]);
				g.fillRect(state.getCurrentTarget().getCoord().getY() * 40 + 5,
								state.getCurrentTarget().getCoord().getX() * 40 + 5, 30, 30);
			}
		}
		
		for(int k = 0; k < 4; k++) {
			g.setColor(colors[k]);
			g.fillOval(coord[k].getY() * 40 + 10, coord[k].getX() * 40 + 10, 20, 20);
		}
	}


	/**
	 * @return the moveLeft
	 */
	public String getM() {
		return moveLeft;
	}

	/**
	 * @param moveLeft the m to set
	 */
	public void setM(String m) {
		this.moveLeft = m;
	}
	
	
	

}
