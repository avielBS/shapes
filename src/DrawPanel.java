import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	public final int NUM_OF_SHAPES = 5, MAX_ITEMS_NUMBER = 30;
	private MenuItem[] items;
	private Shape[] shapes;
	private int shapesCounter;
	private DiamondShape ds;

	public DrawPanel() {

		items = new MenuItem[NUM_OF_SHAPES];

		items[0] = new rectangleMenu();
		items[1] = new triUpMenu();
		items[2] = new triDownMenu();
		items[3] = new roundShapeMenu();
		items[4] = new diamondMenu();

		addMouseMotionListener(new mouse());
		addMouseListener(new mouse());

		shapes = new Shape[MAX_ITEMS_NUMBER];
		shapesCounter = 0;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int x, y, hight;
		x = getWidth();
		y = getHeight();
		hight = y / NUM_OF_SHAPES;

		for (int i = 0; i < items.length; i++) {

			items[i].setLeft(x * 6 / 7);
			items[i].setWidth(x * 1 / 7);
			items[i].setTop(i * hight);
			items[i].setHight(hight);

			items[i].drawMe(g);

		}

		for (int i = 0; i < shapesCounter; i++)
			if (shapes[i] != null)
				shapes[i].drawMe(g);

	}

	public class mouse extends MouseAdapter {
		public void mouseMoved(MouseEvent e) {

			int mx, my;
			mx = e.getX();
			my = e.getY();

			for (int i = 0; i < items.length; i++)
				items[i].checkIfActive(mx, my);

			for (int i = 0; i < shapes.length; i++) {
				if (shapes[i] != null)
					shapes[i].updateEyes(mx, my);
			}

			for (int i = 0; i < shapes.length; i++) {
				if (shapes[i] != null)
					shapes[i].wantDeleteShapeOption(mx, my);
			}

			repaint();

		}

		public void mouseClicked(MouseEvent e) {

			int mx, my, oldx, oldy;

			mx = e.getX();
			my = e.getY();

			Color clr = null;

			if (e.getButton() == 3) {

				for (int i = 0; i < shapes.length; i++) {
					if (shapes[i] != null && shapes[i].checkIfChangeColor(mx, my)) {
						clr = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
						if(clr != null)
							shapes[i].updateColor(clr);
					}
					repaint();
				}

			}
			if (e.getButton() == 1 && mx > getWidth() * 6 / 7) {
				for (int i = 0; i < NUM_OF_SHAPES; i++) {
					if (my > i * getHeight() / NUM_OF_SHAPES && my < (i + 1) * getHeight() / NUM_OF_SHAPES) {
						switch (i) {
						case 0: {
							shapes[shapesCounter] = new RectangleShape();
							break;
						}
						case 1: {
							shapes[shapesCounter] = new TriangleUpShape();
							break;
						}
						case 2: {
							shapes[shapesCounter] = new TriangleDownShape();
							break;
						}
						case 3: {
							shapes[shapesCounter] = new RoundShape();
							break;
						}
						case 4: {
							shapes[shapesCounter] = new DiamondShape();
							break;
						}

						}
					}
				}
			}

			else if (e.getButton() == 1 && mx <= getWidth() * 6 / 7 && shapes[shapesCounter] != null) {
				shapes[shapesCounter++].setCenterShape(mx, my);
				repaint();
				repaint();
			}

			else if (e.getButton() == 1) {

				for (int i = 0; i < shapes.length; i++) {
					if (shapes[i] != null && shapes[i].deleteShape(mx, my))
						shapes[i] = null;

					repaint();
				}

			}

		}
	}
}
