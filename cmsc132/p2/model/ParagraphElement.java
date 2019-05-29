package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement {
	private ArrayList<Element> elementItem;
	
	/*Represents a paragraph (<p>) tag.*/
	public ParagraphElement(String attributes) {
		super("p", true, null, attributes);
		elementItem = new ArrayList<Element>();
	}
	
	public void addItem(Element item) {
		elementItem.add(item);
	}
	
	@Override
	public String genHTML(int indentation) {
		String indents = "";
		String listOfElements = "";

		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}

		for (int i = 0; i < elementItem.size(); i++) {
			listOfElements += "\n" + elementItem.get(i).genHTML(indentation);
		}
		return indents + "<" + getStartTag() + ">" + listOfElements + "\n" + "</" + getEndTag() + ">";
	}
}
