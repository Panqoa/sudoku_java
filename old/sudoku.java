import java.util.Scanner;
public class sudoku
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("________SUDOKU________\n");
        System.out.println("CHOOSE YOUR GAME MODE\n");

        System.out.println("1. 4 X 4\n");

        int c=sc.nextInt();
        if(c==1)
        {
            while(true)
            {
                sudoku4by4.main();
                System.out.println("Play Again");
                System.out.println("1.YES    2.NO");
                if(!(sc.nextInt()==1))
                    break;
            }
        }
        System.out.println("THANK YOU FOR PLAYING");
    }
}
