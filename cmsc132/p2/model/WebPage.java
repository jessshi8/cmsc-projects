package model;

import java.util.ArrayList;

public class WebPage implements Comparable<WebPage> {
	private String title;
	private ArrayList<Element> webPageElement = new ArrayList<Element>();
	protected static boolean enabler;
	

	/*Initializes the object with the specified title and creates the ArrayList.*/
	public WebPage(String title) {
		this.title = title;
	}
	
	public int addElement(Element element) {
		webPageElement.add(element);
		if (!(element instanceof TagElement)) {
			return -1;
		}
		else {
			TagElement other = (TagElement) element;
			return other.getId();
		}	
	}
	
	public String getWebPageHTML(int indentation) {
		String spaces = "";
		String html = "";
		
		for (int i = 0; i < indentation; i++) {
			spaces += " ";
		}
		
		for (int i = 0; i < webPageElement.size(); i++) {
			html += "\n" + webPageElement.get(i).genHTML(indentation);
		}
		return spaces + "<!doctype html>" + "\n" + "<html>" + "\n" + "<head>" +
				"\n" + "<meta charset=" + '"' + "utf-8" + '"' + "/>" + "\n" +
				"<title>" + this.title + "</title>" + "\n" + "</head>" + "\n" + 
				"<body>" + html + "\n" + "</body>" + "\n" + "</html>";
	}
	
	public void writeToFile(String filename, int indentation) {
		Utilities.writeToFile(filename, Integer.toString(indentation));
	}
	
	public Element findElem(int id) {
		return webPageElement.get(id);
	}
	
	public String stats() {
		String listItems = "List Count: ";
		String parItems = "Paragraph Count: ";
		String tableItems = "Table Count: ";
		int numOfListItems = 0, numOfParItems = 0, numOfTableItems = 0;
		double util = 0;
		
		for (int i = 0; i < webPageElement.size(); i++) {
			if (webPageElement.get(i) instanceof ListElement) {
				numOfListItems++;
			}
			if (webPageElement.get(i) instanceof ParagraphElement) {
				numOfParItems++;
			}
			if (webPageElement.get(i) instanceof TableElement) {
				numOfTableItems++;
				TableElement tabElement = (TableElement) webPageElement.get(i);
				util += tabElement.getTableUtilization();
			}
		}
		
		if (!(numOfTableItems == 0)) {
			util /= numOfTableItems;
		}
		
		return listItems + numOfListItems + "\n" + parItems + numOfParItems + "\n" +
				tableItems + numOfTableItems + "\n" + "TableElement Utilization: " + util;
	}
	
	public int compareTo(WebPage webPage) {
		if (!(this.title.equals(webPage.title))) {
			return -1;
		}
		else if (this.title.equals(webPage.title)) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public static void enableId(boolean choice) {
		if (choice == true) {
			enabler = true;
		}
		else {
			enabler = false;
		}
	}
}
