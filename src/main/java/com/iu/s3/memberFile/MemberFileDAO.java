package com.iu.s3.memberFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberFileDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s3.memberFile.MemberFileDAO.";
	
	public int setMemberFile(MemberFileVO memberFileVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberFile",memberFileVO);
	}

}
