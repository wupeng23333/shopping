package beans;

//购物车中的商品项
public class CartItem {
    private Product product;//商品
    private int num;//数量
    private double subTotal;//小计

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public CartItem() {

    }

    public CartItem(Product product, int num, double subTotal) {
        super();
        this.product = product;
        this.num = num;
        this.subTotal = subTotal;
    }
}
