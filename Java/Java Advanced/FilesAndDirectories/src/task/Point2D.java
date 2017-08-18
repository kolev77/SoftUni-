package task;

/**
 * Created by Rostislav Kolev on 24-Apr-17.
 */
public class Point2D {
    int x1;
    int x2;
    int y1;
    int y2;

    Point2D(int x1,int y1,int x2,int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    double dist2D(){
        double distance  = Math.pow((x2-x1),2)+Math.pow((y2-y1),2);
        distance = distance/distance;
        return distance;
    }

    void printDistance(double d){
        System.out.println((int)Math.ceil(d));
    }
}
