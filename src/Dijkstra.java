import java.util.*;
class Pair{
    int node,cost;
    Pair(int node ,int cost){
        this.node=node;
        this.cost=cost;
    }
}

public class Dijkstra {
   static void Dj(List<List<Pair>> adj,int V,int src){

       //Array to hold distances
        int[] dist=new int[V];

        //Fill all the distance with infinity and source with 0
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        //Priority queue with descending cost and add src int the queue
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(p->p.cost));
        pq.offer(new Pair(src,0));

        while (!pq.isEmpty()){

            //remove the first element of queue and store node index in u
            Pair current=pq.poll();
            int u=current.node;

            //Handling the duplicates in the priority queue
            if(current.cost>dist[u])continue;


            //adding all neighbors in the queue with smaller distance
            for(Pair neighbor:adj.get(u)){
                int v=neighbor.node;
                int weight=neighbor.cost;

                if(dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;

                    pq.offer(neighbor);
                }
            }
        }

        System.out.println("The shortest distance from source "+src+" is :");
        for (int i=0;i<V;i++){
            System.out.println(i+" -> "+dist[i]);
        }
    }

    public static void main(String[] args) {
        int V=5;
        List<List<Pair>> adj=new ArrayList<>();

        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        //Setting the adjency list

        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(2,6));
        adj.get(0).add(new Pair(3,12));
        adj.get(0).add(new Pair(4,15));
        adj.get(1).add(new Pair(2,7));
        adj.get(1).add(new Pair(4,3));
        adj.get(2).add(new Pair(3,5));
        adj.get(3).add(new Pair(4,3));

        Dj(adj,V,0);
    }
}
