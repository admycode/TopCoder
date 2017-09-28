import java.util.*;

public class BinaryCode{
	public static String[] decode(String message){
		String[] str = new String[2];
		Arrays.fill(str, null);
		int len = message.length();

		int[] P = new int[len];
		Arrays.fill(P, 0);
		
		P[0] = 0;	//first assume P[0] is 0
		for(int i = 1; i < len; i++){
			if( i == 1 ){
				P[i] = (message.charAt(i-1)-'0') - P[i-1];
				//System.out.println(message.charAt(i-1));
				//System.out.println(P[i-1]);
				//System.out.println(i + " " + P[i]);
				if((P[i] != 0) && (P[i] != 1)){
					str[0] = "\"NONE\"";
					break;
				}
				
			} else if (i == len-1){
				P[i] = message.charAt(i)-'0' - P[i-1];
				//System.out.println(i + " " + P[i]);
				if((P[i] != 0) && (P[i] != 1)){
					str[0] = "\"NONE\"";
					break;
				}
			} else {
				P[i] = message.charAt(i-1)-'0' - P[i-1] - P[i-2];
				//System.out.println(i + " " + P[i]);
				if((P[i] != 0) && (P[i] != 1)){
					str[0] = "\"NONE\"";
					break;
				}
			}
		}

		if(str[0] != "\"NONE\""){
			str[0] = Arrays.toString(P).replace(", ", "").replace("[", "\"").replace("]", "\"");
		}

		P[0] = 1;	//first assume P[0] is 0
		for(int i = 1; i < len; i++){
			if( i == 1 ){
				P[i] = message.charAt(i-1)-'0' - P[i-1];
				if((P[i] != 0) && (P[i] != 1)){
					str[1] = "\"NONE\"";
					break;
				}
				
			} else if (i == len-1){
				P[i] = message.charAt(i)-'0' - P[i-1];
				if((P[i] != 0) && (P[i] != 1)){
					str[1] = "\"NONE\"";
					break;
				}
			} else {
				P[i] = message.charAt(i-1)-'0' - P[i-1] - P[i-2];
				if((P[i] != 0) && (P[i] != 1)){
					str[1] = "\"NONE\"";
					break;
				}
			}
		}
		
		if(str[1] != "\"NONE\""){
			str[1] = Arrays.toString(P).replace(", ", "").replace("[", "\"").replace("]", "\"");
		}
		return str;
	}

	public static void main(String[] args){
		
		String[] str = decode("123210122");
		System.out.println(str[0]);
		System.out.println(str[1]);
		str = decode("11");
		System.out.println(str[0]);
		System.out.println(str[1]);
	}
}
