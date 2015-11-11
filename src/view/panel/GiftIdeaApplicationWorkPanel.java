/**
 * <p>Class extending {@link JPanel}. This panel provides all the functionality that helps 
 * a user to feed in the data about their friend. Then it calls the controller to select 
 * the right gift and displays it in a {@link GiftIdeaApplicationDrawingPanel}</p>
 * 
 * @author Csaba Farkas csaba.farkas@mycit.ie R00117945
 * Date of last modification: 02/11/2015
 */
package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.GiftIdeaApplicationController;
import model.enums.Gender;
import model.enums.Gift;
import model.enums.Relationship;
import view.actionlistener.LaunchWorkPanelActionListener;

public class GiftIdeaApplicationWorkPanel extends JPanel {
	
	private static final long serialVersionUID = 4796682380171019733L;
	
	protected static final String TEXT = "I'm going to help you find the perfect present for your friend.";
	protected static final String TEXT1 = "But first I need some further information.";
	protected static final String TEXT2 = "Please fill in the form below";
	protected static final String NAME_QUESTION_LABEL = "Name:";
	protected static final String TOOLTIP_NAME = "Your friend's name";
	protected static final String NAME_ERROR_MESSAGE = "Please enter your friend's name!";
	protected static final String TOOLTIP_GENDER = "Your friend's gender";
	protected static final String AGE_QUESTION_LABEL = "Age:";
	protected static final String TOOLTIP_AGE = "Your friend's age";
	protected static final String RELATIONSHIP_QUESTION_LABEL = "Relationship Status:";
	protected static final String TOOLTIP_RELATIONSHIP = "Your friend's relationship status";
	protected static final String MALE_BUTTON_LABEL = "Male";
	protected static final String FEMALE_BUTTON_LABEL = "Female";
	protected static final String GENDER_ERROR_MESSAGE = "Please select gender!";
	protected static final String[] AGES = calculateAges();
	protected static final String[] RELATIONSHIPS = {"Single", "In a relationship"};
	protected static final String BACK_BUTTON_LABEL = "<html><p>BACK</p></html>";
	protected static final String GO_BUTTON_LABEL = "<html><p>GO</p></html>";
	protected static final String RESET_BUTTON_LABEL = "<html><p>RESET</p></html>";
	protected static final String WELCOME_STRING = "WELCOME ";
	protected static final String FINAL_STRING = "The ideal gift for ";
	protected static final String FINAL_BOOK_STRING = " is a BOOK!";
	protected static final String FINAL_WINE_STRING = " is WINE!";
	protected static final String FINAL_CHOCOLATE_STRING = " is CHOCOLATE!";
	protected static final String FINAL_DOLL_STRING = " is a DOLL!";
	protected static final String FINAL_FLOWER_STRING = " is FLOWERS!";
	protected static final String FINAL_TOYSOLDIER_STRING = " is a TOY SOLDIER!";
	
	private static String[] calculateAges() {
		String[] ageArray = new String[111];
		for(int i = 0; i < ageArray.length; i++) {
			ageArray[i] = (new Integer(i)).toString();
		}
		return ageArray;
	}
	
	//Instance variables including GUI components and a String element used during painting.
	private String userName;
	private JFrame parentFrame;
	private JTextField nameField;
	private ButtonGroup buttonGroup;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private JComboBox<String> ageComboBox;
	private JComboBox<String> rsComboBox;
	private JButton backButton;
	private JButton goButton;
	private GiftIdeaApplicationDrawingPanel giftIdeaApplicationDrawingPanel;
	private JLabel nameLabel;
	private JLabel ageLabel;
	private JLabel rsLabel;
	
	/**
	 * <p>Constructor method creates and instance of this panel. It initializes instance variables then
	 *  creates and renders the GUI components.</p>
	 *  
	 * @param userName a name that user entered in {@link GiftIdeaApplicationMainPanel}
	 * @param parent indicating the container JFrame
	 */
	public GiftIdeaApplicationWorkPanel(String userName, JFrame parent) {
		super();
		
		this.userName = userName;
		this.parentFrame = parent;
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.giftIdeaApplicationDrawingPanel = new GiftIdeaApplicationDrawingPanel(parentFrame, userName);
		GiftIdeaApplicationController.getInstance().getGui().setDrawnArea(this.giftIdeaApplicationDrawingPanel);
		this.add(createSouthPanel(), BorderLayout.SOUTH);
		this.add(this.giftIdeaApplicationDrawingPanel, BorderLayout.CENTER);
		this.setOpaque(false);	
	}

