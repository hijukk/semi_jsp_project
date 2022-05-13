package test.com.model;

public interface TravelDB {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	String USER_ID = "HJ";
	String PASSWORD = "hi123456";

	String SQL_INSERT = "insert into travel (ATTRACTION, LOCATION, CONTENT, TDATE, SAVE_FILE_NAME ) VALUES (?, ?, ?, ?, ?)";
	String SQL_UPDATE = "update travel set location=?, content=?, tdate=?, save_file_name=? where attraction = ?";
	String SQL_DELETE = "delete from travel where attraction=?";

	String SQL_SELECT_ALL = "select * from travel order by tdate asc";
	String SQL_SEARCH_LIST = "select * from travel where tdate like ? order by attraction asc";
	String SQL_SELECT_ONE = "select * from travel where attraction = ?";

	String SQL_MY_SELECT_ALL = "select * from mytravel where id = ? order by save_date desc";
	String SQL_MY_SELECT_ALL_ADMIN = "select * from mytravel order by save_date desc";
	String SQL_MY_INSERT = "insert into MYTRAVEL (ATTRACTION,ID) VALUES (?,?)";
	String SQL_MY_DELETE = "delete from mytravel where attraction=? and id=?";
	
	String SQL_JLOGIN = "SELECT * FROM join WHERE ID = ? and PW = ?";
}
