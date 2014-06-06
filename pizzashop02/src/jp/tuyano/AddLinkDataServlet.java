package jp.tuyano;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddLinkDataServlet extends HttpServlet {
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
		String count = req.getParameter("count"); // 変更
		String ad3 = req.getParameter("address");
		String ad1 = req.getParameter("address1");
		String ad2 = req.getParameter("address2");
		if (ad1.equals("東京都")) {
			if (ad2.equals("1"))
				ad2 = "小平市";
			else if (ad2.equals("2"))
				ad2 = "国分寺市";
			else if (ad2.equals("3"))
				ad2 = "世田谷区";
			else if (ad2.equals("4"))
				ad2 = "江東区";
			else if (ad2.equals("5"))
				ad2 = "江戸川区";
			else if (ad2.equals("6"))
				ad2 = "豊島区";
		}
		if (ad1.equals("神奈川県")) {
			if (ad2.equals("1"))
				ad2 = "横浜市";
			else if (ad2.equals("2"))
				ad2 = "川崎市";
			else if (ad2.equals("3"))
				ad2 = "相模原市";
			else if (ad2.equals("4"))
				ad2 = "小田原市";
			else if (ad2.equals("5"))
				ad2 = "横須賀市";
			else if (ad2.equals("6"))
				ad2 = "箱根町";
		}
		if (ad1.equals("香川県")) {
			if (ad2.equals("1"))
				ad2 = "高松市";
			else if (ad2.equals("2"))
				ad2 = "丸亀市";
			else if (ad2.equals("3"))
				ad2 = "坂出市";
			else if (ad2.equals("4"))
				ad2 = "観音寺市";
			else if (ad2.equals("5"))
				ad2 = "三豊市";
			else if (ad2.equals("6"))
				ad2 = "満濃町";
		}

		String address = ad1 + ad2 + ad3;
		Date date = Calendar.getInstance().getTime();
		String price = req.getParameter("price");
		String phone = req.getParameter("phone");
		String haitatsu = "×";
		int price2 = Integer.parseInt(price);
		int count2 = Integer.parseInt(count);
		int price3 = 0;
		price3 = price2 * count2;
		price = Integer.toString(price3);
		String pay = req.getParameter("pay");
		LinkData data = new LinkData(title, count, address, date, price, phone,
				haitatsu, pay);
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		try {
			manager.makePersistent(data);
		} finally {
			manager.close();
		}
		resp.sendRedirect("/finish.html");
	}
}