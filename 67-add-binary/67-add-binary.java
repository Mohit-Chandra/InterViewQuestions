class Solution {
    public String addBinary(String a, String b) {
        int aindex = a.length()-1;
        int bindex = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(aindex >=0 || bindex>=0){
            int sum = 0;
            if(aindex>=0){
                sum+=a.charAt(aindex)-'0';
                aindex--;
            }
            if(bindex>=0){
                sum+=b.charAt(bindex)-'0';
                bindex--;
            }
            sum+=carry;
            carry = sum/2;
            sb.append(sum % 2);
        }
        if(carry!=0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}