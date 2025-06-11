package com.nhom2.project_capybra_system.repository.impl;

import com.nhom2.project_capybra_system.dto.UserDto;
import com.nhom2.project_capybra_system.entity.User;
import com.nhom2.project_capybra_system.repository.IUserRepository;
import com.nhom2.project_capybra_system.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String FIND_ALL_USER_ACCOUNT =
            " select u.*, a.username, a.status as account_status, a.password, a.role_id " +
                    "from users u inner join accounts a on u.account_id = a.id where a.role_id = 1;";

    private static final String FIND_ALL_USER_ACCOUNT_BY_USER_ID =
            " select u.*, a.username, a.status as account_status, a.password, a.role_id " +
                    "from users u inner join accounts a on u.account_id = a.id where u.id = ?;";

    private static final String FIND_ALL_USER_ACCOUNT_BY_ACCOUNT_ID =
            " select u.*, a.username, a.status as account_status, a.password, a.role_id " +
                    "from users u inner join accounts a on u.account_id = a.id where a.id = ?;";

    private static final String GET_USER_ID = "select id from users where account_id = ?;";

    private static final String FIND_BY_USERNAME =
            "select u.* from users u inner join accounts a on a.id = u.account_id where a.username = ?";

    private static final String UPDATE_USER =
            "update users set name = ?, address = ?, phone = ?, email = ? where id = ?";

    private static final String FIND_ALL_USER_ACCOUNT_BY_NAME_AND_STATUS =
            " select u.*, a.username, a.status as account_status, a.password, a.role_id " +
                    "from users u inner join accounts a on u.account_id = a.id " +
                    "where a.role_id = 1 and u.name like ? and a.status like ?;";
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

    @Override
    public UserDto findUserAndAccountByAccountId(int id) {
        try (Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USER_ACCOUNT_BY_ACCOUNT_ID)){
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

    @Override
    public User findByUsername(String username) {
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_USERNAME)) {

            statement.setString(1, username);
            ResultSet resultSet =  statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setAccountId(resultSet.getInt("account_id"));
                user.setAddress(resultSet.getString("address"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setId(resultSet.getInt("id"));
                user.setStatus(resultSet.getBoolean("status"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER)){

            statement.setString(1, user.getName());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getId());

            int affectedRow = statement.executeUpdate();
            return affectedRow == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getUserId(int accountId) {
        int userId= -1;
        try(Connection connection = DatabaseUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ID)){
            preparedStatement.setInt(1,accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                userId = resultSet.getInt("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public List<UserDto> findAllUserAndAccountByNameAndAccountStatus(String findName, int findStatus) {
        List<UserDto> userDtos = new ArrayList<>();
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USER_ACCOUNT_BY_NAME_AND_STATUS)) {

            statement.setString(1, "%" + findName + "%");
            statement.setString(2, "%" + (findStatus == -1 ? "" : findStatus) + "%");

            ResultSet resultSet = statement.executeQuery();
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

                userDtos.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDtos;
    }
}
