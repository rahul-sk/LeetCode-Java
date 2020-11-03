/**
 *In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *If the town judge exists, then:
 *The town judge trusts nobody.
 *Everybody (except for the town judge) trusts the town judge.
 *There is exactly one person that satisfies properties 1 and 2.
 *You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1
 * @author Rahul S Koimattur
 * Intuition : Judge is the one who has 0 out degree and N-1 indegree. 
 *             So the problem boils down to finding a node which satisifies the above condition.
 */

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] out=new int[N+1];
        int[] inn=new int[N+1];
        for(int[] d:trust){
          inn[d[1]]++;
          out[d[0]]++;
        }
       int res=-1;
       for(int i=1;i<=N;i++){
         if(inn[i]==N-1 && out[i]==0){
           res=i;
           break;
         }
       }
        return res;
    }
}