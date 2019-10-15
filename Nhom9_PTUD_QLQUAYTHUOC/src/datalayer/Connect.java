package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Connect {
private static Connection con;
public static Connection getConnect() {
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLQUAYTHUOC;Username=sa;Password = sapassword");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println("Kết nối không thành công\n");
		System.out.println(e);
		}
		
	
	return con;
	
}
public static String testConnect() {
    try{
        con = Connect.getConnect();
        return "Kết nối thành công";
    }
    catch(Exception e) {
        return "Kết nối thất bại";
    }
} 
}
