package com.nhom2.project_capybra_system.dto;

public class UserDto {
    private int userId;
    private String name;
    private String phone;
    private String address;
    private String email;
    private int accountId;
    private String username;
    private int roleId;
    private boolean accountStatus;

    public UserDto() {
    }

    public int getUserId() {
        return userId;
    }

    public UserDto(int userId, String name, String phone, String address, String email,
                   int accountId, String username, int roleId, boolean accountStatus) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.accountId = accountId;
        this.username = username;
        this.roleId = roleId;
        this.accountStatus = accountStatus;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
