package Java;

/**
 * Created by raghu on 1/9/2017.
 */
enum Color{Black, White, Red, Yellow, Green}

public class PaintFill {
    public static void main(String[] args) {

    }

    public Boolean paintFill(Color[][] screen, int r , int c, Color nColor)
    {
        if(screen[r][c] == nColor) return false;

        return  paintFill(screen, r, c, nColor, screen[r][c]);

    }

    public Boolean paintFill(Color[][] screen, int r , int c, Color nColor, Color color)
    {
        if( r< 0 || r >= screen.length || c < 0 || c >= screen[0].length)
        {
            return false;
        }

        if(screen[r][c]== color)
        {
            screen[r][c] = nColor;
            paintFill(screen, r, c-1, nColor,color); //left
            paintFill(screen, r, c+1, nColor,color); //right
            paintFill(screen, r-1, c, nColor,color); //up
            paintFill(screen, r+1, c, nColor,color); //down
        }
        return true;
    }
}
