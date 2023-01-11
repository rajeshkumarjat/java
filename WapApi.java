package URL;

import java.net.URL;
import java.util.Scanner;
import java.net.*;
import java.lang.*;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class WapApi {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.thingspeak.com/channels/875453/feeds.json?api_key=1DSQ7R1XTT1OK0Z1&results=20");
        Scanner sc = new Scanner(url.openStream());
        String str = "";
        while(sc.hasNextLine()){
            str+=sc.nextLine();
        }
    //System.out.println(str);
      JSONParser jp = new JSONParser();
      JSONObject obj = (JSONObject)jp.parse(str);
      JSONObject obj1 = (JSONObject)obj.get("channel");
      System.out.println("id: "+obj1.get("id"));
      System.out.println("name: "+obj1.get("name"));
      JSONArray arr = (JSONArray)obj.get("feeds");
      for(int i=0;i<arr.size();i++){
        JSONObject obj2 = (JSONObject)arr.get(i);
        System.out.println("field1: "+obj2.get("field1"));
      }
        } catch (Exception e) {
            // TODO: handle exception
        }
        }
}
