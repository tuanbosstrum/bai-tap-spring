package edu.phuxuan.k17.spring.baitapcontrollerdemo.model;

public class Custormer {
	private int id;
	private String code;
    private String name;
    private String email;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public Custormer() {
		// TODO Auto-generated constructor stub
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Custormer(int id, String code, String name, String email) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.email = email;
		
	}
    
    public Custormer(String code, String name, String email) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
	} 
	
}
