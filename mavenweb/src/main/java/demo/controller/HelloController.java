/**
 * 
 */
package demo.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.vo.TResult;
import demo.vo.UserInfo;

/**
 * 使用注解定义url匹配
 * http://localhost:8080/mavenweb/welcomee
 * http://localhost:8080/mavenweb/hello
 * @author liyi
 * 
 */

@Controller
//@RequestMapping("/welcomee")
public class HelloController {
	@RequestMapping(value = "/welcomee",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring3 MVC 例子");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		model.addAttribute("date", dateFormat.format(new java.util.Date()));
		// hello.jsp
		return "hello";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		// message对应jsp文件中的JSTL${message}
		model.addAttribute("message", "Hello Spring MVC Frame234234234work!!!!");  
		return "hello2"; // hello2.jsp
	}
	
	@RequestMapping(value = "/queryuserbyid", method = RequestMethod.GET)
	public  @ResponseBody UserInfo printHello2() {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("wahaha");
		userInfo.setUsername("李雷");
		userInfo.setAge(18);
		return userInfo;
	}
	

}