	/**
	 * <p>Private function which returns a JPanel. This JPanel is inserted into the 
	 * "south" part of the instance of this class.</p>
	 * <p>Elements including:
	 * <ul>
	 * <li>JPanel objects to "insulate" contents, thus eliminate stretched elements</li>
	 * <li>Border objects</li>
	 * <li>BoxLayouts</li>
	 * <li>RadioButtons in ButtonGroup object</li>
	 * <li>JComboBoxes</li>
	 * <li>A "Back" button which navigates back to {@link GiftIdeaApplicationMainPanel}</li>
	 * <li>A "Go" button which triggers the event that displays selected present</li>
	 * </ul>
	 * </p>
	 * 
	 * @return
	 */
	private JPanel createSouthPanel() {
		// Panel with Form
		JPanel southPanel = new JPanel();
		southPanel.setOpaque(false);
		Border lineBorder = BorderFactory.createLineBorder(new Color(90, 93, 89));
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 0, 15, 0);
		southPanel.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		BoxLayout southPanelLayout = new BoxLayout(southPanel, BoxLayout.Y_AXIS);
		southPanel.setLayout(southPanelLayout);
		Font labelFont = new Font("Arial Narrow", Font.PLAIN, 18);
		
		JPanel formPanel = new JPanel();
		formPanel.setOpaque(false);
		BoxLayout formLayout = new BoxLayout(formPanel, BoxLayout.X_AXIS);
		formPanel.setLayout(formLayout);
		
		JPanel nameLabelContainer = new JPanel();
		nameLabelContainer.setOpaque(false);
		this.nameLabel = new JLabel(NAME_QUESTION_LABEL);
		this.nameLabel.setFont(labelFont);
		this.nameLabel.setForeground(new Color(90, 93, 89));
		nameLabelContainer.add(this.nameLabel);
		formPanel.add(nameLabelContainer);
		
		this.nameField = new JTextField(16);
		this.nameField.setToolTipText(TOOLTIP_NAME);
		nameLabelContainer.add(this.nameField);
		formPanel.add(nameLabelContainer);
		
		JPanel genderBoxContainer = new JPanel();
		genderBoxContainer.setOpaque(false);
		genderBoxContainer.setToolTipText(TOOLTIP_GENDER);
		
		this.buttonGroup = new ButtonGroup();
		this.maleButton = new JRadioButton(MALE_BUTTON_LABEL);
		this.maleButton.setOpaque(false);
		this.maleButton.setForeground(new Color(90, 93, 89));
		this.maleButton.setFont(labelFont);
		this.buttonGroup.add(this.maleButton);
		genderBoxContainer.add(maleButton);
		this.femaleButton = new JRadioButton(FEMALE_BUTTON_LABEL);
		this.buttonGroup.add(this.femaleButton);
		this.femaleButton.setOpaque(false);
		this.femaleButton.setForeground(new Color(90, 93, 89));
		this.femaleButton.setFont(labelFont);
		genderBoxContainer.add(this.femaleButton);
		formPanel.add(genderBoxContainer);
		formPanel.add(Box.createHorizontalStrut(10));
		
		JPanel ageBoxContainer = new JPanel();
		ageBoxContainer.setOpaque(false);
		this.ageLabel = new JLabel(AGE_QUESTION_LABEL);
		this.ageLabel.setFont(labelFont);
		this.ageLabel.setForeground(new Color(90, 93, 89));
		ageBoxContainer.add(this.ageLabel);
		
		this.ageComboBox = new JComboBox<String>(AGES);
		this.ageComboBox.setToolTipText(TOOLTIP_AGE);
		ageBoxContainer.add(this.ageComboBox);
		formPanel.add(ageBoxContainer);
		formPanel.add(Box.createHorizontalStrut(10));
		
		JPanel rsBoxContainer = new JPanel();
		rsBoxContainer.setOpaque(false);
		this.rsLabel = new JLabel(RELATIONSHIP_QUESTION_LABEL);
		this.rsLabel.setFont(labelFont);
		this.rsLabel.setForeground(new Color(90, 93, 89));
		rsBoxContainer.add(this.rsLabel);
		
