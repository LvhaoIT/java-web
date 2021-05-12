package com.listener.ServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/6
 * Time: 21:49
 */
public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局变量被创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局变量被销毁");
    }
}
