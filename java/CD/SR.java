package CD;

import java.util.Scanner;
import java.util.Stack;

public class SR {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of productions:");
        int n=input.nextInt();
        String[] p = new String[n];
        System.out.println("Enter the productions");
        for (int i = 0; i < n; i++) {
            p[i]=input.next();
        }

        System.out.println("Enter the input string:");
        String str = input.next();
        Stack<Character> stack = new Stack<Character>();
        stack.push('$');
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            for (int j = 0; j < p.length; j++) {
                int top=stack.size()-1;
                int flag=1;
                if (stack.elementAt(top)==p[j].charAt(3)){
                    for (int k = 3; k < p[j].length(); k++) {
                        if (stack.elementAt(top)==p[j].charAt(k))   
                            top--;
                        else{
                            flag=0;
                            break;
                        }
                    }
                    if (flag==1){
                        for (int k = 3; k < p[j].length(); k++) {
                            stack.pop();
                        }
                        stack.push(p[j].charAt(0));
                    }
                }
            }
            System.out.println(stack);
        }
        int top= stack.size()-1;
        if(stack.elementAt(top)==p[0].charAt(0)&&stack.elementAt(top-1)=='$'){
            System.out.println("String accepted");
        }
        else
            System.out.println("String Not accepted");
    }
}
