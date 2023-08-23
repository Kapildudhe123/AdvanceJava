package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		if (id != null) {
			UserModel model = new UserModel();
			try {
				UserBean bean = model.findbypk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {

			resp.sendRedirect("UserRegistration.jsp");

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String id = req.getParameter("id");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (op.equals("SignUp")) {

			UserBean bean = new UserBean();
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassword(password);
			try {
				bean.setDob(sdf.parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			bean.setAddress(address);

			UserModel model = new UserModel();

			try {
				// bean = model.findbylogin(loginId);
				model.add(bean);
				if (bean != null) {

					req.setAttribute("msg", "User Register Successfully...!!!");

				} else {
					model.add(bean);
					// bean= model.findbylogin(loginId);
					req.setAttribute("msg", "User Aready Exist....!!!");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");

			rd.forward(req, resp);
		}

		if (op.equals("Reset")) {

			resp.sendRedirect("UserRegistration.jsp");

		}
		if (op.equals("List")) {
			resp.sendRedirect("UserListCtl");
		}
		if (op.equals("Update")) {

			UserBean bean = new UserBean();
			bean.setId(Integer.parseInt(id));
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassword(password);
			try {
				bean.setDob(sdf.parse(dob));
				bean.setAddress(address);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			UserModel model = new UserModel();
			try {
				model.update(bean);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bean = model.findbypk(bean.getId());
				req.setAttribute("bean", bean);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}