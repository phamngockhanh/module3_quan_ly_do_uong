package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.repository.IUserRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String FIND_ALL_USER_ACCOUNT =
            " select u.*, a.username, a.status as account_status, a.password, a.role_id " +
                    "from users u inner join accounts a on u.account_id = a.id where a.role_id = 1;";

    private static final String FIND_ALL_USER_ACCOUNT_BY_USER_ID =
            " select u.*, a.username, a.status as account_status, a.password, a.role_id " +
                    "from users u inner join accounts a on u.account_id = a.id where a.role_id = 1 and u.id = ?;";
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }



    @Override
    public boolean delete(int id) {
        return false;
    }


    @Override
    public void add(User user) {
        String sql = "insert into users (name, account_id, phone, address, email, status) " +
                "values (?,?,?,?,?,?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAccountId());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getEmail());
            statement.setBoolean(6, user.isStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDto> findAllUserAndAccount() {
        List<UserDto> userDtoList = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USER_ACCOUNT);
            ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                UserDto user = new UserDto();

                user.setUserId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setAccountId(resultSet.getInt("account_id"));
                user.setUsername(resultSet.getString("username"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setAccountStatus(resultSet.getBoolean("account_status"));

                userDtoList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return userDtoList;
    }

    @Override
    public UserDto findUserAndAccountByUserId(int id) {
        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USER_ACCOUNT_BY_USER_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                UserDto userDto = new UserDto();

                userDto.setUserId(resultSet.getInt("id"));
                userDto.setName(resultSet.getString("name"));
                userDto.setEmail(resultSet.getString("email"));
                userDto.setAddress(resultSet.getString("address"));
                userDto.setPhone(resultSet.getString("phone"));
                userDto.setAccountId(resultSet.getInt("account_id"));
                userDto.setUsername(resultSet.getString("username"));
                userDto.setRoleId(resultSet.getInt("role_id"));
                userDto.setAccountStatus(resultSet.getBoolean("account_status"));
                return userDto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
