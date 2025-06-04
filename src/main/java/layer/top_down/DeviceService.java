package layer.top_down;
public class DeviceService {
  private DeviceRepository deviceRepository;

  public DeviceService(DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  public void turnDeviceOn(Device device) {
    device.setOn(true);
    deviceRepository.updateDeviceState(device.getId(), true);
  }

  public void turnDeviceOff(Device device) {
    device.setOn(false);
    deviceRepository.updateDeviceState(device.getId(), false);
  }
}
