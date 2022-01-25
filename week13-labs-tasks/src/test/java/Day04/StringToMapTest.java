package Day04;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringToMapTest {
    @Test
    void testVowelsCount(){
        StringToMap stringStatistics = new StringToMap();

        Map<Character,Integer> result = stringStatistics.converterFromStringToMap("appletree");

        assertEquals(1,result.get('a'));
        assertEquals(3,result.get('e'));
        assertNull(result.get('u'));
    }

    @Test
    public void mapOrderingByValue(){
        StringToMap stringStatistics = new StringToMap();

        Map<Character,Integer> result = stringStatistics.converterFromStringToMap("eappluetruee");

        List<Map.Entry<Character,Integer>> entryList = new LinkedList<>(result.entrySet());

        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));

        for(Map.Entry<Character,Integer> act : entryList){
            System.out.println(act.getKey()+" "+act.getValue());
        }

    }

}