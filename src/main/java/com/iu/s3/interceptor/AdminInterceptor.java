package com.iu.s3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s3.member.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//controller 진입전 필터링
		//true면 다음 컨트롤러로 진행
		//false면 컨트롤러 진입 불가
		System.out.println("컨트롤러 진입 전");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		boolean check=false;
		if(memberVO != null && memberVO.getId().equals("admin")) {
			check = !check;
			//check=true;
		}else {
			response.sendRedirect("../member/memberLogin");
		}
		
		return check;
	}
	
	
	/*
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { //Controller에서 리턴후 필터링 System.out.println("컨트롤러 리턴 후 ");
	 * 
	 * }
	 * 
	 * @Override public void afterCompletion(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) throws Exception
	 * { //jsp 페이지를 작성 후 Client로 보내기 전 super.afterCompletion(request, response,
	 * handler, ex); }
	 * 
	 * @Override public void afterConcurrentHandlingStarted(HttpServletRequest
	 * request, HttpServletResponse response, Object handler) throws Exception {
	 * //비동기방식 실행 super.afterConcurrentHandlingStarted(request, response, handler);
	 * }
	 */

}
