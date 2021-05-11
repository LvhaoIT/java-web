package com.listener;

import com.til.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/7
 * Time: 15:00
 */
public class OneListener implements ServletContextListener {
    //在tomcat启动时，创建20个connection，在useradd方法执行时候，将
    //connection对象交给add方法使用
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util = new JdbcUtil();
        Map map = new HashMap<>();
        for (int i = 1; i <= 2; i++) {
            Connection con = util.createCon();
            System.out.println("在服务器启动时，创建出Connection对象 " + con + "(" + i + ")");
            map.put(con, true);//true表示这个通道处于空闲状态，false通道正在被使用
        }
        //为了在http服务器运行期间，一直都可以使用20个Connection，所以将connection保存到全局作用域对象中
        ServletContext application = sce.getServletContext();//获取全局作用域对象
        application.setAttribute("key1", map);//放入全局变量中
    }

    /**
     * 在http服务器关闭的时刻，我们需要将这20个connection进行销毁
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map) application.getAttribute("key1");
        Iterator it = map.keySet().iterator();//将map中数据放入set集合，然后利用迭代器进行一个排序
        //遍历迭代器
        /**
         * 1、hasNext() ：此方法用来判断迭代器对象指向的索引位置有没有元素
         * 2、next() ：获取迭代器对象当前索引位置的元素并将索引下标移至下一个元素
         * 3、remove() ：删除参数中指定元素
         */
        while (it.hasNext()) {
            Connection con = (Connection) it.next();

            if (con != null) {
                try {
                    System.out.println("Connection对象" + con + "准备被销毁");
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
}
