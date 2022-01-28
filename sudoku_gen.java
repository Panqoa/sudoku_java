public class sudoku_gen
{
    int size=9;

    int a[][]=new int[size][size];

    public int[][] gen()
    {
        System.out.println(a.length);
        for(int n=1;n<=size;n++)
        {
            for(int i=0;i<size; )
            {
                int j=(int)(Math.random()*size);
                if(a[i][j]==0)
                {
                    if(ch_col(j,n) && ch_block(i,j,n))
                    {
                        //System.out.println(j);
                        a[i][j]=n;
                        i++;
                        for(int k=0;k<=8;k++)
                        {
                            for(int l=0;l<=8;l++)
                            {
                                System.out.print(a[k][l]+ " ");
                            }
                            System.out.println();
                        }
                    }
                }
            }

        }
        return a;
    }

    public boolean ch_col(int j, int n)
    {
        for(int i=0;i<size;i++)
        {
            if(a[i][j]==n)
                return false;
        }
        return true;
    }
    
    public boolean ch_block(int row, int col, int num)
    {
        int blockrow=(int)(Math.sqrt(size));
        int blockcol=(int)(Math.sqrt(size));
        boolean res=true;
        int startrowindex=row-(row%blockrow);
        int startcolindex=col-(col%blockcol);
        int i=0,j=0;
        outer:
        for(i=startrowindex;i<startrowindex+blockrow;i++)
        {
            for(j=startcolindex;j<startcolindex+blockcol;j++)
            {
                if(i==row && j==col)
                continue;
                else
                {
                    if(a[i][j]==num)
                    {
                        res=false;
                        break outer;
                    }
                }
            }
        }
        return res;
    }
}
