package test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songwanke
 * @date 2017/12/11
 */
public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        System.out.println("*****"+map);

    }
}
