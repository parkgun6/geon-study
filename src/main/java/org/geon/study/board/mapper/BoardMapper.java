package org.geon.study.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.study.board.dto.Board;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getBoard();

    int insertBoard(Board board);
}
