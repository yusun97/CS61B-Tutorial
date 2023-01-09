public class printStar{
	public static void main(String[] args){
		showStar(5);	
	}
	
	public static void showStar(int size){
		for(int row = 0; row < size; row++){
			for(int col = 0; col <= row; col++){
				System.out.print("*");		
			}
			System.out.println("");		
		}
	}
}
