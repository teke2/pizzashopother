package jp.tuyano;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class EditLinkDataServlet extends HttpServlet {
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
		String address = req.getParameter("address");
		String haitatsu = req.getParameter("haitatsu");
		String price = "1000";
		int price2 = Integer.parseInt(price);
		int count2 = Integer.parseInt(count);
		int price3 = 0;
		price3 = price2 * count2;
		price = Integer.toString(price3);
		String pay = req.getParameter("pay");
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		LinkData data = (LinkData) manager.getObjectById(LinkData.class, id);
		data.setTitle(title);
		data.setCount(count);
		data.setPrice(price);
		data.setAddress(address);
		data.setHaitatsu(haitatsu);
		data.setPay(pay);
		manager.close();
		resp.sendRedirect("/shopsdata.html");
	}
}