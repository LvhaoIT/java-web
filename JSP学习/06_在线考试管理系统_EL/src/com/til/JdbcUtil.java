package com.til;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

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

    //--------------------通过全局作用域对线得到Connetion---------------start
    public Connection createCon(HttpServletRequest request) {
        //1.通过请求对象来获得全局作用域对象
        ServletContext application = request.getServletContext();
        //2.获得对象集合
        Map map = (Map) application.getAttribute("key1");
        //3.从map中获得一个处于空闲状态的Connection
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            conn = (Connection) it.next();
            if ((boolean) map.get(conn)) {
                //判断是否可用
                map.put(conn, false);//需要用的进行关闭
                break;
            }

        }
        return conn;
    }
    //--------------------通过全局作用域对线得到Connetion---------------end

    //----------------====重载运行ps--------------------------------Statr
    public PreparedStatement createStatement(HttpServletRequest request, String sql) {
        try {
            ps = createCon(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    //---------------------重载---------------------------

    //------------------重载close方法----------------------Srart
    public void close(HttpServletRequest request) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ServletContext application = request.getServletContext();//获得全局
        Map map = (Map) application.getAttribute("key1");
        map.put(conn, true);//表明又可以使用了


    }
    //------------------重载close方法----------------------end

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
        conn = createCon();
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
