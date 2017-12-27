package test.GsonTest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author songwanke
 * @date 2017/12/12
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewRoleResourceRequestVo {

    /**
     * 买家角色权限
     */
    private List<Long> buyerRoleResourceIds;

    /**
     * 供应商角色权限
     */
    private List<Long> sellerRoleResourceIds;

    /**
     * 公共部分角色权限
     */
    private List<Long> publicRoleResourceIds;

    /**
     * 卖家角色权限
     */
    private List<Long> shopRoleResourceIds;

    public List<Long> getBuyerRoleResourceIds() {
        return buyerRoleResourceIds;
    }

    public void setBuyerRoleResourceIds(List<Long> buyerRoleResourceIds) {
        this.buyerRoleResourceIds = buyerRoleResourceIds;
    }

    public List<Long> getSellerRoleResourceIds() {
        return sellerRoleResourceIds;
    }

    public void setSellerRoleResourceIds(List<Long> sellerRoleResourceIds) {
        this.sellerRoleResourceIds = sellerRoleResourceIds;
    }

    public List<Long> getPublicRoleResourceIds() {
        return publicRoleResourceIds;
    }

    public void setPublicRoleResourceIds(List<Long> publicRoleResourceIds) {
        this.publicRoleResourceIds = publicRoleResourceIds;
    }

    public List<Long> getShopRoleResourceIds() {
        return shopRoleResourceIds;
    }

    public void setShopRoleResourceIds(List<Long> shopRoleResourceIds) {
        this.shopRoleResourceIds = shopRoleResourceIds;
    }

    @Override
    public String toString() {
        return "NewRoleResourceRequestVo{" +
                "buyerRoleResourceIds=" + buyerRoleResourceIds +
                ", sellerRoleResourceIds=" + sellerRoleResourceIds +
                ", publicRoleResourceIds=" + publicRoleResourceIds +
                ", shopRoleResourceIds=" + shopRoleResourceIds +
                '}';
    }
}
