package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			MarksheetModel model = new MarksheetModel();
			try {
				MarksheetBean bean = model.findbypk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateMarksheet.jsp");

				rd.forward(req, resp);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int roll_no = Integer.parseInt(req.getParameter("rollNo"));
		int physisc = Integer.parseInt(req.getParameter("physisc"));
		int chemistry = Integer.parseInt(req.getParameter("chemistry"));
		int maths = Integer.parseInt(req.getParameter("maths"));

		if (op.equals("SignUp")) {

			MarksheetBean bean = new MarksheetBean();
			// bean.setId();
			bean.setName(name);
			bean.setRollNo(roll_no);
			bean.setPhysisc(physisc);
			bean.setChemistry(chemistry);
			bean.setMaths(maths);

			MarksheetModel model = new MarksheetModel();
			try {
				model.add(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			req.setAttribute("msg", "success");

			RequestDispatcher rd = req.getRequestDispatcher("Marksheet.jsp");
			rd.forward(req, resp);
		}

		if (op.equals("Reset")) {

			resp.sendRedirect("Marksheet.jsp");
		}
		if (op.equals("List")) {
			resp.sendRedirect("MarksheetListCtl");
		}
		if (op.equals("Update")) {

			MarksheetBean bean = new MarksheetBean();
			bean.setId(id);
			bean.setName(name);
			bean.setRollNo(roll_no);
			bean.setPhysisc(physisc);
			bean.setChemistry(chemistry);
			bean.setMaths(maths);

			MarksheetModel model = new MarksheetModel();
			try {
				model.update(bean);

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				bean=	model.findbypk(id);

					req.setAttribute("bean", bean);
					RequestDispatcher rd = req.getRequestDispatcher("UpdateMarksheet.jsp");
					rd.forward(req, resp);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}
	}


