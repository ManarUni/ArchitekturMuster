package layer.top_down;

public class Device {
  private int id;
  private String name;
  private boolean isOn;

  // Konstruktor
  public Device(int id, String name, boolean isOn) {
    this.id = id;
    this.name = name;
    this.isOn = isOn;
  }

  // Getter & Setter
  public int getId() { return id; }
  public String getName() { return name; }
  public boolean isOn() { return isOn; }

  public void setOn(boolean on) { isOn = on; }
}
