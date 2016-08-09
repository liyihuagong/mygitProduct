/**
 * 
 */
package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面从定向
 * 
 * @author liyi
 * 
 */
@Controller
public class WebController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index"; // 返回index.jsp视图
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:finalPage";
	}

	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage() {
		return "final"; // 返回final.jsp视图
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirectStatic() {
		return "redirect:/pages/final.html";
	}
}
