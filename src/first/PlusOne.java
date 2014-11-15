package first;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    if(digits==null) return null;
    int carry = 0;
    for(int i=digits.length-1;i>=0;i--){
        if(i==digits.length-1){
            digits[i] += 1; 
        }else {
            digits[i] += carry;
        }
        if(digits[i]>=10){
            carry = 1;
        }else{
            carry = 0;
        }
        digits[i] = digits[i] % 10;
        if(i==0 && carry==1){
            int[] results = new int[digits.length+1];
            results[0] = 1;
            for(int j=1;j<results.length;j++){
                results[j] = digits[j-1];
            }
            return results;
        }
    }
    return digits;
  }
}
