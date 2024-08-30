package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}else {
			CustomerBean cb=new CustomerBean();
			cb.setuName(req.getParameter("uname"));
			cb.setpWord(req.getParameter("pword"));
			cb.setfName(req.getParameter("fname"));
			cb.setlName(req.getParameter("lname"));
			cb.setAddr(req.getParameter("addr"));
			cb.setmId(req.getParameter("mid"));
			cb.setPhno(Long.parseLong(req.getParameter("phno")));
			int k=new RegisterDAO().register(cb);
			if(k>0) {
				req.setAttribute("msg", "Register successfully..<br>");
				
			}
			RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
			rd.forward(req, res);
		}
	}

}



