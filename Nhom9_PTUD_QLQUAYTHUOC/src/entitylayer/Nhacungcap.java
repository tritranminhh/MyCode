package entitylayer;

public class Nhacungcap implements Comparable<Nhacungcap>{
private String maNCC;
private String tenNCC;
private String sdt;
private String email;
/**
 * @return the maNCC
 */
public String getMaNCC() {
	return maNCC;
}
/**
 * @param maNCC the maNCC to set
 */
public void setMaNCC(String maNCC) {
	this.maNCC = maNCC;
}
/**
 * @return the tenNCC
 */
public String getTenNCC() {
	return tenNCC;
}
/**
 * @param tenNCC the tenNCC to set
 */
public void setTenNCC(String tenNCC) {
	this.tenNCC = tenNCC;
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
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((maNCC == null) ? 0 : maNCC.hashCode());
	result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
	result = prime * result + ((tenNCC == null) ? 0 : tenNCC.hashCode());
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
	Nhacungcap other = (Nhacungcap) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (maNCC == null) {
		if (other.maNCC != null)
			return false;
	} else if (!maNCC.equals(other.maNCC))
		return false;
	if (sdt == null) {
		if (other.sdt != null)
			return false;
	} else if (!sdt.equals(other.sdt))
		return false;
	if (tenNCC == null) {
		if (other.tenNCC != null)
			return false;
	} else if (!tenNCC.equals(other.tenNCC))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Nhacungcap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", sdt=" + sdt + ", email=" + email + "]";
}
public Nhacungcap(String maNCC, String tenNCC, String sdt, String email) {
	super();
	this.maNCC = maNCC;
	this.tenNCC = tenNCC;
	this.sdt = sdt;
	this.email = email;
}
public Nhacungcap() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public int compareTo(Nhacungcap o) {
	// TODO Auto-generated method stub
	return this.getTenNCC().compareToIgnoreCase(o.getTenNCC());
}

}
