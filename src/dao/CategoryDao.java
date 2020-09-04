package dao;

import beans.Category;
import beans.Product;

import java.util.List;

public interface CategoryDao {
    //得到所有的分类
    public List<Category> getAllCategory() throws Exception;
    //得到分类详情
    public List<Product> getAllProductByCategory(int cid) throws Exception;
}
