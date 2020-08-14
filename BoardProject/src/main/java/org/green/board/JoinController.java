package org.green.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {

	@Autowired
	private JoinService service;
	
	@Autowired
	private BoardService bservice;
	
	@RequestMapping("/")
	public String goLogin(Model model) {
		model.addAttribute("msg", "로그인 하세요!");
		return "loginForm";
	}

	@RequestMapping("/join")
	public String goJoin(Model model) {
		model.addAttribute("msg", "회원가입 하세요!");
		return "joinForm";
	}

	@RequestMapping(value = "/joinConfirm", method = RequestMethod.POST)
	public String joinConfirm(@ModelAttribute JoinInfo info, Model model, HttpServletRequest request) {
		boolean isTrim = false;
		if (info.getId().trim().equals("")) {
			model.addAttribute("msg", "아이디를 입력하세요");
			isTrim = true;
		} else if(info.getName().trim().equals("")) {
			model.addAttribute("msg", "이름을 입력하세요");
			isTrim = true;
		} else if(info.getPassword().trim().equals("")) {
			model.addAttribute("msg", "비밀번호를 입력하세요");
			isTrim = true;
		} else if(info.getNickName().trim().equals("")) {
			model.addAttribute("msg", "닉네임을 입력하세요");
			isTrim = true;
		}
		if (!isTrim) {
			int result = service.joinInsert(info);
			if (result == 1) {
				service.createBoard(info.getId());
				return "redirect:/";
			} else {
				model.addAttribute("msg", "중복된 아이디입니다");
			}
		}
		return "joinForm";
	}
	@RequestMapping(value = "/goBoard", method = RequestMethod.POST)
	public ModelAndView goBoard(@RequestParam String id, @RequestParam String password, HttpServletRequest request) {
		JoinInfo info = service.joinSearch(id, password);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mainBoard");
		if(info == null) {
			mav.addObject("msg", "로그인 실패");
			mav.setViewName("loginForm");
		} else {
			request.getSession().setAttribute("id", info.getId());
			mav.addObject("list", bservice.getAll(request.getSession().getAttribute("id").toString()));
		}
		return mav;
	}
}
