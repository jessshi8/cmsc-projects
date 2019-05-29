package model;

public class AnchorElement extends TagElement {
	private String url, linkText;
	
	/*Initializes the tag with the provided parameters.*/
	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, null, attributes);
		this.url = url;
		this.linkText = linkText;
	}

	public String getLinkText() {
		return this.linkText;
	}

	public String getUrlText() {
		return this.url;
	}

	@Override
	public String genHTML(int indentation) {
		String indents = "";
		
		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}
		if (attributes == null) {
		return indents + "<" + getStartTag() + " href=" + '"' + getUrlText() + 
				'"' + ">" + getLinkText() + "</" + getEndTag() + ">";
		}
		else {
			setAttributes("href=" + '"' + url + '"' + " " + attributes);
			return indents + "<" + getStartTag() + ">" + getLinkText() + "</" + getEndTag() + ">";
			
		}
	}
}
