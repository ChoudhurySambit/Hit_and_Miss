import java.io.*;
class Gamehelp{
    public String GetInput(String prompt){
        String input=null;
        System.out.println(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            input = is.readLine();
            if (input.length()==0)
                return null;
        }
        catch (Exception e){
            System.out.println("exception "+e);
        }
        return input;
    }
}
class Ship{
    int[] location;
    int NumberOfhits=0;
    public void setlocation(int[] num){
        location =num;
    }
    public String checkyourself(String guss){
        int input=Integer.parseInt(guss);
        String result="miss";
        for (int i : location) {
            if (i==input){
                NumberOfhits++;
                result="hit";
                break;
            }
            else{
                result="miss";
            }
        }
        if (NumberOfhits==location.length){
            result="Kill";
        }
        System.out.println(result);
        return result;
    }
}
public class Ship_shinking_game{
    public static void main(String[] args) {
        Ship ob = new Ship();
        int Guss=0;
        boolean a1=true;
        int num=(int)(Math.random()*5);
        int[] num1={num,num+1,num+2};
        ob.setlocation(num1);
        Gamehelp ob1 = new Gamehelp();
        while(a1==true){
            String input=ob1.GetInput("Enter Value");
            String Result=ob.checkyourself(input);
            Guss++;
            if (Result.equals("Kill"))
                a1=false;
        }
        System.out.println("You Took "+ Guss +" gusses");
    }
}