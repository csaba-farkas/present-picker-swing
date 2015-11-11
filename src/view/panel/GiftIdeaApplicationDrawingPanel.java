/**
 * <p>This class defines the behavior of the JPanel where the selected gift is displayed.
 *  It is displayed as part of the {@link GiftIdeaApplicationWorkPanel}</p>
 * <p>Date of last modification: 29/10/2015</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 */
package view.panel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GiftIdeaApplicationController;
import model.enums.Gift;

public class GiftIdeaApplicationDrawingPanel extends JPanel {
	
	private static final long serialVersionUID = -6268910380385585006L;
	
	private BufferedImage bufferedImage;		//BufferedImage object displays a jpg file
	private float transparency;					//Float variable used when fading in image
	private Gift gift;							//Gift enum indicates which gift to display
	private JFrame parentFrame;					//JFrame indicates the JFrame containing this panel
	private String userName;					//String object that stores the user's name
	
	/**
	 * <p>Constructor method defines the basic behavior of the class.</p>
	 * <ul>
	 * <li>Class extends to {@link javax.swing.JPanel} and inherits all the methods</li>
	 * <li>Background is set to transparent</li>
	 * <li>Field variables are initialized</li>
	 * </ul>
	 * 
	 * @param parentFrame is the JFrame containing this panel.
	 * @param userName indicates user's name.
	 */
	public GiftIdeaApplicationDrawingPanel(JFrame parentFrame, String userName) {
		super();
		this.setOpaque(false);
		this.gift = Gift.NONE;
		this.bufferedImage = null;
		this.transparency = 0.0f;
		this.parentFrame = parentFrame;
		this.userName =userName;
	}
	
	/**
	 * <p>This class overrides its paint method. Inside the paint method it selects the type of {@link Gift}
	 * to be painted by using a switch-case block. It works in the following way: </p>
	 * <ul>
	 * <li>{@link Gift}.NONE: no image is displayed only a few lines of text</li>
	 * <li>{@link Gift}.BOOK: book.jpg is loaded into bufferedImage and passed to the drawImage method</li>
	 * <li>{@link Gift}.CHOCOLATE: chocolate.jp is loaded into bufferedImage and passed to the drawImage method</li>
	 * <li>Same procedure is used with the rest of the images</li>
	 * <li>A String object is also passed to the drawImage method indicating the name of the gift</li>
	 * </ul>
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paint(g2d);
		
		switch(this.gift) {
			case NONE:
				drawStrings(g2d);
				break;
			case BOOK:
				try {
					URL url = GiftIdeaApplicationDrawingPanel.this.getClass().getResource("/images/book.jpg");
					this.bufferedImage = ImageIO.read(new File(url.getPath()));
				} catch(IOException e) {
					e.printStackTrace();
				}
				drawImage(g2d, GiftIdeaApplicationWorkPanel.FINAL_STRING + GiftIdeaApplicationController.getInstance().getFriendsName().toUpperCase() + GiftIdeaApplicationWorkPanel.FINAL_BOOK_STRING);
				break;
			case CHOCOLATE:
				try {
					URL url = GiftIdeaApplicationDrawingPanel.this.getClass().getResource("/images/chocolate.jpg");
					this.bufferedImage = ImageIO.read(new File(url.getPath()));
				} catch(IOException e) {
					e.printStackTrace();
				}
				drawImage(g2d, GiftIdeaApplicationWorkPanel.FINAL_STRING + GiftIdeaApplicationController.getInstance().getFriendsName().toUpperCase() + GiftIdeaApplicationWorkPanel.FINAL_CHOCOLATE_STRING);
				break;
			case DOLL:
				try {
					URL url = GiftIdeaApplicationDrawingPanel.this.getClass().getResource("/images/doll.jpg");
					this.bufferedImage = ImageIO.read(new File(url.getPath()));
				} catch(IOException e) {
					e.printStackTrace();
				}
				drawImage(g2d, GiftIdeaApplicationWorkPanel.FINAL_STRING + GiftIdeaApplicationController.getInstance().getFriendsName().toUpperCase() + GiftIdeaApplicationWorkPanel.FINAL_DOLL_STRING);
				break;
			case FLOWER:
				try {
					URL url = GiftIdeaApplicationDrawingPanel.this.getClass().getResource("/images/flowers.jpg");
					this.bufferedImage = ImageIO.read(new File(url.getPath()));
				} catch(IOException e) {
					e.printStackTrace();
				}
				drawImage(g2d, GiftIdeaApplicationWorkPanel.FINAL_STRING + GiftIdeaApplicationController.getInstance().getFriendsName().toUpperCase() + GiftIdeaApplicationWorkPanel.FINAL_FLOWER_STRING);
				break;
			case TOY_SOLDIER:
				try {
					URL url = GiftIdeaApplicationDrawingPanel.this.getClass().getResource("/images/gijoe.jpg");
					this.bufferedImage = ImageIO.read(new File(url.getPath()));
				} catch(IOException e) {
					e.printStackTrace();
				}
				drawImage(g2d, GiftIdeaApplicationWorkPanel.FINAL_STRING + GiftIdeaApplicationController.getInstance().getFriendsName().toUpperCase() + GiftIdeaApplicationWorkPanel.FINAL_TOYSOLDIER_STRING);
				break;
			case WINE:
				try {
					URL url = GiftIdeaApplicationDrawingPanel.this.getClass().getResource("/images/wine.jpg");
					this.bufferedImage = ImageIO.read(new File(url.getPath()));
				} catch(IOException e) {
					e.printStackTrace();
				}
				drawImage(g2d, GiftIdeaApplicationWorkPanel.FINAL_STRING + GiftIdeaApplicationController.getInstance().getFriendsName().toUpperCase() + GiftIdeaApplicationWorkPanel.FINAL_WINE_STRING);
				break;
		}
		
	}
	
	/**
	 * <p>Setter method of {@link Gift} gift field.</p>
	 * 
	 * @param gift is a {@link Gift} enumerator.
	 */
	public void setGift(Gift gift) {
		this.gift = gift;
	}
	
