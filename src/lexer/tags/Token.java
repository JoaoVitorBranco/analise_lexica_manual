package lexer.tags;


public class Token {

    public Tag tag;
    public int line;

   
    public Token(Tag tag, int line) {
        this.tag = tag;
        this.line = line;
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
        return this.line + " " + "<" + this.tag.toString() + "> ";
    }
}
