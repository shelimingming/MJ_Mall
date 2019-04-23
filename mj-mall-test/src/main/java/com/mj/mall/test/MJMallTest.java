package com.mj.mall.test;

import com.mj.mall.test.util.HSqlHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Statement;

public abstract class MJMallTest {

    final static Logger logger = LoggerFactory.getLogger(MJMallTest.class);

    private static Connection conn;
    private static Statement stat;

    @BeforeClass
    public static void beforeClass() {
        logger.info("beforeClass()");
        //初始化数据库
        HSqlHelper hSqlHelper = HSqlHelper.getInstance();
        conn = hSqlHelper.getConn();
        stat = hSqlHelper.getStat();
    }

    @Before
    public void before() {
        //创建数据库表
        createTables();

        //向表中插入预置数据
        insertTables();
    }

    /**
     * 创建数据库表，由每个模块的测试类实现
     */
    public abstract void createTables();

    /**
     * 向表中插入预置数据，由每个模块的测试类实现
     */
    protected abstract void insertTables();

}
