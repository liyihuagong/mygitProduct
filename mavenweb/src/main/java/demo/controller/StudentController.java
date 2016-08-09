/**
 * 
 */
package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.vo.Student;
import demo.vo.TResult;
import demo.vo.UserInfo;

/**
 * 表单提交测试 http://localhost:8080/mavenweb/student
 * 
 * @author liyi
 * 
 */
@Controller
public class StudentController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());// 返回student.jsp视图
	}

	/*
	 * addStudent() will be called against a POST method on the /addStudent URL.
	 * You will prepare your model object based on the submitted information.
	 * Finally a "result" view will be returned from the service method, which
	 * will result in rendering result.jsp
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student,
			ModelMap model) { // 提交过来的数据
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "result"; // 返回result.jsp视图
	}
	
	
}
