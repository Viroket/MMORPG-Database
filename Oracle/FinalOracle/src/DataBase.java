import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DataBase {

	public static final String USER = "User";
	public static final String SERVER = "server";
	public String queryFind;
	private Connection connection;
	private Statement stmt;
	
	private CallableStatement procstmt;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	private static final String DB_USER2 = "C##APP_USER";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1522:orcld";
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
		public DataBase(String userName , String password) {
			System.out.println("-------- Oracle JDBC Connection Testing ------");

	        try {
	        	
	            Class.forName(DB_DRIVER);

	        } catch (ClassNotFoundException e) {

	            System.out.println("Where is your Oracle JDBC Driver?");
	            e.printStackTrace();
	            return;

	        }

	        System.out.println("Oracle JDBC Driver Registered!");

	        connection = null;

	        try {

	        	if(userName.equals(DB_USER)) {
	        		connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	        	}
	        	else if(userName.equals(DB_USER2)){
	        		connection = DriverManager.getConnection(DB_CONNECTION, DB_USER2, DB_PASSWORD);
	        	}
	            
	            
	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return;

	        }

	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }
	        
		}
		 
		
		
	public ResultSet getServerData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOSERVER";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	public ResultSet getUsersData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOUsers";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	public ResultSet getCharacterData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOCharacter";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}

	public ResultSet getQuestsData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOQuests";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public ResultSet getItemsData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOItems";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	public ResultSet getMonstersData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOMonsters";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	public ResultSet getQuestsStatusData() {
		ResultSet rs = null;
		try {
			String query = "select * from SYSTEM.MMOQuestsStatus";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public ResultSet getOldUserNames() {
		ResultSet rs = null;
		try {
			String query = "select * from MMOUSER_NAMES_HISTORY";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public ResultSet getCursor() {
		ResultSet rs = null;
		try {
			String query = "   CURSOR itm_cur IS \r\n" + 
					"   SELECT * \r\n" + 
					"   FROM MMOITEMS\r\n" + 
					"   WHERE WEIGHT > 99  ";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	
	
	public int getIds(String idRowName , String tableName ,int id) {
		int idNum = 0;
		try {
			String query = "SELECT " +idRowName +" FROM "+ tableName +" WHERE " +idRowName +" = " +id;
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			idNum = stmt.executeUpdate(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return idNum;
	}
	
	
	public ResultSet getNumberOfPlayersInServers() {
		ResultSet rs = null;
		try {
			String query = "SELECT  MMOSERVER.SERVERNAME , COUNT(MMOUSERS.SERVERID) AS NUM_USERS\r\n" + 
						   "FROM MMOSERVER , MMOUSERS\r\n" + 
						   "WHERE MMOSERVER.SERVERID = MMOUSERS.SERVERID\r\n" + 
						   "GROUP BY MMOSERVER.SERVERNAME";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public ResultSet getAVGNumberOfOnlinePlayers() {
		ResultSet rs = null;
		try {
			String query = "SELECT SERVERID,AVG(CURRENTONLINE) AS Average\r\n" + 
					"  FROM MMOSERVER\r\n" + 
					"  GROUP BY SERVERID";
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public void createViews(String name , int hp) {
		String query = "";
		try {
			if(name.equals("VSERVERS_MONSTERS")) {
				 query = "CREATE OR REPLACE VIEW vServers_Monsters( ids, names )\r\n" + 
						"AS\r\n" + 
						"SELECT SERVERID , SERVERNAME \r\n" + 
						"FROM MMOSERVER \r\n" + 
						"UNION\r\n"+
						"SELECT MONSTERID , MONSTERNAME \r\n" + 
						"FROM MMOMONSTERS \r\n";
			}
			else if(name.equals("MMOMONSTERS") && hp != -1) {
				query = "CREATE OR REPLACE VIEW vMmoMonsters\r\n" + 
						"AS\r\n" + 
						"SELECT *\r\n" + 
						"FROM MMOMONSTERS \r\n" + 
						"WHERE HP > " +hp;
			}
			else if(name.equals("MMOMONSTERS")){
				query = "CREATE OR REPLACE VIEW vMmoMonsters\r\n" + 
						"AS\r\n" + 
						"SELECT *\r\n" + 
						"FROM MMOMONSTERS \r\n" + 
						"WHERE HP > 100000";
			}

			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			stmt.executeQuery(query);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public ResultSet getViewTables(String viewName) {
		ResultSet rs = null;
		String query = "";
		try {
			if(viewName.equals("VSERVERS_MONSTERS")) {
				query = "select * from VSERVERS_MONSTERS";
			}
			else {
				query = "select * from vMmoMonsters";
			}
			
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public void updateViews(String viewName , String whatToChange , String whereToLook , int whatToUpdateTo , int id) {
		try {
			String insertSQL = "UPDATE " + viewName +" SET " +whatToChange +" = " +whatToUpdateTo +" WHERE " +whereToLook +" = " +id;
			System.out.println(insertSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	/** insert new data into the database in server using SEQ and NEXTVAL*/
	public void insertIntoServer(String ServerName, int MaxCapacity, int CurrentOnline, int numRegister) {
		try {
			String insertSQL = "insert into MMOSERVER(SERVERID,SERVERNAME,MAXCAPACITY,CURRENTONLINE,NUMREGiSTERED) values (SEQ_SERVER.NEXTVAL, " +"'" +ServerName +"'" +", " + MaxCapacity  + ", "  + CurrentOnline  + ", "  + numRegister + ")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	/** insert new data into the database in users using SEQ and NEXTVAL*/
	public void insertIntoUsers(String userName, String userPassword, String email, int numRegister , int serverId) {
		try {
			String insertSQL = "insert into MMOUSERS values (SEQ_USERS.NEXTVAL, " +"'" +userName +"'" +", " +"'" +userPassword +"'"  + ", "  +"'" +email +"'"  + ", "  + numRegister + "," +serverId + ")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void insertIntoCharecter(String charName, String charClass, String race, int exp , int hp , int mana , int gold , int lvl , int location , int userId) {
		try {
			String insertSQL = "insert into MMOCHARACTER values (SEQ_CHARACTER.NEXTVAL, " +"'" +charName +"'" +", " +"'" +charClass +"'"  + ", "  +"'" +race +"'"  + ", "  + exp + "," +hp + ", " + mana + ", " + gold + ", " + lvl + ", "+location + ", " +userId +")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void insertIntoQuets(String questName, int questLvl, int expEarn , int iteamReward , int objective ) {
		try {
			String insertSQL = "insert into MMOQUESTS values (SEQ_QUESTS.NEXTVAL, " +"'" +questName +"' "+"," +questLvl +"," +expEarn +"," +iteamReward +"," +objective +")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void insertIntoItems(String itemName, int itemValue, int slot, int weight , String itemType ) {
		try {
			String insertSQL = "insert into MMOITEMS values (SEQ_ITEMS.NEXTVAL, " +"'" +itemName +"'" +", "  +itemValue   + ", "   +slot   + ", "  + weight + "," +"'"+itemType +"'" +")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	public void insertIntoMonsters(String monsterName, int hp, int damage, int location  ) {
		try {
			String insertSQL = "insert into MMOMONSTERS values (SEQ_MONSTERS.NEXTVAL, " +"'" +monsterName +"'" +", "  +hp   + ", "   +damage   + ", "  + location +")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void insertIntoQuestStatus(int charectureId, int QuestId, String Status  ) {
		try {
			String insertSQL = "insert into MMOQUESTSSTATUS values (" +charectureId +", "  +QuestId   + ", "   + "'"+ Status+ "'" +")";
			System.out.println(insertSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			stmt.executeUpdate(insertSQL);
			System.out.println("Record is inserted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void deleteRows(String fromWhere, String colName, String val) {
		try {
			String deleteSQL = "DELETE FROM "+fromWhere +" WHERE " +colName +" = " +val;
			System.out.println(deleteSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(deleteSQL);
			
			stmt.executeUpdate(deleteSQL);
			System.out.println("Record is deleted.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void updateName(String tableName, String newName, String id , String colId , String colName) {
		try {
			String updateSQL = "UPDATE "+tableName +" SET "+colName +" = '"  +newName +"'"  +" WHERE " +colId +" = " +id;
			System.out.println(updateSQL);

			// execute insert SQL statement
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(updateSQL);
			
			stmt.executeUpdate(updateSQL);
			System.out.println("Record is updated.");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	public ResultSet findServerOrUser(String serverOrUser,String serverOrUserName , int numberOfRegisted , int serverId) {
		ResultSet rs = null;
		try {
			if(serverOrUser.equals(SERVER)) {
				if(serverOrUserName.isEmpty()) {
					queryFind = "select * from MMOSERVER WHERE NUMREGISTERED <= "+numberOfRegisted;
				}
				else if(numberOfRegisted == -1) {
					queryFind = "select * from MMOSERVER WHERE SERVERNAME LIKE " +"'%"+serverOrUserName+"%'";
				}
				else {
					queryFind = "select * from MMOSERVER WHERE SERVERNAME LIKE " +"'%"+serverOrUserName+"%'" +" AND NUMREGISTERED <= "+numberOfRegisted;
				}
			}
			else {
				if(serverOrUserName.isEmpty()) {
					queryFind = "select * from MMOUSERS WHERE SERVERID = "+serverId;
				}
				else if(serverId == -1) {
					queryFind = "select * from MMOUSERS WHERE USERNAME LIKE " +"'%"+serverOrUserName+"%'";
				}
				else {
					queryFind = "select * from MMOUSERS WHERE USERNAME LIKE " +"'%"+serverOrUserName+"%'" +" AND SERVERID = "+serverId;
				}
			}
			
			System.out.println(queryFind);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(queryFind);
			// execute insert SQL statement
			rs = stmt.executeQuery(queryFind);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public ResultSet sortTable(boolean ascendin , String table , String lable) {
		ResultSet rs = null;
		String query;
		try {
			if(ascendin) {
				query = "select * from "  + table  +" ORDER BY "  +lable  +" ASC" ;
			}else {
				query = "select * from "  + table  +" ORDER BY "  +lable  +" DESC" ;
			}
			
			System.out.println(query);

			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(query);
			// execute insert SQL statement
			rs = stmt.executeQuery(query);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return rs;
	}
	
	public int getMaxNumberOfQuests() {
		int max = -1;
		try {
			String insertSQL = "SELECT QUESTID FROM MMOQUESTS";
			System.out.println(insertSQL);

			// execute insert SQL statement
			
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			max = stmt.executeUpdate(insertSQL);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return max;
	}
	
	public int getMaxNumberOfCharacters() {
		int max = -1;
		try {
			String insertSQL = "SELECT CHARID FROM MMOCHARACTER";
			System.out.println(insertSQL);

			// execute insert SQL statement
			
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			max = stmt.executeUpdate(insertSQL);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return max;
	}
	
	public int getMaxNumberOfServers() {
		int max = -1;
		try {
			String insertSQL = "SELECT SERVERID FROM MMOSERVER";
			System.out.println(insertSQL);

			// execute insert SQL statement
			
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			max = stmt.executeUpdate(insertSQL);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return max;
	}
	public int getMaxNumberOfUsers() {
		int max = -1;
		try {
			String insertSQL = "SELECT USERID FROM MMOUSERS";
			System.out.println(insertSQL);

			// execute insert SQL statement
			
			connection = DriverManager.getConnection(DB_CONNECTION , DB_USER , DB_PASSWORD);
			stmt = connection.prepareStatement(insertSQL);
			
			max = stmt.executeUpdate(insertSQL);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return max;
	}
	
	public void deleteMonsterFromPackge(int itemID) {
		try {
			procstmt = connection.prepareCall("{call monsters_package.delMonster(?)}");
			procstmt.setInt(1, itemID);
			
			// execute PL\SQL call statement
			procstmt.execute ();
			
		} catch (SQLException e) {

			printSQLException(e);

		}
	}
	
	public String getItemFromIdProc(int itemID) {
		String name = null;
		try {
			procstmt = connection.prepareCall("{call GET_ITEM_NAME_PROC (? , ?)}");
			procstmt.setInt(1, itemID);
			procstmt.registerOutParameter(2, java.sql.Types.VARCHAR); //register out parameter
			
			// execute PL\SQL call statement
			procstmt.execute ();
			
			name = (String)procstmt.getObject (2);
			System.out.println(name);  
		} catch (SQLException e) {

			printSQLException(e);

		}catch (Exception ex) {

			ex.printStackTrace();

		}
		
		return name;
	}
	

	public String getSmallerName(String name , int start , int end) {
		String result = "";
		
		try {
			procstmt = connection.prepareCall("{call ?:= smallerName (? , ? , ?)}");
			procstmt.setString(2, name);
			procstmt.setInt(3, start);
			procstmt.setInt(4, end);
			procstmt.registerOutParameter(1, java.sql.Types.VARCHAR); //register out parameter
			
			// execute PL\SQL call statement
			procstmt.execute ();
			
			result = procstmt.getString(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (java.sql.SQLException e) {
			printSQLException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void printSQLException(SQLException ex) {

	    for (Throwable e : ex) {
	        if (e instanceof SQLException) {
	            if (ignoreSQLException(((SQLException)e).getSQLState()) == false) {

	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " +((SQLException)e).getSQLState());

	                System.err.println("Error Code: " +((SQLException)e).getErrorCode());

	                System.err.println("Message: " + e.getMessage());

	                Throwable t = ex.getCause();
	                while(t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}
	
	public static boolean ignoreSQLException(String sqlState) {

	    if (sqlState == null) {
	        System.out.println("The SQL state is not defined!");
	        return false;
	    }

	    // X0Y32: Jar file already exists in schema
	    if (sqlState.equalsIgnoreCase("X0Y32"))
	        return true;

	    // 42Y55: Table already exists in schema
	    if (sqlState.equalsIgnoreCase("42Y55"))
	        return true;

	    return false;
	}
	
	public void strongMonstersLocations() {
		try {
			procstmt = connection.prepareCall("{call strong_monsters_locations ()}");
			
			
			// execute PL\SQL call statement
			
			procstmt.execute ();
			
			
		} catch (SQLException e) {

			printSQLException(e);

		}
	}
	
	
	
	
}