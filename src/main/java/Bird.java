public class Bird {

  private static final double SPEED_CONSTANT = 100.0d;
  private static final double LOAD_FACTOR = 0.75;
  private BirdType type;
  private double weight;
  private double numberOfCoconuts;
  private boolean isNailed;
  private double voltage;

  public Bird(BirdType type, double weight, double numberOfCoconuts, boolean isNailed, double voltage) {
    this.type = type;
    this.weight = weight;
    this.numberOfCoconuts = numberOfCoconuts;
    this.isNailed = isNailed;
    this.voltage = voltage;
  }

  public double getSpeed() {
    switch (type) {
      case EUROPEAN:
        return getBaseSpeed();
      case AFRICAN:
        return getBaseSpeed() - LOAD_FACTOR * numberOfCoconuts;
      case NORWEGIAN_BLUE:
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }
    throw new RuntimeException("Should be unreachable");
  }

  private double getBaseSpeed(double voltage) {
    return getBaseSpeed() * voltage;
  }

  private double getBaseSpeed() {
    return SPEED_CONSTANT / weight;
  }

  enum BirdType {
    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE
  }

  public static void main(String[] args) {
    Bird bird = new Bird(BirdType.EUROPEAN, 100.0, 1.0, false, 10.0);
    System.out.println("Bird type: " + bird.type + ". Speed: " + bird.getSpeed());
  }
}
