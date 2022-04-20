/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int rowArr[]=new int[row];
        Arrays.fill(rowArr,-1);
        int colArr[]=new int[col];
        Arrays.fill(colArr,-1);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowArr[i]=0;
                    colArr[j]=0;
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowArr[i]==0 || colArr[j]==0){
                     matrix[i][j]=0;
                }
            }
        }
    }
}


//optimised approach
// we are traversing from back because zeroth col and row may change when we start traversing from the beginning so we have started traversing from the back 
// we have to take col0th because ?
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col0th=true;
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0){
                col0th= false;
            }
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }  
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>0;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
             }
             if(col0th==false){
                    matrix[i][0]=0;
             }
        }
      
    }
}
