/**
 * <p>Class which extends {@link JFrame} and implements {@link IGiftIdeaApplicationGUI} interface.
 * This class is creates the frame of the application.</p>
 * <p>Date of last modification: 29/10/2015</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import interfaces.IGiftIdeaApplicationGUI;
import view.panel.GiftIdeaApplicationMainPanel;
import view.panel.GiftIdeaApplicationDrawingPanel;

public class GiftIdeaApplicationFrame extends JFrame implements IGiftIdeaApplicationGUI {

	private static final long serialVersionUID = -6253552984378129683L;
	
	private JPanel mainPanel;													//JPanel field variable
	private GiftIdeaApplicationDrawingPanel giftIdeaApplicationDrawingPanel;	//GiftIdeaApplicationDrawingPanel field variable

	/**
	 * <p>Method which constructs a {@link GiftIdeaApplicationFrame} object. It defines the
	 * behavior and look of the object.</p>
	 * <ul>
	 * <li>Creates a {@link GiftIdeaApplicationMainPanel} object and adds it to the Content Pane</li>
	 * <li>Sets minimum size and the Default Close Operation</li>
	 * <li>Positions the frame to the middle of the screen</li>
	 * </ul>
	 * 
	 * @param title is a String object stores the title of the frame.
	 */
	public GiftIdeaApplicationFrame(String title) {
		super(title);
		
		this.mainPanel = new GiftIdeaApplicationMainPanel(this);
		this.getContentPane().setBackground(new Color(245, 231, 141));
		this.getContentPane().add(this.mainPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(1000, 600));
        
		//Frame appears in the middle of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      //Get the size of the screen
        int frameWidth = this.getSize().width;
        int frameHeigth = this.getSize().height;
        int locationX = (dimension.width - frameWidth)/2;                //X coordinate = (width of screen - width of frame) / 2
        int locationY = (dimension.height - frameHeigth)/2;              //Y coordinate = (height of screen - height of frame) / 2
        this.setLocation(locationX, locationY);
        
        this.setVisible(true);
	}

	/**
	 * <p>Implemented {@link IGiftIdeaApplicationGUI} method.</p>
	 * 
	 * @return Content Pane of the frame.
	 */
	@Override
	public JComponent getFrameContentPane() {
		return (JPanel) this.getContentPane();
	}

	/**
	 * <p>Implemented {@link IGiftIdeaApplicationGUI} method. It sets the DrawnArea field to the passed {@link GiftIdeaApplicationDrawingPanel} object.</p>
	 * 
	 * @param a {@link GiftIdeaApplicationDrawingPanel} object.
	 */
	@Override
	public void setDrawnArea(GiftIdeaApplicationDrawingPanel giftIdeaApplicationDrawingPanel) {
		this.giftIdeaApplicationDrawingPanel = giftIdeaApplicationDrawingPanel;
	}

	/**
	 * <p>Implemented {@link IGiftIdeaApplicationGUI} method.</p>
	 * 
	 * @return the {@link GiftIdeaApplicationDrawingPanel} field.
	 */
	@Override
	public GiftIdeaApplicationDrawingPanel getDrawnArea() {
		return this.giftIdeaApplicationDrawingPanel;
	}


	
	
	
}

