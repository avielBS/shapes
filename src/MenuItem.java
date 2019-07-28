import java.awt.Color;
import java.awt.Graphics;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class MenuItem {

	protected int left, top, width, hight;
	protected boolean active;
	protected Color backgroundColor, formColor;

	public MenuItem() {
		this(0, 0, 0, 0);
	}

	public MenuItem(int l, int t, int w, int h) {
		left = l;
		top = t;
		width = w;
		hight = h;
		active = false;
		backgroundColor = Color.DARK_GRAY;
		formColor = Color.black;
	}

	public void setLeft(int l) {
		left = l;
	}

	public void setTop(int t) {
		top = t;
	}

	public void setWidth(int w) {
		width = w;
	}

	public void setHight(int h) {
		hight = h;
	}

	public void checkIfActive(int mx, int my) {

		if (mx <= left + width && mx >= left && my <= top + hight && my >= top) {
			active = true;
			backgroundColor = Color.GRAY;
			formColor = Color.YELLOW;

		} else {
			active = false;
			backgroundColor = Color.DARK_GRAY;
			formColor = Color.black;
		}

	}

	public boolean getActive() {
		return active;
	}

	public void drawMe(Graphics g) {

		g.setColor(backgroundColor);
		g.fillRect(left, top, width, hight);

		g.setColor(Color.BLACK);
		g.drawRect(left, top, width, hight);

	}

}
