package additional_question;

public class LongestPalidrome {

	private static int lowPos;
	private static int maxLength;
	
	public static void main(String[] args){
		System.out.println(longestPalidrom("civilwartestingwhetherthatnaptionoranynarti"
				+ "onsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefie"
				+ "mldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplacefo"
				+ "rthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproper"
				+ "thatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannoth"
				+ "allowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfarabov"
				+ "eourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayhe"
				+ "rebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretot"
				+ "heulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforust"
				+ "obeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwet"
				+ "akeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionth"
				+ "atweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsd"
				+ "erGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeo"
				+ "pleshallnotperishfromtheearth"));
	}
	
	public static String longestPalidrom(String s){
		if(s.length()<2){
			return s;
		}
		for(int i=0; i<s.length()-1; i++){
			extendPalidrom(s, i, i);
			extendPalidrom(s, i, i+1);
		}
		System.out.println("");
		return s.substring(lowPos, lowPos+maxLength);
	}
	
	public static void extendPalidrom(String s, int m, int n){
		while(m>=0&&n<s.length()&&s.charAt(m)==s.charAt(n)){
			m--;
			n++;
		}
		if(maxLength<n-m-1){
			lowPos = m+1;
			maxLength = n-m-1;
		}
	}
}
