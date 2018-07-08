import java.util.Random;

public class IceCreamCone {
	private StackLL<String> coneStack; //stack of the icecream
	public static final String VANILLA = "vanilla";
	public static final String STRAWBERRY = "strawberry";
	public static final String GREEN_TEA = "green tea";
	public static final String BURNT_CARAMEL = "burnt caramel";
/**
 * Constructor that initializes the stack of ice cream cone
 */
	public IceCreamCone() {
		coneStack = new StackLL<String>();

	}
	/**
	 * Method that peek the scoop
	 * @return the top of the stack
	 */
	public String peekScoop() {
		return coneStack.peek();
	}
	/**
	 * check if the stack is empty
	 * @return true if cone is empty
	 */
	public boolean isEmpty() {
		return coneStack.isEmpty();
	}
	/**
	 * method that add the scoop with specific flavor
	 * @param flavor String
	 */
	public void addScoop(String flavor)
	{	
		
		coneStack.push(flavor);
	}
	/**
	 * method that delete the scoop
	 * @return the cone that is popped
	 */
	public String deleteScoop() {
		return coneStack.pop();
	}
	/**
	 * Method that adds a scoop of random flavor
	 * 
	 */
	public void addScoop() {
		//generate a flavor from random 4 flavours
		Random cone = new Random();
		int coneNum = cone.nextInt(4);
		
		// push the specific flavor scoop to the stack
		if ( coneNum == 0) {
			coneStack.push(VANILLA);
	}
		if ( coneNum == 1) {

			coneStack.push(STRAWBERRY);
		}
		if (coneNum==2) {
			coneStack.push(GREEN_TEA);
		}
		if (coneNum==3) {
			coneStack.push(BURNT_CARAMEL);
		}
	
	}
}