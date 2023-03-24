package org.geon.study.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.study.board.dto.Reply;

import java.util.List;

@Mapper
public interface ReplyMapper {

    List<Reply> getReply(int bno);

    int insertReply(Reply reply);
}
