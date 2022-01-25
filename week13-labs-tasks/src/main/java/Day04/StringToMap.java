package Day04;

import java.util.TreeMap;

public class StringToMap {
    public TreeMap<Character, Integer> converterFromStringToMap(String input){
        TreeMap<Character, Integer> output=new TreeMap();
        Character key;
        for (char c: input.toCharArray()) {
            key=Character.valueOf(c);
            if(output.containsKey(key)){
                output.put(key,output.get(key)+1);
            }
            else{
                output.put(key,1);
            }
        }
        return output;
    }
}
