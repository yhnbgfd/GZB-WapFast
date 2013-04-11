package servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SMSReport extends HttpServlet {
	private static final long serialVersionUID = 784318064598055413L;
	private final Log log = LogFactory.getLog(getClass()); 

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}
		this.receiveReport(request, response);
	}
	
	
	private void receiveReport(HttpServletRequest request, HttpServletResponse response){
		String Status = request.getParameter("Status");
		String MessageFlag = request.getParameter("MessageFlag");
		log.warn("### Get a SMS report : status="+Status+" & MessageFlag="+MessageFlag);
	}
}
