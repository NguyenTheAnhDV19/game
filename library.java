public class library {
    public static boolean collideX(int x1, int x2,int y1, int y2, int width1, int width2, int height1, int height2){
        if(Collide(x1,x2,y1,y2,width1,width2,height1,height2) == true){
            int space = x1+ width1 - x2; int spaceRight = x1 - x2+width2;
            if(space <=1 && space >= 0 ){
                return true;
            }else if(spaceRight >= -1 && spaceRight <= 0){
                return true;
            }
        }
        return false;
    }
   public static boolean Collide(int x1, int x2,int y1, int y2, int width1, int width2, int height1, int height2){
        if(x1+width1 >= x2 && x1<= x2 + width2) {
            if (y1 <= y2 + height2 && y1 + height1 >= y2) {
                return true;
            }
        }
        return false;
    }
}
