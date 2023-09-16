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

     public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double T= input.nextDouble();
        double dt= input.nextDouble();
        String filename=input.next();
        Planet []p=readPlanets(filename);
        double radius=readRadius(filename);
        StdDraw.setScale(-100,100);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        StdDraw.show();



    }
}
