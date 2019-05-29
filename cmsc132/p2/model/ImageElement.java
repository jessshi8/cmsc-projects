package model;

public class ImageElement extends TagElement {
	private String imageURL, alt;
	private int width, height;
	
	/*Represents an <img> tag.*/
	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, null, attributes);
		this.imageURL = imageURL;
		this.width = width;
		this.height = height;
		this.alt = alt;
	}

	public String getImageURL() {
		return this.imageURL;
	}

	@Override
	public String genHTML(int indentation) {
		String indents = "";

		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}
		return indents + "<" + getStartTag() + " src=" 
		+ '"' + imageURL + '"' + " width=" + '"' + width + '"' + " height=" + 
		'"' + height + '"' + " alt=" + '"' + alt + '"' + ">";
	}
}