		this.rsComboBox = new JComboBox<String>(RELATIONSHIPS);
		this.rsComboBox.setToolTipText(TOOLTIP_RELATIONSHIP);
		rsBoxContainer.add(rsComboBox);
		formPanel.add(rsBoxContainer);
		
		southPanel.add(formPanel);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setOpaque(false);
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
		BoxLayout buttonsPanelLayout = new BoxLayout(buttonsPanel, BoxLayout.X_AXIS);
		buttonsPanel.setLayout(buttonsPanelLayout);
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.setOpaque(false);
		this.backButton = new JButton(BACK_BUTTON_LABEL);
		this.backButton.setBackground(new Color(253, 88, 91));
		this.backButton.setPreferredSize(new Dimension(100, 30));
		this.backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().removeAll();
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().add(new GiftIdeaApplicationMainPanel(parentFrame));
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().revalidate();
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().repaint();
			}
			
		});
		buttonContainer.add(this.backButton);
	
		buttonContainer.add(Box.createHorizontalStrut(70));
		
		this.goButton = new JButton(GO_BUTTON_LABEL);
		this.goButton.setPreferredSize(new Dimension(100, 30));
		this.goButton.setBackground(new Color(62, 241, 8));
		this.goButton.addActionListener(new GoButtonActionListener());
		
		buttonContainer.add(this.goButton);
		buttonsPanel.add(buttonContainer);
		
		southPanel.add(buttonsPanel);
		
		return southPanel;
	}
	
	/**
	 * <p>Inner class which implements {@link ActionListener} and overrides its actionPerformed
	 * method. Method parses the values entered by user e.g. name, age, gender and relationship 
	 * status from the appropriate GUI elements. Then it calls {@link GiftIdeaApplicationController}
	 * that creates a specified gift, depending on the values entered by the user.</p>
	 * <p>The controller also calls a method that inserts the gift into {@link GiftIdeaApplicationDrawingPanel}. 
	 * After the gift was displayed, the text of the button is changed to "Reset" and a new
	 *  {@link LaunchWorkPanelActionListener} object attached to it. All of the form components are 
	 *  disabled, so user cannot enter new values until he/she resets the screen.</p>
	 *  
	 * @author Csaba Farkas csaba.farkas@mycit.ie
	 *
	 */
	private class GoButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(goButton.getText().equals(GO_BUTTON_LABEL)) {
				repaint();
				
				String friendsName = "";
				if(!nameField.getText().trim().equals("")) {
					friendsName = nameField.getText().trim();
				} else {
					JOptionPane.showMessageDialog(parentFrame, GiftIdeaApplicationWorkPanel.NAME_ERROR_MESSAGE, GiftIdeaApplicationMainPanel.ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
					return;
				}
				Gender friendsGender = null;
				if(buttonGroup.getSelection() != null) {
					if(maleButton.isSelected()){
						friendsGender = Gender.MALE;
					} else {
						friendsGender = Gender.FEMALE;
					}
				} else {
					JOptionPane.showMessageDialog(parentFrame, GiftIdeaApplicationWorkPanel.GENDER_ERROR_MESSAGE, GiftIdeaApplicationMainPanel.ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
					return;
				}
				int friendsAge = ageComboBox.getSelectedIndex();
				
				Relationship relationship = null;
				if(rsComboBox.getSelectedItem().toString().equals("Single")) {
					relationship = Relationship.SINGLE;
				} else {
					relationship = Relationship.IN_A_RELATIONSHIP;
				}
				
				GiftIdeaApplicationController.getInstance().setFriendsName(friendsName);
				GiftIdeaApplicationController.getInstance().setGift(friendsAge, friendsGender, relationship);
				Gift gift = GiftIdeaApplicationController.getInstance().getGift();
				GiftIdeaApplicationController.getInstance().getGui().getDrawnArea().setGift(gift);
				
				nameLabel.setEnabled(false);
				nameField.setEditable(false);
				nameField.setEnabled(false);
				maleButton.setEnabled(false);
				femaleButton.setEnabled(false);
				ageLabel.setEnabled(false);
				ageComboBox.setEnabled(false);
				rsLabel.setEnabled(false);
				rsComboBox.setEnabled(false);
				goButton.setText(RESET_BUTTON_LABEL);
				
				goButton.addActionListener(new LaunchWorkPanelActionListener(userName, parentFrame));
			}
			
		}
		
	}
	
}




