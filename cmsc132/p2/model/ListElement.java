package model;

import java.util.ArrayList;

public class ListElement extends TagElement {
	private ArrayList<Element> elementItem;

	public ListElement(boolean ordered, String attributes) {
		/*If ordered is true the list will be an ordered list; unordered otherwise.*/
		super(ordered ? "ol" : "ul", true, null, attributes);
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
			listOfElements += "\n" + "<li>" + "\n" + elementItem.get(i).genHTML(indentation) + "\n" + "</li>" + "\n";
		}

		return indents + "<" + getStartTag() + ">" + listOfElements + "\n" + "</" + getEndTag() + ">";
	}
}
