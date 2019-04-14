package com.mj.mall.member.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.MJMallTest;

import static org.junit.Assert.*;

public class MemberServiceImplTest extends MJMallTest {

    final static Logger logger = LoggerFactory.getLogger(Test.class);

    @Before
    public void setUp() throws Exception {
        logger.info("测试：{}", "输出日志");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void register() {
    }

    @Test
    public void login() {
    }

    @Test
    public void findByTokenUser() {
    }

    @Override
    public void createTables() {

    }

    @Override
    protected void insertTables() {

    }
}