package ihetesam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class recordwindow {

	JFrame frame;
	private JTextField txtcustomername;
	private JTextField txtamount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recordwindow window = new recordwindow();
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
	public recordwindow() {
		initialize();
		GetData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(21, 42, 141, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAmount.setBounds(21, 104, 141, 36);
		frame.getContentPane().add(lblAmount);
		
		txtcustomername = new JTextField();
		txtcustomername.setBounds(162, 42, 280, 30);
		frame.getContentPane().add(txtcustomername);
		txtcustomername.setColumns(10);
		
		txtamount = new JTextField();
		txtamount.setBounds(162, 104, 280, 30);
		frame.getContentPane().add(txtamount);
		txtamount.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (!txtcustomername.getText().equals("") && !txtamount.getText().equals("")) {
						
						
						Connection con = DBConnection.MySqlConnection();
						String username= txtcustomername.getText();
						//String s = txtsalary.getText();
						int amount = Integer.parseInt(txtamount.getText());
						if (!con.equals(null)) {
							Statement stmt = con.createStatement();
							String query= "insert into record (customername, amount) values ('"+username+"' , '"+amount+"')"; 
	                                
							JOptionPane.showMessageDialog(null,query);
							stmt.execute(query);
							stmt.close();
							con.close();
							JOptionPane.showMessageDialog(null,"Record Added");
							txtcustomername.setText("");
							txtamount.setText("");
							GetData();
					
						}
						else {
							JOptionPane.showMessageDialog(null,"Input correct Username");
						
						
														}
						
						
			}
					else {
						JOptionPane.showMessageDialog(null,"Input username/salary");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Database Connection failed "+ex.toString());
				}
				
				
				
			}
		});
		btnNewButton.setBounds(112, 168, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (!txtcustomername.getText().equals("") && !txtamount.getText().equals("")) {
						
						
						Connection con = DBConnection.MySqlConnection();
						String username= txtcustomername.getText();
						String s = txtamount.getText();
						int salary = Integer.parseInt(s);
						if (!con.equals(null)) {
							Statement stmt = con.createStatement();
							String query1="select amount from record where customername = '"+username+"'";
							ResultSet rs = stmt.executeQuery(query1);
							int amount = 0;
							while(rs.next()) {
							amount = rs.getInt(1);
							
							
							}
							amount = (amount)+(salary);
							String query= "update record "
	                                + "set amount= "       + amount + " where customername ='"+ txtcustomername.getText()+ "'";
							JOptionPane.showMessageDialog(null,query);
							stmt.execute(query);
							stmt.close();
							con.close();
							JOptionPane.showMessageDialog(null,"record updated");
							txtcustomername.setText("");
							txtamount.setText("");
							GetData();
					
						}
						else {
							JOptionPane.showMessageDialog(null,"Input correct Username");
						
						
														}
						
						
			}
					else {
						JOptionPane.showMessageDialog(null,"Input username/salary");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Database Connection failed "+ex.toString());
				}
			}
		});
		btnNewButton_1.setBounds(211, 168, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!txtcustomername.getText().equals("")) {
						Connection con = DBConnection.MySqlConnection();
						String username= txtcustomername.getText();
						if (!con.equals(null)) {
							Statement stmt = con.createStatement();
							String query= "delete from record"
	                                + " where customername= '"       + txtcustomername.getText().trim() + "'";
							stmt.execute(query);
							stmt.close();
							con.close();
							JOptionPane.showMessageDialog(null,"User deleted");
							txtcustomername.setText("");
							GetData();
							
							
														}
						
						
			}
					else {
						JOptionPane.showMessageDialog(null,"Input Username");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Database Connection failed "+ex.toString());
				}
			}
		});
		btnNewButton_2.setBounds(310, 168, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 219, 502, 220);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer Name","Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
					String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("Go to billing");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bill obj = new bill();
				obj.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(409, 168, 133, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
	void GetData() {
		try {
		Connection con = DBConnection.MySqlConnection();
		
		String query= "select customername, amount from record";
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int rowCount = model.getRowCount();
		for(int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		Statement stmt = con.createStatement();
		String Username, Name;
		
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			
			Name = rs.getString(1);
			Username = rs.getString(2);
			
			String row[] = {Name,Username};
			model.addRow(row);
		}
		stmt.close();
		con.close();
		
		}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null,ex.getLocalizedMessage());
	}
		
		
	}
}
