package json;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JSONUtils {
	private static final Logger log = Logger.getLogger(JSONUtils.class);
//	private static JSONObject jsonObject = getJSONObject();
	private static JsonConfig jsonConfig = getJSONConfig();
	private static Gson gson = getGsonInst();
	private static Gson gsonNotDatetime = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().disableHtmlEscaping().create();
	

	public static String toJson(Object object){
//		return JSONObject.fromObject(object, jsonConfig).toString();
		return JSONArray.fromObject(object, jsonConfig).toString();
	}
	public static String toJsonByGson(Object object){
		String json = gson.toJson(object);
		/*byte[] buf = json.getBytes();
		log.debug("toJsonByGson()");
		for (int i = 0; i < buf.length; i++) {
			if (buf[i]==13) {
				log.debug("fuck");
				buf[i] = 0;
			}
			
		}*/
		//char chr1 = 13;
		//char chr2 = 0;
		json = json.replace("\\r", "");
		json = json.replace("\\n", "");
		json = json.replace("\\r\\n", "");
		json = json.replace("\\t", "");
		//json = json.replaceAll("\\r", "");
		//log.debug("b2b执行对象转json方法-->"+json);
		return json;
	}
	public static String toJsonByGsonNotDatetime(Object object){
		String json = gsonNotDatetime.toJson(object);
		/*byte[] buf = json.getBytes();
		log.debug("toJsonByGson()");
		for (int i = 0; i < buf.length; i++) {
			if (buf[i]==13) {
				log.debug("fuck");
				buf[i] = 0;
			}
			
		}*/
		//char chr1 = 13;
		//char chr2 = 0;
		json = json.replace("\\r", "");
		json = json.replace("\\n", "");
		json = json.replace("\\r\\n", "");
		json = json.replace("\\t", "");
		//json = json.replaceAll("\\r", "");
		//log.debug("b2b执行对象转json方法-->"+json);
		return json;
	}
	
	public static Object jsonToObjectByGsonNotDatetime(String json, Class<?> clazz){
		
		return gsonNotDatetime.fromJson(json, clazz);
	}
	
	public static Object jsonToObjectByGson(String json, Class<?> clazz){
		
		return gson.fromJson(json, clazz);
	}
	
	private static JsonConfig getJSONConfig(){
		jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return jsonConfig;  
		
	}
	
	private static Gson getGsonInst(){
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().disableHtmlEscaping().create();
		log.debug("初始化Gson对象OK");
		return gson; 
		
	}
	
	

}

class JsonDateValueProcessor implements JsonValueProcessor {  
    private String format ="yyyy-MM-dd HH:mm:ss";  
      
    public JsonDateValueProcessor() {  
        super();  
    }  
      
    public JsonDateValueProcessor(String format) {  
        super();  
        this.format = format;  
    }  
  
    public Object processArrayValue(Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return null;  
    }  
  
    public Object processObjectValue(String paramString, Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
      
      
    private Object process(Object value){  
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format);    
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    }  
  
}

