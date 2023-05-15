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
import javax.servlet.http.HttpSession;

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
			
		case "login":         // 로그인 페이지로 이동
			log.info(">>> login page로 이동");
			destPage = "/member/login.jsp";
			break;
			
		case "login_auth":   // 실제 로그인이 일어나는 케이스
			try {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				MemberVO mvo2 = new MemberVO(id, pw);
				// 해당 id, password가 DB상에 있는지 체크
				// 해당 객체(사용자)를 가져와서
				// 해당 객체(사용자)를 세션에 담기
				log.info(">>> login 요청" +mvo2);
				MemberVO loginMvo = msv.login(mvo2);
				// 같은 정보가 있으면 객체를 리턴, 없다면 null이 리턴
				// 객체가 있다면 세션에 저장
				if(loginMvo != null) {
					// 세션 가져오기, 연결된 세션이 없다면 새로 생성
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					// 로그인 유지 시간(초단위)
					ses.setMaxInactiveInterval(10*60);
					System.out.println(loginMvo);
				} else {
					request.setAttribute("msg_login", 0);	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage="/";
			break;
			
		case "logout":
			try {
				// 세션 가져오기 (연결된 세션)
				HttpSession ses = request.getSession();
				// 마지막 로그인 시간 기록
				MemberVO mvo2 = (MemberVO)ses.getAttribute("ses");
				String id = mvo2.getMid();
				log.info(">>> 로그인 아이디 : "+id);
				// 로그인정보(id)를 주고 마지막 로그인 시간 기록(update)
				isOk = msv.lastLogin(id);
				log.info(">>> 로그아웃 > "+(isOk>0 ? "성공":"실패"));
				ses.invalidate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage="/";
			break;
			
		case "list":
			List<MemberVO> list = new ArrayList<MemberVO>();
			list = msv.list();
			request.setAttribute("list", list);
			destPage = "/member/list.jsp";
			break;
			
		case "modify":
			destPage = "/member/modify.jsp";
			HttpSession ses = request.getSession();
			MemberVO mvo2 = (MemberVO)ses.getAttribute("ses");
			
			request.setAttribute("mvo", msv.modify(mvo2));
			log.info(">>> 회원정보 읽어옴");
			break;
			
		case "edit":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			MemberVO mvoEdit = new MemberVO(id, pw, phone, email);
			
			int isOk = msv.edit(mvoEdit);
			System.out.println(">>> 정보수정 > "+(isOk > 0 ? "성공":"실패"));
			
			destPage = "/";
			break;
			
		case "detail":
			destPage = "/member/modify.jsp";
			String id2 = request.getParameter("mid");
			MemberVO mvoDt = new MemberVO(id2);
			
			request.setAttribute("mvo", msv.modify(mvoDt));
			break;
			
		case "delete":
			try {
				String delId = request.getParameter("mid");
				MemberVO mvo3 = new MemberVO(delId);
				isOk = msv.delete(mvo3);
				log.info(">>> 회원탈퇴 > "+(isOk>0 ? "성공":"실패"));
				
				HttpSession ses2 = request.getSession();
				MemberVO mvo4 = (MemberVO)ses2.getAttribute("ses");
				
				if(isOk > 0 && delId.equals(mvo4.getMid())) {
					ses2.invalidate();
				}else {
					request.setAttribute("msg_delete", 0);	
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage="/";
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
