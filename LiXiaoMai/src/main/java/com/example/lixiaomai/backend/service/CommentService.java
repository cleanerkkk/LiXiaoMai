package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CommentDao;
import com.example.lixiaomai.backend.entity.Comment;

import java.util.List;

public class CommentService {
    static CommentDao commentDao = new CommentDao();

    public Comment getCommentById(int id){
        return commentDao.getCommentById(id);
    }

    public boolean addComment(Comment comment){
        return commentDao.addComment(comment);
    }

    public List<Comment> getCommentByStartId(int StartId){
        return commentDao.getCommentByStartId(StartId);
    }

    public List<Comment> getCommentByEndId(int EndId){
        return commentDao.getCommentByEndId(EndId);
    }

    public boolean delCommentById(int id){
        return commentDao.delCommentById(id);
    }

    public boolean likeCommentById(int id){
        return commentDao.likeCommentById(id);
    }

    public boolean dislikeCommentById(int id){
        return commentDao.dislikeCommentById(id);
    }
}
