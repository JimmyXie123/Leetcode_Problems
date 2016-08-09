public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int colMin = search(image, true, true, 0, y, 0, m-1);
        int colMax = search(image, true, false, y, n-1, 0, m-1);
        int rowMin = search(image, false, true, 0, x, colMin, colMax);
        int rowMax = search(image, false, false, x, m-1, colMin, colMax);
        return (colMax-colMin+1)*(rowMax-rowMin+1);
    }
    
    private int search(char[][] image, boolean vertical, boolean inside, int lower, int higher, int min, int max){
        while(lower+1<higher){
            int mid = lower+(higher-lower)/2;
            boolean flag = false;
            for(int i=min; i<=max; i++){
                if((vertical?image[i][mid]:image[mid][i])=='1'){
                    flag = true;
                    break;
                }
            }
            if(flag){
                if(inside){
                    higher = mid;
                }else{
                    lower = mid;
                }
            }else{
                if(inside){
                    lower = mid;
                }else{
                    higher = mid;
                }
            }
        }
        
        if(inside){
            for(int i=min; i<=max; i++){
                if((vertical?image[i][lower]:image[lower][i])=='1'){
                    return lower;
                }
            }
            return higher;
        }else{
            for(int i=min; i<=max; i++){
                if((vertical?image[i][higher]:image[higher][i])=='1'){
                    return higher;
                }
            }
            return lower;
        }
        
    }
}