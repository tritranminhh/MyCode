package bussinesslayer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datalayer.Connect;
import entitylayer.Loai;

public class QLLoai {
private ArrayList<Loai> dsLoaiThuoc;
public QLLoai() {
	dsLoaiThuoc=new ArrayList<Loai>();
	try {
		Connection con=Connect.getConnect();
		String sql="Select * from LOAI";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			Loai loaiThuoc=new Loai();
			loaiThuoc.setMaLoai(rs.getString(1).trim());
			loaiThuoc.setTenLoai(rs.getString(2).trim());
			dsLoaiThuoc.add(loaiThuoc);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public boolean ThemLoaiThuoc(Loai x) {
	if(dsLoaiThuoc.contains(x))
		return false;
	if(dsLoaiThuoc.add(x)) {
		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		
		try {
			stmt = con.prepareStatement("insert into LOAI values (?, ?)");
			
			stmt.setString(1, x.getMaLoai());
			stmt.setString(2, x.getTenLoai());
		
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
public Loai timLoaiThuoc(String tenLoaiThuoc) {
	for (Loai x : dsLoaiThuoc)
		if(x.getTenLoai().equalsIgnoreCase(tenLoaiThuoc))
			return x;
	return null;
}
public ArrayList<Loai> getDsLoai() {
	return dsLoaiThuoc;
}
}
