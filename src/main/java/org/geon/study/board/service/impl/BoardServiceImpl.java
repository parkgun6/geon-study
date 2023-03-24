package org.geon.study.board.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.study.board.dto.Board;
import org.geon.study.board.mapper.BoardMapper;
import org.geon.study.board.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;


    @Override
    public List<Board> getBoardList() {
        return boardMapper.getBoard();
    }
}
