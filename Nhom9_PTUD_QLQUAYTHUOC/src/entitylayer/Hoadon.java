package entitylayer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Hoadon {
private String maHD;
private Khachhang khachhang;
private Nhanvien nhanVien;
private ArrayList<Thuoc> dsThuocLe;
private ArrayList<Integer> soLuong;
private GregorianCalendar ngayLapHD=new GregorianCalendar();
private final float VAT=(float) 0.05;
/**
 * @return the maHD
 */
public String getMaHD() {
	return maHD;
}
/**
 * @param maHD the maHD to set
 */
public void setMaHD(String maHD) {
	this.maHD = maHD;
}
/**
 * @return the khachhang
 */
public Khachhang getKhachhang() {
	return khachhang;
}
/**
 * @param khachhang the khachhang to set
 */
public void setKhachhang(Khachhang khachhang) {
	this.khachhang = khachhang;
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
 * @return the dsThuocLe
 */
public ArrayList<Thuoc> getDsThuocLe() {
	return dsThuocLe;
}
/**
 * @param dsThuocLe the dsThuocLe to set
 */
public void setDsThuocLe(ArrayList<Thuoc> dsThuocLe) {
	this.dsThuocLe = dsThuocLe;
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
 * @return the ngayLapHD
 */
public GregorianCalendar getNgayLapHD() {
	return ngayLapHD;
}
/**
 * @param ngayLapHD the ngayLapHD to set
 */
public void setNgayLapHD(GregorianCalendar ngayLapHD) {
	this.ngayLapHD = ngayLapHD;
}
/**
 * @return the vAT
 */
public float getVAT() {
	return VAT;
}
public double thanhTien(int index) {
	double money = 0;
	for (Thuoc x : dsThuocLe) 
		money += x.getDonGia() * soLuong.get(index);
	return money;
}
public double tongTien() {
	double money = 0;
	for (int i = 0; i < soLuong.size(); i++)
		money += thanhTien(i);
	return money;
}
public double thueVAT() {
	return tongTien() * VAT;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Float.floatToIntBits(VAT);
	result = prime * result + ((dsThuocLe == null) ? 0 : dsThuocLe.hashCode());
	result = prime * result + ((khachhang == null) ? 0 : khachhang.hashCode());
	result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
	result = prime * result + ((ngayLapHD == null) ? 0 : ngayLapHD.hashCode());
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
	Hoadon other = (Hoadon) obj;
	if (Float.floatToIntBits(VAT) != Float.floatToIntBits(other.VAT))
		return false;
	if (dsThuocLe == null) {
		if (other.dsThuocLe != null)
			return false;
	} else if (!dsThuocLe.equals(other.dsThuocLe))
		return false;
	if (khachhang == null) {
		if (other.khachhang != null)
			return false;
	} else if (!khachhang.equals(other.khachhang))
		return false;
	if (maHD == null) {
		if (other.maHD != null)
			return false;
	} else if (!maHD.equals(other.maHD))
		return false;
	if (ngayLapHD == null) {
		if (other.ngayLapHD != null)
			return false;
	} else if (!ngayLapHD.equals(other.ngayLapHD))
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
	return "Hoadon [maHD=" + maHD + ", khachhang=" + khachhang + ", nhanVien=" + nhanVien + ", dsThuocLe=" + dsThuocLe
			+ ", soLuong=" + soLuong + ", ngayLapHD=" + ngayLapHD + ", VAT=" + VAT + "]";
}
public Hoadon(String maHD, Khachhang khachhang, Nhanvien nhanVien, ArrayList<Thuoc> dsThuocLe,
		ArrayList<Integer> soLuong, GregorianCalendar ngayLapHD) {
	super();
	this.maHD = maHD;
	this.khachhang = khachhang;
	this.nhanVien = nhanVien;
	this.dsThuocLe = dsThuocLe;
	this.soLuong = soLuong;
	this.ngayLapHD = ngayLapHD;
}
public Hoadon() {
	super();
	// TODO Auto-generated constructor stub
}

}
