package com.iu.s3.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s3.board.BoardVO;
import com.iu.s3.member.MemberVO;

public class UpdateInterceptor  extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(modelAndView.getViewName());
		
		//BoardVO
		 Map<String, Object> map = modelAndView.getModel();
		 BoardVO boardVO = (BoardVO)map.get("vo");
		 
		//Login MemberVO
		MemberVO memberVO =  (MemberVO)request.getSession().getAttribute("member");
		
		if(!(memberVO != null && memberVO.getId().equals(boardVO.getWriter()))) {
			modelAndView.setViewName("redirect:./noticeList");
		}
		
	}

}
