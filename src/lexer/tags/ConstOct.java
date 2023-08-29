
package lexer.tags;

public class ConstOct extends Token{
    private String oct;


    public ConstOct(String oct, int line, int column ){
        super(Tag.OCT, line,column);
        setOct(oct);

    }

    public String getOct(){
        return this.oct;
    }
    public void setOct(String oct){
        if (! isConstOct(oct)){
            throw new IllegalArgumentException("Oct não válido");
        }
        else{
            this.oct = oct;
        }
    }
    public String toString(){
        return super.toString() + this.oct;
    }

    public static boolean isConstOct(String oct){
        oct = oct.toLowerCase();
        if(oct.matches("0[0-7]*")){
            return true;
        }
        return false;
    }

}
