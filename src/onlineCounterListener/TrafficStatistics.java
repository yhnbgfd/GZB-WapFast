package onlineCounterListener;

import util.JDBConnection;

public class TrafficStatistics {
	
	public void Statistics(String ip){
		if(ip.equals("127.0.0.1")){
			return;
		}else{
			JDBConnection db = new JDBConnection();
			db.executeUpdate("insert into T_TrafficStatistics(ip,time) values('"+ip+"',now())");
			db.closeConnection();
		}
	}
	
	public void Statistics(String ip,String user){
		if(ip.equals("127.0.0.1")){
			return;
		}else{
		    JDBConnection db = new JDBConnection();
		    db.executeUpdate("insert into T_TrafficStatistics(ip,time,user) values('"+ip+"',now(),'"+user+"')");
		    db.closeConnection();
		}
	}
}
