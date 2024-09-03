import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> h = new HashMap<>();
        HashMap<String, ArrayList<int[]>> g = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) {
            h.put(genres[i], h.getOrDefault(genres[i], 0) + plays[i]);
            
            if(g.containsKey(genres[i])) {
                g.get(genres[i]).add(new int[]{plays[i], i});
            } else {
                ArrayList<int[]> t = new ArrayList<>();
                t.add(new int[]{plays[i], i});
                g.put(genres[i], t);
            }
        }
        
        List<String> keySet = new ArrayList<>(h.keySet());
        keySet.sort((o1, o2) -> h.get(o2).compareTo(h.get(o1)));
        
        for(String key: keySet) {
            ArrayList<int[]> p = g.get(key);
            Collections.sort(p, (o1, o2) -> o2[0] - o1[0]);
            
            ans.add(p.get(0)[1]);
            if(p.size() > 1)
                ans.add(p.get(1)[1]);
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}