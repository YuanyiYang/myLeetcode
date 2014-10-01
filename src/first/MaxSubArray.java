package first;

public class MaxSubArray {
	public int maxSubArray(int[] A){
		int max = Integer.MIN_VALUE;
		int helper = 0;
		for(int i=0;i<A.length;i++){
			if(helper<0){
				helper = 0;
			}
			helper += A[i];
			max = Math.max(helper, max);
		}
		return max;
	}
}