	/**
	 * <p>This method paints the text to the welcome screen when this panel is initially displayed.</p>
	 * <p>The first line of text is painted to the middle of the X axis and 100px above the middle of the Y axis.
	 * The following lines are painted below the first line. Distances are calculated by decrementing the offset
	 * variable by (height of next row + a 3px gap).</p>
	 * 
	 * @param g2d is a {@link Graphics2D} object passed from the paint method.
	 */
	private void drawStrings(Graphics2D g2d) {
		int offset = 100;								//offset indicates where the first line of text is displayed. i.e. 100px above half of the panel
		final int GAP = 3;								//GAP indicates the distance between rows of text.
		int stringWidth, startPositionX, stringHeight;	//indicating row width, a start position of a row and row height
		
		String welcome = GiftIdeaApplicationWorkPanel.WELCOME_STRING + this.userName;	//Welcome string is concatenated from a static variable + user's name i.e. WELCOM JOHN
		
		g2d.setXORMode(getBackground());
		
		//First line
		g2d.setFont(new Font("Arial", Font.PLAIN, 25));
		stringWidth = getStringWidth(welcome.toUpperCase(), g2d);
		startPositionX = getStartPositionX(stringWidth);
		g2d.drawString(welcome, startPositionX, parentFrame.getHeight()/2 - offset);
		
		//Second line
		g2d.setFont(new Font("Arial", Font.PLAIN, 18));
		stringWidth = getStringWidth(GiftIdeaApplicationWorkPanel.TEXT.toUpperCase(), g2d);
		stringHeight = getStringHeight(GiftIdeaApplicationWorkPanel.TEXT, g2d);
		offset -= (stringHeight + GAP);
		startPositionX = getStartPositionX(stringWidth);
		g2d.drawString(GiftIdeaApplicationWorkPanel.TEXT.toUpperCase(), startPositionX, parentFrame.getHeight()/2 - offset);
		
		//Third line
		stringWidth = getStringWidth(GiftIdeaApplicationWorkPanel.TEXT1.toUpperCase(), g2d);
		stringHeight = getStringHeight(GiftIdeaApplicationWorkPanel.TEXT1, g2d);
		offset -= (stringHeight + GAP);
		startPositionX = getStartPositionX(stringWidth);
		g2d.drawString(GiftIdeaApplicationWorkPanel.TEXT1.toUpperCase(), startPositionX, parentFrame.getHeight()/2 - offset);

		//Fourth line
		stringWidth = getStringWidth(GiftIdeaApplicationWorkPanel.TEXT2.toUpperCase(), g2d);
		stringHeight = getStringHeight(GiftIdeaApplicationWorkPanel.TEXT2, g2d);
		offset -= (stringHeight + GAP);
		startPositionX = getStartPositionX(stringWidth);
		g2d.drawString(GiftIdeaApplicationWorkPanel.TEXT2.toUpperCase(), startPositionX, parentFrame.getHeight()/2 - offset);
		
	}

