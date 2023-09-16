import java.util.Scanner;

public class NBody {
    public static double readRadius(String filename){
       In in=new In(filename);
        int number=in.readInt();
        double radius=in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String filename){
        In in=new In(filename);
        int number=in.readInt();
        double radius=in.readDouble();
        Planet []p=new Planet[number];
        for(int i=0;i<number;i++){
            double xxPos=in.readDouble();
            double yyPos=in.readDouble();
            double xxVel=in.readDouble();
            double yyVel=in.readDouble();
            double mass=in.readDouble();
            String pimgFileName=in.readString();
            Planet pl=new Planet(xxPos,yyPos,xxVel,yyVel,mass,pimgFileName);
            p[i]=pl;

        }
        return p;


    }
    public static int readNumber(String filename){
        In in=new In(filename);
        int num=in.readInt();
        return num;
    }

     public static void main(String[] args) {
         double T = new Double(args[0]);
         double dt = new Double(args[1]);
         String filename = args[2];
         Planet []p=readPlanets(filename);
        double radius=readRadius(filename);
        int num=readNumber(filename);
        StdDraw.setXscale(-radius,radius);
        StdDraw.setYscale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        double time=0;
        while(time!=T){
            double []xForces=new double[num];
            double []yForces=new double[num];
            for(int i=0;i<num;i++){
                xForces[i]=p[i].calcNetForceExertedByX(p);
                yForces[i]=p[i].calcNetForceExertedByY(p);
            }
            for(int i=0;i<num;i++){
                p[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Planet planet:p){
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;

        }
         StdOut.printf("%d\n", p.length);
         StdOut.printf("%.2e\n", radius);
         for (int i = 0; i < p.length; i++) {
             StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                     p[i].xxPos, p[i].yyPos, p[i].xxVel,
                     p[i].yyVel, p[i].mass, p[i].imgFileName);
         }
    }
}
