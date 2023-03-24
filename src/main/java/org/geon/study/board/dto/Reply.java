package org.geon.study.board.dto;

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

    private Long bno;

    private String reply;

    private String nickname;

    private Date regDate;

    private Date modDate;

    private boolean delFlag;
}
