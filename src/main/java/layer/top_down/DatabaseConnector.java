package layer.top_down;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {

  private static final String DEFAULT_DB_URL = "jdbc:mysql://duemmer.informatik.uni-oldenburg.de:54020/trash?serverTimezone=UTC";
  private static final String DEFAULT_USER = "manar";
  private static final String DEFAULT_PASSWORD = "For(inti=0)";

  private static final HikariDataSource dataSource;

  static {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(System.getProperty("DB_URL", DEFAULT_DB_URL));
    config.setUsername(System.getProperty("DB_USER", DEFAULT_USER));
    config.setPassword(System.getProperty("DB_PASS", DEFAULT_PASSWORD));

    config.setMaximumPoolSize(10);         // Anzahl gleichzeitiger Verbindungen
    config.setMinimumIdle(2);              // Mindestanzahl idler Verbindungen
    config.setIdleTimeout(600000);         // 10 Minuten
    config.setConnectionTimeout(30000);    // Max Wartezeit beim Anfordern einer Connection
    config.setMaxLifetime(1800000);        // Max Lebensdauer einer Connection (30min)

    dataSource = new HikariDataSource(config);
  }

  public static Connection connect() throws SQLException {
    return dataSource.getConnection();  // holt Connection aus Pool
  }
}
