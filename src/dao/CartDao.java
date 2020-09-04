package dao;

import beans.Cart;
import beans.Product;

public interface CartDao {
    //添加商品到购物车
    public Cart addCartItemToCart(Product product, int num) throws Exception;
    //清空购物车
    public Cart clearCart() throws Exception;
    //删除商品项
    public Cart delProduct(Product product,Cart cart) throws Exception;
}
