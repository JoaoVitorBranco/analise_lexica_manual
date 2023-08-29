package lexer.tags;


public class Token {

    public Tag tag;
    public int line;
    private int column;

   
    public Token(Tag tag, int line, int column) {
        this.tag = tag;
        this.line = line;
        this.column = column;
    }

    public String getTag() {
        return this.tag.toString();
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getLine() {
        return this.line;
    }

    public void setLine(int line) {
        this.line = line;
    }
    
    @Override
    public String toString() {
        return this.line + ":" + this.column + " " + "<" + this.tag.toString() + "> ";
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
