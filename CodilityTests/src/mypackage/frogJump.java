package mypackage;

//import java.lang.Math;

public class frogJump {

    public static void main(String[] args)
    {
        frogJump obj = new frogJump();
        System.out.println("Number of jumps frog needs to make: " + obj.solution(10,120,30));
    }

    public int solution(int X, int Y, int D){
        
        int ans = 0;
        int i=1;
        int sum = (X + (i*D));
        /*
        while(sum < (Y + D))
        {
            if(sum < Y)
            {
                i++;
                sum = (X + (i*D));
            }
            if(sum == Y || sum > Y){
                ans = i;
                break;
            }
        }
        */
        
        do{
            if(X == Y){
                break;
            }
            
            sum = (X + (i*D));
            if(sum < Y)
            {
                i++;
                sum = (X + (i*D));
            }
            if(sum == Y || sum > Y){
                ans = i;
                break;
            }

        }
        while(sum < (Y + D));
        return ans;
    }
}