import java.awt.Graphics;

public class roundShapeMenu extends MenuItem {

	public roundShapeMenu() {
		super();
	}

	public void drawMe(Graphics g) {

		super.drawMe(g);
		g.setColor(formColor);
		g.drawOval(left + 10, top + 10, width - 20, hight - 20);

	}

}
