package additional_question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_cloest_point {

	public static void main(String[] args){
		Point[] points = {new Point(1,2),new Point(4,2),new Point(7,2),new Point(1,8)};
		Point origin = new Point(0,0);
		Point[] result = Solution(points, origin, 3);
		System.out.println();
	}
	public static Point[] Solution(Point[] array, Point origin, int k) {
		Point[] solution = new Point[k];
		PriorityQueue<Point> queue = new PriorityQueue<Point>(array.length, new Comparator<Point>(){
			@Override
			public int compare(Point a, Point b){
				if(getDistance(origin,a)>getDistance(origin,b)){
					return 1;
				}else if(getDistance(origin,a)==getDistance(origin,b)){
					return 0;
				}else{
					return -1;
				}
			}
		});
	
		for(Point point:array){
			queue.offer(point);
		}
		for(int i=0;i<k;i++){
			solution[i] = queue.poll();
		}
		return solution;
	}
	
	public static double getDistance(Point a, Point b){
		double result = Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		return result;
	}
}

class Point{
	public int x;
	public int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}