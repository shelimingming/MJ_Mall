package com.mj.mall.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HSqlHelper {
    private static HSqlHelper hSqlHelper = new HSqlHelper();


    private Connection conn;
    private Statement stat;

    private HSqlHelper() {
        // 加载HSQL DB的JDBC驱动
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            // 在内存中建立数据库db,用户名为sa,密码为空
//          Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:score", "sa", "");
//          Connection conn = DriverManager.getConnection("jdbc:hsqldb:db", "sa", "");
            this.conn = DriverManager.getConnection("jdbc:hsqldb:.", "sa", "");
            this.stat = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例模式，返回单例对象
     *
     * @return
     */
    public static HSqlHelper getInstance() {
        return hSqlHelper;
    }

    public Connection getConn() {
        return conn;
    }

    public Statement getStat() {
        return stat;
    }
}
