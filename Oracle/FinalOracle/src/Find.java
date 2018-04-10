import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Find extends JFrame {
	
	public static final String USER = "User";
	public static final String SERVER = "server";
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER, DB_PASSWORD);
	public ResultSet set;
	public TableColumn width;
	public DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	private JTextField jfServerName;
	private JTextField jfServerRegist;
	private JButton btnFindServer;
	private JLabel lblUserName;
	private JTextField jfUserName;
	private JLabel lblServerId;
	private JTextField jfServerId;
	private JButton btnFindUser;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnFindItem;
	private JLabel lblWronginput;
	
	public Find() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,700, 500 );
		JLabel lblServerName = new JLabel("Server Name");
		lblServerName.setBounds(20, 31, 80, 14);
		getContentPane().add(lblServerName);
		
		lblWronginput = new JLabel("");
		lblWronginput.setBounds(535, 90, 139, 14);
		getContentPane().add(lblWronginput);
		
		jfServerName = new JTextField();
		jfServerName.setBounds(110, 28, 86, 20);
		getContentPane().add(jfServerName);
		jfServerName.setColumns(10);
		
		JLabel lblServer = new JLabel("Server Registered");
		lblServer.setBounds(206, 45, 109, 14);
		getContentPane().add(lblServer);
		
		jfServerRegist = new JTextField();
		jfServerRegist.setBounds(327, 28, 86, 20);
		getContentPane().add(jfServerRegist);
		jfServerRegist.setColumns(10);
		
		jfUserName = new JTextField();
		jfUserName.setColumns(10);
		jfUserName.setBounds(110, 87, 86, 20);
		getContentPane().add(jfUserName);
		
		btnFindServer = new JButton("Find Server");
		btnFindServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//set = db.getServerData();
					if(jfServerRegist.getText().isEmpty()) {
						set = db.findServerOrUser(SERVER , jfServerName.getText() , -1 , -1);
					}else {
						set = db.findServerOrUser(SERVER , jfServerName.getText() , Integer.parseInt(jfServerRegist.getText()) , -1);
					}
					setNewModelAndGetTable();
				} catch (Exception e) {
					lblWronginput.setText("Somthing went wrong");
				}
				
				
			}
		});
		btnFindServer.setBounds(423, 27, 102, 23);
		getContentPane().add(btnFindServer);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(20, 90, 80, 14);
		getContentPane().add(lblUserName);
		
		
		
		lblServerId = new JLabel("Server Id");
		lblServerId.setBounds(206, 90, 102, 14);
		getContentPane().add(lblServerId);
		
		jfServerId = new JTextField();
		jfServerId.setColumns(10);
		jfServerId.setBounds(327, 87, 86, 20);
		getContentPane().add(jfServerId);
		
		btnFindUser = new JButton("Find User");
		btnFindUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jfServerId.getText().isEmpty()) {
						set = db.findServerOrUser(USER , jfUserName.getText() , -1 , -1);
					}else {
						set = db.findServerOrUser(USER , jfUserName.getText() , -1 ,  Integer.parseInt(jfServerId.getText()));
					}
					setNewModelAndGetTable();
				}catch (Exception ex) {
					lblWronginput.setText("Somthing went wrong");
				}
				
				
			}
		});
		btnFindUser.setBounds(423, 86, 102, 23);
		getContentPane().add(btnFindUser);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 130, 654, 308);
		getContentPane().add(panel);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(20);
		
		panel.add(table);
		
		lblNewLabel = new JLabel("Minimum number of");
		lblNewLabel.setBounds(206, 31, 120, 14);
		getContentPane().add(lblNewLabel);
		
		btnFindItem = new JButton("Find item name");
		btnFindItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Procedure();
				
			}
		});
		btnFindItem.setBounds(535, 27, 139, 23);
		getContentPane().add(btnFindItem);
		
		
	}
	
	public void setNewModelAndGetTable() {
		model.setRowCount(0);
		model.setColumnCount(0);
		getTable(model);
	}
	
	public void getTable(DefaultTableModel model) {
		try {
			
			String[] mainRow = new String[set.getMetaData().getColumnCount()];
			for(int i = 1 ; i < set.getMetaData().getColumnCount()+1 ; i++) {
				model.addColumn(set.getMetaData().getColumnName(i));
				
				mainRow[i-1] = set.getMetaData().getColumnLabel(i).toLowerCase();
				
			}
			model.addRow(mainRow);
			while(set.next()) {
				String[] row = new String[set.getMetaData().getColumnCount()];
				
				for(int i = 1 ; i < set.getMetaData().getColumnCount()+1 ; i++) {
					row[i-1] = set.getString(i);
					//System.out.println(row[i]);
					width = table.getColumnModel().getColumn(i-1); //make the colom larger in size
					width.setPreferredWidth(110);//make it larger
				}
				
				model.addRow(row);
				
				//table.add
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
