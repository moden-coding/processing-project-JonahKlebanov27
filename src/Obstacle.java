import processing.core.PApplet;

public class Obstacle {

    MyLine top;
    MyLine right;
    MyLine bottom;
    MyLine left;

    public void setup(float centerX, float centerY, float size){
        top = new MyLine();
        right = new MyLine();
        bottom = new MyLine();
        left = new MyLine(); 
        top.setup(centerX-size/2, centerY-size/2, centerX+size/2, centerY-size/2);
        right.setup(centerX-size/2,centerY-size/2,centerX-size/2, centerY+size/2);
        bottom.setup(centerX-size/2,centerY+size/2,centerX+size/2, centerY+size/2 );
        left.setup(centerX+size/2,centerY+size/2,centerX+size/2, centerY-size/2 );

        

    }
    public void draw(PApplet p){
        top.draw(p);
        right.draw(p);
        left.draw(p);
        bottom.draw(p);

    }


    public void move(float x, float y){
       top.move(x,y);
       right.move(x,y);
       left.move(x,y);
       bottom.move(x,y);

       
       


    }
      
 }
    

