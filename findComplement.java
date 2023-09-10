class Solution {
    public int findComplement(int num) {
        int nBits = (int)Math.floor((Math.log(num) / Math.log(2)) + 1);
        int mask = (1 << nBits) - 1;
        return ~num & mask;
    }
}
