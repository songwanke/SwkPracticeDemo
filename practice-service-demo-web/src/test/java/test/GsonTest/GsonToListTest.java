package test.GsonTest;

import com.google.gson.Gson;

/**
 * @author songwanke
 * @date 2017/12/12
 */
public class GsonToListTest {

    public static void main(String[] args) {
       // String roleIds = "{\"buyerRoleResourceIds\":[\"11261\",\"11263\",\"11264\",\"11265\",\"11266\",\"11267\",\"11268\",\"11422\",\"11427\",\"11262\",\"11764\"],\"sellerRoleResourceIds\":[\"11293\",\"11295\",\"11425\",\"11962\",\"15263\",\"11294\",\"15229\",\"15230\",\"15231\"]}";

        String roleIds = "";
        NewRoleResourceRequestVo newRoleResourceRequestVo = new Gson().fromJson(roleIds, NewRoleResourceRequestVo.class);

        /*List<Long> buyerRoleResourceIds = newRoleResourceRequestVo.getBuyerRoleResourceIds();
        List<Long> sellerRoleResourceIds = newRoleResourceRequestVo.getSellerRoleResourceIds();

        System.out.println("*****"+buyerRoleResourceIds);
        System.out.println("*****"+sellerRoleResourceIds);*/

        System.out.println("******"+newRoleResourceRequestVo);
    }
}
