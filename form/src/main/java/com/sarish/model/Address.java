package com.sarish.model;

public class Address {
	private int houseNo;
	private String road;
	private String pincode;

	public Address() {
		super();
	}
	public Address(int houseNo) {
		super();
		this.houseNo=houseNo;
	}
	public Address(int houseNo, String road, String pincode) {
		super();
		this.houseNo = houseNo;
		this.road = road;
		this.pincode = pincode;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", road=" + road + ", pincode=" + pincode + "]";
	}

}
