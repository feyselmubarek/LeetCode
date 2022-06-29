class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        for(int idx = people.length - 1; idx >= 0; idx--){
            int steps = people[idx][1];
            int itr = idx - 1;
            
            while(itr >= 0 && people[itr][0] == people[idx][0]){
                steps--;
                itr--;
            }
            
            itr = idx;            
            while(steps > 0){
                int[] temp = people[itr + 1];
                people[itr + 1] = people[itr]; 
                people[itr] = temp;
                steps--;
                itr++;
            }
        }
        
        return people;
    }
}

