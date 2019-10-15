import java.util.ArrayList;
import java.util.Random;

public class Password {
	
	public static String getpasswd() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        
        StringBuilder sb = new StringBuilder();
        
        Random rnd = new Random();
        
        while (sb.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());
            sb.append(characters.charAt(index));
        }
        String passwd = sb.toString();
        return passwd;

    }


}
