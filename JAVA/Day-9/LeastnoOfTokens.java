/*
/*
You are given some tokens printed with unique numbers on them and an integer T.
Your task is to find the least number of tokens that you need to make up the 
value T, by adding the numbers printed on all the tokens. 
If you cannot make the value T, by any combination of the tokens, return -1.

NOTE: Assume that you have an unlimited set of tokens of each number type.

Input Format:
-------------
Line-1: Space separated integers tokens[], number printed on tokens.
Line-2: An integer T.

Output Format:
--------------
Print an integer, minimum number of tokens to make the value T.


Sample Input-1:
---------------
1 2 5
11

Sample Output-1:
----------------
3

Explanation:
------------
5+5+1 = 11


Sample Input-2:
---------------
2 4
15

Sample Output-2:
----------------
-1

*/
import java.util.*;

public class Test{
    public static int Tokens(int []arr,int n){
        if(n<1)return 0;
        int []dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i:arr){
            for(int j=i;j<=n;j++){
                if(dp[j-i]!=Integer.MAX_VALUE)
                dp[j]=Math.min(dp[j],dp[j-i]+1);
            }
        }
        if(dp[n]!=Integer.MAX_VALUE)
        return dp[n];
        return -1;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String []ar=sc.nextLine().split(" ");
        int arr[]=new int[ar.length];
        for(int i=0;i<ar.length;i++)
        arr[i]=Integer.parseInt(ar[i]);
        int n=sc.nextInt();
        System.out.println(Tokens(arr,n));

    }
}
