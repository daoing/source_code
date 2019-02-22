package main;

import org.dom4j.DocumentException;

import dom4j.Xmlread;

public class Dom4jtest {

	public static void main(String[] args) throws DocumentException {
		Xmlread xmlread = new Xmlread();
		//"student.xml"
		xmlread.getcontent("student.xml");
	}

}
