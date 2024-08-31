package test;

public class oddEven {

	public static void main(String[] args) {
		
//		int[] arr = {7,9,22,14,66};
//	      int odd = 0; 
//	      int even = 0;
//	      int len=arr.length;
//	      
//	      for (int i=0; i<len; i++ ){
//	          if(arr[i]%2==0) {
//	        	  even++;
//	          }
//	          else 
//	          {
//	          odd++;
//	          }
//	      }
//	      System.out.println(odd+ "----"+ even);

	// =========================================
	
//		String s1 = "Kalyana";
//		String revS="";
//		char rev ;
//		for (int i=0; i<s1.length(); i++) {
//			rev = s1.charAt(i);
//			revS = rev+revS ;
//		}
//		
//		System.out.println(revS);
//	
	//============================================
		
	String s1 = "Kaifa000Number999";	
		
	int u=0, n=0, l=0,s=0;
	
	for (int i=0; i<s1.length();i++) {
		
		char c = s1.charAt(i);
		
		if (c>='A' && c<='Z') {
			u++;
		}
		else if (c>='a' && c<='z') {
			l++;
		}
		else if (c>='0' && n<='9') {
			n++;
		}
		else 
			s++;
	}
	
	System.out.println("Upper:"+u +"\nLower:"+l+"\nNmber:"+n+"\nSpecial:"+s);
	}

}
