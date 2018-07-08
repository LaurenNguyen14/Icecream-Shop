import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class IceCreamConeView extends JComponent {
	private IceCreamCone cone;
	public static final int DIAM = 50; // diameter of scoop
	public static final int GAP = 10; // the overlap of scoops
	public static final int CONE_HEIGHT = 70;

	/**
	 * Constructor of the cone view
	 * 
	 * @param cone
	 *            IceCreamCone
	 */
	public IceCreamConeView(IceCreamCone cone) {
		this.cone = cone;
	}

	/**
	 * Method that paints the cone
	 * @param g Graphics g
	 */
	public void paintCone(Graphics g) {
		Color coneColor = Color.ORANGE;
		g.setColor(coneColor);
		
		// set the x and y of three points of polygon
		int[] x = { getWidth() / 2 - DIAM / 3 - 3, getWidth() / 2, getWidth() / 2 + DIAM / 3 + 3 };
		int[] y = { getHeight() - CONE_HEIGHT, getHeight(), getHeight() - CONE_HEIGHT };
		g.fillPolygon(x, y, 3);

	}
	/**
	 * Method that paint the view
	 * @param g Graphics
	 */
	public void paint(Graphics g) {
		// the y of of the ice cream
		int y = getHeight() - CONE_HEIGHT - DIAM + GAP;
		// create a temporary stack
		IceCreamCone temp = new IceCreamCone();
		paintCone(g);
		
		// while the scone stack is not empty, pop the top and add it to the temporary stack
		while (!cone.isEmpty())
			temp.addScoop(cone.deleteScoop());
		// while the temporary stack is not empty
		while (!temp.isEmpty()) {
			// pop the scoop from temp back to the cone
			String flavor = temp.deleteScoop();
			cone.addScoop(flavor);
			
			if (flavor.equals(IceCreamCone.VANILLA))
				g.setColor(Color.WHITE);
			if (flavor.equals(IceCreamCone.STRAWBERRY))
				g.setColor(Color.PINK);
			if (flavor.equals(IceCreamCone.GREEN_TEA))
				g.setColor(Color.GREEN);
			if (flavor.equals(IceCreamCone.BURNT_CARAMEL))
				g.setColor(new Color(139, 69, 19));

			g.fillOval(getWidth() / 2 - DIAM / 2, y, DIAM, DIAM);
			y = y - DIAM + GAP; // after draw a scoop, move up the y

		}
	}
}
