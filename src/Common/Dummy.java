package Common;

public class Dummy {
	public String RandomString(int chars) {
		String text = null;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz" +" ";
		StringBuilder bd = new StringBuilder(chars);
		for(int i =0 ; i< chars;i++) {
			int index = (int)(AlphaNumericString.length()*Math.random());
			text = bd.append(AlphaNumericString.charAt(index)).toString();
		}
		return text;
	}
}
