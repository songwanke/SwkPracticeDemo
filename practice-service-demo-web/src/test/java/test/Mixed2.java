package test;

/**
 * @author songwanke
 * @date 2017/11/27
 */
public class Mixed2 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A a2 = new C();
        A a3 = new B();
        /*a2.m1();
        a2.m2();
        a2.m3();*/

        a3.m1();
        a3.m2();
        a3.m3();

       /* b.m1();
        c.m2();
        a.m3();*/

       /* c.m1();
        c.m2();
        c.m3();*/

        /*a.m1();
        b.m2();
        c.m3();*/
    }
}
