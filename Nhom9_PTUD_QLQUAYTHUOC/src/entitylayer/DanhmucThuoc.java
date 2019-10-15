package entitylayer;

public class DanhmucThuoc {
private String maDM;
private String tenDM;
/**
 * @return the maDM
 */
public String getMaDM() {
	return maDM;
}
/**
 * @param maDM the maDM to set
 */
public void setMaDM(String maDM) {
	this.maDM = maDM;
}
/**
 * @return the tenDM
 */
public String getTenDM() {
	return tenDM;
}
/**
 * @param tenDM the tenDM to set
 */
public void setTenDM(String tenDM) {
	this.tenDM = tenDM;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maDM == null) ? 0 : maDM.hashCode());
	result = prime * result + ((tenDM == null) ? 0 : tenDM.hashCode());
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
	DanhmucThuoc other = (DanhmucThuoc) obj;
	if (maDM == null) {
		if (other.maDM != null)
			return false;
	} else if (!maDM.equals(other.maDM))
		return false;
	if (tenDM == null) {
		if (other.tenDM != null)
			return false;
	} else if (!tenDM.equals(other.tenDM))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "DanhmucThuoc [maDM=" + maDM + ", tenDM=" + tenDM + "]";
}
public DanhmucThuoc(String maDM, String tenDM) {
	super();
	this.maDM = maDM;
	this.tenDM = tenDM;
}
public DanhmucThuoc() {
	super();
	// TODO Auto-generated constructor stub
}

}
