package com.code.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.user.doamin.Comment;
import com.code.user.service.CommentService;

@WebServlet("/addCommentServlet")
public class addCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf=8");
		response.setContentType("text/html;charset=utf-8");
		
		String table_name = request.getParameter("table_name");
		
		CommentService commentUservice = new CommentService();
		
		Comment comment = new Comment();
		comment.setName((String)request.getSession().getAttribute("name"));
		comment.setDay(request.getParameter("day"));
		comment.setContent(request.getParameter("content"));
		
		commentUservice.addComment(comment, table_name);
		
		request.getRequestDispatcher("/showCommentServlet").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}