package Main;
import com.google.gson.*;
public class FromJson {

	  public static void main(String[] args){
		  

	        Menu m = new Gson().fromJson("{\"menuname\":\"ºìÉÕÈâ\",\"taste\":\"ÏÌÌğ\",\"tag\":\"ÖØ¿Ú\"}", Menu.class);
	        System.out.println(m.getName());
	        System.out.println(m.getTaste());
	        System.out.println(m.getTag());
	 
	    }


}
