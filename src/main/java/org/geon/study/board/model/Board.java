package org.geon.study.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    @ApiModelProperty(hidden = true)
    private Long bno;

    private String title;

    private String content;

    private String username;

    private String nickname;

    @ApiModelProperty(hidden = true)
    private String regDate;

    @ApiModelProperty(hidden = true)
    private String modDate;

    @ApiModelProperty(hidden = true)
    private UserRole role;

    public String boardToString(Board board) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Long bno = board.getBno();
        String title = board.getTitle();
        String content = board.getContent();
        String username = board.getUsername();
        String nickname = board.getNickname();
        String regDate = dateFormat.format(new Date());
        String modDate = dateFormat.format(new Date());
        String role = UserRole.parseValue(board.getRole().toString());

        return String.format("%d,%s,%s,%s,%s,%s,%s,%s%n", bno, title, content, username, nickname, regDate, modDate, role);
    }
}
