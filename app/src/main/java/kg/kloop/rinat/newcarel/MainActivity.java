package kg.kloop.rinat.newcarel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private TextView textView;
    private CarelGrid grid;
    private GameCanvas canvas;
    private Carel carel;
    private Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        grid = new CarelGrid();
        canvas = new GameCanvas(textView);
        carel = new Carel(canvas, grid);

        startButton = (Button)findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });




   }

    private void go() {
        //Ниже идут команды Карелу.

        /*while (true){
            dropBeeper();
            if (isFrontClear()) move();
            else break;
            turnRight();
            while (true){
                dropBeeper();
                if (isFrontClear()){
                    move();
                } else break;
            }
            turnLeft();
            turnLeft();
            while (isFrontClear()){
                move();
            }
            turnRight();
            if (isFrontClear()) move();
            else break;
        }
        turnLeft();
        turnLeft();
        while (isFrontClear()) move();
        turnLeft();
        turnLeft();*/
        while (true){
            dropBeeper();
            if(isFrontClear()){
                safeMove();
                //makeStalactite();
                makeRealStalactite();
                safeMove();
            } else break;
        }
        goBack();

        //Команды Карелу закончились.
    }


    //Здесь пишем новые методы.

    private void makeRealStalactite() {
        turnRight();
        moveToWall();
        turnAround();
        makeCone();
        turnRight();
    }

    private void makeCone() {
        dropBeeper();
        while (true){
            if (isFrontClear()) {
                doubleBeepersInNextCell();
                move();
            }
            else break;
        }
    }

    private void doubleBeepersInNextCell() {

    }

    private void goBack() {
        turnAround();
        moveToWall();
        turnAround();
    }

    private void makeStalactite() {
        turnRight();
        putBeepersToWall();
        turnAround();
        moveToWall();
        turnRight();
    }

    private void moveToWall() {
        while (isFrontClear()) move();
    }

    private void turnAround() {
        turnLeft();
        turnLeft();
    }

    private void putBeepersToWall() {
        while (true){
            dropBeeper();
            if (isFrontClear()) move();
            else break;
        }
    }

    private void safeMove() {
        if (isFrontClear()) move();
    }
    
    //Новые методы закончились.
    
    private void move(){
        carel.move();
    }

    private void turnLeft(){
        carel.turnLeft();
    }

    private void turnRight(){for(int i=0;i<3;i++)carel.turnLeft();}


    private void collectBeeper(){
        carel.collectBeeper();
    }
    
    private void dropBeeper(){
        carel.dropBeeper();
    }
    
    private boolean isFrontClear(){
        return carel.isFrontClear();
    }
    
    private boolean isBeeper(){
        return carel.isBeeper();
    }
}
