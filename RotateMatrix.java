public class RotateMatrix {
	
	public static void main(String[] args){
		int[][] ProcessMatrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] result = Solution(ProcessMatrix,1);
		System.out.println();
	}
	
    public static int[][] Solution(int[][] matrix, int flag) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
        	return matrix;
        }
        int[][] result = transform(matrix);
        filp(result,flag);
        return result;
        
    }
        
    private static int[][] transform(int[][] matrix){
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] result = new int[n][m];
    	for(int i=0;i<m;i++){
    		for(int j=0; j<n; j++){
    			result[j][i] = matrix[i][j];
    		}
    	}
    	return result;
    }
    private static void filp(int[][] matrix,int flag){
    	int m = matrix.length;
    	int n = matrix[0].length;
    	if(flag==-1){
    		for(int i=0; i<m; i++){
    			for(int j=0; j<n/2; j++){
    				int tmp = matrix[i][j];
    				matrix[i][j] = matrix[i][n-j-1];
    				matrix[i][n-j-1] = tmp;
    			}
    		}
    	}else{
    		for(int i=0; i<m/2 ; i++){
    			for(int j=0; j<n; j++){
    				int tmp = matrix[i][j];
    				matrix[i][j] = matrix[m-i-1][j];
    				matrix[m-i-1][j] = tmp;
    			}
    		}
    	}
    }
}