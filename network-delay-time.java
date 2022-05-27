import java.util.*;
//https://www.codingninjas.com/codestudio/problems/network-delay-time_1382215?leftPanelTab=0

public class Solution {
   
    static class Edge{
int src;
int nbr;
int wt;
Edge(int src,int nbr,int wt){
this.src=src;
this.nbr=nbr;
this.wt=wt;

    }
}
static class Pair implements Comparable<Pair>{
    int  n;
    int lev;
    Pair(int n ,int lev){
        this.n=n;
        this.lev=lev;
    }
    @Override
    public int compareTo(Pair that){
        return this.lev-that.lev;
        
    }
}
public  static int networkDelayTime(int[][] t, int n, int k) {
    ArrayList<Edge> a[]= new ArrayList[n+1];
    for(int i=0;i<n+1;i++){
        a[i]=new ArrayList<>();
    }
    for(int i=0;i<t.length;i++){
        a[t[i][0]].add(new Edge(t[i][0],t[i][1] ,t[i][2]));
    }
   boolean vis[] = new boolean[n+1];
    PriorityQueue<Pair> pq= new PriorityQueue<>();
    pq.add(new Pair(k,0));
    int ans  =0;
    
    while(pq.size()>0){
        Pair rem = pq.remove();
        if(vis[rem.n]){
            continue;
        }
        vis[rem.n] =true;
        ans = rem.lev;
        for(Edge e : a[rem.n]){
            if(!vis[e.nbr]){
                pq.add(new Pair(e.nbr , rem.lev+e.wt));
                
            }
        }
    } 
    for(int i=1;i<vis.length;i++){
        if(!vis[i]){
            return -1
                ;
        }
    }
    return ans ;
    
}

}
