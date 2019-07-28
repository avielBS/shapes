import java.awt.Color;
import java.awt.Graphics;

public class TriangleUpShape extends Shape {
	public TriangleUpShape() {
		super();
	}

	public TriangleUpShape(int l, int t) {

		super(l, t);

	}

	public void drawMe(Graphics g) {

		int[] x = new int[3];
		int[] y = new int[3];

		x[0] = left;
		x[1] = left + WIDTH;
		x[2] = (left + left + WIDTH) / 2;

		y[0] = top + HIGHT;
		y[1] = top + HIGHT;
		y[2] = top;

		g.setColor(shpaeColor);
		g.fillPolygon(x, y, 3);
		g.setColor(Color.black);
		g.drawPolygon(x, y, 3);

		super.drawMe(g);

	}
}
