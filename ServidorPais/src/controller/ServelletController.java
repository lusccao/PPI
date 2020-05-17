package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import dao.ConnectionFactory;

@WebServlet("/controller.do")
public class ServelletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileWriter logRequest;

	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Começo de criação de LOG
			logRequest = new FileWriter(new File("/home/lucasarthur/Documentos/logreq"), true);
			request.setCharacterEncoding("UTF-8");
			logRequest.append("\n" + Calendar.getInstance().getTime() + " Chegou uma requisição de: " + request.getParameter("command"));
			logRequest.flush();
			//Fim de criaçãõ de LOG
			Command comando = (Command)Class.forName("command."+request.getParameter("command")).newInstance();
			comando.executar(request, response);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request,response);
	}
	
	@Override
	public void init(){
		try {
			ConnectionFactory.obtemConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy(){
		try {
			ConnectionFactory.fecharConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
