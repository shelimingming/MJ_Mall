package test;

import test.util.HSqlHelper;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.Statement;

public abstract class MJMallTest {

    private static Connection conn;
    private static Statement stat;

    @BeforeClass
    public static void beforeClass() {
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

    public abstract void createTables();

    protected abstract void insertTables();

}
