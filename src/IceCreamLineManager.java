import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IceCreamLineManager extends JPanel implements ActionListener {
	private IceCreamLine line;

	private JButton addOrder;
	private JButton serveNext;

	private JPanel panel;
/**
 * Constructor of line manager
 */
	public IceCreamLineManager() {
		super(new BorderLayout());
		
		line = new IceCreamLine();

		panel = new JPanel(new BorderLayout());

		// create add order button
		addOrder = new JButton("Add a random order");
		panel.add(addOrder, BorderLayout.NORTH);
		addOrder.addActionListener(this);
		
		// create serve next order button
		serveNext = new JButton("Serve the next order");
		panel.add(serveNext, BorderLayout.SOUTH);
		serveNext.addActionListener(this);

		
		add(panel, BorderLayout.NORTH);

		add(line, BorderLayout.CENTER);
		
	

	}
	
/**
 * Method manipulates the buttons
 * e ActionEvent
 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addOrder) {
			line.addRandomOrder();
			

		}
		if (e.getSource() == serveNext) {
			if(line!=null)
			line.serveNextOrder();
			
		
		}
		validate();
		repaint();
		
	}
/**
 * Main method
 * @param args String
 */
	public static void main(String[] args) {
		JFrame guiFrame;

		guiFrame = new JFrame();
		// set size of the game
		guiFrame.setSize(400, 700);
		guiFrame.add(new IceCreamLineManager());

		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setVisible(true);
	}
}
