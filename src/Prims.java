import java.util.*;

class Pairs{
    int node,cost;
    Pairs(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}

class Prims {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Pairs>> adj = new ArrayList<>();

        // Step 1: Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Add edges (u, v, weight)
        adj.get(0).add(new Pairs(1, 2));
        adj.get(0).add(new Pairs(3, 6));
        adj.get(1).add(new Pairs(0, 2));
        adj.get(1).add(new Pairs(2, 3));
        adj.get(1).add(new Pairs(3, 8));
        adj.get(1).add(new Pairs(4, 5));
        adj.get(2).add(new Pairs(1, 3));
        adj.get(2).add(new Pairs(4, 7));
        adj.get(3).add(new Pairs(0, 6));
        adj.get(3).add(new Pairs(1, 8));
        adj.get(3).add(new Pairs(4, 9));
        adj.get(4).add(new Pairs(1, 5));
        adj.get(4).add(new Pairs(2, 7));
        adj.get(4).add(new Pairs(3, 9));

        boolean[] visited=new boolean[V];
        Arrays.fill(visited,false);

        PriorityQueue<Pairs> pq=new PriorityQueue<>(Comparator.comparingInt(p->p.cost));
        //src node
        pq.offer(new Pairs(0,0));

        int sumMst=0;
        int edges=0;

        while (!pq.isEmpty()&&edges<V){
            Pairs current=pq.poll();
            int u=current.node;

            if(!visited[u]){
                sumMst+=current.cost;
                visited[u]=true;
                edges++;

                for (Pairs neighbours:adj.get(u)){
                    if(!visited[neighbours.node]){
                        pq.offer(neighbours);
                    }
                }
            }
        }

        System.out.println("The cost of mst is "+sumMst);
    }
}
