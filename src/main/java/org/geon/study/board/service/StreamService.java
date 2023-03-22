package org.geon.study.board.service;

import org.geon.study.board.model.Board;
import org.geon.study.board.model.UserRole;
import org.geon.study.common.util.ConvertUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface StreamService {

    public String aopTest();

    public List<Board> getList();

    public List<Board> searchList(int menu, String userInput);

    default Optional<List<Board>> resultData(List<String> originList) {
        List<Board> boardList = originList.stream().map(this::parseBoard).collect(Collectors.toList());
        Optional<List<Board>> optionalList = ConvertUtil.arrayToOptionalList(boardList);
        return optionalList;
    }

    default Board parseBoard(String data) {
        String[] dataList = data.split(",");
        if (dataList.length < 8) {
            throw new IllegalArgumentException("Invalid board data: " + data);
        }
        return Board.builder()
                .bno(Long.parseLong(dataList[0]))
                .title(dataList[1])
                .content(dataList[2])
                .username(dataList[3])
                .nickname(dataList[4])
                .regDate(dataList[5])
                .modDate(dataList[6])
                .role(UserRole.findByUserRole(dataList[7]))
                .build();
    }
}
