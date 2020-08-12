package org.green.spring_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//POJO	어떠한 제약도 받지 않는 일반적인 클래스
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
//	@RequestMapping("/a/b/{myValue}") //{} 변수처럼 지정이됨
//	public String pathVariable(@PathVariable("myValue") String myValue) {
//		System.out.println(myValue);
//		return "other";
//	}
//	@RequestMapping("empty") 
//	public void emptyAction() {
//		
//	}
	/*
	 * - parameter종류
	 * request, response, session, OutputStream/Writer
	 * @RequestParam("i")
	 * @RequestParam(value = "i", required = true) required = 이파라미터는 무조건 있어야한다.
	 * @ModelAttribute("속성이름")
	 * @CookieValue("쿠키이름")
	 * @CookieValue(value = "쿠키이름", required=false, defaultValue = "1")
	 * @PathVariable("myValue") = 요청 URL이 /a/b/what 일때 myValue -> what
	 * 
	 * - 리턴종류
	 * String :view 이름 리턴
	 * ModelAndView : model + view
	 * void : URL에서 뷰이름을 구함 (RequestToViewResolver)
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
	
	//value : url root형태, get방식
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
