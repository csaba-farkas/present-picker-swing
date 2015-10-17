package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import interfaces.IGiftIdeaApplicationGUI;
import view.panel.GiftIdeaApplicationMainPanel;

public class GiftIdeaApplicationFrame extends JFrame implements IGiftIdeaApplicationGUI {

	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;

	public GiftIdeaApplicationFrame(String title) {
		super(title);
		
		this.mainPanel = new GiftIdeaApplicationMainPanel(this);
		this.getContentPane().setLayout(new CardLayout());
		this.getContentPane().setBackground(new Color(30, 79, 148));
		this.getContentPane().add(this.mainPanel, BorderLayout.CENTER);
		//this.mainPanel.getRootPane().setDefaultButton(((GiftIdeaApplicationMainPanel) this.mainPanel).getLaunchButton());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 600);
        
		//Frame appears in the middle of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      //Get the size of the screen
        int frameWidth = this.getSize().width;
        int frameHeigth = this.getSize().height;
        int locationX = (dimension.width - frameWidth)/2;                //X coordinate = (width of screen - width of frame) / 2
        int locationY = (dimension.height - frameHeigth)/2;              //Y coordinate = (height of screen - height of frame) / 2
        this.setLocation(locationX, locationY);
        
        this.setVisible(true);
	}

	@Override
	public JComponent getFrameContentPane() {
		return (JPanel) this.getContentPane();
	}

	@Override
	public JRootPane getFrameRootPane() {
		
		return this.rootPane;
	}	
	
}

