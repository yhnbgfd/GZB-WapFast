package util;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {
	/**
	 * 前台
	 * 输入String类型的json数据串，返回干净的数据并在每行结尾添加<br />
	 * @param str String类型的json数据串
	 * @return
	 * @throws JSONException
	 */
	public String get(String str) throws JSONException{
//		JSONObject json = new JSONObject(str);
		String strjson = "";
//		Iterator<?> objkey=json.keys();  
//		while (objkey.hasNext()) {// 遍历JSONObject   
//			String aa2 = (String) objkey.next().toString();   
//			String bb2 = json.getString(aa2);         
//			strjson += aa2+":"+bb2+"<br />";
//		}
		str = str.replaceAll("\\{", "");
		str = str.replaceAll("\\}", "");
		str = str.replaceAll("\\\"", "");
		str = str.replaceAll("&;", "<br />");
		str = str.replaceAll("\\;", "<br />");
		strjson = str.replaceAll("&:", ":");
		return strjson;
	}
	/**
	 * 后台
	 * 第一次的str最好是 String str = "";
	 * 整合成json格式的字符串
	 * @param str 整合成json格式的字符串
	 * @param key 关键字
	 * @param value 值
	 * @return
	 * @throws JSONException
	 */
	public String put(String str,String key,String value) throws JSONException{
		StringBuffer bf = new StringBuffer(str);
		if(str.equals("")){
//			bf.append("{");
		}else{
			bf.append("&;");
		}
		bf.append(key + "&:" + value);
		return bf.toString();
	}
}
