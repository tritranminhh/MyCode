package entitylayer;

import java.util.GregorianCalendar;

public class Khachhang {
private String maKH;
private String tenKH;
private String gtinh;
private GregorianCalendar ngaySinh;
private String diaChi;
private String email;
private String SDT;
/**
 * @return the maKH
 */
public String getMaKH() {
	return maKH;
}
/**
 * @param maKH the maKH to set
 */
public void setMaKH(String maKH) {
	this.maKH = maKH;
}
/**
 * @return the tenKH
 */
public String getTenKH() {
	return tenKH;
}
/**
 * @param tenKH the tenKH to set
 */
public void setTenKH(String tenKH) {
	this.tenKH = tenKH;
}
/**
 * @return the gtinh
 */
public String getGtinh() {
	return gtinh;
}
/**
 * @param gtinh the gtinh to set
 */
public void setGtinh(String gtinh) {
	this.gtinh = gtinh;
}
/**
 * @return the ngaySinh
 */
public GregorianCalendar getNgaySinh() {
	return ngaySinh;
}
/**
 * @param ngaySinh the ngaySinh to set
 */
public void setNgaySinh(GregorianCalendar ngaySinh) {
	this.ngaySinh = ngaySinh;
}
/**
 * @return the diaChi
 */
public String getDiaChi() {
	return diaChi;
}
/**
 * @param diaChi the diaChi to set
 */
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the sDT
 */
public String getSDT() {
	return SDT;
}
/**
 * @param sDT the sDT to set
 */
public void setSDT(String sDT) {
	SDT = sDT;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((SDT == null) ? 0 : SDT.hashCode());
	result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((gtinh == null) ? 0 : gtinh.hashCode());
	result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
	result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
	result = prime * result + ((tenKH == null) ? 0 : tenKH.hashCode());
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
	Khachhang other = (Khachhang) obj;
	if (SDT == null) {
		if (other.SDT != null)
			return false;
	} else if (!SDT.equals(other.SDT))
		return false;
	if (diaChi == null) {
		if (other.diaChi != null)
			return false;
	} else if (!diaChi.equals(other.diaChi))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (gtinh == null) {
		if (other.gtinh != null)
			return false;
	} else if (!gtinh.equals(other.gtinh))
		return false;
	if (maKH == null) {
		if (other.maKH != null)
			return false;
	} else if (!maKH.equals(other.maKH))
		return false;
	if (ngaySinh == null) {
		if (other.ngaySinh != null)
			return false;
	} else if (!ngaySinh.equals(other.ngaySinh))
		return false;
	if (tenKH == null) {
		if (other.tenKH != null)
			return false;
	} else if (!tenKH.equals(other.tenKH))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Khachhang [maKH=" + maKH + ", tenKH=" + tenKH + ", gtinh=" + gtinh + ", ngaySinh=" + ngaySinh + ", diaChi="
			+ diaChi + ", email=" + email + ", SDT=" + SDT + "]";
}
public Khachhang(String maKH, String tenKH, String gtinh, GregorianCalendar ngaySinh, String diaChi, String email,
		String sDT) {
	super();
	this.maKH = maKH;
	this.tenKH = tenKH;
	this.gtinh = gtinh;
	this.ngaySinh = ngaySinh;
	this.diaChi = diaChi;
	this.email = email;
	SDT = sDT;
}
public Khachhang() {
	super();
	// TODO Auto-generated constructor stub
}

}
