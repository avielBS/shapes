import java.awt.Color;
import java.awt.Graphics;

public class closeWindow {

	public final int SIZE = 15;

	private int left, top;
	private Color backgroundColor, xColor;

	public closeWindow() {
		this(0, 0);

	}

	public closeWindow(int l, int t) {
		updatePlace(l, t);
		backgroundColor = Color.DARK_GRAY;
		xColor = Color.red;

	}

	public void drawMe(Graphics g) {

		g.setColor(backgroundColor);
		g.fillRect(left, top, SIZE, SIZE);

		g.setColor(xColor);
		g.drawLine(left, top, left + SIZE, top + SIZE);
		g.drawLine(left + SIZE, top, left, top + SIZE);

	}

	public void updatePlace(int x, int y) {
		left = x - SIZE;
		top = y;
	}

	public boolean wantToDeleteMe(int mx, int my) {

		return mx >= left && mx <= left + SIZE && my >= top && my <= top + SIZE;
	}

}
