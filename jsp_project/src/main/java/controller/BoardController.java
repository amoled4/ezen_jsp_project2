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

import domain.BoardVO;
import domain.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// log 설정
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp; // 웹의 목적지 주소로 객체를 전달해주는 객체
	private BoardService bsv; // interface 구현체
	private int isOk; // DB의 insert, update, delete의 결과를 받는 변수
	private String destPage; // 목적지 주소를 저장해주는 변수

	private int bno;
	private String title;
	private String writer;
	private String regdate;
	private String content;
	private int readcount;
	private BoardVO bvo;
	private HttpSession ses;

	public BoardController() {
		bsv = new BoardServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// characterEncoding 설정 / contentType / uri
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 요청 경로(원하는 서비스) 컨트롤러 주소/요청 서비스
		String uri = request.getRequestURI();
		log.info(">>> uri : " + uri);
		// /mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path : " + path);

		switch (path) {
		case "register":
			destPage = "/board/register.jsp";
			break;

		case "insert":
			// 제목, 작성자, 글내용
			title = request.getParameter("title");
			writer = request.getParameter("writer");
			content = request.getParameter("content");
			bvo = new BoardVO(title, writer, content);

			isOk = bsv.insert(bvo);
			log.info(">>> 글작성 > " + (isOk > 0 ? "성공" : "실패"));
			destPage = "/brd/list";
			break;

		case "list":
			List<BoardVO> list = new ArrayList<BoardVO>();
			list = bsv.list();
			request.setAttribute("list", list);
			destPage = "/board/list.jsp";
			break;

		case "detail":
			bno = Integer.parseInt(request.getParameter("bno"));
			bvo = bsv.detail(bno);
			request.setAttribute("bvo", bvo);
			log.info("글내용 읽어옴");

			isOk = bsv.count(bno);
			log.info(">>> 조회수 업데이트 > " + (isOk > 0 ? "성공" : "실패"));
			destPage = "/board/detail.jsp";
			break;

		case "modify":
			bno = Integer.parseInt(request.getParameter("bno"));
			bvo = bsv.detail(bno);
			request.setAttribute("bvo", bvo);
			destPage = "/board/modify.jsp";
			break;

		case "edit":
			bvo = new BoardVO(Integer.parseInt(request.getParameter("bno")), request.getParameter("title"),
					request.getParameter("content"));

			isOk = bsv.edit(bvo);
			log.info(">>> 글수정 > " + (isOk > 0 ? "성공" : "실패"));

			destPage = "/brd/list";
			break;

		case "remove":
			bno = Integer.parseInt(request.getParameter("bno"));
			isOk = bsv.remove(bno);
			log.info(">>> 글삭제 > " + (isOk > 0 ? "성공" : "실패"));
			destPage = "/brd/list";
			break;

		}

		// 페이지 이동(서블릿으로 구현)
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
