import java.util.Scanner;
public class sudoku_game
{
    int size;
    int a[][];
    int game[][];
    int dif;
    sudoku_game(int s,int array[][],int d)
    {
        size=s;
        a=array;
        game=new int[s][s];
        dif=d;
    }

    public void game_gen()
    {
        for(int i=0;i<size;i++) //Inserts space in random indexes(chance is 1 in 3)
        {
            for(int j=0;j<size;j++)
            {
                if((int)(Math.random()*dif)!=1)
                    game[i][j]=a[i][j];
            }
        }
    }

    public void print_game()
    {
        for(int k=1;k<=size;k++)
        System.out.print("    "+k);
        System.out.println();
        System.out.print("  ");
        for(int k=0;k<size;k++)
            System.out.print("—————");
            System.out.println();
        
            for(int i=0;i<size;i++) 
        {
            System.out.print((i+1)+" | ");
            for(int j=0;j<size;j++)
            {
                if(game[i][j]==0)
                    System.out.print("   | ");
                else if(game[i][j]>9)
                    System.out.print(game[i][j]+" | ");
                else
                    System.out.print(game[i][j]+"  | ");
            }
            System.out.print(" "+(i+1));
            System.out.println();
            System.out.print("  ");
            for(int k=0;k<size;k++)
                System.out.print("—————");
               System.out.println(); 
        }
        
        for(int k=1;k<=size;k++)
        System.out.print("    "+k);
        System.out.println(); 
    }

    public boolean ch_game()
    {
        int c=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(game[i][j]==0)
                    c++;
            }
        }
        if(c==0)
            return true;
        else
            return false;
    }

    public void game()
    {
        Scanner sc=new Scanner(System.in);
        int w=0;
        game_gen();
        while(true)   //Infinite loop
        {
            print_game();
            if(ch_game())
            {
                System.out.println("\nYOU WON !\n");
                return;
            }
            System.out.println();
            System.out.println("Choose your row");   //Asks user for indexes
            int k=sc.nextInt();
            System.out.println("Choose your column");
            int l=sc.nextInt();
            System.out.println("Enter your value:");
            int e=sc.nextInt();

            if(a[k-1][l-1]==e)     //If enetered value is correct update the question sudoku
            {
                game[k-1][l-1]=e;
                System.out.println("Correct");
            }
            else
            {
                System.out.println("Wrong");
                if(++w==3)
                {
                    System.out.println("\nYOU LOSE ! \n"); 
                    return;
                }
            }
        }
    }
}

