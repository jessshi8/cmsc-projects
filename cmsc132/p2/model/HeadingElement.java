package model;

public class HeadingElement extends TagElement {
	private Element content;
	private int level;
	
	/*Includes the content as part of the heading.*/
	public HeadingElement(Element content, int level, String attributes) {
		super("h", true, content, attributes);
		this.content = content;
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String genHTML(int indentation) {
		String indents = "";
		
		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}
		return indents + "<" + getStartTag() + level + ">" 
		+ content.genHTML(0) + "</" + getEndTag() + level + ">";
	}
}
