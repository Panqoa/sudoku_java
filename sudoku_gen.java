public class sudoku_gen
{
    int size;
    int a[][];
    int row[];
    sudoku_gen(int s)
    {
        size=s;
        a=new int[s][s];
        row=new int[s];
    }

    public int[][] gen()
    {
        System.out.println("Generating Sudoku...");
        for(int i=0;i<size ;)
        {
            row=gen_row();
            if(ch_row(i))
            {
                place_row(row,i);
                i++;
            }
            row=new int[size];

        }
        return a;
    }

    public int[] gen_row()
    {
        for(int  h=1;h<=size; )
        {
            int i=(int)(Math.random()*size);
            if(row[i]==0)
            {
                row[i]=h; h++;
            }
        }
        return row;
    }

    public void place_row(int row[],int i)
    {
        for(int j=0;j<size;j++)
        {
            a[i][j]=row[j];
        }
    }

    public boolean ch_row(int i)
    {
        for(int k=0;k<size;k++)
        {
            if(ch_row_col(i,k,row[k]) && ch_block(i,k,row[k]))
                continue;
            else
                return false;
        }
        return true;
    }

    public boolean ch_row_col(int i,int j, int n)
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
