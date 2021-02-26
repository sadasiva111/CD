package CD;

import java.util.Scanner;

public class nfa2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter dimensions of transition table:m*n");
        int m=input.nextInt();
        int n= input.nextInt();
        char[][] table= new char[m][n];
        System.out.println("Enter transition table of nfa:");
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j]=input.next().charAt(0);
            }
        }
        System.out.println("Enter Initial State:");
        char pstate=input.next().charAt(0);
        System.out.println("Enter Final State:");
        char fstate=input.next().charAt(0);

        System.out.println("Enter Input string:");
        String str = input.next();

        for (int i = 0; i < str.length(); i++) {
            int index1=0,index2=0;
            for (int j = 1; j < table.length; j++) {
                if(table[j][0]==pstate){
                    index1=j;
                    break;
                }
            }
            for (int j = 1; j < table[0].length; j++) {
                if(table[0][j]==str.charAt(i)){
                    index2=j;
                    break;
                }
            }
            pstate=table[index1][index2];
            if(pstate=='#'){
                System.out.println("Not accepted");
                System.exit(0);
            }
        }
        if(pstate==fstate)
            System.out.println("It is accepted by nfa");
        else System.out.println("not accepted");
    }
}
