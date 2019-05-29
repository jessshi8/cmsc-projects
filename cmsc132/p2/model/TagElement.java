package model;

public class TagElement implements Element {
	private String tagName;
	protected String attributes;
	private boolean endTag;
	private Element content;
	
	private int id;
	protected static int staticID;
	protected static boolean enabler;
	
	/*Initializes a tag element.*/
	public TagElement(String tagName, boolean endTag, 
			Element content, String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		
		staticID++;
		id = staticID;
	}

	public int getId() {
		return staticID;
	}

	public String getStringId() {
		return this.tagName + " id=" + '"' + this.tagName + this.id + '"';
	}
	
	/*string representing the start 
	 * tag including attributes (if any).*/
	public String getStartTag() {
		if (!(this.attributes == null)) {
			if (enabler == true) {
				return getStringId() + " " + this.attributes;
			}
			else {
				return this.tagName + " " + this.attributes;
			}
		}
		else {
			if (enabler == true) {
				return getStringId();
			}
			else {
				return this.tagName;
			}
		}
	}
	
	/*end tag or empty string 
	 * (for tags with only start tag)*/
	public String getEndTag() {
		if (this.endTag == true) {
			return this.tagName;
		}
		else {
			return "";
		}
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public static void resetIds() {
		staticID = 0;
	}

	public static void enableId(boolean choice) {
		if (choice == true) {
			enabler = true;
		}
		else {
			enabler = false;
		}
	}
	
	@Override
	public String genHTML(int indentation) {
		String indents = "";
		
		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}
		return indents + "<" + getStartTag() + ">" + content.genHTML(0) + "</" + getEndTag() + ">";
	}
}
