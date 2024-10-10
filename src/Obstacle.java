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

        if(direction==true){
            if(obj_moving_up){
                move(0,speed);
                obj_position_y +=speed;
                if(obj_position_y >= obj_top_boundary){
                    obj_moving_up = false;
                }
            } 
            else {
                move(0,-speed);
                obj_position_y -= speed;
    
    
                if (obj_position_y <= obj_top_boundary) 
                {
                    obj_moving_up = true;
                }
    
            }
        } else{
            if (obj_moving_right) {
                move(speed,0); 
                obj_position_x += speed;
                if (obj_position_x >= obj_right_boundary) {
                    obj_moving_right = false;
                }
            }
            else {
                move(-speed,0); 
                obj_position_x -= speed;
                if(obj_position_x <= obj_left_boundary){
                    obj_moving_right = true;
                }
            } 
        }

        
        
        
        
        
        
    }


            
            
            

        

          
    



    public void move(float x, float y){
       top.move(x,y);
       right.move(x,y);
       left.move(x,y);
       bottom.move(x,y);

       
       


    }
    float obj_left_boundary = 10;
    float obj_right_boundary = 140;
    boolean obj_moving_right = true;
    float obj_position_x = obj_left_boundary;  
    
    float obj_top_boundary = 140;
    float obj_bottom_boundary = 340;
    float speed=3.5f;
    float obj_position_y = obj_top_boundary;
     boolean obj_moving_up = true;


    public void setboundaries(float left, float top, float bottom, float right){

        obj_left_boundary=left;
        obj_top_boundary=top; 
        obj_bottom_boundary=bottom;
        obj_right_boundary=right;

        obj_position_x=left; 

    
     



    }
    public void setspeed(float spd){

       speed=spd;

    }
      
     public boolean direction = false; //moving up if true moving right if false
      
 

     


     
 }


