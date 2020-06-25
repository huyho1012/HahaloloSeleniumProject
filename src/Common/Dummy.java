package Common;

public class Dummy {
	public final String SCRIPTCODE = "<script>window.alert('sxx');</script>";
	public final String HTMLCODE = "<div> Hello Word </div>";
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
	public String RamdomVirtualMail() {
		String email = null;
		String AlphaNumericString = "0123456789";
		StringBuilder bd = new StringBuilder();
		for(int i =0 ; i< 6;i++) {
			int index = (int)(AlphaNumericString.length()*Math.random());
			email = bd.append(AlphaNumericString.charAt(index)).toString();
		}
		return "huyho"+email+"@mailinator.com";
	}
	public String DummyPass (int passLenght){
		String password = "";
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
		StringBuilder bd = new StringBuilder(passLenght);
		for(int i =0 ; i< passLenght;i++) {
			int index = (int)(AlphaNumericString.length()*Math.random());
			password = bd.append(AlphaNumericString.charAt(index)).toString();
		}
		return password;
	}

}
