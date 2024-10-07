import processing.core.*;


public class App extends PApplet {

    
    MyTriangle tri; 
    MyLine line, line2, line3, line4, line5, line6, line7,line8,line9,line10,line11,line12,line13;
    float speed = 20;

    
       public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        float centerX = 50;
        float centerY = 550;
        tri = new MyTriangle();
        tri.setup(centerX, centerY); 
        line = new MyLine();
        line2= new MyLine();
        line3= new MyLine();
        line4= new MyLine();
        line5= new MyLine();
        line6= new MyLine();
        line7= new MyLine();
        line8= new MyLine();
        line9= new MyLine();
        line10= new MyLine();
        line11= new MyLine();
        line12= new MyLine();
        line13= new MyLine();

        line.setup(100,600,100,100);
        line2.setup(100,100,150,100); 
        line3.setup(0,0,0,600);
        line4.setup(0,0,800,0);
        line5.setup(800,0,800,600);
        line6.setup(800,600,0,600);
        line7.setup(150,100,150,600);
        line8.setup(250,100,250,500);
        line9.setup(250,500,400,500);
        line10.setup(300,100,300,400);
        line11.setup(300,400,350,400);


    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(0, 175, 90);
        fill(0, 90, 175);
        stroke(200, 0, 0);
        strokeWeight(5);
        tri.draw(this);
  
        stroke(0);
        strokeWeight(2);
        
        line.draw(this);
        line2.draw(this);
        line3.draw(this);
        line4.draw(this);
        line5.draw(this);
        line6.draw(this);
        line7.draw(this);
        line8.draw(this);
        line9.draw(this);
        line10.draw(this);
        line11.draw(this);
        line12.draw(this);
        line13.draw(this);
        

    }

    public void keyPressed() {
        System.out.println("key pressed");

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
        tri.move(deltaX, deltaY);

    }

    public boolean willTriangleCrossLine(float deltaX, float deltaY) {


        MyTriangle temptr = new MyTriangle(tri);
        temptr.move(deltaX, deltaY);
        
        if(temptr.IntersectsWithLine(line)  || temptr.IntersectsWithLine(line2) || temptr.IntersectsWithLine(line3) || temptr.IntersectsWithLine(line4) || temptr.IntersectsWithLine(line5) || temptr.IntersectsWithLine(line6) || temptr.IntersectsWithLine(line7) || temptr.IntersectsWithLine(line8) || temptr.IntersectsWithLine(line9) || temptr.IntersectsWithLine(line10) || temptr.IntersectsWithLine(line11) || temptr.IntersectsWithLine(line12) || temptr.IntersectsWithLine(line13)){
            return true;
            


        }else{
            return false;

        }

        

        
    }
}
