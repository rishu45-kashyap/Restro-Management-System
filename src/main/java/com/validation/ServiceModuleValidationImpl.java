package com.validation;

public class ServiceModuleValidationImpl implements ServiceModuleValidation {
	private String result;

	@Override
	public String serviceModuleValidation(String iconname, String title, String description) {
		try {

			int iconname_len = iconname.length();
			int title_len = title.length();
			int description_len = description.length();

			if (iconname_len < 4 || iconname_len > 30) {
				result = "INVALID ICON NAME";
				System.out.println(iconname.length());
			} else if (title_len < 4 || title_len > 20) {
				result = "INVALID TITLE";
			} else if (description_len <20 || description_len > 78) {
				result = "INVALID DESCRIPTION";
			} else {
				result = "VALID";
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = "SOMETHING WENT WRONG";
		}

		// TODO Auto-generated method stub
		return result;
	}

}
