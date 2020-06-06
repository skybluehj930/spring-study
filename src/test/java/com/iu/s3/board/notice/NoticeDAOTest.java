package com.iu.s3.board.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s3.MyAbstractTest;
import com.iu.s3.board.BoardVO;

public class NoticeDAOTest extends MyAbstractTest{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void setInsertTest() throws Exception {
		
		for(int i=0;i<150;i++) {
		BoardVO boardVO = new NoticeVO();
		boardVO.setNum(Long.parseLong(i+""));
		boardVO.setWriter("writer"+i);
		boardVO.setTitle("title"+i);
		boardVO.setContents("contents"+i);
		
		int result = noticeDAO.setInsert(boardVO);
		if(i%10 == 0 ) {
			Thread.sleep(500);
		}
		}
		
	}

}
