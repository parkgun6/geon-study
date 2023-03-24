package org.geon.study.jdbc;

import lombok.extern.log4j.Log4j2;
import org.geon.study.time.mapper.TimeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class TimeMapperTests {

    @Autowired
    TimeMapper timeMapper;

    @Test
    public void timeNowTest() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void timeNowTest2() {
        log.info(timeMapper.getTime2());
    }
}
