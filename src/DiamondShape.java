import java.awt.Color;
import java.awt.Graphics;

public class DiamondShape extends Shape {

	public DiamondShape() {
		super();
	}

	public DiamondShape(int l, int t) {
		super(l, t);
	}

	public void drawMe(Graphics g) {

		int[] x = new int[4];
		int[] y = new int[4];

		x[0] = (left + left + WIDTH) / 2;
		x[1] = left;
		x[2] = (left + left + WIDTH) / 2;
		x[3] = left + WIDTH;

		y[0] = top;
		y[1] = (top + top + HIGHT) / 2;
		y[2] = top + HIGHT;
		y[3] = (top + top + HIGHT) / 2;

		g.setColor(shpaeColor);
		g.fillPolygon(x, y, 4);

		g.setColor(Color.BLACK);
		g.drawPolygon(x, y, 4);

		super.drawMe(g);
	}

}
