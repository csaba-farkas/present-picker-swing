package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GiftIdeaApplicationController;

public class GiftIdeaApplicationMainPanel extends JPanel {

	private static final long serialVersionUID = 1369857900211748899L;
	
	private static final String WELCOME_LABEL_MESSAGE = "Hello Stranger! Please enter your name:";
	private static final String LAUNCH_BUTTON_TEXT = "Launch!";

	protected static final Object ERROR_MESSAGE = "Please enter your name!";

	protected static final String ERROR_MESSAGE_TITLE = "Error";
	
	private JTextField nameField;
	private JButton launchButton;
	private JFrame parent;
	
	public GiftIdeaApplicationMainPanel(JFrame parent) {
		super();
		this.parent = parent;
		
		this.setLayout(new BorderLayout());
		JPanel southPanel = new JPanel();
		southPanel.add(createSouthPanel());
		southPanel.setPreferredSize(new Dimension(200, 300));
		southPanel.setOpaque(false);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.setOpaque(false);
		this.parent.getRootPane().setDefaultButton(this.launchButton);

	}

	private JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setOpaque(false);
		JLabel centerLabel = new JLabel(WELCOME_LABEL_MESSAGE);
		centerLabel.setHorizontalAlignment(JLabel.CENTER);
		centerLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		centerLabel.setForeground(Color.WHITE);
		centerPanel.add(centerLabel);
		return centerPanel;
	}

	private JPanel createSouthPanel() {
		JPanel southPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(southPanel, BoxLayout.Y_AXIS);
		southPanel.setLayout(boxLayout);
		this.nameField = new JTextField(25);
		this.launchButton = new JButton(LAUNCH_BUTTON_TEXT);
		
		southPanel.add(nameField);
		this.nameField.setAlignmentY(CENTER_ALIGNMENT);
		this.nameField.setHorizontalAlignment(JTextField.CENTER);
		this.nameField.setFont(new Font("Arial Narrow", Font.PLAIN, 21));
		this.nameField.setForeground(new Color(90, 93, 89));
		southPanel.add(Box.createVerticalStrut(10));
		
		southPanel.add(launchButton);
		this.launchButton.setAlignmentX(CENTER_ALIGNMENT);
		this.launchButton.setBackground(new Color(62, 241, 8));
		this.launchButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		this.launchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(GiftIdeaApplicationMainPanel.this, ERROR_MESSAGE, ERROR_MESSAGE_TITLE, JOptionPane.ERROR_MESSAGE);
				}
				else {
					GiftIdeaApplicationController.getInstance().setUserName(nameField.getText().trim());
					GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().removeAll();
					GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().add(new TestPanel(nameField.getText().trim(), parent));
					GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().revalidate();
					GiftIdeaApplicationController.getInstance().getGui().getFrameContentPane().repaint();

				}
				
			}
		});
		
		southPanel.setOpaque(false);
		return southPanel;
	}
}
