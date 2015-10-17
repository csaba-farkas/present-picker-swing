package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import controller.GiftIdeaApplicationController;
import net.miginfocom.swing.MigLayout;

public class GiftIdeaApplicationWorkPanel extends JPanel {

	private static final long serialVersionUID = 2125803719685015337L;
	
	
	private static final String TEXT = "<html><p color=\"white\"><font size = \"3.5\">I'm going to help you find the perfect present for your friend but first I need some further information.</font></p></html>";
	private static final String NAME_QUESTION_LABEL = "<html><p color=\"white\"><font size = \"3.5\">What is your friend's name?</font></p></html>";
	private static final String GENDER_QUESTION_LABEL = "<html><p color=\"white\"><font size = \"3.5\">What's your friend's gender?</font></p></html>";
	private static final String AGE_QUESTION_LABEL = "<html><p color=\"white\"><font size = \"3.5\">How old is your friend?</font></p></html>";
	private static final String RELATIONSHIP_QUESTION_LABEL = "<html><p color=\"white\"><font size = \"3.5\">What is your friend's relationship status?</font></p></html>";
	private static final String[] GENDERS = {"Male", "Female"};
	private static final String[] AGES = calculateAges();
	private static final String[] RELATIONSHIPS = {"Single", "In a relationship"};
	
	private static String[] calculateAges() {
		String[] ageArray = new String[111];
		for(int i = 0; i < ageArray.length; i++) {
			ageArray[i] = (new Integer(i)).toString();
		}
		return ageArray;
	}
	private String name;
	private JFrame parent;
	
	public GiftIdeaApplicationWorkPanel(String name, JFrame parent) {
		super();
		
		this.name = name;
		this.parent = parent;
		this.setOpaque(false);
		//this.setPreferredSize(parentFrameDimension);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.setLayout(new GridLayout(1, 2));
		
		//Create left hand panel
		JPanel leftHandPanel = createLeftHandPanel();
		this.add(leftHandPanel);
		
		JPanel rightHandPanel = createRigthHandPanel();
		this.add(rightHandPanel);
	}

	private JPanel createRigthHandPanel() {
		JPanel rightHandPanel = new JPanel();
		rightHandPanel.setOpaque(false);
		
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Present", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
		Border margin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		//rightHandPanel.setMaximumSize(new Dimension(parentFrameDimension.height, parentFrameDimension.width/2-30));

		rightHandPanel.setBorder(new CompoundBorder(margin, border));
		return rightHandPanel;
	}

	private JPanel createLeftHandPanel() {
		JPanel leftHandPanel = new JPanel();
		leftHandPanel.setOpaque(false);
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
		Border margin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border innerMargin = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border outerCompundBorder = BorderFactory.createCompoundBorder(margin, border);
		Border totalBorder = new CompoundBorder(outerCompundBorder, innerMargin);
		leftHandPanel.setBorder(totalBorder);
		
		leftHandPanel.setLayout(new GridLayout(7, 1));
		
		//leftHandPanel.setMaximumSize(new Dimension(parentFrameDimension.height, parentFrameDimension.width/2-30));
		//leftHandPanel.setAlignmentY(TOP_ALIGNMENT);
		
		//JPanel innerPanel = new JPanel();
		//BoxLayout boxLayout = new BoxLayout(innerPanel, BoxLayout.Y_AXIS);
		//innerPanel.setLayout(boxLayout);
		//innerPanel.setOpaque(false);
		//innerPanel.setAlignmentX(LEFT_ALIGNMENT);
		//innerPanel.setAlignmentY(TOP_ALIGNMENT);
		//innerPanel.setMaximumSize(new Dimension(leftHandPanel.getSize()));
		JLabel nameLabel = new JLabel("Hello " + GiftIdeaApplicationController.getInstance().getUserName());
		nameLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		nameLabel.setForeground(Color.WHITE);
		leftHandPanel.add(nameLabel);
		
		//JPanel textPanel = new JPanel();
		//textPanel.setOpaque(false);
		JLabel textLabel = new JLabel(TEXT);
		leftHandPanel.add(textLabel);
		//leftHandPanel.add(textPanel);
		
		
		leftHandPanel.add(textLabel);
		
		//leftHandPanel.add(innerPanel);
		
		//nameQuestionPanel
		JPanel nameQuestionPanel = new JPanel();
		nameQuestionPanel.setOpaque(false);
		nameQuestionPanel.setLayout(new MigLayout("", "[][][]", ""));
		JLabel nameQuestionLabel = new JLabel(NAME_QUESTION_LABEL);
		JTextField nameField = new JTextField(20);
		nameQuestionPanel.add(nameQuestionLabel, "span 2");
		nameQuestionPanel.add("gapleft 40", nameField);
		leftHandPanel.add(nameQuestionPanel);
		
		JPanel genderQuestionPanel = new JPanel();
		genderQuestionPanel.setOpaque(false);
		genderQuestionPanel.setLayout(new MigLayout("", "[][][]", ""));
		JLabel genderQuestionLabel = new JLabel(GENDER_QUESTION_LABEL);
		JComboBox genderBox = new JComboBox(GENDERS);
		genderQuestionPanel.add(genderQuestionLabel, "span 2");
		genderQuestionPanel.add("gapleft 40", genderBox);
		leftHandPanel.add(genderQuestionPanel);
		
		JPanel ageQuestionPanel = new JPanel();
		ageQuestionPanel.setOpaque(false);
		ageQuestionPanel.setLayout(new MigLayout());
		JLabel ageQuestionLabel = new JLabel(AGE_QUESTION_LABEL);
		JComboBox ageBox = new JComboBox(AGES);
		ageQuestionPanel.add(ageQuestionLabel);
		ageQuestionPanel.add("gapleft 20", ageBox);
		leftHandPanel.add(ageQuestionPanel);
		
		JPanel relationshipQuestionPanel = new JPanel();
		relationshipQuestionPanel.setOpaque(false);
		relationshipQuestionPanel.setLayout(new MigLayout());
		JLabel relationshipQuestionLabel = new JLabel(RELATIONSHIP_QUESTION_LABEL);
		JComboBox relationshipBox = new JComboBox(RELATIONSHIPS);
		relationshipQuestionPanel.add(relationshipQuestionLabel);
		relationshipQuestionPanel.add(relationshipBox, "span");
		leftHandPanel.add(relationshipQuestionPanel);
		
		JButton backButton = new JButton("<html><p><b>Back</b></p></html>");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().removeAll();
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().add(new GiftIdeaApplicationMainPanel(parent));
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().revalidate();
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().repaint();
				
			}
			
		});
		JButton generateButton = new JButton("<html><p><b>Generate!</b></p></html>");
		JPanel buttonsPanel = new JPanel(new MigLayout()); 
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(backButton);
		buttonsPanel.add(generateButton, "span 2");
		leftHandPanel.add(buttonsPanel);
		
		
		
		return leftHandPanel;
	}
}
