package entitylayer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Donthuoc implements Comparable<Donthuoc>{
private String maDonThuoc;
private Khachhang khachHang;
private Nhanvien nhanVien;
private ArrayList<Thuoc> dsThuoc;
private ArrayList<Integer> soLuong;
private GregorianCalendar ngayLapDon=new GregorianCalendar();
private final float VAT=(float) 0.05;
/**
 * @return the maDonThuoc
 */
public String getMaDonThuoc() {
	return maDonThuoc;
}
/**
 * @param maDonThuoc the maDonThuoc to set
 */
public void setMaDonThuoc(String maDonThuoc) {
	this.maDonThuoc = maDonThuoc;
}
/**
 * @return the khachHang
 */
public Khachhang getKhachHang() {
	return khachHang;
}
/**
 * @param khachHang the khachHang to set
 */
public void setKhachHang(Khachhang khachHang) {
	this.khachHang = khachHang;
}
/**
 * @return the nhanVien
 */
public Nhanvien getNhanVien() {
	return nhanVien;
}
/**
 * @param nhanVien the nhanVien to set
 */
public void setNhanVien(Nhanvien nhanVien) {
	this.nhanVien = nhanVien;
}
/**
 * @return the dsThuoc
 */
public ArrayList<Thuoc> getDsThuoc() {
	return dsThuoc;
}
/**
 * @param dsThuoc the dsThuoc to set
 */
public void setDsThuoc(ArrayList<Thuoc> dsThuoc) {
	this.dsThuoc = dsThuoc;
}
/**
 * @return the soLuong
 */
public ArrayList<Integer> getSoLuong() {
	return soLuong;
}
/**
 * @param soLuong the soLuong to set
 */
public void setSoLuong(ArrayList<Integer> soLuong) {
	this.soLuong = soLuong;
}
/**
 * @return the ngayLapDon
 */
public GregorianCalendar getNgayLapDon() {
	return ngayLapDon;
}
/**
 * @param ngayLapDon the ngayLapDon to set
 */
public void setNgayLapDon(GregorianCalendar ngayLapDon) {
	this.ngayLapDon = ngayLapDon;
}
/**
 * @return the vAT
 */
public float getVAT() {
	return VAT;
}
public double getthanhTien(int index) {
	double money = 0;
	for (Thuoc x : dsThuoc) 
		money += x.getDonGia() * soLuong.get(index);
	return money;
}
public double gettongTien() {
	double money = 0;
	for (int i = 0; i < soLuong.size(); i++)
		money += getthanhTien(i);
	return money;
}
public double getthueVAT() {
	return gettongTien() * VAT;
}
@Override
public int compareTo(Donthuoc o) {
	// TODO Auto-generated method stub
	if(this.ngayLapDon.getTime().getTime()<o.getNgayLapDon().getTime().getTime())
		return -1;
	if(this.ngayLapDon.getTime().getTime()<o.getNgayLapDon().getTime().getTime())
		return -1;
	return this.khachHang.getMaKH().compareToIgnoreCase(o.getKhachHang().getMaKH());
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Float.floatToIntBits(VAT);
	result = prime * result + ((dsThuoc == null) ? 0 : dsThuoc.hashCode());
	result = prime * result + ((khachHang == null) ? 0 : khachHang.hashCode());
	result = prime * result + ((maDonThuoc == null) ? 0 : maDonThuoc.hashCode());
	result = prime * result + ((ngayLapDon == null) ? 0 : ngayLapDon.hashCode());
	result = prime * result + ((nhanVien == null) ? 0 : nhanVien.hashCode());
	result = prime * result + ((soLuong == null) ? 0 : soLuong.hashCode());
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Donthuoc other = (Donthuoc) obj;
	if (Float.floatToIntBits(VAT) != Float.floatToIntBits(other.VAT))
		return false;
	if (dsThuoc == null) {
		if (other.dsThuoc != null)
			return false;
	} else if (!dsThuoc.equals(other.dsThuoc))
		return false;
	if (khachHang == null) {
		if (other.khachHang != null)
			return false;
	} else if (!khachHang.equals(other.khachHang))
		return false;
	if (maDonThuoc == null) {
		if (other.maDonThuoc != null)
			return false;
	} else if (!maDonThuoc.equals(other.maDonThuoc))
		return false;
	if (ngayLapDon == null) {
		if (other.ngayLapDon != null)
			return false;
	} else if (!ngayLapDon.equals(other.ngayLapDon))
		return false;
	if (nhanVien == null) {
		if (other.nhanVien != null)
			return false;
	} else if (!nhanVien.equals(other.nhanVien))
		return false;
	if (soLuong == null) {
		if (other.soLuong != null)
			return false;
	} else if (!soLuong.equals(other.soLuong))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Donthuoc [maDonThuoc=" + maDonThuoc + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", dsThuoc="
			+ dsThuoc + ", soLuong=" + soLuong + ", ngayLapDon=" + ngayLapDon + ", VAT=" + VAT + "]";
}
public Donthuoc(String maDonThuoc, Khachhang khachHang, Nhanvien nhanVien, ArrayList<Thuoc> dsThuoc,
		ArrayList<Integer> soLuong, GregorianCalendar ngayLapDon) {
	super();
	this.maDonThuoc = maDonThuoc;
	this.khachHang = khachHang;
	this.nhanVien = nhanVien;
	this.dsThuoc = dsThuoc;
	this.soLuong = soLuong;
	this.ngayLapDon = ngayLapDon;
}
public Donthuoc() {
	super();
	// TODO Auto-generated constructor stub
}


}
