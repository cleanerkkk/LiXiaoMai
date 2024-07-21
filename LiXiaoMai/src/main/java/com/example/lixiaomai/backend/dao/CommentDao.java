package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public Comment getCommentById(int id){
        try {
            String sql = "SELECT * FROM COMMENT WHERE ID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn, sql, new BeanHandler<>(Comment.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addComment(Comment comment) { //发起一条新的评论
        try {
            String sql = "INSERT INTO COMMENT (STARTID,ENDID,STARTNAME,ENDNAME,TIME,CONTENT,LIKES,COID,DISLIKES,STATUS) VALUES (?,?,?,?,?,?,?,?,?,?)";
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,
                    sql,
                    comment.getStartId(), comment.getEndId(), comment.getStartName(), comment.getEndName(), comment.getTime(), comment.getContent(), comment.getLikes(), comment.getCoId(), comment.getDislikes(), comment.getStatus()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> getCommentByStartId(int StartId){
        try{
            String sql = "SELECT * FROM COMMENT WHERE STARTID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn,sql, new BeanListHandler<>(Comment.class), StartId);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Comment> getCommentByEndId(int EndId){
        try{
            String sql = "SELECT * FROM COMMENT WHERE ENDID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn,sql, new BeanListHandler<>(Comment.class), EndId);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delCommentById(int id){
        try{
            String sql = "DELETE FROM COMMENT WHERE ID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,sql,id) > 0;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean likeCommentById(int id){
        try{
            String sql = "UPDATE COMMENT SET LIKES = LIKES + 1 WHERE ID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,sql,id) > 0;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean dislikeCommentById(int id){
        try{
            String sql = "UPDATE COMMENT SET DISLIKES = DISLIKES + 1 WHERE ID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.update(conn,sql,id) > 0;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Comment> getAllcommentByOid(int oid){
        try{
            String sql = "SELECT * FROM COMMENT WHERE OID = ?";
            Connection conn = DatabaseUtils.getConnection();
            return runner.query(conn,sql,new BeanListHandler<>(Comment.class),oid);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



}
