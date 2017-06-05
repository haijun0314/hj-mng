package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jxjz.common.util.JsonUtil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonTest {
    private static JsonGenerator jsonGenerator = null;

    private static ObjectMapper objectMapper =  new ObjectMapper();;

    private static AccountBean bean = null;

    
	public static void main(String[] args) {
	    try {
	    	init();
	    	String  json="";
//	    	jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
//	        jsonGenerator.writeObject(bean);    
	    	json= objectMapper.writeValueAsString(bean);
	        System.out.println(json);
	        Map map=objectMapper.readValue(json, Map.class);
	        System.out.println(map);
	        
	        ArrayList  list=new ArrayList();
	        list.add(init1());
	        list.add(init1());
	        list.add(init1());
	        json= objectMapper.writeValueAsString(list);
	        System.out.println(json);
	        
	        JavaType javaType = JsonUtil.getCollectionType(ArrayList.class, AccountBean.class); 
	        List<AccountBean> lst =  (List<AccountBean>)objectMapper.readValue(json, javaType); 
	        System.out.println(json);
	        
	    } catch (IOException e) {
	        e.printStackTrace();

	    }
		
	}   
    
    
    
    public static AccountBean init1() {

    	AccountBean  bean = new AccountBean();
        bean.setAddress("jjjjjjjjjj");
        bean.setEmail("tttttttttt");
        bean.setId(555);
        bean.setName("ggggggggggggggg");
        
        return bean;
        
        
    }   
    
    
    public static void init() {

        bean = new AccountBean();
        bean.setAddress("china-Guangzhou");
        bean.setEmail("hoojo_@126.com");
        bean.setId(1);
        bean.setName("hoojo");
    }

    public static class AccountBean {

        private int id;

        private String name;

        private String email;

        private String address;
 

        public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}

    }   
 

}
