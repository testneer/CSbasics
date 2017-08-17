package Model;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class ColoredLine2D extends Line2D.Double{
	private Color color = Color.black;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
