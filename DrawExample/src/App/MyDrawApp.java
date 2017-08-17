package App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import Model.ColoredLine2D;

public class MyDrawApp extends JFrame implements ActionListener, MouseListener {
	private Point originPoint = null;

	ArrayList<ColoredLine2D> lines = new ArrayList<ColoredLine2D>();

	public MyDrawApp() {
		this.setTitle("My Tablet");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.setLayout(new BorderLayout());
	}

	public void paint(Graphics g) {
		paintComponents(g);
		for (ColoredLine2D line : lines) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(line.getColor());
			g2.draw(line);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {

	}

	public void mouseExited(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
    	
        int x = me.getX();
        int y = me.getY();

        if(originPoint == null){
    		originPoint = new Point(x, y);
    	}
        else{
        	Point destination = new Point(x, y);
        	ColoredLine2D line = new ColoredLine2D(originPoint, destination);
        	originPoint = destination;
	        lines.add(line);
	        repaint();	
        }
    }

	public void mouseReleased(MouseEvent me) {
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyDrawApp frame = new MyDrawApp();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}