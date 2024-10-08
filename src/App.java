import processing.core.*;


public class App extends PApplet {

    
    MyTriangle tri; 
    MyLine line, line2, line3, line4, line5, line6, line7,line8,line9,line10,line11,line12,line13,line14,line15,line16;
    float speed = 10; 
    Obstacle ob;

    
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
        line14= new MyLine();
        line15= new MyLine();
        line16= new MyLine();


        line.setup(150,150,150,500);
        line2.setup(150,150,300,150); 
        line3.setup(0,0,0,600); //left border
        line4.setup(0,0,800,0); //top border
        line5.setup(800,0,800,600); //right border
        line6.setup(800,600,0,600); //bottom border
        line7.setup(150,350,300,350);
        line8.setup(300,350,300,600);
        line9.setup(300,475,425,475);
        line10.setup(550,237,300,237);
        line11.setup(800,150,550,150);
        line12.setup(550,150,550,450);
        line13.setup(550,450,650,450);
        line14.setup(800,350,700,350);
        line15.setup(700,350,700,200);
        line16.setup(400,0,400,75); 

        ob= new Obstacle();
        ob.setup(100,100, 20);


    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(0, 175, 90);
        fill(0, 90, 175);
        stroke(200, 0, 0);
        strokeWeight(2);
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
        line14.draw(this);
        line15.draw(this);
        line16.draw(this);

        ob.draw(this);


        

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
        
        if(temptr.IntersectsWithLine(line)  || temptr.IntersectsWithLine(line2) || temptr.IntersectsWithLine(line3) || temptr.IntersectsWithLine(line4) || temptr.IntersectsWithLine(line5) || temptr.IntersectsWithLine(line6) || temptr.IntersectsWithLine(line7) || temptr.IntersectsWithLine(line8) || temptr.IntersectsWithLine(line9) || temptr.IntersectsWithLine(line10) || temptr.IntersectsWithLine(line11) || temptr.IntersectsWithLine(line12) || temptr.IntersectsWithLine(line13) || temptr.IntersectsWithLine(line14) || temptr.IntersectsWithLine(line15) || temptr.IntersectsWithLine(line16)){
            return true;
            


        }else{
            return false;

        }

        

        
    }
}
