package org.geon.study.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.geon.study.board.dto.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void getBoardTest() {
        log.info(boardMapper.getBoard());
    }

    @Test
    public void insertBoard() {
        IntStream.rangeClosed(1, 500).forEach(i -> {
            Board board = Board.builder()
                    .title("title..." + i)
                    .content("content..." + i)
                    .build();
            boardMapper.insertBoard(board);
        });
    }
}
