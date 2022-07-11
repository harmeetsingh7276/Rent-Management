package org.rentmanagement.model;

public class Tenant {
	private long mobileNumber;
	private String name;
	private String idProof;
	private long deposit;
	private long rent;
	private String dateOfDepositGiven;
	private String dateOfLiving;

	public Tenant(long mobileNumber, String name, String idProof, long deposit, long rent, String dateOfDepositGiven,
			String dateOfLiving) {
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.idProof = idProof;
		this.deposit = deposit;
		this.rent = rent;
		this.dateOfDepositGiven = dateOfDepositGiven;
		this.dateOfLiving = dateOfLiving;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
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

	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

	public long getRent() {
		return rent;
	}

	public void setRent(long rent) {
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
}
