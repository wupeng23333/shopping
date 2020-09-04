package beans;

import java.util.ArrayList;
import java.util.List;

//购物车
public class Cart {
    private List<CartItem> list=null;
    private double total;//总价
    //添加商品项到购物车

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
