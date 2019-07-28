import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// aviel ben shalom 311315006

		JFrame jf = new JFrame();
		DrawPanel dp = new DrawPanel();

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 600);
		jf.add(dp);
		jf.setVisible(true);
		jf.setLocation(100, 100);

	}

}
