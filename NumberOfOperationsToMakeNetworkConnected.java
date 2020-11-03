/**
 *There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming
 *a network where connections[i] = [a, b] represents a connection between computers a and b. 
 *Any computer can reach any other computer directly or indirectly through the network. 
 *Given an initial computer network connections. You can extract certain cables between 
 *two directly connected computers, and place them between any pair of disconnected computers 
 *to make them directly connected. Return the minimum number of times you need to do this in 
 *order to make all the computers connected. If it's not possible, return -1. 
 * @author Rahul S Koimattur
 * Intuition : While connecting a pair of systems,we check if the 2 systems belong to the same
 * component in which case we will increment our redundancy(rud) counter, If they do not belong
 * To the same component, then we will connect the 2 systems using the union operation, Finally 
 * see if the number of individual components/systems is greater than the redudancy value in which
 * Case we return -1 else we return rud-1
 */

 class Solution {
    private void union(int a,int b,int[] par){
     int ap=find(a,par);
        int bp=find(b,par);
        if(ap==bp) return;
        par[ap]=bp;
    }
    private int find(int a,int[] par){
       while(par[a]!=a){
         a=par[a];
        }
        return a;
    }
    public int makeConnected(int n, int[][] connections) {
        int[] par=new int[n];
        int rud=0,cnt=0;
        for(int i=0;i<n;i++){
        par[i]=i;
        }
        for(int[] e:connections){
         int from=e[0],to=e[1];
         if(find(from,par)==find(to,par)) rud++;
          else{
             union(from,to,par);
          }  
        }
        for(int i=0;i<n;i++){
          if(par[i]==i) cnt++;
        }
        return (rud<cnt-1?-1:cnt-1);
    }
}