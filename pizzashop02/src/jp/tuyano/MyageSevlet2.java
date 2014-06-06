package jp.tuyano;

import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MyageSevlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		String param1 = req.getParameter("id");
		PrintWriter out = resp.getWriter();

		List<LinkData2> list2 = null;
		if (param1 == null || param1 == "") {

			String query2 = "select from " + LinkData2.class.getName();
			try {

				list2 = (List<LinkData2>) manager.newQuery(query2).execute();
			} catch (JDOObjectNotFoundException e) {
			}
		} else {
			try {

				LinkData2 data2 = (LinkData2) manager.getObjectById(
						LinkData2.class, Long.parseLong(param1));

				list2 = new ArrayList();

				list2.add(data2);
			} catch (JDOObjectNotFoundException e) {
			}
		}

		String res2 = "[";
		if (list2 != null) {
			for (LinkData2 data2 : list2) {
				res2 += "{id:" + data2.getId() + ",count:'" + data2.getCount()
						+ "',title:'" + data2.getTitle() + "',date:'"
						+ data2.getDatetime() + "',eat:'" + data2.getEat()
						+ "',phone:'" + data2.getPhone() + "',time:'"
						+ data2.getTime() + "',price:'" + data2.getPrice()
						+ "'},";
			}
		}

		res2 += "]";

		out.println(res2);
		manager.close();
	}
}