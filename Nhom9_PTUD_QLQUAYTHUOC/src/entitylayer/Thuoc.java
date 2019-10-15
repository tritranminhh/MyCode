package entitylayer;

import java.util.GregorianCalendar;

public class Thuoc implements Comparable<Thuoc>{
private String maThuoc;
private String tenThuoc;
private Loai loaiThuoc;
private int soLuong;
private DanhmucThuoc danhMuc;
private Chucnang chucNang;
private Dangthuoc dangThuoc;
private int HDS;
private double donGia;
private GregorianCalendar NSX;
private Nhacungcap NCC;

public Thuoc(String maThuoc, String tenThuoc, Loai loaiThuoc, int soLuong, DanhmucThuoc danhMuc, Chucnang chucNang,
		Dangthuoc dangThuoc, int hDS, double donGia, GregorianCalendar nSX, Nhacungcap nCC) {
	super();
	this.maThuoc = maThuoc;
	this.tenThuoc = tenThuoc;
	this.loaiThuoc = loaiThuoc;
	this.soLuong = soLuong;
	this.danhMuc = danhMuc;
	this.chucNang = chucNang;
	this.dangThuoc = dangThuoc;
	HDS = hDS;
	this.donGia = donGia;
	NSX = nSX;
	NCC = nCC;
}
/**
 * @return the donGia
 */
public double getDonGia() {
	return donGia;
}
/**
 * @param donGia the donGia to set
 */
public void setDonGia(double donGia) {
	this.donGia = donGia;
}
/**
 * @return the maThuoc
 */
public String getMaThuoc() {
	return maThuoc;
}
/**
 * @param maThuoc the maThuoc to set
 */
public void setMaThuoc(String maThuoc) {
	this.maThuoc = maThuoc;
}
/**
 * @return the tenThuoc
 */
public String getTenThuoc() {
	return tenThuoc;
}
/**
 * @param tenThuoc the tenThuoc to set
 */
public void setTenThuoc(String tenThuoc) {
	this.tenThuoc = tenThuoc;
}
/**
 * @return the loaiThuoc
 */
public Loai getLoaiThuoc() {
	return loaiThuoc;
}
/**
 * @param loaiThuoc the loaiThuoc to set
 */
public void setLoaiThuoc(Loai loaiThuoc) {
	this.loaiThuoc = loaiThuoc;
}
/**
 * @return the soLuong
 */
public int getSoLuong() {
	return soLuong;
}
/**
 * @param soLuong the soLuong to set
 */
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
/**
 * @return the danhMuc
 */
public DanhmucThuoc getDanhMuc() {
	return danhMuc;
}
/**
 * @param danhMuc the danhMuc to set
 */
public void setDanhMuc(DanhmucThuoc danhMuc) {
	this.danhMuc = danhMuc;
}
/**
 * @return the chucNang
 */
public Chucnang getChucNang() {
	return chucNang;
}
/**
 * @param chucNang the chucNang to set
 */
public void setChucNang(Chucnang chucNang) {
	this.chucNang = chucNang;
}
/**
 * @return the dangThuoc
 */
public Dangthuoc getDangThuoc() {
	return dangThuoc;
}
/**
 * @param dangThuoc the dangThuoc to set
 */
public void setDangThuoc(Dangthuoc dangThuoc) {
	this.dangThuoc = dangThuoc;
}
/**
 * @return the hDS
 */
public int getHDS() {
	return HDS;
}
/**
 * @param hDS the hDS to set
 */
public void setHDS(int hDS) {
	HDS = hDS;
}
/**
 * @return the nSX
 */
public GregorianCalendar getNSX() {
	return NSX;
}
/**
 * @param nSX the nSX to set
 */
public void setNSX(GregorianCalendar nSX) {
	NSX = nSX;
}
/**
 * @return the nCC
 */
public Nhacungcap getNCC() {
	return NCC;
}
/**
 * @param nCC the nCC to set
 */
public void setNCC(Nhacungcap nCC) {
	NCC = nCC;
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + HDS;
	result = prime * result + ((NCC == null) ? 0 : NCC.hashCode());
	result = prime * result + ((NSX == null) ? 0 : NSX.hashCode());
	result = prime * result + ((chucNang == null) ? 0 : chucNang.hashCode());
	result = prime * result + ((dangThuoc == null) ? 0 : dangThuoc.hashCode());
	result = prime * result + ((danhMuc == null) ? 0 : danhMuc.hashCode());
	long temp;
	temp = Double.doubleToLongBits(donGia);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((loaiThuoc == null) ? 0 : loaiThuoc.hashCode());
	result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
	result = prime * result + soLuong;
	result = prime * result + ((tenThuoc == null) ? 0 : tenThuoc.hashCode());
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
	Thuoc other = (Thuoc) obj;
	if (HDS != other.HDS)
		return false;
	if (NCC == null) {
		if (other.NCC != null)
			return false;
	} else if (!NCC.equals(other.NCC))
		return false;
	if (NSX == null) {
		if (other.NSX != null)
			return false;
	} else if (!NSX.equals(other.NSX))
		return false;
	if (chucNang == null) {
		if (other.chucNang != null)
			return false;
	} else if (!chucNang.equals(other.chucNang))
		return false;
	if (dangThuoc == null) {
		if (other.dangThuoc != null)
			return false;
	} else if (!dangThuoc.equals(other.dangThuoc))
		return false;
	if (danhMuc == null) {
		if (other.danhMuc != null)
			return false;
	} else if (!danhMuc.equals(other.danhMuc))
		return false;
	if (Double.doubleToLongBits(donGia) != Double.doubleToLongBits(other.donGia))
		return false;
	if (loaiThuoc == null) {
		if (other.loaiThuoc != null)
			return false;
	} else if (!loaiThuoc.equals(other.loaiThuoc))
		return false;
	if (maThuoc == null) {
		if (other.maThuoc != null)
			return false;
	} else if (!maThuoc.equals(other.maThuoc))
		return false;
	if (soLuong != other.soLuong)
		return false;
	if (tenThuoc == null) {
		if (other.tenThuoc != null)
			return false;
	} else if (!tenThuoc.equals(other.tenThuoc))
		return false;
	return true;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", loaiThuoc=" + loaiThuoc + ", soLuong=" + soLuong
			+ ", danhMuc=" + danhMuc + ", chucNang=" + chucNang + ", dangThuoc=" + dangThuoc + ", HDS=" + HDS
			+ ", donGia=" + donGia + ", NSX=" + NSX + ", NCC=" + NCC + "]";
}
public Thuoc() {
	super();
	// TODO Auto-generated constructor stub
}
public Thuoc(String maThuoc, String tenThuoc, Loai loaiThuoc, int soLuong, DanhmucThuoc danhMuc, Chucnang chucNang,
		Dangthuoc dangThuoc, int hDS, GregorianCalendar nSX, Nhacungcap nCC) {
	super();
	this.maThuoc = maThuoc;
	this.tenThuoc = tenThuoc;
	this.loaiThuoc = loaiThuoc;
	this.soLuong = soLuong;
	this.danhMuc = danhMuc;
	this.chucNang = chucNang;
	this.dangThuoc = dangThuoc;
	HDS = hDS;
	NSX = nSX;
	NCC = nCC;
}
@Override
public int compareTo(Thuoc o) {
	// TODO Auto-generated method stub
	return this.tenThuoc.compareToIgnoreCase(o.getTenThuoc());
}

}
