import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class IceCreamLine extends Box {

	private QueueLL<IceCreamCone> line;

	private IceCreamConeView view;
/**
 * Constructor of icecream line
 */
	public IceCreamLine() {
		super(BoxLayout.Y_AXIS);

		line = new QueueLL<>();

	}
/**
 * Method that add a random order
 */
	public void addRandomOrder() {
		IceCreamCone cone = new IceCreamCone(); // create a new cone
		//generate a random number of scoops
		Random scoopNum = new Random();
		int num = scoopNum.nextInt(4);

		if (num == 0) {
			cone.addScoop();

		}
		if (num == 1) {
			int i = 0;
			while (i <= num) {

				cone.addScoop();
				i++;
			}

		}
		if (num == 2) {
			int i = 0;
			while (i <= num) {
				cone.addScoop();
				i++;
			}

		}
		if (num == 3) {
			int i = 0;
			while (i <= num) {
				cone.addScoop();
				i++;
			}

		}
		
		// add the cone to the queue
		line.enqueue(cone);
		// update the view
		view = new IceCreamConeView(cone);
		add(view);

	}

	/**
	 * Method that remove the current order
	 * @return nextOrder IceCreamCone
	 */
	public IceCreamCone serveNextOrder() {
		remove(0);
		return line.dequeue();

	}
/**
 * Method that check if the line is empty
 * @return true if the line is empty
 */
	public boolean isEmpty() {
		return line.isEmpty();
	}
	/**
	 * Method that get the cone data
	 * @return scoop peeked IceCreamCone
	 */

	public IceCreamCone getCone() {
		return line.peek();

	}
}
