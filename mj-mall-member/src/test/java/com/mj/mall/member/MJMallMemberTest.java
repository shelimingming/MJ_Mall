package com.mj.mall.member;

import com.mj.mall.member.service.impl.MemberServiceImplTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.MJMallTest;

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
