/**
 * <p>Controller class connecting the model elements with the GUI elements.</p>
 * <p>Date of last modification: 29/10/2015</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 * 
 * 
 */
package controller;

import interfaces.IGiftIdeaApplicationGUI;
import model.enums.Gender;
import model.enums.Gift;
import model.enums.Relationship;

public class GiftIdeaApplicationController {

	/**
	 * <p>This class is a singleton class. It is created during compilation and stored in memory.
	 * The only one instance of this class can be used by calling the getInstance() method.
	 * No new instances need to be created.</p>
	 * 
	 * @return an instance of {@link GiftIdeaApplicationController}
	 */
	public static GiftIdeaApplicationController getInstance() {
		return GiftIdeaApplicationControllerHolder.INSTANCE;
		
	}
	
	private IGiftIdeaApplicationGUI gui;		//Instance of GUI element. JFrame in this case.
	private String userName;					//User name stored in a String
	private Gift gift;							//Gift enumerator indicating selected gift
	private String friendsName;					//Friend's name stored in a String


	/**
	 * <p>Static class that holds one constant variable to create and store the only one instance
	 * of {@link GiftIdeaApplicationController}.</p>
	 *
	 */
	private static class GiftIdeaApplicationControllerHolder {
		private static final GiftIdeaApplicationController INSTANCE = new GiftIdeaApplicationController();
    }

	/**
	 * <p>This method returns the GUI object attached to the program.</p>
	 * 
	 * @return a GUI object which implements {@link IGiftIdeaApplicationGUI}
	 */
	public IGiftIdeaApplicationGUI getGui() {
		return gui;
	}

	/**
	 * <p>This method attaches a GUI object to the program. This allows the program to be
	 * implemented on different platforms.</p>
	 * 
	 * @param a GUI object which implements {@link IGiftIdeaApplicationGUI} 
	 */
	public void setGui(IGiftIdeaApplicationGUI gui) {
		this.gui = gui;
	}
	
	/**
	 * <p>This method changes the userName field to the String parameter passed to the method.</p>
	 * 
	 * @param a String object indicating the user's name.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * <p>This method returns the String value stored in userName field.</p>
	 * 
	 * @return a String object that stores the user's name.
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * <p>This method selects the right gift for the user based on the three
	 * parameters passed to the method.</p>
	 * <p>Gifts are selected in the following way:
	 * <ul>
	 * <li>Single male over 18 years of age: A bottle of wine</li>
	 * <li>Single male under 18 years of age: A toy soldier</li>
	 * <li>Attached male over 18 years of age: A book</li>
	 * <li>Attached male under 18 years of age: A toy soldier</li>
	 * <li>Single female over 18 years of age: A bottle of wine</li>
	 * <li>Single female under 18 years of age:  A toy doll</li>
	 * <li>Attached female over 18 years of age: Chocolate</li>
	 * <li>Attached female under 18 years of age: A toy doll</li>
	 * </ul>
	 * 
	 * @param age is a primitive integer value indicating the age of the person.
	 * @param gender is a {@link Gender} enumerator indicating the gender of the person.
	 * @param rs is a {@link Relationship} enumerator indicating the relationship status of the person.
	 */
	public void setGift(int age, Gender gender, Relationship rs) {
		
		switch(gender) {
		
		case MALE:
			switch(rs) {
			case SINGLE:
				if(age >= 18) {
					this.gift = Gift.WINE;
				} else {
					this.gift = Gift.TOY_SOLDIER;
				}
				break;
			case IN_A_RELATIONSHIP:
				if(age >= 18) {
					this.gift = Gift.BOOK;
				} else {
					this.gift = Gift.TOY_SOLDIER;
				}
				break;
			}
			break;
		case FEMALE:
			switch(rs) {
			case SINGLE:
				if(age >= 18) {
					this.gift = Gift.FLOWER;
				} else {
					this.gift = Gift.DOLL;
				}
				break;
			case IN_A_RELATIONSHIP:
				if(age >= 18) {
					this.gift = Gift.CHOCOLATE;
				} else {
					this.gift = Gift.DOLL;
				}
				break;
			}
			break;
			
		}
		
	}
	
	/**
	 * <p>Overloaded method. It takes no parameters and it sets the {@link Gift} enumerator field
	 * to {@link Gift}.NONE. It is used when user resets the application.</p>
	 */
	public void setGift() {
		this.gift = Gift.NONE;
	}
	
	/**
	 * <p>Getter method that returns the value of the {@link Gift} enumerator field.</p>
	 * 
	 * @return the value of {@link Gift} gift field.
	 */
	public Gift getGift() {
		return this.gift;
	}
	
	/**
	 * <p>Getter method which returns a String object that stores the name of the person.</p>
	 * 
	 * @return the value of String friendsName field.
	 */
	public String getFriendsName() {
		return friendsName;
	}

	/**
	 * <p>Setter method which sets String friendsName field to the parameter passed to the method.
	 * 
	 * @param a String object.
	 */
	public void setFriendsName(String friendsName) {
		this.friendsName = friendsName;
	}
}
