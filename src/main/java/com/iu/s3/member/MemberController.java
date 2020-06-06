package com.iu.s3.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public String memberJoin() throws Exception{
		System.out.println("member Join");
		return "member/memberJoin";
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile pic, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setMember(memberVO, pic, session);
		
		if(result>0) {
			mv.setViewName("redirect:../");
		}else {
			mv.addObject("msg", "Join Fail");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	//메서드명 memberLogin
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public String memberLogin()throws Exception{
		System.out.println("Member Form Login");
		//Form 으로 이동
		return "member/memberLogin";
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		//parameter의 구성은 key=value
		//key의 타입은 String, value의 타입도 String
		
		
//		int id = Integer.parseInt(request.getParameter("id"));
//		String pw = request.getParameter("pw");
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("ID : "+memberVO.getId());
		System.out.println("PW : "+memberVO.getPw());
		
		System.out.println("Member Login 처리");
		
		memberVO = memberService.getMember(memberVO);
		System.out.println("MemberVO : "+memberVO);
		
		if(memberVO != null) {
			//로그인 성공
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "Login Fail");
			mv.addObject("path", "./memberLogin");
		}
		
		return mv;
	}
	
	// 메서드명 memberPage 경로 : /member/memberPage
	
	@RequestMapping(value = "memberPage")
	public String memberPage()throws Exception{
		
		return "member/memberPage";
	}
	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		//session.removeAttribute("member");
		session.invalidate();//Session 유지시간을 0으로 설정
		return "redirect:../";
	}
	

}





