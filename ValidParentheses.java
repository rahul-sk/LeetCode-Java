 /**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * @author Rahul S Koimattur
 * Hint : use stack data structure.
 */
 
 class Solution {
    public boolean isValid(String s) {
        Deque<Character> damn=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                damn.addFirst(s.charAt(i));
            }
            else{
                if(damn.isEmpty()){
                    return false;
                }
                if((s.charAt(i)=='}' && damn.peekFirst()!='{') || (s.charAt(i)==']' && damn.peekFirst()!='[') || (s.charAt(i)==')' && damn.peekFirst()!='(')){
                    return false;
                }
                damn.pop();
          }
       }
        return damn.isEmpty();
    }
}
