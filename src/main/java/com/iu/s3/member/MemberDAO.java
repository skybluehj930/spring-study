package com.iu.s3.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	//NAMESPACE의 이름은 현재 클래스의 경로명(패키지명).클래스명 과 일치하게 작성
	//Mapper의 namespace속성명과 일치
	private final String NAMESPACE="com.iu.s3.member.MemberDAO.";
	
	//기능별 메서드 생성
	
	//insert
	public int setMember(MemberVO memberVO) throws Exception{
		//statement
		//맵퍼의 namespace.id명
		//com.iu.s3.member.MemberDAO.setMember
		//parameter
		//맵퍼에서 필요한 Data
		//parameter의 갯수는 딱 1개 가능
		return sqlSession.insert(NAMESPACE+"setMember", memberVO);
	}
	
	//delete
	
	public int setDelete(String idx)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", idx);
		
	}
	
	//select
	//매개변수로 Map
	public MemberVO getMember(MemberVO memberVO)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "test");
		map.put("pw", "test");
		map.put("vo", memberVO);
		return sqlSession.selectOne(NAMESPACE+"getMember", map);
		
	}
	
	//update
	public int setUpdate(MemberVO memberVO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", memberVO);
	}
	

}






