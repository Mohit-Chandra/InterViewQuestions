class UnionFind{
    int n;
    int parent[];
    int rank[];
    UnionFind(int n){
        this.n=n;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i+=1){
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }
    
    public int find(int a){
        if(a!=this.parent[a])
            this.parent[a] = this.find(this.parent[a]);
        return this.parent[a];
    }
    
    public boolean union(int a,int b){
        a = find(a);
        b = find(b);
        boolean isMerged = false;
        if(a == b)
            return isMerged;
        isMerged = true;
        if(this.rank[a] > this.rank[b]){
            this.parent[b] = a;
        }else if(this.rank[a]<this.rank[b]){
            this.parent[a] = b;
        }else{
            this.parent[a] = b;
            this.rank[b]+=1;
        }
        return isMerged;
    }
}
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        if(logs == null)
            return 0;
        Arrays.sort(logs,(l1,l2)->Integer.compare(l1[0],l2[0]));
        int grpCount = n;
        UnionFind uf = new UnionFind(n);
        
        for(int[] log:logs){
            int timestamp = log[0],a = log[1],b=log[2];
            if(uf.union(a,b)){
                grpCount-=1;
            }
            if(grpCount == 1){
                return timestamp;
            }
        }
        return-1;
    }
}