public class SnakeGame {
    Deque<Integer> body;
    HashSet<Integer> set;
    int width;
    int height;
    int[][] food;
    int score;
    int foodIndex;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        body = new LinkedList();
        set = new HashSet();
        body.offer(0);
        set.add(0);
        score = 0;
        foodIndex = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score==-1){
            return -1;
        }
        
        int rowhead = body.peekFirst()/width;
        int colhead = body.peekFirst()%width;
        
        if(direction.equals("U")){
            rowhead--;
        }else if(direction.equals("L")){
            colhead--;
        }else if(direction.equals("R")){
            colhead++;
        }else{
            rowhead++;
        }
        int head = rowhead*width+colhead;
        
        set.remove(body.peekLast());
        if(rowhead<0||rowhead==height||colhead<0||colhead==width||set.contains(head)){
            return -1;
        }
        
        set.add(head);
        body.offerFirst(head);
        if(foodIndex<food.length&&rowhead==food[foodIndex][0]&&colhead==food[foodIndex][1]){
            set.add(body.peekLast());
            foodIndex++;
            return ++score;
        }
        
        body.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */