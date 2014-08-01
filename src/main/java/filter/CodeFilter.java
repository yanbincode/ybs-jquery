package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 用于转换字符编码的过滤器
 * 
 * @author thinkPad_Y
 * 
 */
public class CodeFilter implements Filter {

	/**
	 * 初始化方法
	 */
	public void init(FilterConfig config) throws ServletException {
		// System.out.println("codeFile init");
	}

	/**
	 * 执行过滤器
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 将请求或响应向后传递。当前不拦截. 不调用这个方法，就不让请求通过。
		chain.doFilter(request, response);
		// System.out.println("doCodeFilter");
	}

	/**
	 * 销毁
	 */
	public void destroy() {
		// System.out.println("codeFile destroy");
	}

}
