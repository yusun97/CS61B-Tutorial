public class NBody{


	public static double readRadius(String fileName){
		In in = new In(fileName);
		in.readInt();
		return in.readDouble();
	}

	public static Body[] readBodies(String fileName){
		In in = new In(fileName);
		in.readInt();
		in.readDouble();

		Body[] bodys = new Body[5];

		/*
		 The first two values are the x- and y-coordinates of the initial position; 
		 the next pair of values are the x- and y-components of the initial velocity; 
		 the fifth value is the mass; 
		 the last value is a String that is the name of an image file used to display the planets.
		*/

		for(int i = 0; i < 5 && !in.isEmpty(); i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			bodys[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

		}
		return bodys;
	}


}

