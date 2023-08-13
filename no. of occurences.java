class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        HashSet<Integer> map=new HashSet<>();
                for(int i=0;i<nums.length;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],1);
            }
            else{
                mp.put(nums[i],mp.get(nums[i])+1);
            }
        }

        for(var e:mp.keySet()){
            map.add(mp.get(e));
        }
       if(mp.size()==map.size()){
           return true;
       }
     return false;

    }
}
