package com.Dao;

import com.entity.Users;
import com.til.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //驱动已经创建
    private JdbcUtil util = new JdbcUtil();

    //------------------------------重载add
    public int add(Users user, HttpServletRequest request) {
        int result = 0;
        String sql = "insert into users(userName,password,sex,email) values(?,?,?,?)";
        //编译sql框架
        PreparedStatement ps = this.util.createStatement(request, sql);
        //插入值
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            //执行sql语句
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close(request);
        }
        return result;
    }

    //-------------------------------------------
    public int add(Users user) {
        int result = 0;
        String sql = "insert into users(userName,password,sex,email) values(?,?,?,?)";
        //编译sql框架
        PreparedStatement ps = this.util.createStatement(sql);
        //插入值
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            //执行sql语句
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close();
        }
        return result;
    }

    public List find() {
        List<Users> list = new ArrayList();
        ResultSet rs = null;
        String sql = "select * from Users order by userId asc";
        PreparedStatement ps = this.util.createStatement(sql);
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                //取出数据
                Integer userId;
                String userName, password, sex, email;
                userId = rs.getInt("userId");
                userName = rs.getString("userName");
                password = rs.getString("password");
                sex = rs.getString("sex");
                email = rs.getString("email");
                list.add(new Users(userId, userName, password, sex, email));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close(rs);
            this.util.close();
        }

        return list;
    }

    public int delete(String userId) {
        int result = 0;
        String sql = "delete from users where userId=?";
        PreparedStatement ps = this.util.createStatement(sql);
        try {
            //Integer.parseInt(userId)将字符串转换为int类型
            ps.setInt(1, Integer.parseInt(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close();
        }
        return result;
    }

    public int update(String userId) {
        int result = 0;

        return result;
    }

    public int login(String userName, String password) {
        int result = 0;
        ResultSet rs = null;
        String sql = "select * from Users where userName=? and password=?";
        PreparedStatement ps = this.util.createStatement(sql);
        try {
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = 1;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }

        return result;
    }
}
