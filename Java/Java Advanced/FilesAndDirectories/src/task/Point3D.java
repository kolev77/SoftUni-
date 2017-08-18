package task;

/**
 * Created by Rostislav Kolev on 24-Apr-17.
 */
public class Point3D extends Point2D{
    int z1;
    int z2;
    Point3D(int x1,int y1,int z1,int x2,int y2,int z2){
        super(x1,y1,x2,y2);
        this.z1 = z1;
        this.z2 = z2;
    }

}
