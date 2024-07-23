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

    public List<Comment> getCommentByOId(int oId){
        return commentDao.getAllcommentByOid(oId);
    }

    public Comment getCommentStartWithCustomerByOId(int oId){
        return commentDao.getCommentStartWithCustomerByOid(oId);
    }

    public Comment getCommentStartWithBusinessByOId(int oId){
        return commentDao.getCommentStartWithBusinessByOid(oId);
    }
    public Comment getCommentEndWithBusinessByOId(int oId){
        return commentDao.getCommentEndWithBusinessByOid(oId);
    }

    public Comment getCommentStartWithDelivermanByOId(int oId){
        return commentDao.getCommentStartWithDelivermanByOid(oId);
    }
    public Comment getCommentEndWithDelivermanByOId(int oId){
        return commentDao.getCommentEndWithDelivermanByOid(oId);
    }
}
