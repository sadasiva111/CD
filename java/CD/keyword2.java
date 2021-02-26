package CD;

import java.util.Scanner;

public class keyword2 {
    public static void main(String[] args) {
        String[] keywords={"int","char","const","float","double","long","short","signed","unsigned","delete",
                            "if","else","while","do","struct","enum","union","typedef","continue","break",
                            "auto","static","register","extern","switch","case","return","default","sizeof","volatile",
                            "for","void"};
        int [] temp = new int[32];
        for (int i = 0; i < 32; i++) {
            temp[i]=1;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Word length:");
        int n = input.nextInt();
        int k=0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Character "+(i+1));
            char x = input.next().charAt(0);
            int flag=0;
            for (int j = 0; j < 32; j++) {
                if (temp[j]==1){
                    if (x==keywords[j].charAt(k)){
                        temp[j]=1;
                        flag=1;
                    }
                    else temp[j]=0;
                }
            }
            if(flag==0){
                System.out.println("No match");
                System.exit(0);
            }
            k++;
        }
        for (int i = 0; i < 32; i++) {
            if (temp[i]==1){
                if (keywords[i].length()==n){
                    System.out.println("It is keyword");
                    System.exit(0);
                }
            }
        }
        System.out.println("No match");
    }
}
