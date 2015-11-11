/**
 * <p>Interface which must be implemented by the GUI class that is attached to the program.</p>
 * <p>Date of last modification: 29/10/2015</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 */
package interfaces;

import javax.swing.JComponent;

import view.panel.GiftIdeaApplicationDrawingPanel;

public interface IGiftIdeaApplicationGUI {

	public JComponent getFrameContentPane();
	public void setDrawnArea(GiftIdeaApplicationDrawingPanel giftIdeaApplicationDrawingPanel);
	public GiftIdeaApplicationDrawingPanel getDrawnArea();
}
