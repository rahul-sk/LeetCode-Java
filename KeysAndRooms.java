  
 /**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v 
 * opens the room with number v. Initially, all the rooms start locked (except for room 0). You can walk back and forth between rooms freely. Return true if and 
 * only if you can enter every room.
 * @author Rahul S Koimattur
 * Intuition : Scan the rooms array from left to right add the visited rooms to a set and at the end, check if the size of the set equals the number of rooms.
 */
 
 class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
     Set<Integer> hs=new HashSet<>();
     Queue<Integer> visitedRooms=new LinkedList<>();
     visitedRooms.add(0);
     while(!visitedRooms.isEmpty()){
         int rm=visitedRooms.poll();
         hs.add(rm);
         for(int i:rooms.get(rm)){
           if(!hs.contains(i)){
           visitedRooms.add(i);    
           }
         }
         
     }
        return hs.size()==rooms.size();
    }
}
