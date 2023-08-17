class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (bracketPairs.containsValue(c)) {
                stack.push(c);
            } else if (bracketPairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}
