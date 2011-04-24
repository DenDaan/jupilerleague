package voetbal.speler.util;

import javax.persistence.*;

@Entity
@Table(name="Nations")
public class Nation {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;

	@Column(name="FullName")
	private String fullName;

	@Column(name="Abbreviation")
	private String abbreviation;

	//TODO: check for right creation and already existing nations
	public Nation(String abbreviation, String fullName) {
		this.fullName = fullName;
		this.abbreviation = abbreviation;
	}
	
	public Nation(String fullName){
		this(null, fullName);
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abbreviation == null) ? 0 : abbreviation.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nation other = (Nation) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		return true;
	}
}
