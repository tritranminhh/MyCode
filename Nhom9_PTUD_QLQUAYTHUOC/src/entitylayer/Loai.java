package entitylayer;

public class Loai {
private String maLoai;
private String tenLoai;
/**
 * @return the maLoai
 */
public String getMaLoai() {
	return maLoai;
}
/**
 * @param maLoai the maLoai to set
 */
public void setMaLoai(String maLoai) {
	this.maLoai = maLoai;
}
/**
 * @return the tenLoai
 */
public String getTenLoai() {
	return tenLoai;
}
/**
 * @param tenLoai the tenLoai to set
 */
public void setTenLoai(String tenLoai) {
	this.tenLoai = tenLoai;
}
public Loai(String maLoai, String tenLoai) {
	super();
	this.maLoai = maLoai;
	this.tenLoai = tenLoai;
}
public Loai() {
	super();
	// TODO Auto-generated constructor stub
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((maLoai == null) ? 0 : maLoai.hashCode());
	result = prime * result + ((tenLoai == null) ? 0 : tenLoai.hashCode());
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
	Loai other = (Loai) obj;
	if (maLoai == null) {
		if (other.maLoai != null)
			return false;
	} else if (!maLoai.equals(other.maLoai))
		return false;
	if (tenLoai == null) {
		if (other.tenLoai != null)
			return false;
	} else if (!tenLoai.equals(other.tenLoai))
		return false;
	return true;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Loai [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
}

}
