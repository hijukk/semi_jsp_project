package test.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.TravelDAO;
import test.com.model.TravelDAOImpl;
import test.com.model.TravelVO;

/**
 * Servlet implementation class JLoginController
 */
@WebServlet({ "/JLoginOK.do", "/jLogout.do" })
public class JLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TravelDAO dao = new TravelDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
		if (sPath.compareTo("/jLogout.do") == 0) {
			request.getSession().removeAttribute("session_id");

			response.sendRedirect("index.do");
		}

	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sPath = request.getServletPath();
		System.out.println("sPath:" + sPath);
		doGet(request, response);

		if (sPath.compareTo("/JLoginOK.do") == 0) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println("id: " + id);
			System.out.println("pw: " + pw);

			TravelVO vo = new TravelVO();
			vo.setId(id);
			vo.setPw(pw);
			
			TravelVO vo2 = dao.jLogin(vo);
			System.out.println("jLoginController: " + vo2);
			
			if(vo2.getId() != null) {
				System.out.println("login successed..");
				
				request.getSession().setAttribute("session_id", id);//성공했을때 아이디 줄수있음
				request.getSession().setMaxInactiveInterval(60);
			}else {
				System.out.println("login failed..");
			}

			response.sendRedirect("index.do");
					
		}
	}

}
