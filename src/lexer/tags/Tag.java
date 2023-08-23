
public enum Tag{
  RESERVED("RESERVED"), 
  INDENTIFIER("INDENTIFIER"),
  INT("INT"),
  HEX("HEX"),
  OCT("OCT"),
  DOUBLE("DOUBLE"),
  STRING("STRING"),
  CHAR("CHAR"),
  OPERATOR("OPERATOR"),
  PONCTUACTOR("PONCTUACTOR");

  private final String text;

  Tag(final String text) {
        this.text = text;
  }

  @Override
  public String toString() {
      return text;
  }
}