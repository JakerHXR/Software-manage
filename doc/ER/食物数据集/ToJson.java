package Main;
import com.google.gson.*;
public class ToJson {

	public static void main(String[] args){
		 
        
        Menu m1 = new Menu();
        m1.setName("ºìÉÕÈâ");
        m1.setTaste("ÏÌÌğ");
        m1.setTag("ÖØ¿Ú");
   
        String json = new Gson().toJson(m1);
    
        System.out.println(json);
 
    }


}
