import processing.core.*;


public class App extends PApplet {

    
    MyTriangle tri; 
    MyLine line, line2, line3, line4, line5, line6, line7,line8,line9,line10,line11,line12,line13,line14,line15,line16,finishLine;
    float speed = 5; //speed of triangle
    Obstacle ob,ob1,ob2,ob3,ob4,ob5,ob6,ob7;
      
    float initialCenterX = 50; //start position of triangle
    float initialCenterY = 550;
   
   
     
    long startTime; //timer
    long gameTime; //timer
    int gameState = 0; 

    
       public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
       
        tri = new MyTriangle();
        
        tri.setup(initialCenterX,initialCenterY);
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
        finishLine= new MyLine();


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
        finishLine.setup(800, 325,700, 325);

        
        
        ob= new Obstacle();
        ob.setup(10,300, 20); 
        ob.setboundaries(10,0,0,140);
        ob.setspeed(3.5f);
       
        ob1= new Obstacle();
        ob1.setup(160,200,20);
        ob1.setboundaries(160,0,0,540);
        ob1.setspeed(15); 

        ob2= new Obstacle();
        ob2.setup(160,300,20);
        ob2.setboundaries(160,0,0,540);
        ob2.setspeed(15);

        ob3= new Obstacle();                               
        ob3.setup(200,0,20);
        ob3.setboundaries(0,0,140,0);
        ob3.setspeed(3.5f);
        ob3.direction=true;

        ob4= new Obstacle();
        ob4.setup(310,415,20);
        ob4.setboundaries(310,0,0,540);
        ob4.setspeed(4);

        ob5= new Obstacle();
        ob5.setup(600,460,20);
        ob5.setboundaries(0,460,590,0); //challenge
        ob5.setspeed(3.5f); 
        ob5.direction=true; 
        ob5.debug_print = true; //part of solution

        ob6= new Obstacle();
        ob6.setup(560,400,20);
        ob6.setboundaries(560,0,0,790);
        ob6.setspeed(4.5f);  

        ob7= new Obstacle();
        ob7.setup(560,250,20);
        ob7.setboundaries(560,0,0,690);
        ob7.setspeed(3.5f);  

        startTime = System.currentTimeMillis() / 1000; //timer
        


       






        

        
        

    }

    public void draw(){
        if(gameState==0){
            showStartScreen(); 

        }else if(gameState==1){  //for multiple screens
            runGame();
        }if(gameState==2){
            showEndScreen();
        }

        
    }
       
    void showStartScreen() {
        background(0,0,250);
        textSize(30);
        text("Instructions: Use the arrow keys to control the player. \n Your objective is to avoid the obstacles and make it to the end" ,400,200 );
        textSize(40);
        fill(255);
        textAlign(CENTER, CENTER);
        text("Press SPACE to Start", width / 2, height / 2);

      }

      void showEndScreen(){
        background(0,0,250);
        textSize(30);
        fill(255);
        text("your time was: " + gameTime, 400, 200); 
        textSize(40);
        text("Press ENTER to play again", 400,300);

    


      }
      
      

    public void settings() {
        size(800, 600);
    }

    public void runGame() {

 
       
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
        finishLine.draw(this);

        ob.draw(this); 
        ob1.draw(this);
        ob2.draw(this);
        ob3.draw(this);
        ob4.draw(this);
        ob5.draw(this);
        ob6.draw(this);
        ob7.draw(this);
        textSize(20);
        text("finish",750,335); 
        
        long currentTimeInSeconds = (System.currentTimeMillis() / 1000) - startTime;
        text("Timer: " + currentTimeInSeconds, 700,50); 

        gameTime=currentTimeInSeconds;         
        
        if(tri.IntersectsWithLine(finishLine)){
            resetTriangle();
            gameState=2;


        
           
        }
        

        

        
       
        if (tri.IntersectsWithObstacle(ob)) {
            resetTriangle();  // Reset triangle to starting position if it touches the obstacle
        }
       
        if (tri.IntersectsWithObstacle(ob1)) {
            resetTriangle();  // Reset triangle to starting position if it touches the obstacle
        }
      
        if (tri.IntersectsWithObstacle(ob2)) {
            resetTriangle();  // Reset triangle to starting position if it touches the obstacle
        }

         if (tri.IntersectsWithObstacle(ob3)) {
           resetTriangle();  
        }
        if (tri.IntersectsWithObstacle(ob4)) {
            resetTriangle();  
        }
        if (tri.IntersectsWithObstacle(ob5)) {
            resetTriangle();  
        }
        if (tri.IntersectsWithObstacle(ob6)) {
            resetTriangle();  

        }
        if (tri.IntersectsWithObstacle(ob7)) {
            resetTriangle();  

        }
        handleMovement();

        
    }



        


        

    
      
    public void resetTriangle() {
        // Reset the triangle to the initial starting position
        tri.setup(initialCenterX, initialCenterY);

        startTime = System.currentTimeMillis() / 1000;
    }

    public void keyReleased()
    {
        keyDown = 0;
    }

    public int keyDown=0; // 1 is UP,  2 is DOWN,  3 is LEFT,  4 is RIGHT

    public void handleMovement()
    {
        if (keyDown == 1 && !willTriangleCrossLine(0, -speed)) {
            moveTriangle(0, -speed);
        }
        else if (keyDown == 2 && !willTriangleCrossLine(0, speed)) {
            moveTriangle(0, speed);
        }
        else if (keyDown == 3 && !willTriangleCrossLine( -speed, 0)) {
            moveTriangle(-speed, 0);
        }
        else if (keyDown == 4 && !willTriangleCrossLine( speed, 0)) {
            moveTriangle(speed, 0);
        }
    }

    public void keyPressed() {
       

        if (keyCode == UP) { 
            keyDown = 1;
            
        } else if (keyCode == DOWN){
            keyDown = 2;
            
        } else if (keyCode == LEFT) { 
            keyDown = 3;
            
        } else if (keyCode == RIGHT) { 
            keyDown = 4;
            
               
            }

            if (gameState == 0 && key == ' ') {
                gameState = 1;
                startTime = System.currentTimeMillis() / 1000;  // Reset the timer when the game starts
              }else if(gameState == 2 && key == '\n'){
                gameState = 1;
                gameTime=0;
                
              }
                  

        }




    

    public void moveTriangle(float deltaX, float deltaY) {
        tri.move(deltaX, deltaY);

    }

    public boolean willTriangleCrossLine(float deltaX, float deltaY) {


        MyTriangle temptr = new MyTriangle(tri);
        
        
        temptr.move(deltaX, deltaY);
        
        if(temptr.IntersectsWithLine(line)|| 
        temptr.IntersectsWithLine(line2) || 
        temptr.IntersectsWithLine(line3) || 
        temptr.IntersectsWithLine(line4) || 
        temptr.IntersectsWithLine(line5) || 
        temptr.IntersectsWithLine(line6) || 
        temptr.IntersectsWithLine(line7) || 
        temptr.IntersectsWithLine(line8) || 
        temptr.IntersectsWithLine(line9) || 
        temptr.IntersectsWithLine(line10) || 
        temptr.IntersectsWithLine(line11) || 
        temptr.IntersectsWithLine(line12) || 
        temptr.IntersectsWithLine(line13) || 
        temptr.IntersectsWithLine(line14) || 
        temptr.IntersectsWithLine(line15) || 
        temptr.IntersectsWithLine(line16)){
            return true;
            


        }else{
            return false;

        }

       

        
    }
}
