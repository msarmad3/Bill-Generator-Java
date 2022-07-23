package ihetesam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;



import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class bill {

	 JFrame frame;
	private JTextField txtname;
	private JTextField txtamount;
	private JTextField txtquantity;
	public int sum;
	public int totalsum;
	private JTextField txtmeter;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill window = new bill();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bill() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtarea = new JTextArea();
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(32, 49, 98, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAmount.setBounds(32, 123, 98, 29);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Arial", Font.PLAIN, 17));
		lblQuantity.setBounds(32, 15, 98, 29);
		frame.getContentPane().add(lblQuantity);
		
		txtname = new JTextField();
		txtname.setBounds(104, 55, 151, 20);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtamount = new JTextField();
		txtamount.setColumns(10);
		txtamount.setBounds(104, 129, 151, 20);
		frame.getContentPane().add(txtamount);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(104, 21, 151, 20);
		frame.getContentPane().add(txtquantity);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int s;
				int q;
				int m;
				q = Integer.parseInt(txtquantity.getText());
				m = Integer.parseInt(txtmeter.getText());
				
				s = Integer.parseInt(txtamount.getText());
				m = m*q;
				sum = m*s;
				totalsum  += sum;
				txtarea.setText(txtarea.getText() + txtquantity.getText()+ "    "+txtname.getText()+"      "+txtmeter.getText()+"    "+txtamount.getText()+"      "+totalsum+" \n");
				
				txtname.setText("");
				txtamount.setText("");
				txtquantity.setText("");
				txtmeter.setText("");
				
			}
			
		});
		btnNewButton.setBounds(104, 163, 151, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtname.setText("");
				txtamount.setText("");
				txtquantity.setText("");
				txtmeter.setText("");
				txtarea.setText("---------------------------Ihetesam Cloth Invoice---------------------------\r\nClient Name:\r\nDate:\r\nQty   Name\t  Meter\t Rate   Total\r\n"
						);
			}
		});
		btnNewButton_1.setBounds(104, 197, 151, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		txtarea.setText("---------------------------Ihetesam Cloth Invoice---------------------------\r\nClient Name:\r\nDate:\r\nQty   Name\t  Meter\t Rate   Total\r\n"
				);
		txtarea.setBounds(350, 37, 331, 342);
		frame.getContentPane().add(txtarea);
		
		JButton btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtarea.setText(txtarea.getText() +"____________________________________________________"+"\n");
				txtarea.setText(txtarea.getText() +"TOTAL:                                          "+sum);
				
			}
		});
		btnNewButton_2.setBounds(104, 231, 151, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtarea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(104, 265, 151, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		txtmeter = new JTextField();
		txtmeter.setBounds(104, 95, 151, 20);
		frame.getContentPane().add(txtmeter);
		txtmeter.setColumns(10);
		
		JLabel lblMeters = new JLabel("Meters:");
		lblMeters.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMeters.setBounds(32, 89, 98, 29);
		frame.getContentPane().add(lblMeters);
		
		JButton btnNewButton_4 = new JButton("Go to record");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recordwindow obj = new recordwindow();
				obj.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_4.setBounds(104, 295, 151, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
