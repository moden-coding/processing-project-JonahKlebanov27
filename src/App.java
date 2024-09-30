import processing.core.*;

public class App extends PApplet {

    float x1, y1, x2, y2, x3, y3;
    float speed = 20;

    float lineX1 = 600, lineY1 = 100, lineX2 = 100, lineY2 = 100;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        float centerX = 50;
        float centerY = 550;
        x1 = centerX;
        y1 = centerY - 25;
        x2 = centerX - 25;
        y2 = centerY + 25;
        x3 = centerX + 25;
        y3 = centerY + 25;

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(0, 175, 90);
        fill(0, 90, 175);
        stroke(200, 0, 0);
        strokeWeight(5);
        triangle(x1, y1, x2, y2, x3, y3); 

        stroke(0);
        strokeWeight(2);
        line(100,600,100,100);
       
        

    }

    public void keyPressed() {
        

        if (keyCode == UP && !willTriangleCrossLine(0, -speed)) {
            moveTriangle(0, -speed);  
        } else if (keyCode == DOWN && !willTriangleCrossLine(0, speed)) {
            moveTriangle(0, speed);  
        } else if (keyCode == LEFT && !willTriangleCrossLine(-speed, 0)) {
            moveTriangle(-speed, 0);  
        } else if (keyCode == RIGHT && !willTriangleCrossLine(speed, 0)) {
            moveTriangle(speed, 0);  
        }
    }

    public void moveTriangle(float deltaX, float deltaY) {
        x1 += deltaX;
        y1 += deltaY;
        x2 += deltaX;
        y2 += deltaY;
        x3 += deltaX;
        y3 += deltaY;

    }

    public boolean willTriangleCrossLine(float deltaX, float deltaY) {
        
        float newY1 = y1 + deltaY;
        float newY2 = y2 + deltaY;
        float newY3 = y3 + deltaY;

        
        if (newY1 < lineY1 || newY2 < lineY1 || newY3 < lineY1) {
            return true;  

        
        }
          return false;
  }
}


