package org.geon.study.board.model;

import lombok.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    private Long bno;

    private String title;

    private String content;

    private String username;

    private String nickname;

    private String regDate;

    private String modDate;

    private UserRole role;

    private Object invokeGetter(Board board, Method method) throws IllegalAccessException, InvocationTargetException {
        return method.invoke(board);
    }
}
