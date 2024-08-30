package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")

public class DeleteBookDetailsServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
		req.setAttribute("msg", "Session Expired...<br>");
		req.getRequestDispatcher("Home.jsp").forward(req, res);
	}else {
		String bCode=req.getParameter("bcode");
		ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("alist");
		BookBean bb=null;
		Iterator<BookBean> it=al.iterator();
		while(it.hasNext()) {
			bb=it.next();
			if(bCode.equals(bb.getCode())) {
				break;
			}
		}
		int k=new DeleteBookDetailsDAO().delete(bb);
		if(k>0) {
		req.setAttribute("msg", "Book details deleted successfully...<br>");
		req.getRequestDispatcher("DeleteBookDetails.jsp").forward(req, res);
	}

	}
}
}
