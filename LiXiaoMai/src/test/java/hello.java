import com.example.lixiaomai.backend.entity.Order;
import com.example.lixiaomai.backend.tools.DatabaseUtils;
import com.example.lixiaomai.backend.tools.Tool;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class hello {
    public static void main(String[] args) throws SQLException {
        try {
            Connection conn = DatabaseUtils.getConnection();
            String sql = "SELECT * FROM `ORDER` WHERE cid = ?";
            QueryRunner runner = DatabaseUtils.getRunner();
            List<Object> result = runner.query(conn, sql, new BeanListHandler<>(Object.class), 1);
//            List<Object> result = runner.query(conn, sql, new BeanListHandler<>(Object.class), 1);
//            List<Object> result = runner.query(conn, sql, new BeanListHandler<>(Object.class), 1);
            for (Object obj : result) {
                if (obj instanceof Integer) {
                    System.out.println((Integer) obj);
                } else if (obj instanceof String) {
                    System.out.println((String) obj);
                }
                // 继续添加其他可能的类型判断和处理
            }
        } finally {

        }
    }
}
