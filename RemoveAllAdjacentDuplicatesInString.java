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
