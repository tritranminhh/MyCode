package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import datalayer.Connect;
import entitylayer.Nhanvien;

public class QLNhanvien {
private ArrayList<Nhanvien> dsNV;
private GregorianCalendar ngaySinh;
public QLNhanvien() {
	// TODO Auto-generated constructor stub
	dsNV = new ArrayList<Nhanvien>();
	try {
		Connection con = Connect.getConnect();
		
		String sql = "Select * from NHANVIEN";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Nhanvien nv = new Nhanvien();
			nv.setMaNV(rs.getString(1).trim());
			nv.setTenNV(rs.getString(2).trim());
			nv.setGtinh(rs.getString(3).trim());
			ngaySinh.setTime(rs.getDate(4));
			nv.setNgaySinh(ngaySinh);
			nv.setDiaChi(rs.getString(5).trim());
			nv.setEmail(rs.getString(6).trim());
			nv.setSdt(rs.getString(7).trim());
			nv.setAdmin(rs.getBoolean(8));
			nv.setPassword(rs.getString(9));
			dsNV.add(nv);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public boolean addAcc(Nhanvien x) {
	if (dsNV.contains(x))
		return false;
	if(dsNV.add(x)) {
		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NHANVIEN values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			stmt.setString(1, x.getTenNV());
			stmt.setString(2, x.getGtinh());
			Date udate=x.getNgaySinh().getTime();
			java.sql.Date sdate=new java.sql.Date(udate.getTime());
			stmt.setObject(3, sdate);
			stmt.setString(4, x.getDiaChi());
			stmt.setString(5, x.getEmail());
			stmt.setString(6, x.getSdt());
			stmt.setBoolean(7, x.isAdmin());
			stmt.setString(8, x.getPassword());
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
	}else return false;
}

public Nhanvien TimNV(String maNV){
	for (Nhanvien x : dsNV)
		if (x.getMaNV().equalsIgnoreCase(maNV))
			return x;
	return null;
}

public boolean XoaAcc(String maNV) {
	Nhanvien x = TimNV(maNV);
	if (x == null)
		return false;
	if(dsNV.remove(x)) {
		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM NHANVIEN WHERE MANV = ?");

			stmt.setString(1, x.getMaNV());

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
	return false;
}

public boolean suaNV(Nhanvien x) {
	if(!dsNV.contains(x))
		return false;

	dsNV.set(dsNV.indexOf(x), x);
	
	Connection con = Connect.getConnect();
	PreparedStatement stmt = null;
	int n = 0;
	try {
		stmt = con.prepareStatement("update NHANVIEN set TEN=?, GIOITINH=?, NGAYSINH=?, DIACHI=?, EMAIL=?, SDT=?, ISADMIN=?, PASSWORD=? where MANV=?");
		
		
		stmt.setString(1, x.getGtinh());
		Date udate=x.getNgaySinh().getTime();
		java.sql.Date sdate=new java.sql.Date(udate.getTime());
		stmt.setObject(2, sdate);
		stmt.setString(3, x.getDiaChi());
		stmt.setString(4, x.getEmail());
		stmt.setString(5, x.getSdt());
		stmt.setBoolean(6, x.isAdmin());
		stmt.setString(7, x.getPassword());
		stmt.setString(8, x.getTenNV());
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

public Nhanvien login(String maNV, String password) {
	for (Nhanvien x : dsNV) {
		if (x.getMaNV().equalsIgnoreCase(maNV) && x.getPassword().equals(password)) {
			return x;
		}
	}
	return null; //Không có tài khoản
}

public void sorter() {
	Collections.shuffle(dsNV);
}
public ArrayList<Nhanvien> getListAcc(){
	return dsNV;
}
}
