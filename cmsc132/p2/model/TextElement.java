package model;

public class TextElement implements Element {
	private String text;

	/*Represents text that can appear in an HTML document*/
	public TextElement(String text) {
		this.text = text;
	}
	
	@Override
	public String genHTML(int indentation) {	
		String indents = "";
		
		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}
		return indents + text;
	}
}
