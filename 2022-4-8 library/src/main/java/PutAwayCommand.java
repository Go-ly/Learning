
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PutAwayCommand {
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


        Integer bid = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名: ");
        String name = scanner.nextLine();
        System.out.println("请输入数量: ");
        int count = scanner.nextInt();
        try(Connection c = db.getConnection()) {
            String sql = "select bid from books where name = ?";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, name);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        bid = rs.getInt("bid");
                    }
                }
            }
        }

        if (bid != null) {
            try (Connection c = db.getConnection()) {
                String sql = "update books set total = total + ?, count = count + ? where bid = ?";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setInt(1, count);
                    ps.setInt(2, count);
                    ps.setInt(3, bid);

                    ps.executeUpdate();
                }
            }
        } else {
            try (Connection c = db.getConnection()) {
                String sql = "insert into books (name, count, total) values (?, ?, ?)";
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setString(1, name);
                    ps.setInt(2, count);
                    ps.setInt(3, count);
                    ps.executeUpdate();
                }
            }
        }
        System.out.println("上架成功");
    }
}
