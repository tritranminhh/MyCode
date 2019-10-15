package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import datalayer.Connect;
import entitylayer.Hoadon;
import entitylayer.Thuoc;

public class QLHoaDon {
private ArrayList<Hoadon> dsHD;
private QLThuoc qlThuoc=new QLThuoc();
private QLKhachhang qlKH=new QLKhachhang();
private QLNhanvien qlNV=new QLNhanvien();
private GregorianCalendar ngayLapHD=new GregorianCalendar();
public QLHoaDon() {
	// TODO Auto-generated constructor stub
	dsHD = new ArrayList<Hoadon>();
	try {
		Connection con = Connect.getConnect();
		
		String sql = "select * from [dbo].[CHITIETHOADON] ct join [dbo].[HOADON] hd on ct.MAHD = hd.MAHD";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		String oldcode = null;
		
		ArrayList<Thuoc> dsThuoc = null;
		ArrayList<Integer> sl = null;
		Hoadon hd = null;

		
		while (rs.next()) {
			if(dsHD.isEmpty() || !oldcode.equals(rs.getString(1).trim())) {
				hd = new Hoadon();
				hd.setMaHD(rs.getString(1).trim());
				hd.setKhachhang(qlKH.TimKH(rs.getString(5).trim()));
				hd.setNhanVien(qlNV.TimNV(rs.getString(6).trim()));
				
				ngayLapHD.setTime(rs.getDate(7));
				hd.setNgayLapHD(ngayLapHD);
				
				oldcode = rs.getString(1).trim();
				sl = new ArrayList<Integer>();
				dsThuoc = new ArrayList<Thuoc>();
			}
			
			dsThuoc.add(qlThuoc.TimThuoc(rs.getString(2).trim()));
			hd.setDsThuocLe(dsThuoc);;
			sl.add(rs.getInt(3));
			hd.setSoLuong(sl);
			
			if(dsHD.isEmpty())
				dsHD.add(hd);
			else
				dsHD.set(dsHD.indexOf(hd), hd);
		}
		//cái này code hơi ngu
		dsHD.set(dsHD.indexOf(hd), hd);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
//tìm theo mã
public Hoadon TimHD(String maHD){
	for (Hoadon x : dsHD)
		if (x.getMaHD().equals(maHD))
			return x;
	return null;
}
//thêm 1 hoa don
public boolean themHD(Hoadon x) {
	if(dsHD.contains(x))
		return false;
	if(dsHD.add(x)) {
		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		
		try {
			stmt = con.prepareStatement("insert into HOADON values (?, ?, ?, ?)");
			
			stmt.setString(1, x.getMaHD());
			qlKH.ThemKH(x.getKhachhang());
			stmt.setString(2, x.getKhachhang().getMaKH());
			stmt.setString(3, x.getNhanVien().getMaNV());
			java.util.Date uDate = x.getNgayLapHD().getTime();
			java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			stmt.setObject(4, sDate);
			
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
		
		stmt = null;
		int m = 0;
		int index = 0;
		
		for (Thuoc y : x.getDsThuocLe()) {
			try {
				stmt = con.prepareStatement("insert into CHITIETHOADON values (?, ?, ?)");
				
				stmt.setString(1, x.getMaHD());
				stmt.setString(2, y.getMaThuoc());
				stmt.setInt(3, x.getSoLuong().get(index));
				
				m = stmt.executeUpdate();
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
			index++;
		}
		return n > 0 && m > 0; 
	}
	return false;
}
//get DSTB
public ArrayList<Hoadon> getDSHD(){
	return dsHD;
}
}
