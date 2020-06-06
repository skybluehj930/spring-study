package com.iu.s3.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s3.board.BoardDAO;
import com.iu.s3.board.BoardVO;

@Repository
public class NoticeDAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s3.board.notice.NoticeDAO.";

	@Override
	public int setInsert(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		// num, title, writer, contents
		
		return sqlSession.insert(NAMESPACE+"setInsert", boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		// title, contents 수정
		return sqlSession.update(NAMESPACE+"setUpdate", boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		// num 으로 삭제
		return sqlSession.delete(NAMESPACE+"setDelete", boardVO);
	}

	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		// num 조회
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardVO);
	}
	
	@Override
	public List<BoardVO> getSelectList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getSelectList");
	}

}
