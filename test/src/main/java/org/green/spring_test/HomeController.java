package org.green.spring_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//POJO	��� ���൵ ���� �ʴ� �Ϲ����� Ŭ����
@Controller 
public class HomeController {
	
	@Autowired
	private Some yourSome;
	
	@Autowired
	private Other obj;
	
	@Autowired
	private IAnimal myCat;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		myCat.cry();
		return "home";
	}
	
	/*
	 *  /a/b/what
	 *  myValue -> what
	 */
//	@RequestMapping("/a/b/{myValue}") //{} ����ó�� �����̵�
//	public String pathVariable(@PathVariable("myValue") String myValue) {
//		System.out.println(myValue);
//		return "other";
//	}
//	@RequestMapping("empty") 
//	public void emptyAction() {
//		
//	}
	/*
	 * - parameter����
	 * request, response, session, OutputStream/Writer
	 * @RequestParam("i")
	 * @RequestParam(value = "i", required = true) required = ���Ķ���ʹ� ������ �־���Ѵ�.
	 * @ModelAttribute("�Ӽ��̸�")
	 * @CookieValue("��Ű�̸�")
	 * @CookieValue(value = "��Ű�̸�", required=false, defaultValue = "1")
	 * @PathVariable("myValue") = ��û URL�� /a/b/what �϶� myValue -> what
	 * 
	 * - ��������
	 * String :view �̸� ����
	 * ModelAndView : model + view
	 * void : URL���� ���̸��� ���� (RequestToViewResolver)
	 */
//	@RequestMapping(value = "/userInfo", method = RequestMethod.POST)
//	public String makeUser(@ModelAttribute("otherUser") User user) {
//		return "redirect:start";
//	}
//	@RequestMapping(value = "/formData", method = RequestMethod.POST)
//	public String parameterProcess(String inputValue) {
//		System.out.println(inputValue);
//		return "redirect:start";
//	}
	
	//value : url root����, get���
//	@RequestMapping(value = {"/", "/start"}, method = RequestMethod.GET)
//	public String start(Model model) {
//		request.setAttribute("some", "other");
//		
//		
//		mav.addObject("some", "other");
//		mav.setViewName("hello");
//		return mav;
//		
//		model.addAttribute("some", "other");
//		return "hello";
//	}
	
}
