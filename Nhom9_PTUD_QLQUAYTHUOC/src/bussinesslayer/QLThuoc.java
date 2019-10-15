package bussinesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import datalayer.Connect;
import entitylayer.Chucnang;
import entitylayer.Dangthuoc;
import entitylayer.Loai;
import entitylayer.Thuoc;

public class QLThuoc {
	private QLNhacungcap dsNCC=new QLNhacungcap();
	private ArrayList<Thuoc> dsThuoc;
	private GregorianCalendar NSX=new GregorianCalendar();
	public QLThuoc() {
		// TODO Auto-generated constructor stub
		dsThuoc = new ArrayList<Thuoc>();
		try {
			Connection con = Connect.getConnect();

			String sql = "Select * FROM THUOC thuoc join LOAI loai on thuoc.LOAITHUOC = loai.MALOAI "
					+ "join CHUCNANG cn on thuoc.CHUCNANG = cn.MACN "
					+ "join DANGTHUOC dang on thuoc.DANGTHUOC = dang.MADT "
					+ "join NHACUNGCAP ncc on thuoc.NCC = ncc.MANCC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Thuoc thuoc=new Thuoc();
				thuoc.setMaThuoc(rs.getString(1).trim());
				thuoc.setTenThuoc(rs.getString(2).trim());
				thuoc.setLoaiThuoc(new Loai(rs.getString(3).trim(),rs.getString(12).trim()));
				thuoc.setSoLuong(rs.getInt(4));
				thuoc.setChucNang(new Chucnang(rs.getString(5).trim(),rs.getString(14).trim(),rs.getString(15).trim()));
				thuoc.setDangThuoc(new Dangthuoc(rs.getString(6).trim(),rs.getString(17).trim(),rs.getString(18).trim()));
				thuoc.setHDS(rs.getInt(7));
				thuoc.setDonGia(rs.getDouble(8));
				NSX.setTime(rs.getDate(9));
				thuoc.setNSX(NSX);
				thuoc.setNCC(dsNCC.TimNCC(rs.getString(10).trim()));
				dsThuoc.add(thuoc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//tìm theo mã
	public Thuoc TimThuoc(String maThuoc){
		for (Thuoc x : dsThuoc)
			if (x.getMaThuoc().equals(maThuoc))
				return x;
		return null;
	}
	//tìm theo tên
	public Thuoc TimTenThuoc(String tenThuoc){
		for (Thuoc x : dsThuoc)
			if (x.getTenThuoc().equals(tenThuoc))
				return x;
		return null;
	}
	//thêm 1 thiết bị
	public boolean ThemThuoc(Thuoc x) {
		if(dsThuoc.contains(x))
			return false;
		if(dsThuoc.add(x)) {
			Connection con = Connect.getConnect();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("insert into THUOC values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


				stmt.setString(1, x.getMaThuoc());
				stmt.setString(2, x.getTenThuoc());
				stmt.setString(3, x.getLoaiThuoc().getMaLoai());
				stmt.setInt(4, x.getSoLuong());
				stmt.setString(5, x.getChucNang().getMaCN());
				stmt.setString(6, x.getDangThuoc().getMaDT());
				stmt.setInt(7, x.getHDS());
				stmt.setDouble(8, x.getDonGia());
				Date udate=x.getNSX().getTime();
				java.sql.Date sdate=new java.sql.Date(udate.getTime());
				stmt.setObject(9, sdate);
				stmt.setString(10, x.getNCC().getMaNCC());

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
	//xóa thiết bị
	public boolean XoaThuoc(String maThuoc) {
		Thuoc x = TimThuoc(maThuoc);
		if(x == null)
			return false;
		if(dsThuoc.remove(x)) {
			Connection con = Connect.getConnect();
			PreparedStatement stmt = null;
			int n = 0;
			try {
				stmt = con.prepareStatement("DELETE FROM THUOC WHERE MATHUOC = ?");

				stmt.setString(1, x.getMaThuoc());

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
	//sửa thông tin thiết bị
	public boolean SuaThuoc(Thuoc x) {
		if(!dsThuoc.contains(x))
			return false;

		dsThuoc.set(dsThuoc.indexOf(x), x);

		Connection con = Connect.getConnect();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update THUOC set TENTHUOC=?, LOAI=?, SOLUONG=?, CHUCNANG=?, DANGTHUOC=?,"
					+ "HDS=?, DONGIA=?, NSX=?, NCC=? where MATHUOC=?");


			stmt.setString(1, x.getTenThuoc());
			stmt.setString(2, x.getLoaiThuoc().getMaLoai());
			stmt.setInt(3, x.getSoLuong());
			stmt.setString(4, x.getChucNang().getMaCN());
			stmt.setString(5, x.getDangThuoc().getMaDT());
			stmt.setInt(6, x.getHDS());
			stmt.setDouble(7, x.getDonGia());
			java.util.Date uDate = x.getNSX().getTime();
			java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			stmt.setDate(8,sDate);
			stmt.setString(9, x.getNCC().getMaNCC());
			stmt.setString(10, x.getMaThuoc());

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
	//get DSTB
	public ArrayList<Thuoc> getDsThuoc(){
		sorter();
		return dsThuoc;
	}
	public void sorter() {
		Collections.sort(dsThuoc);
	}

}
