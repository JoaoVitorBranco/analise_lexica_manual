package lexer.tags;


public class ConstReal extends Token{
    private String value;


    ConstReal(String n_real, int line){
        super(Tag.DOUBLE, line);
        
        try{
            setValue(n_real);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public String getValue(){
        return this.value;
    }
    public void setValue(String n_real){
        if (! isConstReal(n_real)){
            throw new IllegalArgumentException("Número Real não válido");
        }
        else{
            this.value = n_real;
        }
    }
    public String toString(){
        return super.toString() + this.value;
    }

    public static boolean isConstReal(String n_real){
        String n_real_lower = n_real.toLowerCase();
        if(n_real_lower.matches("[+,-]?[0-9]+.[0-9]+([e,E][+,-]?[0-9]+)?")){
            return false;
        }

        return true;
    }


}
