package test.LifeSupportSim;

import java.util.ArrayList;

/**
 * @author songwanke
 * @date 2017/11/30
 */
public class V2Radiator {

    public V2Radiator() {
    }

    int v2 = 0;

    public V2Radiator(ArrayList list) {
        for (int x=0;x<5;x++){
            int a = new SimUnit("V2Radiator").powerUse();
            v2 += a;
            System.out.println("V2Radiator"+v2);
            System.out.println("++++++++++++++");
        }
    }
}