	/**
	 * <p>This method displays the image stored in the BufferedImage field on a painted background that can be 
	 * a filled rectangle, filled oval, filled arc or filled polygon. It also paints a string above each
	 * present in the following format "The ideal gift for XY is AB"</p>
	 * <p>Method uses a switch-case block to determine the background of the image. Every image gets a different background.</p>
	 * <p>The image and the text is displayed in the middle of the panel. They are faded in by gradually increasing their
	 * visibility and repainting the screen after every increment until transparency value reaches 1.0. The fade in effect
	 * is achieved by making the thread sleep for 100ms before every increment.</p>
	 * <p>The painting of the shapes are very straight forward except for the hexagon shape. I used hexagon geometry,
	 * a compass, a ruler, a pen and paper to design the algorithm. I can explain the algorithm any time if requested.</p>
	 * 
	 * @param g2d is a {@link Graphics2D} object passed from the paint method.
	 * @param string is a string that is painted above each image.
	 */
	private void drawImage(Graphics2D g2d, String string) {
		
		switch(this.gift) {
		case BOOK:
			//Filled rectangle with border
			g2d.setColor(new Color(250, 172, 172));
			g2d.fillRect(30, 30, this.getWidth()-60, this.getHeight()-60);
			g2d.setColor(new Color(100, 93, 93));
			g2d.drawRect(30, 30, this.getWidth()-60, this.getHeight()-60);
			break;
		case WINE:
			//Filled oval with border
			g2d.setColor(new Color(4, 205, 219));
			g2d.fillOval(30, 30, this.getWidth()-60, this.getHeight()-60);
			g2d.setColor(new Color(100, 93, 93));
			g2d.drawOval(30, 30, this.getWidth()-60, this.getHeight()-60);
			break;
		case CHOCOLATE:
			//Filled hexagon with border
			g2d.setColor(new Color(236, 253, 154));
			Polygon p = new Polygon();
			Double circleRadius = new Double(this.getHeight()/2 - 30);
			Double hexagonRadius = new Double((Math.sqrt(Math.pow(2*circleRadius, 2) - Math.pow(circleRadius, 2)))/2);
			Double smallDistance = new Double(Math.sqrt(Math.pow(circleRadius, 2) - Math.pow(hexagonRadius, 2)));
			p.addPoint(this.getWidth()/2 - circleRadius.intValue()*2, this.getHeight()/2);
			p.addPoint(this.getWidth()/2 - smallDistance.intValue()*2, 30);
			p.addPoint(this.getWidth()/2 + smallDistance.intValue()*2, 30);
			p.addPoint(this.getWidth()/2 + circleRadius.intValue()*2, this.getHeight()/2);
			p.addPoint(this.getWidth()/2 + smallDistance.intValue()*2, this.getHeight()/2 + hexagonRadius.intValue());
			p.addPoint(this.getWidth()/2 - smallDistance.intValue()*2, this.getHeight()/2 + hexagonRadius.intValue());
			g2d.fillPolygon(p);
			g2d.setColor(new Color(100, 93, 93));
			g2d.drawPolygon(p);
			break;
		case DOLL:
			//Filled arc with border
			g2d.setColor(new Color(240, 127, 236));
			g2d.fillArc(30, 30, this.getWidth()-60, this.getHeight()*2 - 120, 0, 180);
			g2d.setColor(new Color(100, 93, 93));
			g2d.drawArc(30, 30, this.getWidth()-60, this.getHeight()*2 - 120, 0, 180);
			g2d.drawLine(30, this.getHeight()-30, this.getWidth()-30, this.getHeight()-30);
			break;
		case FLOWER:
			//Filled arc with border
			g2d.setColor(new Color(240, 127, 236));
			g2d.fillArc(30, 30, this.getWidth()-60,  this.getHeight()*2 - 120, 15, 150);
			g2d.setColor(new Color(100, 93, 93));
			g2d.drawArc(30, 30, this.getWidth()-60, this.getHeight()*2 - 120, 15, 150);
			break;
		case TOY_SOLDIER:
			//Filled rectangle with border
			g2d.setColor(new Color(195, 200, 243));
			Polygon p1 = new Polygon();
			p1.addPoint(120, this.getHeight()-30);
			p1.addPoint(30, 30);
			p1.addPoint(this.getWidth()-30, 30);
			p1.addPoint(this.getWidth()-120, this.getHeight()-30);
			g2d.fillPolygon(p1);
			g2d.setColor(new Color(100, 93, 93));
			g2d.drawPolygon(p1);
			break;
		case NONE:
			break;
		}
		
		//Transparency of image and text is increased by 0.05 after each repaint.
		this.transparency += 0.05f;
		
		//When value of transparency reaches 1.0 the repaint cycle stops --> image and text are fully visible
		if (this.transparency >= 1.0f) {
	    	this.transparency = 1.0f;
	    } else {
	    	
	    	//I used the AlphaComposite singleton class to blend the colors of the image and text with the background
	    	g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));

