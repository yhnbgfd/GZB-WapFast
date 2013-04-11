package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetSMS extends HttpServlet{
	private static final long serialVersionUID = -1821138359137918728L;
	private final Log log = LogFactory.getLog(getClass()); 

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}
		try {
			this.get(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer("http://http.smstong.com/rx/?");
		sb.append("uid=141697");
		sb.append("&pwd=b6b9fac79ef653a01201a43832b1df93");

		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputline = in.readLine();

		System.out.println(inputline);
	}
}
