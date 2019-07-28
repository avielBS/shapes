import java.awt.Graphics;

public class rectangleMenu extends MenuItem {

	public rectangleMenu() {
		super();
	}

	public void drawMe(Graphics g) {
		super.drawMe(g);

		g.setColor(this.formColor);
		g.drawRect(left + 10, top + 10, width - 20, hight - 20);

	}

}
