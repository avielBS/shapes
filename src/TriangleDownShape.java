import java.awt.Color;
import java.awt.Graphics;

public class TriangleDownShape extends Shape {
	public TriangleDownShape() {
		super();
	}

	public TriangleDownShape(int l, int t) {

		super(l, t);

	}

	public void drawMe(Graphics g) {

		int[] x = new int[3];
		int[] y = new int[3];

		x[0] = left;
		x[1] = left + WIDTH;
		x[2] = (left + left + WIDTH) / 2;

		y[0] = top;
		y[1] = top;
		y[2] = top + HIGHT;

		g.setColor(shpaeColor);
		g.fillPolygon(x, y, 3);
		g.setColor(Color.black);
		g.drawPolygon(x, y, 3);

		super.drawMe(g);

	}
}
