package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import datalayer.Connect;
import entitylayer.Chucnang;
import entitylayer.Dangthuoc;

public class QLChucnang {
	private ArrayList<Chucnang> dsCN;
	public QLChucnang() {
		dsCN=new ArrayList<Chucnang>();
		try {
			Connection con=Connect.getConnect();
			String sql="Select * from CHUCNANG";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Chucnang cn=new Chucnang();
				cn.setMaCN(rs.getString(1).trim());
				cn.setTenCN(rs.getString(2).trim());
				cn.setMota(rs.getString(3).trim());
				dsCN.add(cn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean ThemDangThuoc(Chucnang x) {
		if(dsCN.contains(x))
			return false;
		if(dsCN.add(x)) {
			Connection con = Connect.getConnect();
			PreparedStatement stmt = null;
			int n = 0;
			
			try {
				stmt = con.prepareStatement("insert into CHUCNANG values (?, ?)");
				
				stmt.setString(1, x.getMaCN());
				stmt.setString(2, x.getTenCN());
				stmt.setString(3, x.getMota());
			
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
	public Chucnang timChucNangThuoc(String tenCN) {
		for (Chucnang x : dsCN)
			if(x.getTenCN().equalsIgnoreCase(tenCN))
				return x;
		return null;
	}
	public ArrayList<Chucnang> getDsCN() {
		return dsCN;
	}
}
