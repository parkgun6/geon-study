package org.geon.study.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    private Long rno;

    private String reply;

    private String username;

    private String nickname;

    private Date regDate;

    private Date modDate;
}
