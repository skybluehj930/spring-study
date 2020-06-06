package com.iu.s3.member;

import com.iu.s3.memberFile.MemberFileVO;

public class MemberVO {
	
	//DTO 거의 같은 개념
	//생성 규칙
	//모든 멤버변수의 접근지정자는 private
	//getter, setter 필요
	//생성자는 여러개 만들 수 있지만 디폴트 생성자는 꼭 필요
	//멤버변수의 데이터타입은 파라미터와 동일
	//데이터베이스의 컬럼의 데이터타입과 멤버변수의 데이터타입 동일
	//멤버변수의 변수명은 파라미터의 이름과 동일
	//데이터베이스의 테이블의 컬럼명과 변수명 동일
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String birth;
	
	//1:1 관계
	private MemberFileVO memberFileVO;
	
	
	
	
	
	
	public MemberFileVO getMemberFileVO() {
		return memberFileVO;
	}
	public void setMemberFileVO(MemberFileVO memberFileVO) {
		this.memberFileVO = memberFileVO;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	

}
