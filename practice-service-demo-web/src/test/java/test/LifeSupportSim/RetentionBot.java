package test.LifeSupportSim;

import java.util.ArrayList;

/**
 * @author songwanke
 * @date 2017/11/30
 */
public class RetentionBot {

    int re = 0;

    public RetentionBot(ArrayList list) {
        for (int z = 0; z < 20; z++) {
            int c = new SimUnit("Retention").powerUse();
            re += c;
            System.out.println("RetentionBot" + re);
        }
    }
}