	        repaint();
	    }
	    
		g2d.drawImage(this.bufferedImage, getImageXPostion(this.bufferedImage), getImageYPosition(this.bufferedImage), null);
		g2d.setColor(new Color(100, 93, 93));
		g2d.setFont(new Font("Arial", Font.PLAIN, 22));
		g2d.drawString(string, getStartPositionX(getStringWidth(string, g2d)), this.getHeight()/6);
		
	    try {
	        Thread.sleep(100);
	    } catch (InterruptedException e) {

	        e.printStackTrace();
	    }
	}
 
	/**
	 * <p>This method calculates the starting position of the BufferedImage object on Y axis.
	 * It subtracts half of the height of the image from half of the height of the panel.</p>
	 * 
	 * @param bufferedImage2 is the image which position on Y axis is returned.
	 * @return an integer value indicating the position of the image on Y axis.
	 */
	private int getImageYPosition(BufferedImage bufferedImage2) {
		int imageHeight = bufferedImage2.getHeight();
		return this.getHeight()/2 - imageHeight/2;
	}

	/**
	 * <p>Method which calculates the starting position of the BufferedImage object on X axis.
	 * It works in similar way as the getImageYPosition method but this one is using the width
	 * of the image and the panel to calculate the starting position.</p>
	 * 
	 * @param bufferedImage2 is the image which position on X axis is returned.
	 * @return an integer value indicating the position of the image on X axis.
	 */
	private int getImageXPostion(BufferedImage bufferedImage2) {
		int imageWidth = bufferedImage2.getWidth();
		return this.getWidth()/2 - imageWidth/2;
	}

	/**
	 * <p>Method which calculates the width of a line of text in pixels in a specified
	 * graphics context. It uses the getFontMetrics().getStringBounds().getWidth method
	 * of the {@link Graphics2D} class to execute the calculation.</p>
	 * 
	 * @param s	is a line of text of which width is to be calculated.
	 * @param g2d is a {@link Graphics2D} object. It indicates the graphics context of the text.
	 * @return the width of the text in pixels in the given context.
	 */
	private int getStringWidth(String s, Graphics2D g2d) {
		return (int) g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
	}
	
	/**
	 * <p>Similar method to getStringWidth, but this is calculating the height of
	 * a line of in a specified graphics context.</p>
	 * 
	 * @param s is a line of text of which width is to be calculated.
	 * @param g2d is a {@link Graphics2D} object. It indicates the graphics context of the text.
	 * @return the height of the text in pixels in the given context.
	 */
	private int getStringHeight(String s, Graphics g2d) {
		return (int) g2d.getFontMetrics().getStringBounds(s, g2d).getHeight();
	}
	
	/**
	 * <p>Method which calculates the start position of each line of text so they are center aligned.
	 * It uses the width of the screen and the width of the text for the calculation.</p>
	 * 
	 * @param stringWidth is an integer variable indicating the width of the text.
	 * @return the starting position of the line on the X axis.
	 */
	private int getStartPositionX(int stringWidth) {
		return parentFrame.getWidth()/2 - stringWidth/2;
	}
	
}
