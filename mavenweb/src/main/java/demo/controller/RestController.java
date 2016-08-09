/**
 * 
 */
package demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.vo.Message;
import demo.vo.Student;
import demo.vo.TResult;
import demo.vo.UserInfo;

/**
 * 测试请求返回json字符串
 * 以http://www.cnblogs.com/mumuxinfei/tag/springmvc/为例子制作demo
 * http://localhost:8080/mavenweb/query_user_by_id?user_id=1001
 * http://localhost:8080/mavenweb/get_messageMode  Jackson的使用和定制,使用jackson设定返回对象的字段和格式
 * @author liyi
 * 
 */
@Controller
public class RestController {
	@RequestMapping(value = "/query_user_by_id", method = RequestMethod.GET)
	public @ResponseBody TResult<UserInfo> queryUserById(
			@RequestParam(value = "user_id") String userId) {
		TResult<UserInfo> result = new TResult<UserInfo>();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setUsername("李雷");
		userInfo.setAge(18);
		result.setValue(userInfo); 
		result.setSuccess(true);
		return result;
	}
	
	@RequestMapping(value = "/get_messageMode", method = RequestMethod.GET)
	public @ResponseBody TResult<Message> queryUserById() {
		TResult<Message> result = new TResult<Message>();
		Message msg = new Message();
		msg.setUserId("12345");
		msg.setMessage("this change modeID");
		msg.setTimestamp(new Date());
		result.setValue(msg); 
		result.setSuccess(true);
		return result;
	}
}
