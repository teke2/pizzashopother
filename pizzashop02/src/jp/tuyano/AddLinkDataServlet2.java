package jp.tuyano;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddLinkDataServlet2 extends HttpServlet {
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
		String title = req.getParameter("title");
		String count = req.getParameter("count");
		String day = req.getParameter("day");
		String time1 = req.getParameter("time");
		String time = day + " " + time1;
		String ad1 = req.getParameter("eat");
		String ad2 = req.getParameter("eat2");
		if (ad1.equals("お店でたべる")) {
			if (ad2.equals("1"))
				ad2 = "1人";
			else if (ad2.equals("2"))
				ad2 = "2人";
			else if (ad2.equals("3"))
				ad2 = "3人";
			else if (ad2.equals("4"))
				ad2 = "4人";
			else if (ad2.equals("5"))
				ad2 = "5人";
			else if (ad2.equals("6"))
				ad2 = "6人";
			else if (ad2.equals("7"))
				ad2 = "7人";
			else if (ad2.equals("8"))
				ad2 = "8人";
			else if (ad2.equals("9"))
				ad2 = "9人";
			else if (ad2.equals("10"))
				ad2 = "10人";
		}
		if (ad1.equals("テイクアウト")) {
			ad2 = "×";
		}
		String ad = ad1 + " / " + ad2;
		Date date = Calendar.getInstance().getTime();
		String price = req.getParameter("price");
		String phone = req.getParameter("phone");
		int price2 = Integer.parseInt(price);
		int count2 = Integer.parseInt(count);
		int price3 = 0;
		price3 = price2 * count2;
		price = Integer.toString(price3);
		LinkData2 data2 = new LinkData2(title, count, ad, date, price, phone,
				time);
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		try {
			manager.makePersistent(data2);
		} finally {
			manager.close();
		}
		resp.sendRedirect("/finish.html");
	}
}