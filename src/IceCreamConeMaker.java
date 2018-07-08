import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IceCreamConeMaker extends JPanel implements ActionListener {
	private IceCreamCone cone;
	private IceCreamConeView view;
	
	// four buttons that manipulate the scoops that are added
	private JButton vanillaButton;
	private JButton berryButton;
	private JButton teaButton;
	private JButton caramelButton;
	private JButton trashButton;
	private JButton randomButton;

	// panels that hold all the buttons
	private JPanel allButtons;
	private JPanel smallButtons;

	/**
	 * Constructor 
	 */
	public IceCreamConeMaker() {
		super(new BorderLayout());

		allButtons = new JPanel(new BorderLayout());
		smallButtons = new JPanel(new GridLayout());

		createView();
		createVanilla();
		createStrawberry();
		createTea();
		createCaramel();
		createTrash();
		createRandom();

	}
	/**
	 * Method defines the random button
	 */
	public void createRandom() {
		randomButton = new JButton("random");
		smallButtons.add(randomButton);
		allButtons.add(smallButtons, BorderLayout.NORTH);
		allButtons.add(smallButtons, BorderLayout.NORTH);
		
		randomButton.addActionListener(this);
		
	}
	/**
	 * Method defines the vanilla button
	 */
	public void createVanilla() {
		vanillaButton = new JButton("vanilla");
		smallButtons.add(vanillaButton);
		vanillaButton.setOpaque(true);
		vanillaButton.setBackground(Color.WHITE);
		allButtons.add(smallButtons, BorderLayout.NORTH);
		
		vanillaButton.addActionListener(this);

	}
	/**
	 * Method defines the strawberry button
	 */
	public void createStrawberry() {
		berryButton = new JButton("strawberry");
		berryButton.setOpaque(true);
		berryButton.setBackground(Color.PINK);
		smallButtons.add(berryButton);
		berryButton.setBackground(Color.PINK);
		allButtons.add(smallButtons, BorderLayout.NORTH);
		berryButton.addActionListener(this);
	}
	/**
	 * Method defines the tea button
	 */
	public void createTea() {
		teaButton = new JButton("green tea");
		teaButton.setOpaque(true);
		teaButton.setBackground(Color.GREEN);
		smallButtons.add(teaButton);
		teaButton.setBackground(Color.GREEN);
		allButtons.add(smallButtons, BorderLayout.NORTH);
		teaButton.addActionListener(this);
	}
	/**
	 * Method defines the caramel button
	 */
	public void createCaramel() {
		
		caramelButton = new JButton("caramel");
		caramelButton.setOpaque(true);
		caramelButton.setBackground(new Color(139,69,19));
		smallButtons.add(caramelButton);
		caramelButton.setBackground(new Color(139, 69, 19));
		allButtons.add(smallButtons, BorderLayout.NORTH);
		caramelButton.addActionListener(this);
	}
	/**
	 * Method that defines the trash button
	 */
	public void createTrash() {
		trashButton = new JButton("Trash the top scoop!");
		allButtons.add(smallButtons, BorderLayout.NORTH);	
		allButtons.add(trashButton, BorderLayout.SOUTH);
		trashButton.addActionListener(this);
	}
	/**
	 * Method creates view
	 */
	public void createView() {
		cone = new IceCreamCone();
		view = new IceCreamConeView(cone);
		add(allButtons, BorderLayout.NORTH);
		add(view, BorderLayout.CENTER);

	}
	/**
	 * Method manipulates buttons
	 * @param e ActionEvent 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== vanillaButton) {
			cone.addScoop(IceCreamCone.VANILLA);
		
		}
		if (e.getSource()== berryButton) {
			cone.addScoop(IceCreamCone.STRAWBERRY);
			
		}
		if (e.getSource()== teaButton) {
			cone.addScoop(IceCreamCone.GREEN_TEA);
					}
		if(e.getSource()== caramelButton) {
			cone.addScoop(IceCreamCone.BURNT_CARAMEL);
			
		}
		if(e.getSource() == trashButton) {
			cone.deleteScoop();
		}
		if(e.getSource()== randomButton) {
			cone.addScoop();
		}
		repaint();
	}
	public IceCreamCone getCone() {
		return cone;
	}
	public void removeCone() {
		while(!cone.isEmpty()) {
			cone.deleteScoop();
		}
	}
}
