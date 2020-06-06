package com.iu.s3.board;

import java.util.List;

public interface BoardDAO {
	
	//insert
	public int setInsert(BoardVO boardVO)throws Exception;
	//update
	public int setUpdate(BoardVO boardVO)throws Exception;
	//delete
	public int setDelete(BoardVO boardVO)throws Exception;
	//select
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	//selectList
	
	public List<BoardVO> getSelectList() throws Exception;

}
