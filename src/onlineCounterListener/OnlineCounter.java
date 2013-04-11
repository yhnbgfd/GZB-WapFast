package onlineCounterListener;

public class OnlineCounter {
	private static long online = 0;   

    public long getOnline() {
        return online;
    }    
    public static void raise(){
        online++;
//        JDBConnection db = new JDBConnection();
//        db.executeUpdate("insert into T_TrafficStatistics(data) values(now())");
//        db.closeConnection();
    } 
    public static void reduce(){
        online--;
    }

}
