import processing.core.PApplet;

public class MyLine {
    
    
    float x1,y1,x2,y2;
     
    public void draw(PApplet p){
        p.line(x1,y1,x2,y2);

    }
    public void setup( float X1,float Y1,float X2,float Y2){
       x1=X1;
       y1=Y1;
       x2=X2;
       y2=Y2;
       
    } 
    public void move(float x, float y ){
      x1 = x1+x;
      y1 = y1+y;
      x2 = x2+x;
      y2 = y2+y;



    }
}
       
