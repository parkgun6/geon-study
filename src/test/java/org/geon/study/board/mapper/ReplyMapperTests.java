package org.geon.study.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.study.board.dto.Board;
import org.geon.study.board.dto.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {

    @Autowired
    ReplyMapper replyMapper;

    @Test
    public void getBoardTest() {
        log.info(replyMapper.getReply(1));
    }

    @Test
    public void insertReply() {
        IntStream.rangeClosed(1, 500).forEach(i -> {
            Reply reply = Reply.builder()
                    .bno(new Random().nextLong(100L) + 1L)
                    .reply("reply..." + i)
                    .nickname("nickname..." + i)
                    .build();
            replyMapper.insertReply(reply);
        });
    }
}
