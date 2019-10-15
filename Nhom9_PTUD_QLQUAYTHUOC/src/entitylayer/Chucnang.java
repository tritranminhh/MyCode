package entitylayer;

public class Chucnang {
private String maCN;
private String tenCN;
private String mota;
/**
 * @return the maCN
 */
public String getMaCN() {
	return maCN;
}
/**
 * @param maCN the maCN to set
 */
public void setMaCN(String maCN) {
	this.maCN = maCN;
}
/**
 * @return the tenCN
 */
public String getTenCN() {
	return tenCN;
}
/**
 * @param tenCN the tenCN to set
 */
public void setTenCN(String tenCN) {
	this.tenCN = tenCN;
}
/**
 * @return the mota
 */
public String getMota() {
	return mota;
}
/**
 * @param mota the mota to set
 */
public void setMota(String mota) {
	this.mota = mota;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maCN == null) ? 0 : maCN.hashCode());
	result = prime * result + ((mota == null) ? 0 : mota.hashCode());
	result = prime * result + ((tenCN == null) ? 0 : tenCN.hashCode());
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
	Chucnang other = (Chucnang) obj;
	if (maCN == null) {
		if (other.maCN != null)
			return false;
	} else if (!maCN.equals(other.maCN))
		return false;
	if (mota == null) {
		if (other.mota != null)
			return false;
	} else if (!mota.equals(other.mota))
		return false;
	if (tenCN == null) {
		if (other.tenCN != null)
			return false;
	} else if (!tenCN.equals(other.tenCN))
		return false;
	return true;
}
public Chucnang(String maCN, String tenCN, String mota) {
	super();
	this.maCN = maCN;
	this.tenCN = tenCN;
	this.mota = mota;
}
public Chucnang() {
	super();
	// TODO Auto-generated constructor stub
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Chucnang [maCN=" + maCN + ", tenCN=" + tenCN + ", mota=" + mota + "]";
}

}
