package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import controller.GiftIdeaApplicationController;
import model.Gift;
import model.enums.Gender;
import model.enums.Relationship;

public class TestPanel extends JPanel {

	private static final long serialVersionUID = 2125803719685015337L;
	
	
	private static final String TEXT = "I'm going to help you find the perfect present for your friend but first I need some further information.";
	private static final String NAME_QUESTION_LABEL = "Name: ";
	private static final String GENDER_QUESTION_LABEL = "Gender: ";
	private static final String AGE_QUESTION_LABEL = "Age: ";
	private static final String RELATIONSHIP_QUESTION_LABEL = "Relationship Status: ";
	private static final String[] GENDERS = {"", "Male", "Female"};
	private static final String[] AGES = calculateAges();
	private static final String[] RELATIONSHIPS = {"", "Single", "In a relationship"};
	
	private static String[] calculateAges() {
		String[] ageArray = new String[111];
		for(int i = 0; i < ageArray.length; i++) {
			ageArray[i] = (new Integer(i)).toString();
		}
		return ageArray;
	}
	private String userName;
	private JFrame parent;
	private JTextField nameField;
	private JComboBox genderComboBox;
	private JComboBox ageComboBox;
	private JComboBox rsComboBox;
	private Gift giftPanel;
	
	public TestPanel(String userName, JFrame parent) {
		super();
		
		this.userName = userName;
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

		if(this.giftPanel != null) {
			rightHandPanel.add(this.giftPanel);
		}
		rightHandPanel.setBorder(new CompoundBorder(margin, border));
		return rightHandPanel;
	}

