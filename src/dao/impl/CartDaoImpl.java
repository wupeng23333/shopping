package dao.impl;

import beans.Cart;
import beans.CartItem;
import beans.Product;
import dao.CartDao;

import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    @Override
    public Cart addCartItemToCart(Product product,int num) throws Exception {
        Cart cart=new Cart();
        CartItem cartItem=new CartItem();
        cartItem.setNum(num);
        cartItem.setProduct(product);
        cartItem.setSubTotal(product.getPrice()*num);
        List<CartItem> list=new ArrayList<>();
        list.add(cartItem);
        cart.setList(list);
        cart.setTotal(cart.getTotal()+cartItem.getSubTotal());
        return cart;
    }

    @Override
    public Cart clearCart() throws Exception {
        return null;
    }

    @Override
    public Cart delProduct(Product product,Cart cart) throws Exception {
        List<CartItem> list=cart.getList();
        for(CartItem c:list){
            if (c.getProduct().getPid()==product.getPid()) {
                list.remove(c);
                cart.setTotal(cart.getTotal()-c.getSubTotal());
            }
        }
        return cart;
    }
}
