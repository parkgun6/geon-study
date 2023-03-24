package org.geon.study.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    BoardService boardService;

    @Test
    public void getBoardTest() {
        log.info(boardService.getBoardList());
    }
}
