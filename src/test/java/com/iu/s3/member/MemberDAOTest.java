package com.iu.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void setMemberTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testID");
		memberVO.setPw("testPW");
		memberVO.setName("testNAME");
		memberVO.setAge(30);
		memberVO.setBirth("2020-01-01");// YYYY/MM/DD, YYYY-MM-DD
		int result = memberDAO.setMember(memberVO);
		assertEquals(1, result);
	}
	
	//@Test
	public void setDeleteTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test");
		int result = memberDAO.setDelete("");
		assertEquals(1, result);
	}
	
	//@Test
	public void getMemberTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testID");
		memberVO.setPw("testPW");
		memberVO = memberDAO.getMember(memberVO);
		
		assertNull(memberVO);
		
	}
	
	@Test
	public void setUpdateTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testID");
		memberVO.setAge(200);
		memberVO.setName("reName");
		int result = memberDAO.setUpdate(memberVO);
		assertNotEquals(0, result);
	}

}
