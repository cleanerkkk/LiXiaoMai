package com.example.lixiaomai.backend.dao;

import com.example.lixiaomai.backend.entity.Comment;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class CommentDao {
    private final QueryRunner runner = DatabaseUtils.getRunner();

    public Comment getCommentById(int Id){
        String sql = "SELECT * FROM Comment WHERE Id = ?";
        try {
            return runner.query(DatabaseUtils.getConnection(), sql, new BeanHandler<>(Comment.class), Id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
