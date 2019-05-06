package com.mj.mall.member;

import com.mj.mall.test.MJMallTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MJMallMemberTest  extends MJMallTest {
    final static Logger logger = LoggerFactory.getLogger(MJMallMemberTest.class);

    @Override
    public void createTables() {
        logger.info("createTables()");
    }

    @Override
    protected void insertTables() {
        logger.info("insertTables()");
    }
}
