package edu.nyu.lishiyi.dao;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import edu.nyu.lishiyi.Item;
import edu.nyu.lishiyi.dao.model.*;

public class Dao {
	
	protected static String dbClassName = "net.sourceforge.jtds.jdbc.Driver";
	
	protected static String dbUrl = "jdbc:jtds:sqlserver://localhost:1433/"
			+ "db_database28;SelectMethod=Cursor";
	
	protected static String dbUser = "sa";
	protected static String dbPwd = "";
	
	public static Connection conn = null;
	
	static{
		
		try{
			if(conn == null){
				
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
		} catch(Exception ee){
			ee.printStackTrace();
		}
	}	
	private Dao() {

	}
	
	//4.
	public static boolean getLogin(String name, String password) throws SQLException{
		

        Statement stmt = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);   
        ResultSet rs = stmt.executeQuery("selcet * from tb_userlist where name ='"
				+ name + "' and pass ='" + password + "'");

		
	//	ResultSet rs = findForResultSet("selcet * from tb_userlist where name ='"
	//			+ name + "' and pass ='" + password + "'");
		return rs.next();
	}
	//7. CheckLogin ·½·¨
	public static boolean checkLogin(String user, String pass) throws SQLException{
		
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);   
        ResultSet rs = stmt.executeQuery("selcet * from tb_userlist where name ='"
				+ user + "' and pass ='" + pass + "'");

		//ResultSet rs = findForResultSet("selcet * from tb_userlist where name ='"
		//		+ user + "' and pass ='" + pass + "'");
		if(rs == null){
			return false;
		}
		return rs.next();
	}

}
