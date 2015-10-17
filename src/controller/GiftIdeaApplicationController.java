package controller;

import interfaces.IGiftIdeaApplicationGUI;
import model.Gift;
import model.enums.Gender;
import model.enums.Relationship;

public class GiftIdeaApplicationController {

	public static GiftIdeaApplicationController getInstance() {
		return GiftIdeaApplicationControllerHolder.INSTANCE;
		
	}
	
	private IGiftIdeaApplicationGUI gui;
	private String userName;
	private Gift gift;
	
	private static class GiftIdeaApplicationControllerHolder {

        private static final GiftIdeaApplicationController INSTANCE = new GiftIdeaApplicationController();
    }

	public IGiftIdeaApplicationGUI getGui() {
		return gui;
	}

	public void setGui(IGiftIdeaApplicationGUI gui) {
		this.gui = gui;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setGift(String userName, int age, Gender gender, Relationship rs) {
		this.gift = new Gift();
	}
	
	public Gift getGift() {
		return this.gift;
	}
}
