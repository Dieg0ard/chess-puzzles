package logic;
public class Square{
    private char file;
    private int rank;

    // ========================== GETTERS ========================== 
    public int getRank(){
        return rank;
    }

    public int getFile(){
        return file;
    }

    public String getCoordinates(){
        String coordinates = file + rank + "";
        return coordinates;
    }

    // ========================== SETTERS ========================== 
    public void setRank(int rank){
        this.rank = rank;
    }

    public void setFile(char file){
        this.file = file;
    }

    public void setCoordinate(String coordinates){
        char file = coordinates.charAt(0);
        int rank = coordinates.charAt(1) - '0';
        
        this.file = file;
        this.rank = rank;
    }
    
    
}