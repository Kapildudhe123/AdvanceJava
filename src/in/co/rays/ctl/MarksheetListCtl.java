package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

@WebServlet("/MarksheetListCtl")
public class MarksheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageNo = 1;
		int pageSize = 5;
		MarksheetModel model = new MarksheetModel();

		try {
			List list = (List) model.Search(null, pageNo, pageSize);
			List nextlist = model.Search(null, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("nextListSize", nextlist.size());
			RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");

			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		
		int pageNo = Integer.parseInt(req.getParameter("pageNo"));

		 int pageSize = 5;
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		if (op.equals("search")) {
			//int pageNo = Integer.parseInt(req.getParameter("pageNo"));

			String name = req.getParameter("name");
			bean.setName(name);
		}
		if (op.equals("next")) {
			pageNo++;

		}
		if (op.equals("previous")) {
			pageNo--;
		}if (op.equals("delete")) {
			pageNo=1;
		String [] ids  =	req.getParameterValues("ids");
		for (String id : ids) {
			
		try {
			model.delete(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}
		}

		try {
			List list = model.Search(bean, pageNo, pageSize);
			List nextlist = (List) model.Search(null, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("nextListSize", nextlist.size());
			RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
