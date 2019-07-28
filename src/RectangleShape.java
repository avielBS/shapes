import java.awt.Color;
import java.awt.Graphics;

public class RectangleShape extends Shape {

	public RectangleShape() {
		super();
	}

	public RectangleShape(int l, int t) {

		super(l, t);

	}

	public void drawMe(Graphics g) {

		g.setColor(shpaeColor);
		g.fillRect(left, top, WIDTH, HIGHT);

		g.setColor(Color.black);
		g.drawRect(left, top, WIDTH, HIGHT);

		super.drawMe(g);

	}
}
