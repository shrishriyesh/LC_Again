class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> arr1= new ArrayList<>();
        ArrayList<Integer> arr2= new ArrayList<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {arr1.add(i);
                arr2.add(j);}
            }
        }
        for(int x:arr1)
        {
            for(int i=0;i<matrix[0].length;i++)
            matrix[x][i]=0;
        }
        for(int x:arr2)
        {
            for(int i=0;i<matrix.length;i++)
            matrix[i][x]=0;
        }
    }
}