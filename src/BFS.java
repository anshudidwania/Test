import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BFS {

	public static void main(String[] args) {
		int [][] mat = {{1,1},{3,4},{-1,0}};
		Solution s = new Solution();
		s.minTimeToVisitAllPoints(mat);

	}

}
class Node {
    int x, y, cost;
    Node(int x, int y, int cost){
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        Node des = null;
        Node src =  new Node(points[0][0],points[0][1],0);
        for(int i=1; i<points.length; i++){
            des = new Node(points[i][0],points[i][1],0);
            comutedist(src, des);
            src = des;
        }
        return des.cost;
    }
    
    public void comutedist (Node src, Node des){
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);
        Set<String> visited = new HashSet<> ();
        String key = src.x+"_"+src.y;
        visited.add(key);
        int row [] = {0,0,1,-1,1,-1,-1,1};
        int col [] = {1,-1,0,0,1,-1,1,-1};
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.x==des.x && curr.y==des.y){
            	des.cost = curr.cost;
                break;
            }
            
            for(int i=0; i<8; i++){
                int x = curr.x+row[i];
                int y = curr.y+col[i];
                if(isValid(x, y)){
                    key = x+"_"+y;
                    if(!visited.contains(key)){
                        Node n = new Node(x,y,curr.cost+1);
                        q.add(n);
                        visited.add(key);
                    }
                }
                
            } 
        }
    }
    
    public boolean isValid(int x, int y){
        return (x>=-1000 && x<1000) && (y>=-1000 && y<1000);
    }
}