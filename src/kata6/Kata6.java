package kata6;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;

/**
 *
 * @author Guillermo
 */
public class Kata6 {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://jsonplaceholder.typicode.com/posts");
        //Establecemos la connexión
        HttpURLConnection cx = (HttpURLConnection) url.openConnection();
        cx.setRequestMethod("GET");

        InputStream strmContenido = cx.getInputStream();
        byte[] contStream = strmContenido.readAllBytes();

        String json = "";

        for (byte tmp : contStream) {
            json += (char) tmp;
        }

        JSONArray jsonarr = new JSONArray(json);
        ArrayList<Post> posts = new ArrayList<>();
        for (Object object : jsonarr) {
            posts.add(new Post((Integer)((JSONObject)object).get("userId"),(Integer) ((JSONObject)object).get("id"),((JSONObject)object).get("title").toString(),((JSONObject)object).get("body").toString()));
        }
        
        for (Post post : posts) {
            System.out.println(post);
        }
    }
}
