package additional_question;

public class RectangleOverlap {

	public static void main(String[] args){
		
	}
	// Overlap Rectangle
	// Rect 1: top-left(A, B), bottom-right(C, D)
	// Rect 2: top-left(E, F), bottom-right(G, H)
	public static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
		if(r2.x<l1.x||r1.x<l2.x){
			return false;
		}
		if(l1.y<r2.y||l2.y<r1.y){
			return true;
		}
		return true;
	}
}
