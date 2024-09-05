class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String st: skill_trees) {
            int t = 0;
            boolean check = true;
            
            for(int i = 0; i < skill.length(); i++) {
                int id = st.indexOf(skill.charAt(i));
                if(id != -1 && (id < t || t == -1)) {
                    check = false;
                    break;
                }
                t = id;
            }
            if(check) {
                answer++;
            }
        }
        
        return answer;
    }
}