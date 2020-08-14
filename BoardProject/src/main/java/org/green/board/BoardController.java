package org.green.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("id")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/goWrite")
	public String goWrite() {
		return "write";
	}
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		model.addAttribute("msg", "로그아웃 했습니다.");
		request.getSession().removeAttribute("id");
		return "loginForm";
	}
	
	@RequestMapping(value = "/boardWrite", method = {RequestMethod.POST, RequestMethod.GET})
	public String writeBoard(@RequestParam String b_title, @RequestParam String b_content, Model model, HttpServletRequest request) {
		service.writeBoard(new BoardInfo(b_title, b_content, new Date()), request.getSession().getAttribute("id").toString());
		return "redirect:/mainBoard";
	}
	@RequestMapping("/mainBoard")
	public String mainBoard(Model model, HttpServletRequest request) {
		model.addAttribute("list", service.getAll(request.getSession().getAttribute("id").toString()));
		return "mainBoard";
	}
	
	@RequestMapping("/boardUpdate")
	public String updateBoard(@RequestParam String cmd, Model model) {
		model.addAttribute("cmd", cmd);
		return "update";
	}
	
	@RequestMapping("/updateConfirm")
	public ModelAndView updateConfirm(String cmd, String b_title, String b_content, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		BoardInfo info = service.boardSearch(Integer.parseInt(cmd), request.getSession().getAttribute("id").toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (hh:mm)");
		info.setB_title(b_title);
		info.setB_content(b_content);
		info.setB_date(sdf.format(new Date()));
		
		service.boardUpdate(info, request.getSession().getAttribute("id").toString());
		mav.setViewName("redirect:/mainBoard");
		return mav;
	}
	
	@RequestMapping("/boardDelete")
	public String deleteBoard(@RequestParam String cmd, HttpServletRequest request) {
		service.boardDelete(Integer.parseInt(cmd), request.getSession().getAttribute("id").toString());
		return "redirect:/mainBoard";
	}
}
