package Interview;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class SnakeGame {
    
	
	public static void main(String[] args){
		SnakeGame obj = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
		int param_1 = obj.move("D");
		int param_2 = obj.move("D");
		int param_3 = obj.move("R");
		int param_4 = obj.move("U");
		int param_5 = obj.move("U");
		int param_6 = obj.move("L");
		int param_7 = obj.move("D");
		int param_8 = obj.move("R");
		int param_9 = obj.move("R");
		int param_10 = obj.move("U");
		int param_11 = obj.move("L");
		int param_12 = obj.move("L");
		int param_13 = obj.move("D");
		int param_14 = obj.move("R");
		int param_15 = obj.move("U");
	}
	
    private HashSet<int[]> bodySet;
    private Deque<int[]> bodyQueue;
    private int score;
    private int[][] food;
    private int height;
    private int width;
    private int foodIndex;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        bodySet = new HashSet<int[]>();
        bodyQueue = new LinkedList<>();
        score = 0;
        foodIndex = 0;
        this.height = height;
        this.width = width;
        this.food = food;
        bodySet.add(new int[]{0,0});
        bodyQueue.offerFirst(new int[]{0,0});
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score==-1){
            return -1;
        }
        int x = (bodyQueue.peekFirst())[0];
        int y = (bodyQueue.peekFirst())[1];
        switch(direction){
            case "U":{
                x--;
                break;
            }
            case "D":{
                x++;
                break;
            }
            case "L":{
                y--;
                break;
            }
            case "R":{
                y++;
                break;
            }
        }
        if(x<0||x>height-1||y<0||y>width-1){
            return -1;
        }
        if(foodIndex<food.length&&x==food[foodIndex][0]&&y==food[foodIndex][1]){
            score++;
            foodIndex++;
            bodySet.add(bodyQueue.peekFirst());
            bodyQueue.offerFirst(new int[]{x,y});
        }else{
            bodySet.remove(bodyQueue.peekLast());
            bodyQueue.pollLast();
            bodySet.add(bodyQueue.peekFirst());
            bodyQueue.offerFirst(new int[]{x,y});
        }
        if(bodySet.contains(bodyQueue.peekFirst())){
            return -1;
        }
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */