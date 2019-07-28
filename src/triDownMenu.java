import java.awt.Graphics;

public class triDownMenu extends MenuItem {

	public triDownMenu() {
		super();
	}

	public void drawMe(Graphics g) {

		int[] x = new int[3];
		int[] y = new int[3];

		x[0] = left + 10;
		x[1] = left + width - 10;
		x[2] = (left + left + width) / 2;

		y[0] = top + 10;
		y[1] = top + 10;
		y[2] = top + hight - 10;

		super.drawMe(g);
		g.setColor(formColor);
		g.drawPolygon(x, y, 3);
	}

}