	private JPanel createLeftHandPanel() {
		JPanel leftHandPanel = new JPanel();
		leftHandPanel.setOpaque(false);
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
		Border margin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border innerMargin = BorderFactory.createEmptyBorder(50, 15, 5, 5);
		Border outerCompundBorder = BorderFactory.createCompoundBorder(margin, border);
		Border totalBorder = new CompoundBorder(outerCompundBorder, innerMargin);
		leftHandPanel.setBorder(totalBorder);
		
		leftHandPanel.setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea();
		textArea.setOpaque(false);
		//textArea.setPreferredSize(leftHandPanel.getSize());
		textArea.setForeground(new Color(243, 250, 157));;
		textArea.setFont(new Font("Arial", Font.PLAIN, 21));
		String text = "Hello " + this.userName + "! " + TEXT;
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText(text);
		
		leftHandPanel.add(textArea, BorderLayout.NORTH);
		
		JPanel formContainer = new JPanel();
		formContainer.setOpaque(false);
		
		JPanel form = new JPanel();
		form.setLayout(new GridBagLayout());
		form.setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		c.ipady = 15;
		c.anchor = GridBagConstraints.NORTHEAST;
		
		
		JPanel emptyPanel = new JPanel();
		emptyPanel.setOpaque(false);
		form.add(emptyPanel, c);
		
		c.gridy++;
		Font labelFont = new Font("Arial Narrow", Font.PLAIN, 18);
		JLabel nameQuestionLabel = new JLabel(NAME_QUESTION_LABEL);
		nameQuestionLabel.setForeground(Color.WHITE);
		nameQuestionLabel.setFont(labelFont);
		form.add(nameQuestionLabel, c);
		
		c.gridy++;
		JLabel genderQuestionLabel = new JLabel(GENDER_QUESTION_LABEL);
		genderQuestionLabel.setForeground(Color.WHITE);
		genderQuestionLabel.setFont(labelFont);
		form.add(genderQuestionLabel, c);
		
		c.gridy++;
		JLabel ageQuestionLabel = new JLabel(AGE_QUESTION_LABEL);
		ageQuestionLabel.setForeground(Color.WHITE);
		ageQuestionLabel.setFont(labelFont);
		form.add(ageQuestionLabel, c);
		
		c.gridy++;
		JLabel relationshipQuestionLabel = new JLabel(RELATIONSHIP_QUESTION_LABEL);
		relationshipQuestionLabel.setForeground(Color.WHITE);
		relationshipQuestionLabel.setFont(labelFont);
		form.add(relationshipQuestionLabel, c);
		
		c.gridy = 0;
		c.gridx++;
		
		JPanel emptyPanel1 = new JPanel();
		emptyPanel1.setOpaque(false);
		form.add(emptyPanel1, c);
		c.gridy++;
		
		c.anchor = GridBagConstraints.NORTHWEST;
		JPanel nameFieldContainer = new JPanel();
		nameFieldContainer.setOpaque(false);
		this.nameField = new JTextField(15);
		this.nameField.setToolTipText("Your friend's name");
		nameFieldContainer.add(this.nameField);
		form.add(nameFieldContainer, c);
		
		c.gridy++;
		JPanel genderComboBoxContainer = new JPanel();
		genderComboBoxContainer.setOpaque(false);
		this.genderComboBox = new JComboBox(GENDERS);
		this.genderComboBox.setToolTipText("Your friend's gender");
		genderComboBoxContainer.add(this.genderComboBox);
		form.add(genderComboBoxContainer, c);
		
		c.gridy++;
		JPanel ageComboBoxContainer = new JPanel();
		ageComboBoxContainer.setOpaque(false);
		this.ageComboBox = new JComboBox(AGES);
		this.ageComboBox.setToolTipText("Your friend's age");
		ageComboBoxContainer.add(this.ageComboBox);
		form.add(ageComboBoxContainer, c);
		
		c.gridy++;
		JPanel rsComboBoxContainer = new JPanel();
		rsComboBoxContainer.setOpaque(false);
		this.rsComboBox = new JComboBox(RELATIONSHIPS);
		this.rsComboBox.setToolTipText("Your friend's relationship status");
		rsComboBoxContainer.add(this.rsComboBox);
		form.add(rsComboBoxContainer, c);
		
		c.gridx--;
		c.gridy++;
		
		JPanel emptyPanel2 = new JPanel();
		emptyPanel2.setOpaque(false);
		form.add(emptyPanel2, c);
		
		c.gridy++;
		c.gridheight = 2;
		
		c.anchor = GridBagConstraints.PAGE_END;
		JButton backButton = new JButton("Back");
		backButton.setBackground(new Color(253, 88, 91));
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().removeAll();
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().add(new GiftIdeaApplicationMainPanel(parent));
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().revalidate();
				GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().repaint();
				
			}
			
		});
		form.add(backButton, c);
		
		c.gridx++;
		c.gridy--;
		
		JPanel emptyPanel3 = new JPanel();
		emptyPanel3.setOpaque(false);
		form.add(emptyPanel3, c);
		
		c.gridy++;
		c.gridwidth = 1;
		
		JButton generateButton = new JButton("Generate!");
		generateButton.setBackground(new Color(62, 241, 8));
		generateButton.addActionListener(new GenerateButtonListenter());
		form.add(generateButton, c);

		formContainer.add(form);
		leftHandPanel.add(formContainer, BorderLayout.CENTER);
		
		return leftHandPanel;
	}
	
	private class GenerateButtonListenter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(nameField.getText().trim().equals("") || genderComboBox.getSelectedItem() == null || ageComboBox.getSelectedItem() == null || rsComboBox.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(TestPanel.this, "Incomplete form. Please complete form.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				//Parse name
				String friendName = nameField.getText().trim();
				int genderIndex = genderComboBox.getSelectedIndex();
				Gender gender;
				if(genderIndex == 0) {
					gender = Gender.MALE;
				} else {
					gender = Gender.FEMALE;
				}
				Integer age = ageComboBox.getSelectedIndex();
				Relationship rs;
				if(age == 0) {
					rs = Relationship.SINGLE;
				} else {
					rs = Relationship.IN_A_RELATIONSHIP;
				}
				
				GiftIdeaApplicationController.getInstance().setGift(friendName, age, gender, rs);
				giftPanel = GiftIdeaApplicationController.getInstance().getGift();
				repaint();
			}
		}
		
	}
}
