package codewars;

/***
 * Given two words and a letter, return a single word that's a combination of both words, 
 * merged at the point where the given letter first appears in each word. The returned word 
 * should have the beginning of the first word and the ending of the second, with the dividing 
 * letter in the middle. You can assume both words will contain the dividing letter.
 * 
 * Examples:
 * stringMerge("hello", "world", "l")      ==>  "held"
 * stringMerge("coding", "anywhere", "n")  ==>  "codinywhere"
 * stringMerge("jason", "samson", "s")     ==>  "jasamson"
 * stringMerge("wonderful", "people", "e") ==>  "wondeople"
 * 
 * @author Deepanjan
 *
 */

public class StringMerge {

	public String stringMerge(String s1, String s2, String letter) {
		String ans = null;
		
		int pos1 = s1.indexOf(letter); 
		int pos2 = s2.indexOf(letter); 
		int l2 = s2.length();
		
		String sub1 = s1.substring(0, pos1+1); 
		String sub2 = s2.substring(pos2+1, l2); 
		
		ans = sub1.concat(sub2);
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringMerge obj = new StringMerge();
		String ans = obj.stringMerge("jason", "samson", "n");
		System.out.println("Merged string: " + ans);
	}

}
