import java.awt.Graphics;

public class diamondMenu extends MenuItem {

	public diamondMenu() {
		super();
	}

	public void drawMe(Graphics g) {

		int[] x = new int[4];
		int[] y = new int[4];

		x[0] = (left + left + width) / 2;
		x[1] = left + 10;
		x[2] = (left + left + width) / 2;
		x[3] = left + width - 10;

		y[0] = top + 10;
		y[1] = (top + top + hight) / 2;
		y[2] = top + hight - 10;
		y[3] = (top + top + hight) / 2;

		super.drawMe(g);

		g.setColor(formColor);
		g.drawPolygon(x, y, 4);

	}

}
