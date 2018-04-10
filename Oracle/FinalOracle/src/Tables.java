import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tables extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	public ResultSet set;
	public String whereToDelete , colToDelete , colName;
	public DefaultTableModel model;
	public TableColumn width;
	private JTable table;
	
	
	
	public Tables() {
		getContentPane().setLayout(null);
		ButtonGroup bG = new ButtonGroup();
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(135, 11, 616, 14);
		getContentPane().add(lblWronginput);
		
		JRadioButton rdbtServer = new JRadioButton("Server");
		rdbtServer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				colToDelete = "SERVERID";
				colName = "SERVERNAME";
				whereToDelete = "MMOSERVER";
				set = db.getServerData();
				setNewModelAndGetTable();
				
			}
		});
		
		JRadioButton rdbtnOldUserNames = new JRadioButton("Old user names");
		rdbtnOldUserNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				set = db.getOldUserNames();
				setNewModelAndGetTable();
			}
		});
		rdbtnOldUserNames.setBounds(20, 214, 126, 23);
		getContentPane().add(rdbtnOldUserNames);
		
		rdbtServer.setBounds(20, 32, 109, 23);
		getContentPane().add(rdbtServer);
		
		JRadioButton rdbtnUsers = new JRadioButton("Users");
		rdbtnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colName = "USERNAME";
				colToDelete = "USERID";
				whereToDelete = "MMOUSERS";
				set = db.getUsersData();
				setNewModelAndGetTable();
			}
		});
		rdbtnUsers.setBounds(20, 58, 109, 23);
		getContentPane().add(rdbtnUsers);
		
		JRadioButton rdbtnCharacters = new JRadioButton("Characters");
		rdbtnCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colName = "NICKNAME";
				colToDelete = "CHARID";
				whereToDelete = "MMOCHARACTER";
				set = db.getCharacterData();
				setNewModelAndGetTable();
			}
		});
		rdbtnCharacters.setBounds(20, 84, 109, 23);
		getContentPane().add(rdbtnCharacters);
		
		JRadioButton rdbtnItems = new JRadioButton("Items");
		rdbtnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colName = "ITEMNAME";
				colToDelete = "ITEMID";
				whereToDelete = "MMOITEMS";
				set = db.getItemsData();
				setNewModelAndGetTable();
			}
		});
		rdbtnItems.setBounds(20, 110, 109, 23);
		getContentPane().add(rdbtnItems);
		
		JRadioButton rdbtnQuests = new JRadioButton("Quests");
		rdbtnQuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colName = "QUESTNAME";
				colToDelete = "QUESTID";
				whereToDelete = "MMOQUESTS";
				set = db.getQuestsData();
				setNewModelAndGetTable();
			}
		});
		rdbtnQuests.setBounds(20, 136, 109, 23);
		getContentPane().add(rdbtnQuests);
		
		JRadioButton rdbtnMonsters = new JRadioButton("Monsters");
		rdbtnMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colName = "MONSTERNAME";
				colToDelete = "MONSTERID";
				whereToDelete = "MMOMONSTERS";
				set = db.getMonstersData();
				setNewModelAndGetTable();
			}
		});
		rdbtnMonsters.setBounds(20, 162, 109, 23);
		getContentPane().add(rdbtnMonsters);
		
		JRadioButton rdbtnQuestStatus = new JRadioButton("Quest Status");
		rdbtnQuestStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colToDelete = "CHARID";
				whereToDelete = "MMOQUESTSTATUS";
				set = db.getQuestsStatusData();
				setNewModelAndGetTable();
			}
		});
		rdbtnQuestStatus.setBounds(20, 188, 109, 23);
		getContentPane().add(rdbtnQuestStatus);
		
		bG.add(rdbtServer);
		bG.add(rdbtnUsers);
		bG.add(rdbtnCharacters);
		bG.add(rdbtnItems);
		bG.add(rdbtnQuests);
		bG.add(rdbtnMonsters);
		bG.add(rdbtnQuestStatus);
		bG.add(rdbtnOldUserNames);
		
		JPanel panel = new JPanel();
		panel.setBounds(121, 32, 1231, 467);
		getContentPane().add(panel);
		

		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(20);
		
		panel.add(table);
		
		JButton btnServer = new JButton("Server");
		btnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Server();
			}
		});
		btnServer.setBounds(10, 270, 109, 23);
		getContentPane().add(btnServer);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Users();
			}
		});
		btnUser.setBounds(10, 304, 109, 23);
		getContentPane().add(btnUser);
		
		JButton btnCharacters = new JButton("Characters");
		btnCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Character();
			}
		});
		btnCharacters.setBounds(10, 338, 109, 23);
		getContentPane().add(btnCharacters);
		
		JButton btnItems = new JButton("Items");
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Items();
			}
		});
		btnItems.setBounds(10, 372, 109, 23);
		getContentPane().add(btnItems);
		
		JButton btnQuests = new JButton("Quests");
		btnQuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quests();
			}
		});
		btnQuests.setBounds(10, 406, 109, 23);
		getContentPane().add(btnQuests);
		
		JButton btnMonst = new JButton("Monsters");
		btnMonst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Monsters();
			}
		});
		btnMonst.setBounds(10, 440, 109, 23);
		getContentPane().add(btnMonst);
		
		JButton btnQuestStatus = new JButton("Quest Status");
		btnQuestStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuestStatus();
			}
		});
		btnQuestStatus.setBounds(10, 474, 109, 23);
		getContentPane().add(btnQuestStatus);
		
		JLabel lblInsert = new JLabel("Insert");
		lblInsert.setFont(new Font("David", Font.BOLD, 14));
		lblInsert.setBounds(37, 238, 51, 33);
		getContentPane().add(lblInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = (table.getModel().getValueAt(row, 0).toString()); //6
					if(whereToDelete.equals("MMOSERVER")) {
						
					}
					db.deleteRows(whereToDelete, colToDelete, value);
					System.out.println("Item deeted from database");
					set = db.getServerData();
					setNewModelAndGetTable();
					bG.clearSelection();
					lblWronginput.setText("Deleted");
				}catch (Exception ex) {
					lblWronginput.setText("Woung selection");
				}
				
			}
		});
		btnDelete.setBounds(10, 609, 89, 23);
		getContentPane().add(btnDelete);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Find();
				
			}
		});
		btnFind.setBounds(121, 609, 89, 23);
		getContentPane().add(btnFind);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AscendingDescendingSort();
			}
		});
		btnSort.setBounds(242, 609, 89, 23);
		getContentPane().add(btnSort);
		
		JButton btnNumberOfPlayers = new JButton("Number Of Players In Servers");
		btnNumberOfPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					set = db.getNumberOfPlayersInServers();
					setNewModelAndGetTable();
				} catch (Exception e) {
					lblWronginput.setText("Somthing went wrong");
				}
				
				
			}
		});
		btnNumberOfPlayers.setBounds(10, 568, 221, 23);
		getContentPane().add(btnNumberOfPlayers);
		
		JButton btnAvgOnlinePlayers = new JButton("AVG Online Players");
		btnAvgOnlinePlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					set = db.getAVGNumberOfOnlinePlayers();
					setNewModelAndGetTable();
				} catch (Exception ex) {
					lblWronginput.setText("Somthing went wrong");
				}
				
			}
		});
		btnAvgOnlinePlayers.setBounds(242, 568, 153, 23);
		getContentPane().add(btnAvgOnlinePlayers);
		
		JButton btnViews = new JButton("Views");
		btnViews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Views();
			}
		});
		btnViews.setBounds(365, 609, 89, 23);
		getContentPane().add(btnViews);
		
		JButton btnSmallerNames = new JButton("Smaller users name");
		btnSmallerNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = table.getSelectedRow();
					String value = (table.getModel().getValueAt(row, 1).toString());
					String value2 = (table.getModel().getValueAt(row, 0).toString());
					String newName = db.getSmallerName(value , 1 , 5);
					db.updateName(whereToDelete, newName, value2 , colToDelete , colName);
					set = db.getServerData();
					setNewModelAndGetTable();
					bG.clearSelection();
				}catch (ArrayIndexOutOfBoundsException e) {
					lblWronginput.setText("Wrong selection");				
				} catch (Exception e) {
					
				}
				
				
				
				
			}
		});
		btnSmallerNames.setBounds(405, 568, 159, 23);
		getContentPane().add(btnSmallerNames);
		
		JButton btnGet = new JButton("executeCursor");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					db.strongMonstersLocations();
				} catch (Exception e) {
					lblWronginput.setText("somthing went wrong");
				}
				
			}
		});
		btnGet.setBounds(574, 568, 136, 23);
		getContentPane().add(btnGet);
		
		JButton btnDeleteMonsterFrom = new JButton("Delete monster from packeg");
		btnDeleteMonsterFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = (table.getModel().getValueAt(row, 0).toString()); //6
					int id = Integer.parseInt(value);
					db.deleteMonsterFromPackge(id);
					lblWronginput.setText("Deleted");
				} catch (Exception ex) {
					lblWronginput.setText("Wrong selection");
				}
				
				
			}
		});
		btnDeleteMonsterFrom.setBounds(478, 609, 232, 23);
		getContentPane().add(btnDeleteMonsterFrom);
		
		
			
		//table.setModel(Db);
		this.setBounds(200, 200 ,1400, 700 );
	}
	
	public void setNewModelAndGetTable() {
		model.setRowCount(0);
		model.setColumnCount(0);
		getTable(model);
	}
	
	
	//this function will bring us the current table that we want to use 
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
