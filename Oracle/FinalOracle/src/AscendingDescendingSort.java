import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;

public class AscendingDescendingSort extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public String lableName , tableName;
	public String[] mainRow;
	public String[] allTableNames = {"MMOSERVER" , "MMOUSERS" ,"MMOCHARACTER" , "MMOITEMS" , "MMOQUESTS" , "MMOMONSTERS" , "MMOQUESTSSTATUS" };
	public DataBase db = new DataBase(DB_USER ,DB_PASSWORD);
	public DefaultTableModel model;
	public ButtonGroup bG2 = new ButtonGroup();
	public ResultSet set;
	public TableColumn width;
	public JRadioButton [] radio = new JRadioButton[11];
	public int [] radioLocations = {152 , 7 , 109 , 23 ,291 , 7 , 109 , 23 ,426 , 7, 109 ,23 , 577 , 7,
									109 , 23 ,712 , 7 , 109 , 23 ,837 , 7 ,109 ,23 , 963 , 7 , 109 , 23,
									1089 , 7 , 109 , 23 , 152 , 33, 109 , 23 ,291 , 33 ,109 , 23 ,426 , 33 , 109 , 23}; 
	private JTable table;
	public AscendingDescendingSort() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,1300, 700 );
		
		ButtonGroup bG = new ButtonGroup();
		
		for(int i = 0 ; i < 11 ; i++) {
			radio[i] = new JRadioButton();
			bG2.add(radio[i]);
		}
		
		
		JRadioButton rdbtServer = new JRadioButton("Server");
		rdbtServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getServerData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(5 , lables);
				setRadioButtomVisable(5);
				setNewModelAndGetFullTable();
				tableName = allTableNames[0];
				
			}
		});
		rdbtServer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtServer.setBounds(20, 7, 109, 23);
		getContentPane().add(rdbtServer);
		
		JRadioButton rdbtnUsers = new JRadioButton("Users");
		rdbtnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getUsersData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(6 , lables);
				setRadioButtomVisable(6);
				setNewModelAndGetFullTable();
				tableName = allTableNames[1];
			}
		});
		rdbtnUsers.setBounds(20, 33, 109, 23);
		getContentPane().add(rdbtnUsers);
		
		JRadioButton rdbtnCharacters = new JRadioButton("Characters");
		rdbtnCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getCharacterData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(11 , lables);
				setRadioButtomVisable(11);
				setNewModelAndGetFullTable();
				tableName = allTableNames[2];
			}
		});
		rdbtnCharacters.setBounds(20, 59, 109, 23);
		getContentPane().add(rdbtnCharacters);
		
		JRadioButton rdbtnItems = new JRadioButton("Items");
		rdbtnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getItemsData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(6 , lables);
				setRadioButtomVisable(6);
				setNewModelAndGetFullTable();
				tableName = allTableNames[3];
			}
		});
		rdbtnItems.setBounds(20, 85, 109, 23);
		getContentPane().add(rdbtnItems);
		
		JRadioButton rdbtnQuests = new JRadioButton("Quests");
		rdbtnQuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getQuestsData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(6 , lables);
				setRadioButtomVisable(6);
				setNewModelAndGetFullTable();
				tableName = allTableNames[4];
			}
		});
		rdbtnQuests.setBounds(20, 111, 109, 23);
		getContentPane().add(rdbtnQuests);
		
		JRadioButton rdbtnMonsters = new JRadioButton("Monsters");
		rdbtnMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getMonstersData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(5 , lables);
				setRadioButtomVisable(5);
				setNewModelAndGetFullTable();
				tableName = allTableNames[5];
			}
		});
		rdbtnMonsters.setBounds(20, 137, 109, 23);
		getContentPane().add(rdbtnMonsters);
		
		JRadioButton rdbtnQuestStatus = new JRadioButton("Quest Status");
		rdbtnQuestStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getQuestsStatusData();
				String[] lables = setNewModelAndGetTable();
				creatingRadioButtons(3 , lables);
				setRadioButtomVisable(3);
				setNewModelAndGetFullTable();
				tableName = allTableNames[6];
			}
		});
		rdbtnQuestStatus.setBounds(20, 163, 109, 23);
		getContentPane().add(rdbtnQuestStatus);
		
		bG.add(rdbtServer);
		bG.add(rdbtnUsers);
		bG.add(rdbtnCharacters);
		bG.add(rdbtnItems);
		bG.add(rdbtnQuests);
		bG.add(rdbtnMonsters);
		bG.add(rdbtnQuestStatus);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(20);
		
		JPanel panel = new JPanel();
		panel.setBounds(152, 59, 1122, 591);
		getContentPane().add(panel);
		
		
		
		panel.add(table);
		
		JButton btnAscending = new JButton("Ascending");
		btnAscending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					radioButtonSelected();
					set = db.sortTable(true , tableName , lableName);
					setNewModelAndGetFullTable();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
			}
		});
		btnAscending.setBounds(20, 312, 109, 23);
		getContentPane().add(btnAscending);
		
		JButton btnDescending = new JButton("Descending");
		btnDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					radioButtonSelected();
					set = db.sortTable(false , tableName , lableName);
					setNewModelAndGetFullTable();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
			}
		});
		btnDescending.setBounds(20, 346, 109, 23);
		getContentPane().add(btnDescending);
	}
	
	public String[] getTableLables(DefaultTableModel model) {
		try {
			mainRow = new String[set.getMetaData().getColumnCount()];
			for(int i = 1 ; i < set.getMetaData().getColumnCount()+1 ; i++) {
				mainRow[i-1] = set.getMetaData().getColumnLabel(i).toLowerCase();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainRow;
	
	}
	
	public void creatingRadioButtons(int length , String[] lables) {
		int k = 0;
		for(int i = 0 ; i < length ; i++) {
			radio[i].setText(lables[i]);
			radio[i].setBounds(radioLocations[k] , radioLocations[k+1] , radioLocations[k+2] , radioLocations[k+3]);
			k +=4;
			getContentPane().add(radio[i]);
		}
		
	}
	public void radioButtonSelected() {
		for(int i = 0 ; i < 11 ; i++) {
			if(radio[i].isSelected()) {
				lableName = radio[i].getText();
			}
		}
	}

	public void setRadioButtomVisable(int start) {
		for(int i = start ; i < 11 ; i++) {
			radio[i].setVisible(false);
		}
		for(int j = 0 ; j < start ; j++) {
			radio[j].setVisible(true);
		}
	}
	public String[] setNewModelAndGetTable() {
		model.setRowCount(0);
		model.setColumnCount(0);
	return getTableLables(model);
	}
	
	public void setNewModelAndGetFullTable() {
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
