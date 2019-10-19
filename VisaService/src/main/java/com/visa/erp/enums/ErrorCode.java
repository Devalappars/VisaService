package com.visa.erp.enums;

public enum ErrorCode {
	ACCVALIDATION(1,"Validation","Account validation type error");
    
	private Integer id;
    private String label;
    private String desc;
	ErrorCode() {}
	
	ErrorCode(Integer id, String label, String desc){
		this.id = id;
        this.label = label;
        this.desc = desc;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	

}
