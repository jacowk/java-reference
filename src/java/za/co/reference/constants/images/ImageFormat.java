package za.co.reference.constants.images;

public enum ImageFormat{
	
	JPG("JPG"),
	PNG("PNG"),
	GIF("GIF");
	
	ImageFormat(String format){
		this.format = format;
	}
	
	public String getFormat(){
		return format;
	}

	public void setFormat(String format){
		this.format = format;
	}

	private String format;
	
}
