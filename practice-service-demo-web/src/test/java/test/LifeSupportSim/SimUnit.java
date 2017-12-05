package test.LifeSupportSim;

/**
 * @author songwanke
 * @date 2017/11/30
 */
public class SimUnit {
    String botType;

    public SimUnit(String type) {
        botType = type;
    }

    int powerUse() {
        if ("Retention".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}
