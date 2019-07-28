import java.awt.Color;
import java.awt.Graphics;

public class Shape {

	protected int left, top;
	public final int WIDTH = 100, HIGHT = 100;
	protected Color shpaeColor;
	protected boolean choosen, changeColor, cancle;
	protected Eye leftEye, rightEye;
	protected closeWindow close;

	public Shape() {
		this(0, 0);
	}

	public Shape(int l, int t) {
		left = l;
		top = t;

		leftEye = new Eye(left + 10, (top + HIGHT / 4));
		rightEye = new Eye((left * 2 + WIDTH) / 2, top + HIGHT / 4);

		shpaeColor = Color.LIGHT_GRAY; // default color before changing in dialogPanel
		choosen = false;
		changeColor = false;

		close = new closeWindow(left + WIDTH, top);

	}

	public void updateColor(Color c) {
		shpaeColor = c;
	}

	public void setLeft(int mx) {
		left = mx - WIDTH / 2;
	}

	public void setTop(int my) {
		top = my - HIGHT / 2;
	}

	public void updateEyes(int mx, int my) {

		leftEye.updatePupil(mx, my);
		rightEye.updatePupil(mx, my);

	}

	public void drawMe(Graphics g) {

		leftEye.drawMe(g);
		rightEye.drawMe(g);

		if (choosen)
			close.drawMe(g);

	}

	public boolean checkIfChangeColor(int mlx, int mly) {

		if (mlx >= left && mlx <= left + WIDTH && mly <= top + WIDTH && mly >= top) {
			changeColor = true;
			return true;
		} else
			changeColor = false;
		return false;
	}

	public void setCenterShape(int mx, int my) {

		int centerX, centerY;

		centerX = mx - WIDTH / 2;
		centerY = my - HIGHT / 2;

		left = centerX;
		top = centerY;

		leftEye.updatePlace(left + 10, (top + HIGHT / 4));
		rightEye.updatePlace((left * 2 + WIDTH) / 2, top + HIGHT / 4);

		close.updatePlace(left + WIDTH, top);

	}

	public boolean wantDeleteShapeOption(int mx, int my) {

		if (mx >= left && mx <= left + WIDTH && my <= top + WIDTH && my >= top) {
			choosen = true;
			return true;
		} else
			choosen = false;
		return false;
	}

	public boolean deleteShape(int mx, int my) {

		if (close.wantToDeleteMe(mx, my))
			cancle = true;
		else
			cancle = false;

		return cancle;
	}

}
