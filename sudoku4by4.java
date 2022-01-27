import java.util.Scanner;
public class sudoku4by4
{
    public static void main()
    {
        int a[][]=new int[4][4];
        int i, j=0, n=0, b=0, m, q=0;
        System.out.println("Generating Sudoku.....Please wait.....");
        for(i=0;i<=3;i++)
        {
            for(j=0;j<=3;j++) //Generating a random array
            {
                a[i][j]=(int)(1+Math.random()*(4-1+1));
                n++;
            }

            if(n==16)
            {
                
                check: //Checking if it is a sudoku
                for(int k=0;k<=3;k++)
                {
                    for(int l=0;l<=3;l++)
                    {
                        b=a[k][l];
                        for(m=0;m<=3;m++)
                        {
                            if(k==m)
                                continue;
                            else
                            if(b==a[m][l])
                            {
                                i=-1;
                                j=0;n=0;
                                break check;
                            }
                        }
                        for(q=0;q<=3;q++)
                        {
                            if(l==q)
                                continue;
                            else if(b==a[k][q])
                            {
                                i=-1;
                                j=0;n=0;
                                break check;
                            }
                        }
                        if(k%2==1 && l%2==1)
                        {
                            if(a[k][l]==a[k-1][l-1] || a[k][l-1]==a[k][l] || a[k][l]==a[k-1][l] )
                            {
                                i=-1;
                                j=0;
                                n=0;
                                break check;
                            }
                        }
                        if(k%2==0 && l%2==0)
                        {
                            if(a[k][l]==a[k+1][l+1] || a[k][l]==a[k][l+1] || a[k][l]==a[k+1][l])
                            {
                                i=-1;
                                j=0;
                                n=0;
                                break check;
                            }
                        }
                        if(l%2==1 && k%2==0)
                        {
                            if(a[k][l]==a[k][l-1] || a[k][l]==a[k+1][l-1] || a[k+1][l]==a[k][l])
                            {
                                i=-1;
                                j=0;
                                n=0;
                                break check;
                            }
                        }
                        if(k%2==1 && l%2==0)
                        {
                            if(a[k-1][l]==a[k][l] || a[k-1][l+1]==a[k][l] || a[k][l]==a[k][l+1])
                            {
                                i=-1;
                                j=0;
                                n=0;
                                break check;
                            }
                        }
                    }
                }
            }
        }
        
        game_gen(a);  //Calling game generator
    }

    public static void game_gen(int a[][])
    {
        char b[][]=new char[4][4];
        for(int i=0;i<=3;i++) //Inserts space in random indexes(chance is 1 in 3)
        {
            for(int j=0;j<=3;j++)
            {
                if((int)(Math.random()*3+1)==1)
                    b[i][j]=' ';
                else
                    b[i][j]=(char)('0'+a[i][j]);
            }
        }
        game(a,b);  //calls game function
    }

    public static void game(int a[][],char b[][])
    {
        Scanner sc=new Scanner(System.in);
        int c=0,w=0;
        while(true)   //Infinite loop
        {
            System.out.println("——————————————————");
            
            for(int i=0;i<=3;i++)  //Prints the current question sudoku
            {
                System.out.print("| ");
                for(int j=0;j<=3;j++)
                {
                    System.out.print(b[i][j]+" | ");
                    if(b[i][j]==' ')
                    c++;  //Counts no. of spaces
                }
                System.out.println();
                System.out.println("——————————————————");
                
            }
            if(c==0)  //If no spaces are present then won
            {
               System.out.println("YOU WON ! \n");
               return;
            }
            else
            c=0;
            
            System.out.println("Choose your row");   //Asks user for indexes
            int k=sc.nextInt();
            System.out.println("Choose your column");
            int l=sc.nextInt();
            System.out.println("Enter your value:");
            int e=sc.nextInt();
            if(a[k-1][l-1]==e)     //If enetered value is correct update the question sudoku
            {
                b[k-1][l-1]=(char)('0'+e);
                System.out.println("Correct");
            }
            else
            {
                System.out.println("Wrong");
                if(++w==2)
                {
                   System.out.println("\nYOU LOSE ! \n"); 
                   return;
                }
            }
        }
    }
}