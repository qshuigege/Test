package cn.net.fusen.ssm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限拦截器
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {
	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	//springmvc拦截器针对HandlerMapping进行拦截设置。
	//如果在某个HandlerMapping中配置拦截，经过该HandlerMapping映射成功的handler最终才使用该拦截器
	//springmvc也可配置类似全局拦截器，框架将配置的类似全局拦截器注入到每个HandlerMapping中
	/**
	 * 执行handler之后执行(应用场景：统一异常处理，统一日志处理)
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	/**
	 * 进入handler方法之后，返回modelAndView前执行(应用场景：从modelAndView出发，将公用的模型数据在这里传到视图)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 进入handler方法之前执行(应用场景：权限)
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		return true;
	}
}
