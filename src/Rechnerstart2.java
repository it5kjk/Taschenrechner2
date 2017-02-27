import javax.swing.UIManager;

/**
 * Version 1.5 uses high-level functions
 * for mathematical operations.
 * @author JNK
 * @version 1.5
 */

public class Rechnerstart2 {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
			Taschenrechner rechner = new Taschenrechner();
			rechner.setLocationRelativeTo(null);
			rechner.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
