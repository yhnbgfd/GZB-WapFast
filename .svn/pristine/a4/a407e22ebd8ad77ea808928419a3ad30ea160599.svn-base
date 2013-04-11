package onlineCounterListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineCounterListener implements HttpSessionListener {
	
    public void sessionCreated(HttpSessionEvent hse) {
    	OnlineCounter.raise();
    }
    public void sessionDestroyed(HttpSessionEvent hse) {
    	OnlineCounter.reduce();
    }
}
