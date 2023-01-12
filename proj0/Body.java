public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		double dx = this.xxPos - b.xxPos;
		double dy = this.yyPos - b.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Body b){
		double r = calcDistance(b);
		return (G * this.mass * b.mass) / (r * r);
	}

	public double calcForceExertedByX(Body b){
		double r = calcDistance(b);
		double f = calcForceExertedBy(b);
		double dx = b.xxPos - this.xxPos;
		return f * dx / r;

	}

	public double calcForceExertedByY(Body b){
		double r = calcDistance(b);
		double f = calcForceExertedBy(b);
		double dy = b.yyPos - this.yyPos;
		return f * dy / r;
	}

	public double calcNetForceExertedByX(Body[] bodys){
		double fx = 0;
		for(Body b : bodys){
			if(b.equals(this)) continue;
			fx += calcForceExertedByX(b);
		}
		return fx;
		
	}

	public double calcNetForceExertedByY(Body[] bodys){
		double fy = 0;
		for(Body b : bodys){
			if(b.equals(this)) continue;
			fy += calcForceExertedByY(b);
		}
		return fy;
	}

	public void update(double dt, double fX, double fY){
		double aNetX = fX / this.mass;
		double aNetY = fY / this.mass;

		double vNewX = this.xxVel + dt * aNetX;
		double vNewY = this.yyVel + dt * aNetY;

		this.xxPos += dt * vNewX;
		this.yyPos += dt * vNewY;

		this.xxVel = vNewX;
		this.yyVel = vNewY;

	}

	public void draw(){
		//draw one body
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}


} 