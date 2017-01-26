package kg.kloop.rinat.newcarel;


import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;


/**
 * Created by admin on 02.12.2015.
 */
public class GameCanvas extends Object {
    public GameCanvas (TextView textView){
        view = textView;
    }

    public void draw (CarelGrid grid) {
        changeCanvas(grid);

    }

    public void changeCanvas(CarelGrid grid) {
        view.setText("");
        for (int i = 0; i < grid.getHeight(); i++){

            for (int j = 0; j < grid.getWidth(); j++) {
                String sector = "";
                if (j == grid.getCarelX() && i == grid.getCarelY()){
                    sector = drawCarel(Integer.toString(grid.getBeepersNumber(j, i)), grid);
                } else sector = "    " + Integer.toString(grid.getBeepersNumber(j, i)) + "    ";
                view.append(sector);
            }
            view.append("\n \n");
        }
    }

    private String drawCarel(String text, CarelGrid grid){
        String carel = "";

        if (!grid.isCarelDead()) carel = "',(" + text + "):";
        else carel = "',(" + text + ")%";

        String carelHead = "";

        if (grid.getCarelDirectionX() == 1) carelHead = ">";
        else if (grid.getCarelDirectionX() == (-1) ) carelHead = "<";
        else if (grid.getCarelDirectionY() == 1) carelHead = "^";
        else if (grid.getCarelDirectionY() == -1) carelHead = "v";

        return carel + carelHead;
    }

    private TextView view;
}
