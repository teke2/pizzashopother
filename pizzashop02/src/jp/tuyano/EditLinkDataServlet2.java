package jp.tuyano;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class EditLinkDataServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("no url...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		long id = Long.parseLong(req.getParameter("id"));
		String title = req.getParameter("title");
		String count = req.getParameter("count");
		String eat = req.getParameter("eat");
		String time = req.getParameter("time");
		String price = "1000";
		int price2 = Integer.parseInt(price);
		int count2 = Integer.parseInt(count);
		int price3 = 0;
		price3 = price2 * count2;
		price = Integer.toString(price3);
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		LinkData2 data2 = (LinkData2) manager
				.getObjectById(LinkData2.class, id);
		data2.setTitle(title);
		data2.setCount(count);
		data2.setPrice(price);
		data2.setEat(eat);
		data2.setTime(time);
		manager.close();
		resp.sendRedirect("/shopsdata2.html");
	}
}