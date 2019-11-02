package com.visa.erp.enums;

public enum IDTypes {
	Aadhar(1,"Aadhar Card"),
	Passport(2,"Passport"),
	RationCard(3,"Ration Card"),
	VoterCard(4,"Voter Card"),
	BankPassbook(5,"Bank Passbook"),
	Pan(6,"Pan Card"),
	BankStatement(7,"Bank Statement"),
	DrivingLicense(8,"Driving License"),
	BirthCertificate(8,"Birth Certificate"),
	StudentCard(9,"Student Photo Identity Card"),
	;

	private Integer id;
    private String label;
	IDTypes() {}

	IDTypes(Integer id, String label){
		this.id = id;
        this.label = label;
	}

	public static IDTypes fromValue(Integer idType) {
		for (IDTypes b : IDTypes.values()) {
			if (String.valueOf(b.id).equals(idType)) {
				return b;
			}
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static Integer getIdNum(IDTypes idType){
		for (IDTypes b : IDTypes.values()) {
			if (b.equals(idType)) {
				return b.getId();
			}
		}
		return null;
	}
}