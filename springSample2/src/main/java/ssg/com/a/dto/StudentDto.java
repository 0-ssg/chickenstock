package ssg.com.a.dto;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable{
	
	private String name;
	private int age;
	private List<StudentDto> list;
	
	public StudentDto() {
	}

	public StudentDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	 public List<StudentDto> getList() { return list; }
	 
	 public void setList(List<StudentDto> list) { this.list = list; }
	 

	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", age=" + age + "]";
	}
	
	
}
