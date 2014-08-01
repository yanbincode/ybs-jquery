package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = -2908606144414412796L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax传过来的参数
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "yanbin");
		map.put("age", "26");

		System.out.println("get");

		// 返回json格式的字符串，设置response 是必须要的
		response.setContentType("application/json");//
		String result = "{\"name\":\"" + name + "\",\"age\":\"" + age + "\"}";

		ajaxOutput(response, result);

		// 这个少jar包
		// ajaxOutput(response, convert2Json(map));
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax传过来的参数
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "yanbin");
		map.put("age", "26");

		System.out.println("post");

		String result = "{\"name\":\"" + name + "\",\"age\":\"" + age + "\"}";

		String method = request.getParameter("method");

		if ("load".equals(method)) {
			System.out.println("load");
			this.getServletContext().getRequestDispatcher("/html/4_jq_ajax/4.0_jq_ajax.html").forward(request, response);
			return;
		}

		// ajaxOutput(response, convert2Json(map));
		ajaxOutput(response, result);

	}

	/**
	 * ajax输出
	 * 
	 * @param response
	 * @param output
	 */
	protected void ajaxOutput(HttpServletResponse response, String output) {
		try {
			PrintWriter out = response.getWriter();
			out.write(output);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将传入的java对象转换成JSON格式的String <br/>
	 * 利用JSON-lib.jar实现。<br/>
	 * 需要依赖包：commons-lang.jar ; commons-logging.jar; commons-collections.jar;
	 * ezmorph.jar; commons-beanutils.jar
	 * 
	 * @param object
	 * @return
	 */
	protected String convert2Json(Object object) {
		JSONArray jsonObject = JSONArray.fromObject(object);
		return jsonObject.toString();
	}

}
