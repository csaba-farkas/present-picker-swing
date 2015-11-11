/**
 * <p>Main class that contains the only one main method of the application.</p>
 * <p>Date of last modification: 29/10/2015</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 * 
 */
package main;

import javax.swing.SwingUtilities;

import controller.GiftIdeaApplicationController;
import interfaces.IGiftIdeaApplicationGUI;
import view.GiftIdeaApplicationFrame;

public class Main {

	private final static String FRAME_TITLE = "Gift Idea Application";
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IGiftIdeaApplicationGUI frame = new GiftIdeaApplicationFrame(FRAME_TITLE);
				GiftIdeaApplicationController.getInstance().setGui(frame);
			}
		});
	}
}
