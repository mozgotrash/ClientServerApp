import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class JsonCreator {

    static StringBuilder resilt = null;

    public JsonCreator(){
        resilt = new StringBuilder();
        resilt.append("{ ");

    }
    public  String createJson(HashMap<ArrayList<String>, String> data){
        Set<ArrayList<String>> keys = data.keySet();
        int length = keys.toArray().length;
        int k = 0;
        for(ArrayList<String> list : keys){
            String type = list.get(0);
            String name = list.get(1);
            resilt.append("\"");
            resilt.append(name);
            resilt.append("\"");
            resilt.append(" : ");

            if(type.equals("String")){
                resilt.append("\"");
                resilt.append(data.get(list));
                resilt.append("\"");
            }

            if(type.equals("Integer")){
                resilt.append(data.get(list));
                resilt.append(" ");
            }

            if(k + 1 < length){
                resilt.append(", ");
            }
            k++;
        }
        resilt.append(" }");
        return resilt.toString();
    }


}
