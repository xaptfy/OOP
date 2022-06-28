public class Lab2 {

    public static void main(String[] args) {
        args= new String[]{"4","2","3","4","5","6","7","8","9"};
        if (args.length %9 == 0 && args.length != 0){
            Point3d p1 = new Point3d();
            Point3d p2 = new Point3d();
            Point3d p3 = new Point3d();
            p1.setX(Double.parseDouble(args[0]));
            p1.setY(Double.parseDouble(args[1]));
            p1.setZ(Double.parseDouble(args[2]));
            p2.setX(Double.parseDouble(args[3]));
            p2.setY(Double.parseDouble(args[4]));
            p2.setZ(Double.parseDouble(args[5]));
            p3.setX(Double.parseDouble(args[6]));
            p3.setY(Double.parseDouble(args[7]));
            p3.setZ(Double.parseDouble(args[8]));
            System.out.println(p1.getX());
            System.out.println(computeArea(p1,p2,p3));
        }
    }
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        if (p1.ravn(p2) || p2.ravn(p3)||p3.ravn(p1)) {
            System.err.println("Точки равны");
            System.exit(228);
        }
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        double per = (a + b + c)/2;
        return Math.sqrt(per*(per-a)*(per-b)*(per-c));
    }
}
