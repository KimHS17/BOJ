import java.util.*;

class Node {
    int e, w;

    Node(int e, int w) {
        this.e = e;
        this.w = w;
    }
}

class Solution {
    static List<List<Node>> graph;
    
    static boolean isGate(int num, int[] gates) {
        for(int gate: gates) {
            if(num == gate)
                return true;
        }
        
        return false;
    }

    static boolean isSummit(int num, int[] submits) {
        for(int submit: submits) {
            if(num == submit)
                return true;
        }
        
        return false;
    }
    
    static int[] search(int n, int[] gates, int[] summits) {
        Queue<Node> q = new LinkedList<>();
        int[] intensity = new int[n + 1];

        Arrays.fill(intensity, Integer.MAX_VALUE);

        for(int gate : gates) {
            q.add(new Node(gate, 0));
            intensity[gate] = 0;
        }
        
        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.w > intensity[now.e])
                continue;

            for (int i = 0; i < graph.get(now.e).size(); i++) {
                Node next = graph.get(now.e).get(i);
                int dis = Math.max(intensity[now.e], next.w);
                
                if (intensity[next.e] > dis) {
                    intensity[next.e] = dis;
                    q.add(new Node(next.e, dis));
                }
            }
        }

        int resN = Integer.MAX_VALUE;
        int resW = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int summit: summits) {
            if (intensity[summit] < resW) {
                resN = summit;
                resW = intensity[summit];
            }
        }

        return new int[]{resN, resW};
    }

    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        int[] answer;
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] path: paths) {
            if(isGate(path[0], gates) || isSummit(path[1], summits)) {
                graph.get(path[0]).add(new Node(path[1], path[2]));
            } else if(isGate(path[1], gates) || isSummit(path[0], summits)) {
                graph.get(path[1]).add(new Node(path[0], path[2]));
            } else {
                graph.get(path[0]).add(new Node(path[1], path[2]));
                graph.get(path[1]).add(new Node(path[0], path[2]));
            }
        }
        
        answer = search(n, gates, summits);
        
        return answer;
    }
}