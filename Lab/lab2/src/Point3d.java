public class Point3d extends Point2d {

    private double zCoord;

    public Point3d (double x, double y, double z) {
        zCoord = z;
    }

    public Point3d () {
        this(0, 0,0);
    }

    public double getZ (){
        return zCoord;
    }

    public void setZ (double val){
        zCoord = val;
    }

    public boolean ravn (Point3d p){
        return  this.getX() == p.getX() && this.getY() == p.getY() && this.getZ() == p.getZ();
    }

    public double distanceTo(Point3d p){
        //return Math.round(((Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + Math.pow(p.getY() - this.getY(), 2) + Math.pow(p.getZ() - this.getZ(), 2)))*100)/100);
        return Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + Math.pow(p.getY() - this.getY(), 2) + Math.pow(p.getZ() - this.getZ(), 2));
    }
}
