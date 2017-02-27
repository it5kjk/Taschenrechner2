import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Taschenrechner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField tf_1; // contains first operand
	private JTextField tf_2; // contains second operand
	private JTextField tf_3; // result
	
	private JButton bu_1; // plus operation
	private JButton bu_2;
	
	/**
	 * Create the frame.
	 */
	public Taschenrechner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Taschenrechner");
		setBounds(100, 100, 387, 143);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		tf_1 = new JTextField();
		tf_1.setBounds(20, 35, 60, 20);
		contentPane.add(tf_1);
		tf_1.setColumns(10);
		
		tf_2 = new JTextField();
		tf_2.setBounds(90, 35, 60, 20);
		contentPane.add(tf_2);
		tf_2.setColumns(10);
		
		tf_3 = new JTextField();
		tf_3.setBounds(272, 35, 70, 20);
		contentPane.add(tf_3);
		tf_3.setColumns(10);
		
		//button 1
		bu_1 = new JButton("+");
		bu_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyBinaryOp(new MathOp() {
					@Override
					public double calc(double arg1, double arg2) {
						return arg1 + arg2;
					}
				});
			}
		});
		bu_1.setBounds(160, 34, 41, 23);
		contentPane.add(bu_1);
		
		//button 2
		bu_2 = new JButton("*");
		bu_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyBinaryOp(new MathOp() {
					@Override
					public double calc(double arg1, double arg2) {
						return arg1 * arg2;
					}
				});
			}
		});
		bu_2.setBounds(211, 34, 41, 23);
		contentPane.add(bu_2);
	}
	
	private Double getDoubleOrWarn(JTextField tf) {
	    try {
	        double d = Double.parseDouble(tf.getText());   
	        tf.setBackground(Color.white);
	        return d;
	    } catch (NumberFormatException e) {
	        tf.setBackground(Color.red);
	        tf.requestFocus();
	        return null;
	    }
	}
	
	static interface MathOp {
		   double calc(double arg1, double arg2);
	}

	private void applyBinaryOp(MathOp mathOp) {
		Double value_1 = getDoubleOrWarn(tf_1);
		Double value_2 = getDoubleOrWarn(tf_2);
		if((value_1 != null) && (value_2 != null)) {
			double res = mathOp.calc(value_1, value_2);
			tf_3.setText(String.valueOf(res));
			System.out.println(res);
		}
		else
			tf_3.setText("");   
	}
}