package layer.top_down;

import java.sql.*;

public class DeviceRepository {
  private Connection connection;

  public DeviceRepository(Connection connection) {
    this.connection = connection;
  }

  public void updateDeviceState(int deviceId, boolean isOn) {
    String sql = "UPDATE devices SET is_on = ? WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setBoolean(1, isOn);
      stmt.setInt(2, deviceId);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Optional: Load device by id
}
