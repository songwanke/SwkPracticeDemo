package test.LifeSupportSim;

import java.util.ArrayList;

/**
 * @author songwanke
 * @date 2017/11/30
 */
public class TestLifeSupportSim {
    public static void main(String[] args){
        ArrayList alist = new ArrayList();
        V2Radiator v2 = new V2Radiator(alist);
        V3Radiator v3 = new V3Radiator(alist);
        RetentionBot ret = new RetentionBot(alist);


    }
}
