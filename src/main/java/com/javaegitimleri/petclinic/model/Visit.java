package com.javaegitimleri.petclinic.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Visit extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private Date date;

	private String description;

	private Pet pet;

	private Boolean checkup = false;

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return this.pet;
	}

	protected void setPet(Pet pet) {
		this.pet = pet;
	}

	public Boolean getCheckup() {
		return checkup;
	}

	public void setCheckup(Boolean checkup) {
		this.checkup = checkup;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!Visit.class.isAssignableFrom(o.getClass()))
			return false;
		Visit v = (Visit) o;
		return new EqualsBuilder().append(getDate(), v.getDate())
				.append(getPet(), v.getPet())
				.append(getCheckup(), v.getCheckup()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getDate()).append(getPet())
				.toHashCode();
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SIMPLE_STYLE);
	}
}