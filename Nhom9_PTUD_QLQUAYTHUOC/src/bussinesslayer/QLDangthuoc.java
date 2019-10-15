package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datalayer.Connect;
import entitylayer.Dangthuoc;
import entitylayer.Loai;

public class QLDangthuoc {
	private ArrayList<Dangthuoc> dsDangThuoc;
	public QLDangthuoc() {
		dsDangThuoc=new ArrayList<Dangthuoc>();
		try {
			Connection con=Connect.getConnect();
			String sql="Select * from DANGTHUOC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Dangthuoc dang=new Dangthuoc();
				dang.setMaDT(rs.getString(1).trim());
				dang.setTenDT(rs.getString(2).trim());
				dang.setMoTa(rs.getString(3).trim());
				dsDangThuoc.add(dang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean ThemDangThuoc(Dangthuoc x) {
		if(dsDangThuoc.contains(x))
			return false;
		if(dsDangThuoc.add(x)) {
			Connection con = Connect.getConnect();
			PreparedStatement stmt = null;
			int n = 0;
			
			try {
				stmt = con.prepareStatement("insert into DANGTHUOC values (?, ?)");
				
				stmt.setString(1, x.getMaDT());
				stmt.setString(2, x.getTenDT());
				stmt.setString(3, x.getMoTa());
			
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
	public Dangthuoc timDangThuoc(String tenDangThuoc) {
		for (Dangthuoc x : dsDangThuoc)
			if(x.getTenDT().equalsIgnoreCase(tenDangThuoc))
				return x;
		return null;
	}
	public ArrayList<Dangthuoc> getDsDangThuoc() {
		return dsDangThuoc;
	}
}
