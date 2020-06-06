package com.iu.s3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s3.memberFile.MemberFileDAO;
import com.iu.s3.memberFile.MemberFileVO;
import com.iu.s3.util.FileManger;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManger fileManger;
	@Autowired
	private MemberFileDAO memberFileDAO;
	
	//insert join
	public int setMember(MemberVO memberVO, MultipartFile pic, HttpSession session) throws Exception {
		
		//HDD에 저장하고 저장된 이름을 DB에 저장
		// /resources/upload
		//C:\week\images
		String path= session.getServletContext().getRealPath("resources/upload");
		System.out.println("path : "+ path);
		String fileName = fileManger.saveByTransfer(pic, path);
		
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setFileName(fileName);
		memberFileVO.setOriName(pic.getOriginalFilename());
		memberFileVO.setId(memberVO.getId());
		memberFileDAO.setMemberFile(memberFileVO);
		
		return memberDAO.setMember(memberVO);
	}
	
	//select Login
	public MemberVO getMember(MemberVO memberVO)throws Exception{
		
		return memberDAO.getMember(memberVO);
	}

}
