import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IceCreamShop extends JPanel implements ActionListener {
	private int numWin;

	private IceCreamLine line;
	private IceCreamConeMaker coneMaker;

	private JLabel scoreLabel;

	private JPanel west, east;
	private JLabel instruction;
	private JPanel topPanel;
	private JPanel buttonPanel;

	private JButton addOrder;
	private JButton serveNext;
/**
 * Constructor of IceCreamShop
 */
	public IceCreamShop() {
		super(new BorderLayout());
		numWin = 0; //score number
		
		// panel of line and coneMaker
		west = new JPanel(new BorderLayout());
		east = new JPanel(new BorderLayout());
		
		//panel that holds the instruction
		topPanel = new JPanel(new BorderLayout());
		
		//panel that holds the button
		buttonPanel = new JPanel(new BorderLayout());

		line = new IceCreamLine();
		coneMaker = new IceCreamConeMaker();

		// create new buttons
		addOrder = new JButton("Add a random order");
		buttonPanel.add(addOrder, BorderLayout.SOUTH);
		topPanel.add(buttonPanel, BorderLayout.SOUTH);
		addOrder.addActionListener(this);

		serveNext = new JButton("Serve the next order");
		buttonPanel.add(serveNext, BorderLayout.NORTH);
		topPanel.add(buttonPanel, BorderLayout.SOUTH);
		serveNext.addActionListener(this);

		createView();
		createScore();

	}
/**
 * Methods that create the original view
 */
	public void createView() {
		west.add(line, BorderLayout.CENTER);
		east.add(coneMaker, BorderLayout.CENTER);

		west.add(buttonPanel, BorderLayout.SOUTH);
		add(topPanel, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.CENTER);

	}
	/**
	 * Methods that create the score view 
	 */

	public void createScore() {
		instruction = new JLabel("<html>Make icecream cones to match top order<br>"
				+ "<html>Every correct order gives you 10 points<br>" + "<html>Make a wrong choice and you'll lose 5 points<br>");
		scoreLabel = new JLabel("Score: " + getNumWin());
		topPanel.add(instruction, BorderLayout.NORTH);
		topPanel.add(scoreLabel, BorderLayout.SOUTH);
	}
/**
 * Methods that calculate the score
 */
	public void calScore() {
		if (matchCone(line.getCone(), coneMaker.getCone())) {
			numWin = numWin + 10;

		} else {
			numWin = numWin - 5;
		}
		repaint();
		scoreLabel.setText("Score: " + getNumWin());

	}
/**
 * Method the gets the current score
 * @return numWin int
 */
	public int getNumWin() {
		return numWin;
	}

	/**
	 * Method that manipulates the buttons
	 * @param e ActionEvent e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addOrder) {
			line.addRandomOrder();
			
		}
		if (e.getSource() == serveNext) {
			if (!line.isEmpty()) {
				// calculate the score 
				calScore();
				// then remove the order
				line.serveNextOrder();
				coneMaker.removeCone();
			}
		}
		validate();
		repaint();

	}
/**
 * Method that check if the cones are matched
 * @param cone1 IceCreamCone
 * @param cone2 IceCreamCone
 * @return true if the two cones are matched
 */
	public boolean matchCone(IceCreamCone cone1, IceCreamCone cone2) {
		while (!cone1.isEmpty() && !cone2.isEmpty()) {
			if (!cone1.deleteScoop().equals(cone2.deleteScoop()))
				return false;
		}
		// after matching the scoops, if a cone is not empty, it is false
		if (!cone1.isEmpty() || !cone2.isEmpty())
			return false;

		return true;

	}
/**
 * Main method
 * @param args String
 */
	public static void main(String[] args) {
		JFrame guiFrame;

		guiFrame = new JFrame();
		// set size of the game
		guiFrame.setSize(400 * 2, 700);
		guiFrame.add(new IceCreamShop());

		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setVisible(true);
	}
}
