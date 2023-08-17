class Solution {
    public String intToRoman(int num) {//L =50 C=100 D=500, M=1000
        String[] ones={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hunds={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thnds= {"","M","MM","MMM"};
    return thnds[num/1000] + hunds[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }

}
