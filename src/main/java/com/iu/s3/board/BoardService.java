package com.iu.s3.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
	//insert
	public int setInsert(BoardVO boardVO, MultipartFile [] files, HttpSession session)throws Exception;
	//update
	public int setUpdate(BoardVO boardVO)throws Exception;
	//delete
	public int setDelete(BoardVO boardVO)throws Exception;
	//select
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	//selectList
	
	public List<BoardVO> getSelectList() throws Exception;


}
