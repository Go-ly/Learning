
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class BorrowBookCommand {
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
        System.out.println("登录-请输入用户名:>");
        String userName = scanner.nextLine();

        int rid;
        try (Connection c = db.getConnection()) {
            String sql = "select rid from readers where name = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, userName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("登录失败");
                        return;
                    } else {
                        rid = rs.getInt("rid");
                    }
                }
            }
        }

        System.out.println("登陆成功");
        System.out.println("请输入书名:>");
        String bookName = scanner.nextLine();

        int bid;
        int count;

        try (Connection c = db.getConnection()) {
            String sql = "select bid, count from books where name = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, bookName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        System.out.println("查无此书");
                        return;
                    } else {
                        bid = rs.getInt("bid");
                        count = rs.getInt("count");
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("书已借空");
            return;
        }

        // 书的数量减一
        // 借阅记录中增加

        try (Connection c = db.getConnection()) {
            String sql1 = "update books set count = count - 1 where bid = ?";
            String sql2 = "insert into records (bid, rid, borrowed_at) values (?, ?, ?)";

            try (PreparedStatement ps = c.prepareStatement(sql1)) {
                ps.setInt(1, bid);

                ps.executeUpdate();
            }

            try (PreparedStatement ps = c.prepareStatement(sql2)) {
                ps.setInt(1, bid);
                ps.setInt(2, rid);
                ps.setTimestamp(3, new Timestamp(new Date().getTime()));
                ps.executeUpdate();
            }
        }
        System.out.println("借书完成");
    }
}
