import processing.core.PApplet;

public class MyTriangle {
    

    float x1, y1, x2, y2, x3, y3;

    public MyTriangle()
    {}

    public MyTriangle(MyTriangle t)
    {
        x1 = t.x1;
        y1 = t.y1;
        x2 = t.x2;
        y2 = t.y2;
        x3 = t.x3;
        y3 = t.y3;
        
    }

    public void setup(float centerX, float centerY)
    {
        x1 = centerX;
        y1 = centerY - 25;
        x2 = centerX - 25;
        y2 = centerY + 25;
        x3 = centerX + 25;
        y3 = centerY + 25;

    }
    public void draw(PApplet p)
    {
        p.triangle(x1, y1, x2, y2, x3, y3);
    }

    public void move(float deltaX, float deltaY)
    {
        x1 += deltaX;
        y1 += deltaY;
        x2 += deltaX;
        y2 += deltaY;
        x3 += deltaX;
        y3 += deltaY;

    }

    public boolean IntersectsWithLine(MyLine line) {
        return IntersectsWithLine(line.x1, line.y1, line.x2, line.y2);
    }

        // Check if triangle intersects with the line
        public boolean IntersectsWithLine(float lineX1, float lineY1, float lineX2, float lineY2) {
            // Check if any of the triangle's sides intersect with the line
            return linesIntersect(x1, y1, x2, y2, lineX1, lineY1, lineX2, lineY2) ||  // Side 1-2
                   linesIntersect(x2, y2, x3, y3, lineX1, lineY1, lineX2, lineY2) ||  // Side 2-3
                   linesIntersect(x3, y3, x1, y1, lineX1, lineY1, lineX2, lineY2);    // Side 3-1
        }
    
        // Function to check if two lines intersect
        public boolean linesIntersect(float x1, float y1, float x2, float y2,
                                      float x3, float y3, float x4, float y4) {
            // Find the four orientations needed for general and special cases
            int o1 = orientation(x1, y1, x2, y2, x3, y3);
            int o2 = orientation(x1, y1, x2, y2, x4, y4);
            int o3 = orientation(x3, y3, x4, y4, x1, y1);
            int o4 = orientation(x3, y3, x4, y4, x2, y2);
    
            // General case: if the orientations are different, the lines intersect
            if (o1 != o2 && o3 != o4) {
                return true;
            }
    
            // Special cases: Check if the points are collinear and on the line segment
            if (o1 == 0 && onSegment(x1, y1, x3, y3, x2, y2)) return true;
            if (o2 == 0 && onSegment(x1, y1, x4, y4, x2, y2)) return true;
            if (o3 == 0 && onSegment(x3, y3, x1, y1, x4, y4)) return true;
            if (o4 == 0 && onSegment(x3, y3, x2, y2, x4, y4)) return true;
    
            // No intersection
            return false;
        }
    
        // Helper function to determine the orientation of three points (p, q, r)
        // 0 -> p, q and r are collinear
        // 1 -> Clockwise
        // 2 -> Counterclockwise
        public int orientation(float px, float py, float qx, float qy, float rx, float ry) {
            float val = (qy - py) * (rx - qx) - (qx - px) * (ry - qy);
    
            if (val == 0) return 0;  // Collinear
            return (val > 0) ? 1 : 2; // Clockwise or Counterclockwise
        }
    
        // Helper function to check if point q lies on segment pr
        public boolean onSegment(float px, float py, float qx, float qy, float rx, float ry) {
            return qx <= Math.max(px, rx) && qx >= Math.min(px, rx) &&
                   qy <= Math.max(py, ry) && qy >= Math.min(py, ry);
        }
    }

    


    

