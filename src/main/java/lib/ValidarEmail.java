package lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEmail {

	public static boolean validateEmail(String email) {
		boolean emailValidate = false;
		if (email != null) {
			String validate = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(validate, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				emailValidate = true;
			}
		}

		return emailValidate;
	}

}
