public class sudoku_gen
{
    int size=9;
    int a[][]=new int[size][size];

    public int[][] gen()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size; )
            {
                int n=1+(int)(Math.random()*size);
                if(ch_row_col(i,j,n) && ch_block(i,j,n))
                {
                    a[i][j]=n;
                    j++;
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
        return a;
    }

    public boolean ch_row_col(int i, int j, int n)
    {
        for(int k=0;k<size;k++)
        {
            if(a[k][j]==n)
                return false;
        }
        for(int k=0;k<size;k++)
        {
            if(a[i][k]==n)
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
