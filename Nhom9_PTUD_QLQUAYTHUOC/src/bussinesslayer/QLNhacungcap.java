package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import datalayer.Connect;
import entitylayer.Nhacungcap;

public class QLNhacungcap {
private ArrayList<Nhacungcap> dsNhaCC;


public QLNhacungcap() {
	dsNhaCC = new ArrayList<Nhacungcap>();
	try {
		Connection con = Connect.getConnect();
		
		String sql = "Select * from NHACUNGCAP";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Nhacungcap ncc = new Nhacungcap();
			ncc.setMaNCC(rs.getString(1).trim());
			ncc.setTenNCC(rs.getString(2).trim());
			ncc.setSdt(rs.getString(3).trim());
			ncc.setEmail(rs.getString(4).trim());
			dsNhaCC.add(ncc);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//tìm theo mã
public Nhacungcap TimNCC(String maNCC){
	for (Nhacungcap x : dsNhaCC)
		if (x.getMaNCC().equals(maNCC))
			return x;
	return null;
}
//tìm theo tên
public Nhacungcap TimNCCTheoTen(String nameNCC) {
	// TODO Auto-generated method stub
	for (Nhacungcap x : dsNhaCC) {
		if (x.getTenNCC().equalsIgnoreCase(nameNCC))
			return x;
	}
		
	return null;
}
//thêm 1 nhà Cung cap
public boolean addNCC(Nhacungcap x) {
	if(dsNhaCC.contains(x))
		return false;
	if(dsNhaCC.add(x)) {
		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NHACUNGCAP values (?, ?, ?, ?)");
			
			stmt.setString(1, x.getMaNCC());
			stmt.setString(2, x.getTenNCC());
			stmt.setString(3, x.getSdt());
			stmt.setString(4, x.getEmail());
			
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0; 
	}
	else return false;
}
//xóa nha cung cap
public boolean xoaNCC(String maNCC) {
	Nhacungcap x = TimNCC(maNCC);
	if(x == null)
		return false;

	Connection con = Connect.getConnect();
	PreparedStatement stmt = null;
	int n = 0;
	try {
		stmt = con.prepareStatement("DELETE FROM NHACUNGCAP WHERE MANCC = ?");

		stmt.setString(1, x.getMaNCC());
		
		n = stmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(n > 0) {
		dsNhaCC.remove(x);
		return true;
	}
	else return false;
}
//sửa thông tin nhà cung cấp
public boolean suaNCC(Nhacungcap x) {
	if(!dsNhaCC.contains(x))
		return false;

	dsNhaCC.set(dsNhaCC.indexOf(x), x);
	
	Connection con = Connect.getConnect();
	PreparedStatement stmt = null;
	int n = 0;
	try {
		stmt = con.prepareStatement("update NHACUNGCAP set TENNCC=?, PHONE=?, EMAIL=? where MANCC=?");
		
		stmt.setString(1, x.getTenNCC());
		stmt.setString(2, x.getSdt());
		stmt.setString(3, x.getEmail());
		stmt.setString(5, x.getMaNCC());
		
		n = stmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return n > 0; 
}
//get DSNCC
public ArrayList<Nhacungcap> getDSNCC(){
	soter();
	return dsNhaCC;
}
public void soter() {
	Collections.sort(dsNhaCC);
}
}
