import java.awt.Color;
import java.awt.Graphics;

public class RoundShape extends Shape {

	public RoundShape() {
		super();
	}

	public RoundShape(int l, int t) {

		super(l, t);

	}

	public void drawMe(Graphics g) {

		g.setColor(shpaeColor);
		g.fillOval(left, top, WIDTH, HIGHT);

		g.setColor(Color.black);
		g.drawOval(left, top, WIDTH, HIGHT);

		super.drawMe(g);

	}

}
