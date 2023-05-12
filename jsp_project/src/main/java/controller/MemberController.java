package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberServiceImpl;
import service.MemverService;


@WebServlet("/mem/*")  // 어노테이션
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// log 설정
	//private static final Logger log = LoggerFactory.getLogger(클래스명);
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private MemverService msv;
	private int isOk;
	private String destPage;
  
    public MemberController() {
        msv = new MemberServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// characterEncoding 설정 / contentType / uri
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();        // 요청 경로(원하는 서비스) 컨트롤러 주소/요청 서비스
		log.info(">>> uri : "+uri);
		// /mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : "+path);
		
		switch(path) {
		case "join":
			destPage="/member/join.jsp";
			break;
		case "register":
			// jsp에서 가져온 파라미터 저장
			String mid = request.getParameter("id");
			String mpw = request.getParameter("pw");
			String mname = request.getParameter("name");
			String mphone = request.getParameter("phone");
			String memail = request.getParameter("email");
			
			// 파라미터로 mvo 객체 생성
			MemberVO mvo = new MemberVO(mid, mpw, mname, mphone, memail);
			isOk = msv.register(mvo);
			log.info(">>> 회원가입 > "+(isOk>0 ? "성공":"실패"));
			destPage = "/";   // index 페이지로 이동
			break;
			
		case "list":
			List<MemberVO> list = new ArrayList<MemberVO>();
			list = msv.list();
			request.setAttribute("list", list);
			destPage = "/member/list.jsp";
			break;
		}
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
