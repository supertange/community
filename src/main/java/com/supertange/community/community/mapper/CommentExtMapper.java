package com.supertange.community.community.mapper;

import com.supertange.community.community.model.Comment;
import com.supertange.community.community.model.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}