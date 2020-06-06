package com.iu.s3.board.notice.noticeFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeFileDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s3.board.notice.noticeFile.NoticeFileDAO.";
	
	
	public NoticeFileVO getNoticeFile(NoticeFileVO noticeFileVO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNoticeFile", noticeFileVO);
	}
	
	public int setNoticeFile(NoticeFileVO noticeFileVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setNoticeFile", noticeFileVO);
	}

}
