package model;

public class TableElement extends TagElement {
	private double rows, cols, count;
	private Element[][] tableItem;
	
	/*Defines the array and initializes the attributes.*/
	public TableElement(int rows, int cols, String attributes) {
		super("table", true, null, attributes);
		this.rows = rows;
		this.cols = cols;	
		tableItem = new Element[rows][cols];
	}
	
	public void addItem(int rowIndex, int colIndex, Element item) {
		tableItem[rowIndex][colIndex] = item;
	}

	public double getTableUtilization() {
		count = 0;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				if (!(tableItem[i][j] == null)) {
					count++;
				}
			}
		}
		return (count / (this.rows * this.cols)) * 100;
	}

	public String genHTML(int indentation) {
		String indents = "";
		String newItems = "";
		
		for (int i = 0; i < indentation; i++) {
			indents += " ";
		}
		
		for (int i = 0; i < this.rows; i++) {
			newItems += "\n" + "<tr>";
			for (int j = 0; j < this.cols; j++) {
				if (!(tableItem[i][j] == null)) {
					newItems += "<td>" + tableItem[i][j].genHTML(0) + "</td>";
				}
				else {
					newItems += "<td></td>";
				}
			}
			newItems += "</tr>";
		}
		
		return indents + "<" + getStartTag() + ">" + newItems 
				+ "\n" + indents + "</" + getEndTag() + ">";
	}
}
