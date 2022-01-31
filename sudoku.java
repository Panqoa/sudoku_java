import java.util.Scanner;
public class sudoku
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("________SUDOKU________\n");
        int size=0,dif=0;
        while(true)
        {
            System.out.println("CHOOSE YOUR GAME MODE\n");
            System.out.println("1. 4 X 4\n");
            System.out.println("2. 9 X 9\n");
            System.out.println("3. 16 X 16\n");
            int c=sc.nextInt();
            switch(c)
            {
                case 1:
                    size=4;
                    break;
                case 2:
                    size=9;
                    break;
                case 3:
                    size=16;
                    break;
                    default:
                        System.out.println("Invalid");
            }
            System.out.println("CHOOSE YOUR DIFFICULTY\n");
            System.out.println("1. Easy\n");
            System.out.println("2. Medium\n");
            System.out.println("3. Hard\n");
            c=sc.nextInt();
            switch(c)
            {
                case 1:
                    dif=6;
                    break;
                case 2:
                    dif=5;
                    break;
                case 3:
                    dif=4;
                    break;
                    default:
                        System.out.println("Invalid");
            }
            if(size!=0 && dif!=0)
            {
                sudoku_gen gen=new sudoku_gen(size);
                sudoku_game game=new sudoku_game(size,gen.gen(),dif);
                game.game();
                System.out.println("Play Again ?");
                System.out.println("1.YES    2.NO");
                if(!(sc.nextInt()==1))
                break;
            } 
        }
        System.out.println("THANK YOU FOR PLAYING");
    }
}
