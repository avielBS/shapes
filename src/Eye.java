import java.awt.Color;
import java.awt.Graphics;

public class Eye {

	private int eyeLeft, eyeTop, eyeRadius;
	private int pupileLeft, pupileTop, PupileRadius;

	public Eye() {
		this(0, 0);
	}

	public Eye(int l, int t) {
		eyeLeft = l;
		eyeTop = t;

		eyeRadius = 20;

		setPupile(eyeLeft, eyeTop);

	}

	private void setPupile(int mx, int my) {
		PupileRadius = 7;

		int cx, cy; // eyes center
		int cpx, cpy;// pupil center
		double directionX, directionY, length, distance;

		cx = eyeLeft + eyeRadius;
		cy = eyeTop + eyeRadius;

		directionX = mx - cx;
		directionY = my - cy;

		length = Math.sqrt((double) directionX * directionX + directionY * directionY);

		directionX /= length;
		directionY /= length;

		distance = eyeRadius - PupileRadius;

		cpx = (int) (cx + (directionX * distance));
		cpy = (int) (cy + (directionY * distance));

		pupileLeft = cpx - PupileRadius;
		pupileTop = cpy - PupileRadius;

	}

	public void updatePupil(int mx, int my) {
		setPupile(mx, my);
	}

	public void drawMe(Graphics g) {

		g.setColor(Color.white);
		g.fillOval(eyeLeft, eyeTop, eyeRadius * 2, eyeRadius * 2);

		g.setColor(Color.BLACK);
		g.drawOval(eyeLeft, eyeTop, eyeRadius * 2, eyeRadius * 2);

		g.fillOval(pupileLeft, pupileTop, PupileRadius * 2, PupileRadius * 2);

	}

	public void updatePlace(int centerX, int centerY) {
		eyeLeft = centerX;
		eyeTop = centerY;

		updatePupil(centerX, centerY);

	}

}
