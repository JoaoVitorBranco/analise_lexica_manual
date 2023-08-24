package lexer.tags;


public class ConstHex extends Token {
    private String hex;


    public ConstHex(String hex, int line){
        super(Tag.HEX, line);
        
        try{
            setHex(hex);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public String getHex(){
        return this.hex;
    }
    public void setHex(String hex){
        if (! isConstHex(hex)){
            throw new IllegalArgumentException("Hex não válido");
        }
        else{
            this.hex = hex;
        }
    }
    public String toString(){
        return "Hex: " + this.hex;
    }

    public static boolean isConstHex(String hex){
        hex = hex.toLowerCase();
        if(hex.startsWith("0x") && hex.length() > 2 && hex.matches("^0x[0-9a-f]+$")){
            return true;
        }
        return false;
    }

}
