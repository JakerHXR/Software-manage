package Main;
import com.google.gson.*;
public class ToJson {

	public static void main(String[] args){
		 
        
        Menu m1 = new Menu();
        m1.setName("������");
        m1.setTaste("����");
        m1.setTag("�ؿ�");
   
        String json = new Gson().toJson(m1);
    
        System.out.println(json);
 
    }


}
