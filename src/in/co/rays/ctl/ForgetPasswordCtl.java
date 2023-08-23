package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/ForgetPasswordCtl")

public class ForgetPasswordCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("ForgetPasswordView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String loginId = req.getParameter("loginId");

		UserModel model = new UserModel();
		try {
			UserBean bean = model.findbylogin(loginId);
			if(bean!=null) {
				//UserBean bean = model.findbylogin(loginId);
			req.setAttribute("password", bean.getPassword());
			RequestDispatcher rd=req.getRequestDispatcher("ForgetPasswordView.jsp");
			rd.forward(req, resp);
			}else {
				//model.findbylogin(loginId);
				req.setAttribute("password", "invalid LoginId...!!!");
			
			RequestDispatcher rd=req.getRequestDispatcher("ForgetPasswordView.jsp");
			rd.forward(req, resp);
			
		}
		}
			catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
	

