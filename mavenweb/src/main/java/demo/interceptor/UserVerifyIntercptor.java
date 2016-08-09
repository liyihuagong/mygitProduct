/**
 * 
 */
package demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author liyi
 * 
 */
@Component
public class UserVerifyIntercptor extends HandlerInterceptorAdapter {
	private String[] allowUrls = new String[]{
	// *) 用户登陆相关的接口
	"/login",};

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String uri = request.getRequestURI();
		for (String allowUri : allowUrls) {
			if (allowUri.equalsIgnoreCase(uri)) {
				return true;
			}
		}

		// *) 判断是否已经登陆
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			response.sendRedirect("/html/login.html");
			return false;
		}

		// *)
		return true;

	}
}
