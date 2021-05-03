package com.til;

import java.sql.*;

public class JdbcUtil {
    private Connection conn = null;
    private PreparedStatement ps = null;

    static {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //封装conn对象创建
    public Connection createCon() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/csdb?serverTimezone=UTC", "root", "lh051920");
            System.out.println("conn对象创建成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("conn对象创建失败！");
        }
        return conn;
    }

    //封装PreparedStatement对象
    public PreparedStatement createStatement(String sql) {
        Connection conn = createCon();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    //封装销毁
    public void close(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
