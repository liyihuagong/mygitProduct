package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试报错时，返回json 而不是404 500之类
 * 
 * http://localhost:8080/mavenweb/math/div?a=10&b=5
 * 
 * 
 * @author liyi
 *
 */

@Controller
@RequestMapping("/math")
public class TestController {
	@RequestMapping(value="/div", method= RequestMethod.GET)
    @ResponseBody
    public int div(@RequestParam("a") int a,
                    @RequestParam("b") int b) {
        // *) div zero error
        return a / b;
    }
}

