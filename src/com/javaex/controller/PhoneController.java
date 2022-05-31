package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;

/**
 * Servlet implementation class PhoneController
 */
@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	
	

	//필드
	private static final long serialVersionUID = 1L;
	//생성자 (기본생성자 사용)

	//메소드gs

	//메소드일반
	//get방식으로 요청 시 호출 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//코드작성
		String action = request.getParameter("action");
		
		if("list".equals(action)) {
			//데이터 가져오기
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> phoneList = phoneDao.getPersonList();
			System.out.println(phoneList);
			
			//request에 데이터 추가
			request.setAttribute("pList", phoneList);
			
			//데이터 + html 섞기 --> jsp로 포워딩
			//WebUtil webUtil = new WebUtil();
			WebUtil.forward(request, response, "./WEB-INF/list.jsp");
			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./list.jsp");
			rd.forward(request, response);
			*/
		} else if("writeForm".equals(action)) {
			System.out.println("등록폼");
			
			//포워드
			WebUtil.forward(request, response, "./WEB-INF/writeForm.jsp");
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./writeForm.jsp");
			rd.forward(request, response);
			*/
		}else if("write".equals(action)) { //등록일 때
			//파라미터에서 값 꺼내기
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//VO만들어서 초기화
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo);
			
			
			//Vo로 저장하기
			PhoneDao phoneDao = new PhoneDao();
			int count = phoneDao.personInsert(personVo);
			System.out.println(count);
			
			//포워드말고 리다이렉트 list
			/*
			aaaaRequestDispatcher rd = request.getRequestDispatcher("./list.jsp");
			rd.forward(request, response);
			*/
			//webUtil.redirect(request, response, "/phonebook2/pbc?action=list");
			
			
			//WebUtil webUtil = new WebUtil();
			WebUtil.redirect(request, response, "/phonebook2/WEB-INF/pbc?action=list");
			
			//response.sendRedirect("/phonebook2/pbc?action=list");
			
			
		}else if("delete".equals(action)){
			int personid = Integer.parseInt(request.getParameter("personid"));
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personDelete(personid);
			
			//리스트로 리다이렉트
			WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
			//response.sendRedirect("/phonebook2/pbc?action=list");
			
		}else if("updateForm".equals(action)) {
			//포워드 업데이트폼
			System.out.println("업데이트폼");
			
			int personid = Integer.parseInt(request.getParameter("personid"));
			PhoneDao phoneDao = new PhoneDao();
			PersonVo personVo = phoneDao.getPerson(personid);
			request.setAttribute("personVo", personVo);
			
			WebUtil.forward(request, response, "./WEB-INF/updateForm.jsp");
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./updateForm.jsp");
			rd.forward(request, response);
			*/
			
		}else if("update".equals(action)) {
			PhoneDao phoneDao = new PhoneDao();
			int personid = Integer.parseInt(request.getParameter("personid"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVo personVo = new PersonVo(personid, name, hp, company);
			
			phoneDao.personUpdate(personVo);
			
			WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
		}else {
			System.out.println("action 파라미터 없음");
		}
		
		
	}

	//post방식으로 요청 시 호출 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
