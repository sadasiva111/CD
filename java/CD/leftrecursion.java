package CD;

import java.util.Scanner;

public class leftrecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Productions:");
        int n=input.nextInt();

        String[] pd = new String[10];
        System.out.println("Enter Productions of the Grammar");
        for (int i = 0; i < n; i++) {
            pd[i]=input.next();
        }

        int flag=0,u=0,v;
        int k=0,l=0;
        char[] alpha = new char[10];
        char[] beta = new char[10];
        for (int i = 0; i < n; i++) {
            char x=pd[i].charAt(0);
            if(x==pd[i].charAt(3)){
                flag=1;
                for (int j = 4; pd[i].charAt(j)!='|'; j++) {
                    alpha[k++]=pd[i].charAt(j);
                    u=j;
                }
                k=0;
                for (int j = u+2; j<pd[i].length(); j++) {
                    beta[l++]=pd[i].charAt(j);
                }
                l=0;
            }
            else continue;
            System.out.println("Production "+pd[i]+"should be replaced with");
            System.out.print(x+"->");
            for (int j = 0; j < beta.length; j++) {
                System.out.print(beta[j]);
            }
            System.out.print(x+"'\n");
            System.out.print(x+"'->");
            for (int j = 0; j < alpha.length; j++) {
                System.out.print(alpha[j]);
            }
            System.out.print(x+"'|#");
        }
        if (flag==0){
            System.out.println("grammar is not left recursive");
        }
    }
}
