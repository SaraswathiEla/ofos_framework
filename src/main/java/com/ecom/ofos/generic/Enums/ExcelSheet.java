package com.ecom.ofos.generic.Enums;

/**
 * this enum contains sheet name of excel
 * @autor saraswathi B
 */
public enum ExcelSheet {
	ADMIN("Admin"),USER("User");

	String key;
	/*2
	 * 
	 */
	private ExcelSheet(String key)
	{
		this.key=key;
	}
	/**
	 * 
	 * @return
	 */
	public String getSheetName()
	{
		return key;
	}
	
 
}
