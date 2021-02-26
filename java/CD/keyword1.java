package CD;

import java.util.Scanner;

public class keyword1 {
    public static void main(String[] args) {
        String[] keywords ={"if","else","while","for","do","int","char","float","double","long",
                                "short", "signed","unsigned","void","delete","union","struct","enum","goto","continue",
                                "break","auto","static","extern","register","switch","case","const","volatile","typedef",
                                "return","default"};
        System.out.println("Enter word:");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        for (int i = 0; i < 32; i++) {
            if(word.equals(keywords[i])){
                System.out.println("It is a keyword");
                System.exit(0);
            }
        }
        System.out.println("Not a keyword");
    }
}
