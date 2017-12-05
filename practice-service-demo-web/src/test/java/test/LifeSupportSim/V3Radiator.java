package test.LifeSupportSim;

import java.util.ArrayList;

/**
 * @author songwanke
 * @date 2017/11/30
 */
public class V3Radiator extends V2Radiator{

    int v3 = 0;

    public V3Radiator(ArrayList list) {
        for (int x=0;x<10;x++){
            int b = new SimUnit("V3Radiator").powerUse();
            v3 += b;
            System.out.println("V3Radiator"+v3);
            System.out.println("++++++++++++++");
        }
    }
}
