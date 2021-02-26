package CD;

import java.util.Scanner;
import java.util.Stack;

public class FirstFollow {
    static String[]p;
    static Stack<Character> first;
    static Stack<Character> follow;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No.of Productions:");
        int n= input.nextInt();
        System.out.println("Enter the productions:");
        p = new String[n];
        for (int i = 0; i < n; i++) {
            p[i]=input.next();
        }
        first= new Stack<Character>();
        follow= new Stack<Character>();
        char temp;
        do{
            System.out.println("Enter the element for which first&follow should be found");
            char e = input.next().charAt(0);
            if(Character.isLowerCase(e)){
                System.out.println("First={ "+e+" }");
                System.out.println("Follow is not possible for terminal");
                break;
            }

            findFirst(e);
            System.out.println("First=");
            System.out.println(first);
            first.clear();

            findFollow(e);
            System.out.println("Follow=");
            System.out.println(first);
            System.out.println(follow);
            first.clear();
            follow.clear();

            System.out.println("Do you want to continue(Y|N)");
            temp=input.next().charAt(0);
        }while(temp=='Y');
    }

    private static void findFirst(char e) {
        for (int i = 0; i < p.length; i++) {
            if (p[i].charAt(0)==e){
                char temp=p[i].charAt(3);
                if(Character.isLowerCase(temp)){
                    first.push(temp);
                }
                else if (Character.isUpperCase(temp)){
                    findFirst(temp);
                }
            }
        }
    }


    private static void findFollow(char e) {
        if (e=='A'){
            follow.push('$');
        }
        for (int i = 0; i < p.length; i++) {
            for (int j = 3; j < p[i].length(); j++) {
                if (p[i].charAt(j)==e){
                    try{
                        char temp = p[i].charAt(j+1);
                        if (Character.isLowerCase(temp))
                            follow.push(temp);
                        else findFirst(temp);
                    }catch (StringIndexOutOfBoundsException sioobe) {
                        findFollow(p[i].charAt(0));
                    }
                }
            }
        }
    }
}
