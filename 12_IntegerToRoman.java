class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int Th=num/1000;
        int H=(num%1000)/100;
        int T=(num%100)/10;
        int O=num%10;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Th;i++){
            sb.append("M");
        }
        if(H==9){
            sb.append("CM");
        }else if(H>=5){
            sb.append("D");
            for(int i=0;i<H-5;i++){
                sb.append("C");
            }
        }else if(H==4){
            sb.append("CD");
        }else{
            for(int i=0;i<H;i++){
                sb.append("C");
            }
        }
        if(T==9){
            sb.append("XC");
        }else if(T>=5){
            sb.append("L");
            for(int i=0;i<T-5;i++){
                sb.append("X");
            }
        }else if(T==4){
            sb.append("XL");
        }else{
            for(int i=0;i<T;i++){
                sb.append("X");
            }
        }
        if(O==9){
            sb.append("IX");
        }else if(O>=5){
            sb.append("V");
            for(int i=0;i<O-5;i++){
                sb.append("I");
            }
        }else if(O==4){
            sb.append("IV");
        }else{
            for(int i=0;i<O;i++){
                sb.append("I");
            }
        }
        return sb.toString();
    }
}


// Another solution

// class Solution {
//     public String intToRoman(int num) {
//         String[] keys = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//         int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < values.length && num > 0; i++) {
//             // Repeat while the current symbol still fits into num.
//             while (values[i] <= num) {
//                 num -= values[i];
//                 sb.append(keys[i]);
//             }
//         }
//         return sb.toString();
//     }
// }