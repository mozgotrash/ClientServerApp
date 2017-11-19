package clientserverapp.json;

import java.util.HashMap;

public class JsonEncoder {
    public  void createJson(Object obj) {
        HashMap<String, Type> data = new ObjectAnalyzer().analyzeFields(obj);
        JsonCreator creator = new JsonCreator();
        System.out.println(creator.createJson(data, obj));
    }

    public static void main(String[] str){
        JsonEncoder je = new JsonEncoder();
//        je.createJson(new clientserverapp.json.Outer(10, "Hello", new Double(18), new clientserverapp.json.Inner("clientserverapp.json.Inner here", 11)));
        double[] arrlong = {1, 2, 5};
        String[] stringArray = {"fnjdks", "nfjdkal"};
        Inner in = new Inner("clientserverapp.json.Inner here", 11, arrlong);
        Outer out = new Outer(10, "clientserverapp.json.Outer here", 9.0, in);

        je.createJson(out);
    }

}



class Outer{
    int k;
    String str;
    Inner in;
    Double d;


    public Outer(int k, String str, Double d, Inner in) {
        this.k = k;
        this.str = str;
        this.d = d;
        this.in = in;
    }
}

class Inner{
     String Innerstr;
     int Innerintik;
     double[] arrLong;

    public Inner(String str, int intik, double[] arr){

        Innerstr = str;
        Innerintik = intik;
        arrLong = arr;
    }
}


