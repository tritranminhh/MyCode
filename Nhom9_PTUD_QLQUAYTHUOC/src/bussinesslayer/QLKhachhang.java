package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import datalayer.Connect;
import entitylayer.Khachhang;

public class QLKhachhang {
private GregorianCalendar ngaySinh=new GregorianCalendar();
private ArrayList<Khachhang> dskh;
public QLKhachhang() {
	// TODO Auto-generated constructor stub
	dskh = new ArrayList<Khachhang>();
	try {
		Connection con = Connect.getConnect();
		
		String sql = "Select * from KHACHHANG";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Khachhang kh = new Khachhang();
			kh.setMaKH(rs.getString(1).trim());
			kh.setTenKH(rs.getString(2).trim());
			kh.setGtinh(rs.getString(3).trim());
			ngaySinh.setTime(rs.getDate(4));
			kh.setNgaySinh(ngaySinh);
			kh.setDiaChi(rs.getString(5).trim());
			kh.setEmail(rs.getString(6).trim());
			kh.setSDT(rs.getString(7).trim());
			dskh.add(kh);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public boolean ThemKH(Khachhang kh) {
	if(dskh.contains(kh))
		return false;
	if(dskh.add(kh)) {
		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		
		String code;
		do {
			code = getAlphaString(15);
		}while(TimKH(code) != null); //kiem tra trung ma
		kh.setMaKH(code);
		
		try {
			stmt = con.prepareStatement("insert into KHACHHANG values (?, ?, ?, ?, ?)");
			
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getGtinh());
			Date udate=kh.getNgaySinh().getTime();
			java.sql.Date sdate=new java.sql.Date(udate.getTime());
			stmt.setObject(4,sdate);;
			stmt.setString(5, kh.getDiaChi());
			stmt.setString(6, kh.getEmail());
			stmt.setString(7, kh.getSDT());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	return false;
}
public Khachhang TimKH(String maKH) {
	for (Khachhang kh : dskh)
		if(kh.getMaKH().equals(maKH))
			return kh;
	return null;
}
public String getAlphaString(int n) 
{ 

	// chose a Character random from this String 
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "0123456789" +
			"abcdefghijklmnopqrstuvwxyz"; 

	// create StringBuffer size of AlphaNumericString 
	StringBuilder sb = new StringBuilder(n); 

	for (int i = 0; i < n; i++) { 

		// generate a random number between 
		// 0 to AlphaNumericString variable length 
		int index 
		= (int)(AlphaNumericString.length() 
				* Math.random()); 

		// add Character one by one in end of sb 
		sb.append(AlphaNumericString 
				.charAt(index)); 
	} 

	return sb.toString(); 
}
}
