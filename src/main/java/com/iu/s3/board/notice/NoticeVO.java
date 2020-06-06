package com.iu.s3.board.notice;

import java.util.List;

import com.iu.s3.board.BoardVO;
import com.iu.s3.board.notice.noticeFile.NoticeFileVO;

public class NoticeVO extends BoardVO{
	
	private List<NoticeFileVO> noticeFileVOs;

	public List<NoticeFileVO> getNoticeFileVOs() {
		return noticeFileVOs;
	}

	public void setNoticeFileVOs(List<NoticeFileVO> noticeFileVOs) {
		this.noticeFileVOs = noticeFileVOs;
	}
	
	

}
