package ui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanel2 extends JPanel {
	public void paintComponent(Graphics g) {
		ImageIcon pic = new ImageIcon("/Users/chengyunfei/Desktop/bf.jpg");
		g.drawImage(pic.getImage(), 0, 0, null);
	}
}
