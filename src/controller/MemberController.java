package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String idSave = request.getParameter("idSave");
		System.out.println("idSave:"+idSave);
		
		//if문 표현할때 null주의 !
		if(idSave != null && idSave.equals("on")) {
			System.out.println("아이디 쿠키 저장");
			Cookie cookie1 = new Cookie("userId", email);
			cookie1.setMaxAge(60);
			Cookie cookie2 = new Cookie("userPw", email);
			cookie2.setMaxAge(60);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
