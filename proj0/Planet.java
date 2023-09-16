import java.math.BigDecimal;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;yyPos=yP;xxVel=xV;yyVel=yV;mass=m;imgFileName=img;

    }
    public Planet(Planet p){
        this.xxPos=p.xxPos;this.yyPos=p.yyPos;this.xxVel=p.xxVel;this.yyVel=p.yyVel;this.mass=p.mass;this.imgFileName=p.imgFileName;

    }
    public double calcDistance(Planet p){
        double r;
        double r_r;
        r_r=Math.pow((p.xxPos-this.xxPos),2)+Math.pow((p.yyPos-this.yyPos),2);
        r=Math.sqrt(r_r);
        return r;
    }
    static final double  G=6.67e-11;
    public double calcForceExertedBy(Planet p){
        double F;
        F=(G*(this.mass)*(p.mass))/(Math.pow(this.calcDistance(p),2));
        return F;
    }
    public double calcForceExertedByX(Planet p){
        double Fx;
        Fx=(this.calcForceExertedBy(p)*(p.xxPos-this.xxPos))/this.calcDistance(p);
        return Fx;
    }
    public double calcForceExertedByY(Planet p){
        double Fy;
        Fy=(this.calcForceExertedBy(p)*(p.yyPos-this.yyPos))/this.calcDistance(p);
        return Fy;
    }
    public  double calcNetForceExertedByX(Planet []allPlanets){
        double Fx_net=0;
        for(int i=0;i<allPlanets.length;i++) {
            if (!this.equals(allPlanets[i])) {

                Fx_net += this.calcForceExertedByX(allPlanets[i]);
            }
            else {
                Fx_net+=0;
            }
        }
        return Fx_net;

    }
    public  double calcNetForceExertedByY(Planet []allPlanets){
        double Fy_net=0;
        for(int i=0;i<allPlanets.length;i++) {
            if (!this.equals((allPlanets[i]))) {
                Fy_net += this.calcForceExertedByY(allPlanets[i]);
            }

        }
        return Fy_net;
    }
    public void update(double dt,double fX,double fY){
        double aX=fX/mass;
        double aY=fY/mass;
        xxVel=xxVel+dt*aX;
        yyVel=yyVel+dt*aY;
        xxPos=xxPos+dt*xxVel;
        yyPos=yyPos+dt*yyVel;

    }
    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
