package view;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import algo.AStarFinalForm;
import game.Move;
import game.State;
import tab.Builder;

/**
 * Méthode assurant l'affichage du plateau
 * hérite de JFrame
 * @author toure215
 *
 */
public class GameGUI extends JFrame{
	static final long serialVersionUID = 1L;
	private State state;
	private GameView view;
	private JButton buttonReset, buttonNext, buttonStart;
	List<State> listOfStates;
	int k = 0;
	int m;
	
	public GameGUI(State state) {
		super("Ricochet Robots");
		this.state = state;
		AStarFinalForm astar = new AStarFinalForm(state);
		listOfStates = astar.aStarFF();
		m = listOfStates.size() - 1;
		
		//creation des différents component
		JPanel panelSouth = new JPanel();
		panelSouth.setSize(new Dimension(840,280));
		panelSouth.setLayout(new GridLayout(1,2));
		buttonReset = new JButton("Reset");
		buttonNext = new JButton("Next");
		buttonStart = new JButton("Start");

		
		//ajout des différents components au container
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		panelSouth.add(buttonReset);
		panelSouth.add(buttonStart);
		panelSouth.add(buttonNext);		
		container.add(panelSouth, BorderLayout.SOUTH);
		
		//fonctionnalité des différents boutons
		buttonReset.addActionListener(this::reset);
		buttonNext.addActionListener(this::next);
		buttonStart.addActionListener(this::start);
		
		
		view = new GameView(state);
		view.setM(Integer.toString(m));
		container.add(view, BorderLayout.CENTER);
		
		this.pack();
		this.setSize(840, 820);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	/**
	 * Méthode performant l'action jouer next move lorsque l'on
	 * clique sur le boutton next
	 * @param e
	 */
	public void next(ActionEvent e) {
		m = m-1;
		if(k >= listOfStates.size()-1) {
			view.setM("Robot at target location. Reset");
			repaint();
		}
		try {
			view.setM(Integer.toString(m));
			state.next(listOfStates, k);
			k++;
		} catch (IndexOutOfBoundsException e1) {
			view.setM("Robot at target location. Reset");
			repaint();
		}
	}
	
	/**
	 * Méthode perfomant un reset du plateau
	 * @param e
	 */
	public void reset(ActionEvent e) {
		long startTime = System.currentTimeMillis();
		k = 0;
		this.remove(view);
		Builder builder = new Builder();
		state = new State(builder.board);
		AStarFinalForm astar = new AStarFinalForm(state);
		listOfStates = astar.aStarFF();
		m = listOfStates.size() - 1;
		view = new GameView(state);
		view.setM(Integer.toString(m));
		this.getContentPane().add(view);
		SwingUtilities.updateComponentTreeUI(this);
		long endTime = System.currentTimeMillis();
		System.out.println("Solution found " + (endTime - startTime) + " milliseconds");
		
	}
	
	/**
	 * Méthode jouant l'ensemble des moves automatiquement 
	 * lorsque l'on clique sur le boutton start
	 * @param e
	 */
	public void start(ActionEvent e) {
		List<Move> listOfMoves = state.moveMade(listOfStates);
		state.setListOfMoves(listOfMoves);
		Thread thread = new Thread(state);
		thread.start();
		if(state.isOver()) {
		view.setM("Robot at target location. Reset");
		repaint();
		}
		repaint();
	}

	





}
