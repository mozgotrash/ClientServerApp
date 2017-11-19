package clientserverapp.json.formats;

public class ArrayFormatter implements TypeFormatter {

    @Override
    public String format(Object value, Object obj) {
//        throw new NotImplementedException();
        return value.toString();
    }
}

//
//    private short getDimensionalOfArray(Object value){
//        char[] name = value.toString().toCharArray();
//
//        short count = 0;
//        while(count < name.length){
//            if(name[count] == '['){
//                count++;
//                continue;
//            }
//
//            break;
//        }
//        return count;
//    }

//    private String getTypeOfArray(Object value){
//        char[] name = value.toString().toCharArray();
//
//        int count = 0;
//        char nameChar = ' ';
//        while(count < name.length){
//            if(name[count] == '['){
//                count++;
//                continue;
//            }
//            nameChar = name[count];
//            count++;
//            break;
//        }
//      D
//        StringBuilder type = new StringBuilder();
//
//        for(int i = count; i < name.length; i++){
//            if(name[i] == ';' || name[i] == '@'){
//                break;
//            }else{
//                type.append(name[i]);
//            }
//        }
//
//        if(type.toString().equals("")){
//            return String.valueOf(nameChar);
//        }
//
//        return type.toString();
//    }









