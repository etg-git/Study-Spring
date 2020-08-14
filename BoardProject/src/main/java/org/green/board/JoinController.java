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
		model.addAttribute("msg", "�α��� �ϼ���!");
		return "loginForm";
	}

	@RequestMapping("/join")
	public String goJoin(Model model) {
		model.addAttribute("msg", "ȸ������ �ϼ���!");
		return "joinForm";
	}

	@RequestMapping(value = "/joinConfirm", method = RequestMethod.POST)
	public String joinConfirm(@ModelAttribute JoinInfo info, Model model, HttpServletRequest request) {
		boolean isTrim = false;
		if (info.getId().trim().equals("")) {
			model.addAttribute("msg", "���̵� �Է��ϼ���");
			isTrim = true;
		} else if(info.getName().trim().equals("")) {
			model.addAttribute("msg", "�̸��� �Է��ϼ���");
			isTrim = true;
		} else if(info.getPassword().trim().equals("")) {
			model.addAttribute("msg", "��й�ȣ�� �Է��ϼ���");
			isTrim = true;
		} else if(info.getNickName().trim().equals("")) {
			model.addAttribute("msg", "�г����� �Է��ϼ���");
			isTrim = true;
		}
		if (!isTrim) {
			int result = service.joinInsert(info);
			if (result == 1) {
				service.createBoard(info.getId());
				return "redirect:/";
			} else {
				model.addAttribute("msg", "�ߺ��� ���̵��Դϴ�");
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
			mav.addObject("msg", "�α��� ����");
			mav.setViewName("loginForm");
		} else {
			request.getSession().setAttribute("id", info.getId());
			mav.addObject("list", bservice.getAll(request.getSession().getAttribute("id").toString()));
		}
		return mav;
	}
}
