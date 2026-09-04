class Solution {
    int[][] matrix;
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        this.matrix = matrix;
        this.target = target;
        return bin(0, matrix.length * matrix[0].length - 1 ); 
    }
    public boolean bin(int l, int r){
        if(l > r){
            return false;
        }
        int m = l + (r - l) / 2;
        int middle = matrix[m / matrix[0].length][m % matrix[0].length];
        if(middle == target) return true;
        else if(middle > target) return bin(l, m - 1);
        else return bin(m + 1, r);
    }
}
