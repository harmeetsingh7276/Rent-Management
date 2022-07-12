package org.rentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tenants")
@Table(name = "tenants")
public class Tenants {
	@Id
	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "id_proof")
	private String idProof;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "rent")
	private String rent;

	@Column(name = "date_of_deposit_given")
	private String dateOfDepositGiven;

	@Column(name = "date_of_living")
	private String dateOfLiving;

	public Tenants() {
		
	}

	public Tenants(String mobileNumber, String name, String idProof, String deposit, String rent, String dateOfDepositGiven,
			String dateOfLiving) {
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.idProof = idProof;
		this.deposit = deposit;
		this.rent = rent;
		this.dateOfDepositGiven = dateOfDepositGiven;
		this.dateOfLiving = dateOfLiving;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getDateOfDepositGiven() {
		return dateOfDepositGiven;
	}

	public void setDateOfDepositGiven(String dateOfDepositGiven) {
		this.dateOfDepositGiven = dateOfDepositGiven;
	}

	public String getDateOfLiving() {
		return dateOfLiving;
	}

	public void setDateOfLiving(String dateOfLiving) {
		this.dateOfLiving = dateOfLiving;
	}

	@Override
	public String toString() {
		return "Tenants [mobileNumber=" + mobileNumber + ", name=" + name + ", idProof=" + idProof + ", deposit="
				+ deposit + ", rent=" + rent + ", dateOfDepositGiven=" + dateOfDepositGiven + ", dateOfLiving="
				+ dateOfLiving + "]";
	}

}
