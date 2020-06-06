package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s3.board.BoardService;
import com.iu.s3.board.BoardVO;
import com.iu.s3.board.notice.noticeFile.NoticeFileDAO;
import com.iu.s3.board.notice.noticeFile.NoticeFileVO;
import com.iu.s3.util.FileManger;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManger fileManger;
	@Autowired
	private NoticeFileDAO noticeFileDAO;

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
		int result = noticeDAO.setInsert(boardVO);
		
		//1. 저장할 실제 경로
		String path = session.getServletContext().getRealPath("resources/upload/notice");
		System.out.println(path);
		
		//2. HDD 파일을 저장
		for(MultipartFile multipartFile:files) {
			NoticeFileVO noticeFileVO= new NoticeFileVO();
			String fileName = fileManger.save(multipartFile, path);
			System.out.println(fileName);
			
			noticeFileVO.setNum(boardVO.getNum());
			noticeFileVO.setFileName(fileName);
			noticeFileVO.setOriName(multipartFile.getOriginalFilename());
			result = noticeFileDAO.setNoticeFile(noticeFileVO);
			
			
		}
		
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList() throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelectList();
	}
	
	public NoticeFileVO getNoticeFile(NoticeFileVO noticeFileVO)throws Exception{
		return noticeFileDAO.getNoticeFile(noticeFileVO);
	}

}
