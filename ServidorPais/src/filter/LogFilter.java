package filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;

@WebFilter("/*")
public class LogFilter implements Filter {
	FileWriter logRequest;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("logado");
		logRequest = new FileWriter(new File("/home/lucasarthur/Documentos/logreq"), true);
		request.setCharacterEncoding("UTF-8");
		if(usuario == null){
			logRequest.append("\n" + Calendar.getInstance().getTime() + " Chegou uma requisição de: " + req.getParameter("command"));
			logRequest.flush();
		} else {
			logRequest.append("\n" + Calendar.getInstance().getTime() + " Chegou uma requisição de: " + usuario.getUsername()+ " -> " + req.getParameter("command"));
			logRequest.flush();
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
		if(usuario == null){
			logRequest.append("\n" + Calendar.getInstance().getTime() + " Chegou uma requisição de: " + req.getParameter("command"));
			logRequest.flush();
		} else {
			
			logRequest.append("\n" + Calendar.getInstance().getTime() + " Chegou uma requisição de: " + req.getParameter("command")+" -> " + usuario.getUsername());
			logRequest.flush();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
