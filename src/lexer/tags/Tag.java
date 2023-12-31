package lexer.tags;

public enum Tag{
  RESERVED("RESERVED"), 
  IDENTIFIER("IDENTIFIER"),
  INT("INT"),
  HEX("HEX"),
  OCT("OCT"),
  DOUBLE("DOUBLE"),
  STRING("STRING"),
  CHAR("CHAR"),
  OPERATOR("OPERATOR"),
  PUNCTUATOR("PUNCTUATOR");

  private final String text;

  Tag(final String text) {
        this.text = text;
  }

  @Override
  public String toString() {
      return text;
  }
}
