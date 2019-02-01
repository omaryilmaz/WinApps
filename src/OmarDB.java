import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;

public class OmarDB extends JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	static Connection con=null;
	private JTextField txtName;
	private JTextField txtAddress;
	private JLabel label;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					OmarDB window = new OmarDB();
					window.frame.setVisible(true);
					DBCon db=new DBCon();
					con=db.connect();
				} catch (Exception e) {
				e.printStackTrace();
				
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OmarDB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 627, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("\u062A\u062D\u0645\u064A\u0644");
		button.setBounds(112, 11, 129, 49);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                    try {
					
					String query ="select * from Employee";
					PreparedStatement pst =con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
				e.printStackTrace();
				
				}
				
				
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		
		label = new JLabel("");
		label.setBounds(310, 0, 310, 123);
		frame.getContentPane().add(label);
		
		table = new JTable();
		table.setBounds(278, 0, 310, 123);
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBackground(Color.GREEN);
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		frame.getContentPane().add(table);
			
			
			txtName = new JTextField();
			txtName.setBounds(350, 134, 139, 29);
			txtName.setToolTipText("\u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u062B\u0644\u0627\u062B\u064A");
			txtName.setHorizontalAlignment(SwingConstants.RIGHT);
			frame.getContentPane().add(txtName);
			txtName.setColumns(3);
		
			
			
			txtAddress = new JTextField();
			txtAddress.setBounds(350, 174, 139, 29);
			txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
			txtAddress.setToolTipText("\u0627\u0644\u0639\u0646\u0648\u0627\u0646");
			frame.getContentPane().add(txtAddress);
			txtAddress.setColumns(3);
			
			JLabel lblNewLabel = new JLabel("\u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u062B\u0644\u0627\u062B\u064A");
			lblNewLabel.setBounds(499, 141, 89, 22);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel label_1 = new JLabel("\u0627\u0644\u0639\u0646\u0648\u0627\u0646");
			label_1.setBounds(499, 181, 74, 14);
			frame.getContentPane().add(label_1);
			
			JButton btnPt = new JButton("\u062D\u0641\u0638");
			
			btnPt.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					 try {
//						 String query ="INSERT INTO [dbo].[Employee] (ID,FullName) values (txtName.text,txtAddress.text)";
							//String query ="INSERT INTO [dbo].[Employee] (ID,FullName) values (@ID,@FullName)";
							
							String query = "INSERT INTO [Employee] (FullName,Address) values (@FullName,@Address)";
		                          
		                           PreparedStatement pst =con.prepareStatement(query);
		                           pst.setString(1,txtName.getText());
		                           pst.setString(2,txtAddress.getText());
		                           
		                           
		       					 pst.execute();
		       					JOptionPane.showMessageDialog(null, "Saved");
		       				
							
							
							
						} catch (Exception e) 
					 {
						e.getMessage();
						e.printStackTrace();
							
						}
					
					
					
				}
			});
			btnPt.setBounds(189, 154, 129, 49);
			frame.getContentPane().add(btnPt);
	}
}
