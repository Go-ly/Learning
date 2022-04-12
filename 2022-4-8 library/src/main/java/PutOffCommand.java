import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PutOffCommand {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource db = new MysqlDataSource();
        db.setServerName("localhost");
        db.setPort(3306);
        db.setUser("root");
        db.setPassword("123456");
        db.setDatabaseName("library");
        db.setUseSSL(false);
        db.setCharacterEncoding("utf-8");
        db.setServerTimezone("Asia/Shanghai");


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名:>");
        String name = scanner.nextLine();
        System.out.println("请输入数目:>");
        int count = scanner.nextInt();

        Integer bid = null;
        Integer total = null;
        try (Connection c = db.getConnection()) {
            String sql = "select bid, count, total from books where name = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, name);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("查无此书");
                        return;
                    }
                    bid = rs.getInt("bid");
                    total = rs.getInt("total");
                }
            }
        }

        if (count < total) {
            // 执行update进行下架
            try (Connection c = db.getConnection()) {
                String sql = "update books set count = count - ?,total = total - ? where bid = ?";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setInt(1, count);
                    ps.setInt(2, count);
                    ps.setInt(3, bid);

                    ps.executeUpdate();
                }
            }
        } else {
            // 执行delete进行下架
            try (Connection c = db.getConnection()) {
                String sql = "delete from books where bid = ?";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setInt(1, bid);
                    ps.executeUpdate();
                }
            }
        }
        System.out.println("下架成功");
    }
}
