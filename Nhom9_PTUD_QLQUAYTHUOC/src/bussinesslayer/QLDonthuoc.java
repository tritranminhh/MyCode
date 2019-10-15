package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import datalayer.Connect;
import entitylayer.Donthuoc;
import entitylayer.Hoadon;
import entitylayer.Thuoc;

public class QLDonthuoc {
	private ArrayList<Donthuoc> dsDonThuoc;
	private QLThuoc qlThuoc=new QLThuoc();
	private QLKhachhang qlKH=new QLKhachhang();
	private QLNhanvien qlNV=new QLNhanvien();
	private GregorianCalendar ngayLapDonThuoc=new GregorianCalendar();
	public QLDonthuoc() {
		// TODO Auto-generated constructor stub
		dsDonThuoc = new ArrayList<Donthuoc>();
		try {
			Connection con = Connect.getConnect();
			
			String sql = "select * from [dbo].[CHITIETHOADON] ct join [dbo].[HOADON] hd on ct.MAHD = hd.MAHD";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			String oldcode = null;
			
			ArrayList<Thuoc> dsThuoc = null;
			ArrayList<Integer> sl = null;
			Donthuoc dt = null;

			
			while (rs.next()) {
				if(dsDonThuoc.isEmpty() || !oldcode.equals(rs.getString(1).trim())) {
					dt = new Donthuoc();
					dt.setMaDonThuoc(rs.getString(1).trim());
					dt.setKhachHang(qlKH.TimKH(rs.getString(5).trim()));
					dt.setNhanVien(qlNV.TimNV(rs.getString(6).trim()));
					
					ngayLapDonThuoc.setTime(rs.getDate(7));
					dt.setNgayLapDon(ngayLapDonThuoc);;
					
					oldcode = rs.getString(1).trim();
					sl = new ArrayList<Integer>();
					dsThuoc = new ArrayList<Thuoc>();
				}
				
				dsThuoc.add(qlThuoc.TimThuoc(rs.getString(2).trim()));
				dt.setDsThuoc(dsThuoc);;
				sl.add(rs.getInt(3));
				dt.setSoLuong(sl);
				
				if(dsDonThuoc.isEmpty())
					dsDonThuoc.add(dt);
				else
					dsDonThuoc.set(dsDonThuoc.indexOf(dt), dt);
			}
			//cái này code hơi ngu
			dsDonThuoc.set(dsDonThuoc.indexOf(dt), dt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//tìm theo mã
	public Donthuoc TimDonThuoc(String madonThuoc){
		for (Donthuoc x : dsDonThuoc)
			if (x.getMaDonThuoc().equals(madonThuoc))
				return x;
		return null;
	}
	//thêm 1 hoa don
	public boolean themDonThuoc(Donthuoc x) {
		if(dsDonThuoc.contains(x))
			return false;
		if(dsDonThuoc.add(x)) {
			Connection con = Connect.getConnect();
			PreparedStatement stmt = null;
			int n = 0;
			
			try {
				stmt = con.prepareStatement("insert into HOADON values (?, ?, ?, ?)");
				
				stmt.setString(1, x.getMaDonThuoc());
				qlKH.ThemKH(x.getKhachHang());
				stmt.setString(2, x.getKhachHang().getMaKH());
				stmt.setString(3, x.getNhanVien().getMaNV());
				java.util.Date uDate = x.getNgayLapDon().getTime();
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
			
			for (Thuoc y : x.getDsThuoc()) {
				try {
					stmt = con.prepareStatement("insert into CHITIETHOADON values (?, ?, ?)");
					
					stmt.setString(1, x.getMaDonThuoc());
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
	public ArrayList<Donthuoc> getDSDONTHUOC(){
		return dsDonThuoc;
	}
}
