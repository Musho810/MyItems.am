package manager;

import db.DBConnectionProvider;

import model.Category;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryManager {
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    private Category getCategoryFromResultSet(ResultSet resultSet) throws SQLException {
        Category category = Category.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();


        return category;
    }

    public void add(Category category) {
        String sql = "Insert into category (name) Values (?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getName());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                category.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Category> getAll() {
        String sql = "SELECT * From category";
        List<Category> categoryList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                categoryList.add(getCategoryFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }


    public Category getByName(String category) {

        String sql = "SELECT * From category where name = '" + category + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getCategoryFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
