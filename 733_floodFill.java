class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int m=image.length;
       int n=image[0].length;
        int old=image[sr][sc];
        if(old==color)
            return image;
        dfs(image,sr,sc,color,old);
        return image;
    }
    public void dfs(int[][] image,int i,int j,int color,int old)
    {
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=old)
            return;
        image[i][j]=color;
        dfs(image,i+1,j,color,old);
        dfs(image,i-1,j,color,old);
        dfs(image,i,j+1,color,old);
        dfs(image,i,j-1,color,old);
    }
}