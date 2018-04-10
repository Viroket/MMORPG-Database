import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Views extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTable table;
	public ResultSet set;
	public TableColumn width;
	public DefaultTableModel model;
	private JTextField tfHp;
	private JTextField updateHp;
	private JTextField tfId;
	
	public Views() {
		this.setVisible(true);
		this.setBounds(200, 100 ,600, 400 );
		getContentPane().setLayout(null);
		
		updateHp = new JTextField();
		updateHp.setColumns(10);
		updateHp.setBounds(351, 60, 109, 20);
		getContentPane().add(updateHp);
		
		JLabel woungInput = new JLabel("");
		woungInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		woungInput.setBounds(469, 11, 105, 38);
		getContentPane().add(woungInput);
		
		tfId = new JTextField();
		tfId.setBounds(490, 60, 27, 20);
		getContentPane().add(tfId);
		tfId.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 564, 254);
		getContentPane().add(panel);
		
		JLabel done = new JLabel("");
		done.setBounds(109, 28, 46, 14);
		getContentPane().add(done);
		
		JLabel done2 = new JLabel("");
		done2.setBounds(396, 11, 46, 14);
		getContentPane().add(done2);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(20);
		
		panel.add(table);
		
		JLabel lblCreateViews = new JLabel("Server + Monsters");
		lblCreateViews.setBounds(10, 11, 118, 14);
		getContentPane().add(lblCreateViews);
		
		JButton btnSalariesAreAbove = new JButton("Show new server monster view");
		btnSalariesAreAbove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set = db.getViewTables("VSERVERS_MONSTERS");
					setNewModelAndGetTable();
				}catch (Exception ex) {
					woungInput.setText("Failed");
				}
				
			}
		});
		btnSalariesAreAbove.setBounds(10, 59, 214, 23);
		getContentPane().add(btnSalariesAreAbove);
		
		JLabel lblMonsters = new JLabel("Monsters");
		lblMonsters.setBounds(234, 11, 54, 14);
		getContentPane().add(lblMonsters);
		
		JButton btnNewButton = new JButton("Monster Hp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set = db.getViewTables("vMmoMonsters");
					setNewModelAndGetTable();
				}catch (Exception ex) {
					woungInput.setText("Failed");
				}
			}
		});
		btnNewButton.setBounds(234, 28, 109, 23);
		getContentPane().add(btnNewButton);
		
		tfHp = new JTextField();
		tfHp.setBounds(350, 29, 109, 20);
		getContentPane().add(tfHp);
		tfHp.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.createViews("VSERVERS_MONSTERS" , -1);
					done.setText("Done");
				}catch (Exception ex) {
					woungInput.setText("Failed");
				}
				
			}
		});
		btnCreate.setBounds(10, 26, 89, 23);
		getContentPane().add(btnCreate);
		
		JButton button = new JButton("Create");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfHp.getText().isEmpty()) {
					db.createViews("MMOMONSTERS" , -1);
				}
				else {
					db.createViews("MMOMONSTERS" , Integer.parseInt(tfHp.getText()));
				}
				done2.setText("Done");
			}
		});
		button.setBounds(298, 2, 89, 23);
		getContentPane().add(button);
		
		JButton btnUpdateHp = new JButton("Update Hp");
		btnUpdateHp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(updateHp.getText().isEmpty()) {
						woungInput.setText("Enter hp number");
					}
					else if(tfId.getText().isEmpty()) {
						woungInput.setText("Enter id number");
					}
					else {
						db.updateViews("vMmoMonsters" , "HP" , "MONSTERID" , Integer.parseInt(updateHp.getText()) ,Integer.parseInt(tfId.getText()));
						woungInput.setText("Updated");
						set = db.getViewTables("vMmoMonsters");
						setNewModelAndGetTable();
					}
				}catch (Exception ex) {
					woungInput.setText("Failed");
				}
			}
		});
		btnUpdateHp.setBounds(234, 62, 109, 23);
		getContentPane().add(btnUpdateHp);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(470, 63, 22, 14);
		getContentPane().add(lblId);
		
	
		
	
		
		
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
