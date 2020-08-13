package org.green.join_admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService service;
	
	@RequestMapping("/")
	public String mainForm(Model model) {
		JoinInfo[] list = service.getAll();
		model.addAttribute("list", list);
		return "mainForm";
	}
	
	@RequestMapping("/join")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping(value = "/joinConfirm", method = RequestMethod.POST)
	public String joinFormConfirm(@ModelAttribute JoinInfo info) {
		service.insert(info);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam String cmd, Model model) {
		model.addAttribute("cmd", cmd);
		return "updateDeleteSearch";
	}
	
	@RequestMapping(value = "/allSearch", method = RequestMethod.POST)
	public String allSearch(@RequestParam String search_desc, Model model) {
		JoinInfo[] list = service.search(Integer.parseInt(search_desc));
		model.addAttribute("list", list);
		return "mainForm";
	}
	
	@RequestMapping(value = "/searchForm", method = RequestMethod.POST)
	public String searchForm(@RequestParam String search_desc, @RequestParam String cmd, Model model) {
		int id = Integer.parseInt(search_desc);
		model.addAttribute("msg", cmd);
		
		if(service.search(id) == null) {
			return "nullForm";
		} else{
			return "updateDeleteForm";
		}
	}
	@RequestMapping(value = "/updateDelete", method = RequestMethod.POST)
	public String updateDelete(@RequestParam String cmd, @ModelAttribute JoinInfo info, Model model) {
		if(cmd.equals("update")) {
			service.update(info);
		} else{
			service.delete(info);
		}
		
		return "redirect:/";
	}
}
