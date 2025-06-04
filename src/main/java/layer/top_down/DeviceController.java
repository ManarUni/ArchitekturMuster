package layer.top_down;

public class DeviceController {
  private DeviceService deviceService;

  public DeviceController(DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  public void onTurnOnButtonClicked(Device device) {
    deviceService.turnDeviceOn(device);
  }

  public void onTurnOffButtonClicked(Device device) {
    deviceService.turnDeviceOff(device);
  }
}
