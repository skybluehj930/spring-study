package com.iu.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardVO;
import com.iu.s3.board.notice.noticeFile.NoticeFileVO;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute(value = "board")
	public String getBoard() {
		//key = "board"
		//value="notice"
		// 모든 요청에서 사용 가능
		return "notice";
	}
	
	//비동기 방식요청이 발생했을떄 결과물을 JSON으로 변환 해서 전송
	@GetMapping("ajaxList")
	@ResponseBody
	public BoardVO  getAjaxList(BoardVO boardVO)throws Exception{
		 //List<BoardVO> ar = noticeService.getSelectList();
		boardVO = noticeService.getSelect(boardVO);
		 return boardVO;
	}
	
	@PostMapping(value="noticeUpdate")
	public ModelAndView setUpdate2(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(boardVO);
		
		mv.setViewName("redirect:./noticeList");
		
		return mv;
	}
	
	@GetMapping(value="noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getSelect(boardVO);
		mv.setViewName("board/boardUpdate");
		mv.addObject("vo", boardVO);
		return mv;
	}
	
	
	//메서드명 setDelete
	//성공 실패 메시지를 alert
	//list 로 이동
	@GetMapping(value = "noticeDelete")
	public String setDelete(BoardVO boardVO, Model model)throws Exception{
		//Model과 View 분리
		//Model은 Interface
		//Model을 매개변수로 선언
		int result = noticeService.setDelete(boardVO);
		
		String message="Delete Fail";
		if(result>0) {
			message="Delete Success";
		}
		String path="./noticeList";
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		
		return "common/result";
	}
	
	@GetMapping(value = "noticeSelect")
	public ModelAndView getSelect(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView(); 
		boardVO = noticeService.getSelect(boardVO);
		mv.setViewName("board/boardSelect");
		mv.addObject("vo", boardVO);
		return mv;
	}
	
	
	@GetMapping(value = "noticeList")
	public ModelAndView getSelectList(ModelAndView mv)throws Exception{
		//ModelAndView
		//Model과 View를 합친것
		//View = JSP 경로
		//Model = Servlet의 request와 같은 역할
		//request와 생명주기가 같음
		//Controller에서 jsp로 데이터를 운반 하는 역할
		//1. 메서드내에서 생성
		//ModelAndView mv = new ModelAndView();
		//2. 메서드의 매개변수로 선언
		System.out.println("Notice List");
		List<BoardVO> ar = noticeService.getSelectList();
		mv.setViewName("board/boardList");
		mv.addObject("list", ar);

		return mv;
	}
	
	//@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	@GetMapping(value = "noticeWrite")
	public String setInsert()throws Exception{
		return "board/boardWrite";
	}
	
	//@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	@PostMapping(value = "noticeWrite")
	public ModelAndView setInsert(NoticeVO noticeVO, MultipartFile [] files, HttpSession session)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(noticeVO, files, session);
		
		String message="Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		return mv;
	}
	
	@GetMapping("noticeFileDown")
	public ModelAndView noticeFileDown(NoticeFileVO noticeFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		noticeFileVO = noticeService.getNoticeFile(noticeFileVO);
		
		mv.addObject("noticeFile", noticeFileVO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	
	
	
	
	

}
