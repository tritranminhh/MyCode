package entitylayer;

public class Dangthuoc {
private String maDT;
private String tenDT;
private String moTa;
/**
 * @return the maDT
 */
public String getMaDT() {
	return maDT;
}
/**
 * @param maDT the maDT to set
 */
public void setMaDT(String maDT) {
	this.maDT = maDT;
}
/**
 * @return the tenDT
 */
public String getTenDT() {
	return tenDT;
}
/**
 * @param tenDT the tenDT to set
 */
public void setTenDT(String tenDT) {
	this.tenDT = tenDT;
}
/**
 * @return the moTa
 */
public String getMoTa() {
	return moTa;
}
/**
 * @param moTa the moTa to set
 */
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maDT == null) ? 0 : maDT.hashCode());
	result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
	result = prime * result + ((tenDT == null) ? 0 : tenDT.hashCode());
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
	Dangthuoc other = (Dangthuoc) obj;
	if (maDT == null) {
		if (other.maDT != null)
			return false;
	} else if (!maDT.equals(other.maDT))
		return false;
	if (moTa == null) {
		if (other.moTa != null)
			return false;
	} else if (!moTa.equals(other.moTa))
		return false;
	if (tenDT == null) {
		if (other.tenDT != null)
			return false;
	} else if (!tenDT.equals(other.tenDT))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Dangthuoc [maDT=" + maDT + ", tenDT=" + tenDT + ", moTa=" + moTa + "]";
}
public Dangthuoc(String maDT, String tenDT, String moTa) {
	super();
	this.maDT = maDT;
	this.tenDT = tenDT;
	this.moTa = moTa;
}
public Dangthuoc() {
	super();
	// TODO Auto-generated constructor stub
}

}
