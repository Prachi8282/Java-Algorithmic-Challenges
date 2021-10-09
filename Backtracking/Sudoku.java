class Solution {
   boolean a=false;
    public void solveSudoku(char[][] board) {
        //ans=new char[board.length][board[0].length];
        helper(board,0,0);
        //System.out.println(a);
    }
    public void helper(char[][] board,int i,int j){
        if(a)
            return;
        if(i==9)
            {a=true;return;}
        int nx=i,ny=j;
        if(j==8){
            nx=i+1;ny=0;
        }
        else
            ny++;
        if(board[i][j]!='.')
            helper(board,nx,ny);
        else{
            for(char val='1';val<='9';val++){
                if(check(board,i,j,val)){
                    board[i][j]=val;
                    helper(board,nx,ny);
                    if(!a)
                        board[i][j]='.';
                }
            }
        }
    }
    public boolean check(char[][] board,int i,int j,char val){
        for(int k=0;k<9;k++){
            if(board[i][k]==val)
                return false;
            if(board[k][j]==val)
                return false;
        }
        int a=i/3*3,b=j/3*3;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++)
                if(board[x+a][y+b]==val)
                    return false;
        }
        return true;
    }
}