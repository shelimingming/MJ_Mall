package test.util;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;

public class HSqlHelperTest {
    private static Connection conn;
    private static Statement stat;

    @BeforeClass
    public static void before() {
        HSqlHelper hSqlHelper = HSqlHelper.getInstance();
        conn = hSqlHelper.getConn();
        stat = hSqlHelper.getStat();
    }

    @Test
    public void test() throws SQLException {
        // 新建数据表
        stat.executeUpdate("create table temp(id integer, value VARCHAR(250) )");

        // 插入数据
        String sql = "INSERT INTO temp VALUES(1,'value')";
        stat.executeUpdate(sql);
        System.out.println("数据插入成功!");

        // 查询数据
        PreparedStatement pstmt = conn
                .prepareStatement("SELECT * FROM temp");
        ResultSet rs = pstmt.executeQuery();
        String res = null;
        while (rs.next()) {
            res = rs.getString(1) + ":" + rs.getString(2);
            System.out.println("查询结果为:" + res);
        }

        //比较结果
        Assert.assertEquals("查询结果不对！！", "1:value", res);
    }
}
