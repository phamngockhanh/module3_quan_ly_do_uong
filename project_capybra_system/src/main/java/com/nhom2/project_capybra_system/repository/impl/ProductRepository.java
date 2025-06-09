package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.entity.Product;
import com.nhom2.project_capybra_system.repository.IProductRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT = "select * from products";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id = ?";
    private static final String COUNT_PRODUCT = "select count(*) from products;";
    private static final String SELECT_PRODUCT_PAGINATION = "select * from products ORDER BY id LIMIT ? OFFSET ?;";
    private static final String COUNT_PRODUCT_WITH_FILTER= "select count(*) from products where (name LIKE CONCAT('%', ?, '%') OR ? = '') AND (category_id = ? OR ? = 0)";
    private static final String SEARCH_BY_NAME_ID_CATEGORY ="select * from products where (name like concat('%', ?, '%') OR ? = '') AND (category_id = ? OR ? = 0) LIMIT ?,?;";
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public int countProduct(){
        int totalRecords = 0;
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(COUNT_PRODUCT)){
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                totalRecords = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRecords;
    }

    @Override
    public int countProductWithFilter(String productName, int categoryId) {
        int totalRecords = 0;
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(COUNT_PRODUCT_WITH_FILTER)){
            preparedStatement.setString(1,productName);
            preparedStatement.setString(2,productName);
            preparedStatement.setInt(3,categoryId);
            preparedStatement.setInt(4,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                totalRecords = resultSet.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return totalRecords;
    }

    @Override
    public List<Product> findAllWithPagination(String productName, int categoryId,int offset, int pageSize) {
        List<Product> products = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME_ID_CATEGORY)){
            preparedStatement.setString(1,productName);
            preparedStatement.setString(2,productName);
            preparedStatement.setInt(3,categoryId);
            preparedStatement.setInt(4,categoryId);
            preparedStatement.setInt(5,offset);
            preparedStatement.setInt(6,pageSize);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));
                product.setSize(resultSet.getString("size"));
                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findAllNoneFilter(int offset, int pageSize) {
        List<Product> products = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_PAGINATION)){
            preparedStatement.setInt(1,pageSize);
            preparedStatement.setInt(2,offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product  = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getLong("price"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));
                product.setSize(resultSet.getString("size"));
                products.add(product);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return products;
    }



    @Override
    public boolean delete(int id) {
        String DELETE_ID="delete from products where id=?;";
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(DELETE_ID);) {
          preparedStatement.setInt(1,id);
           int effectRow = preparedStatement.executeUpdate();
           return effectRow==1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }

        return false;
    }
//    public boolean add(Product product) throws SQLException {
//        String ADD="insert into products(name,price,category_id,status,description,image,size) value(?,?,?,?,?,?,?);";
//        try(Connection connection=DatabaseUtil.getConnection();
//        PreparedStatement preparedStatement= connection.prepareStatement(ADD);){
//            preparedStatement.setString(1,product.getName());
//            preparedStatement.setInt(2,product.getCategoryId());
//            preparedStatement.setString(3,product.getStatus());
//            preparedStatement.setString(4,product.getDescription());
//            preparedStatement.setString(5,product.getImage());
//        }
//    }



}
