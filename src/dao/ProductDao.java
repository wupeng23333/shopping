package dao;

import beans.Product;

import java.util.List;

public interface ProductDao {
    //查询最热商品
    List<Product> findHots() throws Exception;
    //查询最新商品
    List<Product> findNews() throws Exception;
    //更加pid获得产品项
    public Product getProductByPid(int pid) throws Exception;
    //所有产品
    public List<Product> getAllProduct() throws Exception;
}
