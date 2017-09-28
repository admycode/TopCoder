//TopCoder SRM 144 DIV 2 1100 problem. The hack to this problem is that the technician must traverse each duct twice except the longest duct path.

public class PowerOutage{

	public static int longestpath(int origin, int[] fromJunction, int[] toJunction, int[] ductLength){
	
		int max_path = 0;
		
		for(int i = 0; i < fromJunction.length; i++){
		
			if(fromJunction[i] == origin){
				int path_length = ductLength[i] + longestpath(toJunction[i], fromJunction, toJunction, ductLength);
				max_path = (path_length > max_path) ? path_length : max_path; 
			}
		}
	
		return max_path;
	
	}
	
	public static int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength){
		int max_time = 0;

		for(int length : ductLength){
		
			max_time += 2*length;
		}

		return max_time - longestpath(0, fromJunction, toJunction, ductLength);	

	}

	public static void main(String[] args){
	
		int[] fromJunction = {0,0,0,1,4,4,6,7,7,7,20};
		int[] toJunction = {1,3,4,2,5,6,7,20,9,10,31};
		int[] ductLength = {10,10,100,10,5,1,1,100,1,1,5};

		System.out.println(estimateTimeOut(fromJunction, toJunction, ductLength));

	}

}
