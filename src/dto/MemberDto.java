package dto;

public class MemberDto {

	private String name;
	private String tel;
	private String dept;
	private String age;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	public MemberDto(String name, String tel, String dept, String age) {
		super();
		this.name = name;
		this.tel = tel;
		this.dept = dept;
		this.age = age;
	}
	@Override
	public String toString() {
		return "MemberDto [name=" + name + ", tel=" + tel + ", dept=" + dept + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
