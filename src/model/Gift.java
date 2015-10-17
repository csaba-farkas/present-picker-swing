package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Gift extends JPanel{

	public Gift() {
		super();
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		int x = 0;
		int y = 0;
		
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 50, 50);
	}
}
