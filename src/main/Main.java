package main;

import javax.swing.SwingUtilities;

import controller.GiftIdeaApplicationController;
import interfaces.IGiftIdeaApplicationGUI;
import view.GiftIdeaApplicationFrame;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IGiftIdeaApplicationGUI frame = new GiftIdeaApplicationFrame("Gift Idea Application");
				GiftIdeaApplicationController.getInstance().setGui(frame);
			}
		});
		
	}

}
