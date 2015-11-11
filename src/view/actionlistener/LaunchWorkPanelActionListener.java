/**
 * <p>LaunchWorkPanelActionListener class which implements {@link ActionListener} thus
 * overrides actionPerformend(ActionEvent e) method.</p>
 * <p>Date of last modification: 29/10/2015</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 */
package view.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import controller.GiftIdeaApplicationController;
import view.panel.GiftIdeaApplicationWorkPanel;

public class LaunchWorkPanelActionListener implements ActionListener {

	private String userName;
	private JFrame parentFrame;
	
	/**
	 * <p>Constructor creates an instance of this class. It takes two parameters which indicate
	 * the user's name and a JFrame object.</p>
	 * <p>This object is added to the reset button.</p> 
	 * @param userName indicates user's name.
	 * @param parentFrame indicates the JFrame object that contains the Reset button
	 */
	public LaunchWorkPanelActionListener(String userName, JFrame parentFrame) {
		this.userName = userName;
		this.parentFrame = parentFrame;
	}
	
	/**
	 * <p>Implemented {@link ActionListener} method.</p>
	 * <ul>
	 * <li>Removes everything from the parent frame</li>
	 * <li>Calls {@link GiftIdeaApplicationController}.setGift() method with no parameters.<br>This sets Gift to Gift.NONE</li>
	 * <li>Adds a new {@link GiftIdeaApplicationWorkPanel} to the Content Pane of the parent JFrame</li>j
	 * <li>Revalidates and repaints the contents of the Content Pane of the parent JFrame</li>
	 * </ul>
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().removeAll();
		GiftIdeaApplicationController.getInstance().setGift();
		GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().add(new GiftIdeaApplicationWorkPanel(this.userName, this.parentFrame));
		GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().revalidate();
		GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().repaint();

	}

}
