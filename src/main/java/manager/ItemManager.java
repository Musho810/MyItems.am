package manager;

import db.DBConnectionProvider;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(Item item) {
        String sql = "Insert into item (title,price,category_id,pic_url,user_id) Values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getCategoryId());
            ps.setString(4, item.getPicUrl());
            ps.setInt(5, item.getUserId());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                item.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Item getItemFromResultSet(ResultSet resultSet) throws SQLException {
        Item item = Item.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .price(resultSet.getDouble("price"))
                .categoryId((resultSet.getInt("category_id")))
                .picUrl((resultSet.getString("pic_url")))
                .userId(resultSet.getInt("user_id"))
                .build();
        return item;
    }

    public List<Item> getAllMyItem(int userId) {
        String sql = "SELECT * From item where user_id =" + userId;
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                itemList.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<Item> getAll() {
        String sql = "SELECT * From item";
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                itemList.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<Item> getLast20() {
        String sql = "SELECT * From item LIMIT 20";
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                itemList.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<Item> getLastByCategory(int categoryId) {
        String sql = "SELECT * From item WHERE category_id = " + categoryId + " " + "LIMIT 20 ";
        List<Item> itemList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                itemList.add(getItemFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void deleteItem(int itemId) {
        String sql = "delete from item where id =" + itemId;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void editItem(Item item) {

        String sql = "update item set title=?,price=?,category_id=?,pic_url=?,user_id=? where  id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getCategoryId());
            ps.setString(4, item.getPicUrl());
            ps.setInt(5, item.getUserId());
            ps.setInt(6, item.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Item getById(int itemId) {
        String sql = "SELECT * From item where id = " + itemId;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return getItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
}

