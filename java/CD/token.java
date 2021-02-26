package CD;
import java.util.Scanner;

public class token {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the String:");
        String str=input.nextLine();
        char[][] token = new char[10][10];
        int j=0,k=0;
        for (int i = 0; i<str.length(); i++) {
            if(str.charAt(i)==' '){
                j++;
                k=0;
            }
            else if (str.charAt(i)=='+'||str.charAt(i)=='-'||
                        str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)==';'){
                j++;
                token[j][0]=str.charAt(i);
                j++;
                k=0;
            }
            else{
                token[j][k]=str.charAt(i);
                k++;
            }
        }
        System.out.println("TOKENS ARE:");
        for (int i = 0; i<=j; i++) {
            System.out.println(token[i]);
        }
    }
}
