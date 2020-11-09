
/**
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can. Return the final string after all such duplicate removals have 
been made.  
 * @author Rahul S Koimattur
 * Intuition : Use a Stack and pop the current character if it matches with the top element of the stack, if not then push it to the stack.
 *             the remaining elements in the stack is the final result. 
 */

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> st=new Stack<>();
        for(char c:S.toCharArray()){
           if(st.isEmpty() || st.peek()!=c){
              st.push(c);
           }
            else{
              if(st.peek()==c){
                  st.pop();
              }
            }
        }
        String res="";
        for(char c:st){
          res+=c;
        }
        return res;
        
    }
}
