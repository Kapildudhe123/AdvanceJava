package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.model.StudnetModel;
@WebServlet("/StudentListCtl")
public class StudentListCtl  extends HttpServlet{
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudnetModel model=new StudnetModel();
try {
List list=	model.search(null, 1,8);
	
	req.setAttribute("list", list);
	
RequestDispatcher rd=	req.getRequestDispatcher("StudentListView.jsp");
	rd.forward(req, resp);
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
