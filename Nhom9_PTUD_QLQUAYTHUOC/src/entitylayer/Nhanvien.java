package entitylayer;

import java.util.GregorianCalendar;

public class Nhanvien implements Comparable<Nhanvien>{
private String maNV;
private String tenNV;
private String gtinh;
private GregorianCalendar ngaySinh;
private String diaChi;
private String email;
private String sdt;
private boolean isAdmin;
private String password;

public Nhanvien(String maNV, String tenNV, String gtinh, GregorianCalendar ngaySinh, String diaChi, String email,
		String sdt, boolean isAdmin, String password) {
	super();
	this.maNV = maNV;
	this.tenNV = tenNV;
	this.gtinh = gtinh;
	this.ngaySinh = ngaySinh;
	this.diaChi = diaChi;
	this.email = email;
	this.sdt = sdt;
	this.isAdmin = isAdmin;
	this.password = password;
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
 * @return the password
 */
public String getPassword() {
	return password;
}

/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((gtinh == null) ? 0 : gtinh.hashCode());
	result = prime * result + (isAdmin ? 1231 : 1237);
	result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
	result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
	result = prime * result + ((tenNV == null) ? 0 : tenNV.hashCode());
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
	Nhanvien other = (Nhanvien) obj;
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
	if (isAdmin != other.isAdmin)
		return false;
	if (maNV == null) {
		if (other.maNV != null)
			return false;
	} else if (!maNV.equals(other.maNV))
		return false;
	if (ngaySinh == null) {
		if (other.ngaySinh != null)
			return false;
	} else if (!ngaySinh.equals(other.ngaySinh))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (sdt == null) {
		if (other.sdt != null)
			return false;
	} else if (!sdt.equals(other.sdt))
		return false;
	if (tenNV == null) {
		if (other.tenNV != null)
			return false;
	} else if (!tenNV.equals(other.tenNV))
		return false;
	return true;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */

public Nhanvien() {
	super();
	// TODO Auto-generated constructor stub
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Nhanvien [maNV=" + maNV + ", tenNV=" + tenNV + ", gtinh=" + gtinh + ", ngaySinh=" + ngaySinh + ", diaChi="
			+ diaChi + ", email=" + email + ", sdt=" + sdt + ", isAdmin=" + isAdmin + ", password=" + password + "]";
}

/**
 * @return the maNV
 */
public String getMaNV() {
	return maNV;
}

/**
 * @param maNV the maNV to set
 */
public void setMaNV(String maNV) {
	this.maNV = maNV;
}

/**
 * @return the tenNV
 */
public String getTenNV() {
	return tenNV;
}

/**
 * @param tenNV the tenNV to set
 */
public void setTenNV(String tenNV) {
	this.tenNV = tenNV;
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
 * @return the sdt
 */
public String getSdt() {
	return sdt;
}

/**
 * @param sdt the sdt to set
 */
public void setSdt(String sdt) {
	this.sdt = sdt;
}

/**
 * @return the isAdmin
 */
public boolean isAdmin() {
	return isAdmin;
}

/**
 * @param isAdmin the isAdmin to set
 */
public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}

@Override
public int compareTo(Nhanvien o) {
	// TODO Auto-generated method stub
	return this.getTenNV().compareToIgnoreCase(o.getTenNV());
}

}
