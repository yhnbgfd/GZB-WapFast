package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendSMS {
	private final Log log = LogFactory.getLog(getClass()); 
	
	public boolean sendSMS(String content, String mobilePhones, String priority/*优先级*/,String messageFlag, String moduleName, String exNumber){
		String strURL = "http://http.smstong.com/tx/?uid=141697&pwd=b6b9fac79ef653a01201a43832b1df93";
		String response = "";
		boolean success = false;
		
		RandomNumber rn = new RandomNumber();
		messageFlag = String.valueOf(rn.RandomNumbers(3));
		
        try {
    		strURL += "&mobile=" + mobilePhones
    				+"&content=" + java.net.URLEncoder.encode(content, "GBK");
    		
            URL objURL = new URL(strURL);
            URLConnection objConn = objURL.openConnection();
            objConn.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    objConn.getInputStream()));
            String line = br.readLine();
            while (line != null) {
                response += line;
                line = br.readLine();
            }
            br.close();
            success = true;
            log.warn("### send sms: "+strURL+" and the result is :"+response+" ");
        } catch (Exception e) {
        	success = false;
        	log.error(e.getMessage());
        }
        return success;
	}
}