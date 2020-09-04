package dao.impl;

import beans.Category;
import beans.Product;
import dao.ProductDao;
import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private PreparedStatement pstm = null;
    private ResultSet rs = null;


    @Override
    public List<Product> findHots() throws Exception {
        List<Product> list = new ArrayList<Product>();
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM product WHERE is_hot=1 order by pid desc limit 0,9");
        rs = pstm.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setPid(rs.getInt(1));
            p.setPname(rs.getString(2));
            p.setPrice(rs.getFloat(3));
            p.setPimage(rs.getString(4));
            p.setPdate(rs.getDate(5));
            p.setPdescribe(rs.getString(7));
            p.setIs_hot(rs.getInt(6));
            p.setCid(rs.getInt(8));
            list.add(p);
        }
        return list;
    }

    @Override
    public List<Product> findNews() throws Exception {
        List<Product> list = new ArrayList<Product>();
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM product order by pid desc limit 0,9");
        rs = pstm.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setPid(rs.getInt(1));
            p.setPname(rs.getString(2));
            p.setPrice(rs.getFloat(3));
            p.setPimage(rs.getString(4));
            p.setPdate(rs.getDate(5));
            p.setPdescribe(rs.getString(7));
            p.setIs_hot(rs.getInt(6));
            p.setCid(rs.getInt(8));
            list.add(p);
        }
        return list;
    }

    @Override
    public Product getProductByPid(int pid) throws Exception {
        Product p=new Product();
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM product WHERE pid=?");
        pstm.setString(1, String.valueOf(pid));
        rs=pstm.executeQuery();
        while (rs.next()){
            p.setPid(rs.getInt(1));
            p.setPname(rs.getString(2));
            p.setPrice(rs.getFloat(3));
            p.setPimage(rs.getString(4));
            p.setPdate(rs.getDate(5));
            p.setPdescribe(rs.getString(7));
            p.setIs_hot(rs.getInt(6));
            p.setCid(rs.getInt(8));
        }
        return p;
    }

    @Override
    public List<Product> getAllProduct() throws Exception {
        List<Product> list = new ArrayList<Product>();
        pstm = DbUtil.getConnection().prepareStatement("SELECT * FROM product ");
        rs=pstm.executeQuery();
        while (rs.next()) {
            Product p = new Product();
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
