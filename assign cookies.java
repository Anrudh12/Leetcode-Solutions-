class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // sort the children's greed factors in non-decreasing order
        Arrays.sort(s); // sort the cookie sizes in non-decreasing order
        int contentChildren = 0;
        int i = 0; // pointer to the current child's greed factor
        int j = 0; // pointer to the current cookie size
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // if the current cookie can satisfy the current child's greed factor
                contentChildren++;
                i++;
            }
            j++;
        }
    return contentChildren;
    }
}        
