package kata6;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import javax.xml.bind.*;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
/**
 *
 * @author Guillermo
 */
public class Kata6 {
    private static ArrayList<Post> posts;
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
        posts = new ArrayList<>();
        for (Object object : jsonarr) {
            posts.add(new Post((Integer)((JSONObject)object).get("userId"),(Integer) ((JSONObject)object).get("id"),((JSONObject)object).get("title").toString(),((JSONObject)object).get("body").toString()));
        }
        //Visualizamos los resultados
        for (Post post : posts) {
            System.out.println(post);
        }
        
        //Serealizamos 
        Serializarlo();
        
        //Serealizarmos a XML 
        XML();
        
    }
 
    public static void Serializarlo(){
        //Para este ejemplo cogemos el primer objecto de nuestro array y lo serializamos
        Gson gson = new Gson();
        String jsonS = "{'userId':99,'id':99,'title':'Serializarlo Title','body':'Serializarlo Body'}";
        Post post = gson.fromJson(jsonS, Post.class);
        System.out.println("Objecto Serializado "+post);
    }
    
    public static void XML() throws JAXBException{
        Post postXML = new Post(888,888,"postXML Title","postXML Body");
        
        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance( Post.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal( postXML, new File( "post.xml" ) );
        jaxbMarshaller.marshal( postXML, System.out );
    }
    
    
}
