package com.mj.mall.test.hsql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HsqlApp.class)
public class SpringBootMybatisHsqldbApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Test
    public void saveUser() {
        UserEntity user = new UserEntity(123, "test", "test", "123456789", "123@qq.com", new Date(), new Date(), "123456");

        userMapper.insertUser(user);
        UserEntity userEntityQuery = userMapper.findByID(123);

        System.out.println("userEntityQuery：" + userEntityQuery);
    }

}
