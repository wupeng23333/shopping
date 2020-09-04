package dao.impl;

import beans.Category;
import beans.Product;
import dao.CategoryDao;
import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private PreparedStatement pstm=null;
    private ResultSet rs=null;

    @Override
    public List<Category> getAllCategory() throws Exception {
        List<Category> list=new ArrayList<>();
        pstm= DbUtil.getConnection().prepareStatement("SELECT * FROM category");
        rs=pstm.executeQuery();
        while (rs.next()){
            Category c=new Category();
            c.setCid(rs.getInt(1));
            c.setCname(rs.getString(2));
            list.add(c);
        }
        return list;
    }

    @Override
    public List<Product> getAllProductByCategory(int cid) throws Exception {
        List<Product> list=new ArrayList<>();
        pstm=DbUtil.getConnection().prepareStatement("SELECT * FROM product WHERE cid=?");
        pstm.setString(1, String.valueOf(cid));
        rs=pstm.executeQuery();
        while (rs.next()){
            Product p=new Product();
            p.setPid(rs.getInt(1));
            p.setPname(rs.getString(2));
            p.setPrice(rs.getFloat(3));
            p.setPimage(rs.getString(4));
            p.setPdate(rs.getDate(5));
            p.setIs_hot(rs.getInt(6));
            p.setPdescribe(rs.getString(7));
            p.setCid(rs.getInt(8));
            list.add(p);
        }
        return list;
    }
}
