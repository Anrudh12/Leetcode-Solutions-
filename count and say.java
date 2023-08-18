class Solution {
    public String countAndSay(int n) {
        if(n==1)
        {
            return "1";
        }
        if(n==2)
        {
            return "11";
        }
        StringBuilder nm=new StringBuilder();
        nm.append("11");
        for(int i=3;i<=n;i++)
        {
            StringBuilder kk=new StringBuilder();
            task(nm.toString(),kk);
            nm.setLength(0);
            nm.append(kk);
        }
        return nm.toString();
    }
    public void task(String s, StringBuilder nm)
    {
        int count=1;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                count++;
            }
            else
            {
                nm.append(count);
                nm.append(s.charAt(i));
                count=1;
            }
        }
        nm.append(count);
        nm.append(s.charAt(s.length()-1));
    }
}
