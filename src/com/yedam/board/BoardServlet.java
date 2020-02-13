package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		BoardService service = new BoardServiceImpl();

		
		String bNo = request.getParameter("boardNo");  // jsp요청은 문자로 해야함
		int boardNo = Integer.parseInt(bNo);  // 여기서는 int로사용하게 때문에 
		// int boardNo = 1; // Integer.parseInt(bNo);  여기서는 int로사용하게 때문에 

		List<BoardDTO> replyList = service.getReplyList(boardNo);
		JSONArray replyAry=new JSONArray();
		for(BoardDTO reply:replyList) {
			JSONObject robj=new JSONObject();
			robj.put("rbNo", reply.getBoardNo());
			robj.put("rcont", reply.getContent());
			robj.put("rwrit", reply.getWriter());
			robj.put("rdate", reply.getCreationDate());
			robj.put("rpNo", reply.getParentNo());
			replyAry.add(robj);
		}
		service=new BoardServiceImpl();
		JSONObject obj=new JSONObject();
		BoardDTO brd=service.getBoard(boardNo);
		obj.put("bNo",brd.getBoardNo());
		obj.put("title",brd.getTitle());
		obj.put("content",brd.getContent());
		obj.put("writer",brd.getWriter());
		obj.put("cDate",brd.getCreationDate());
		obj.put("rList",replyAry);
		out.print(obj);
	}

}
