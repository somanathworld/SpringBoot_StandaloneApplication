package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("bdProcessor")
public class BookDetailsProcessor implements ItemProcessor<String, String> {

	public BookDetailsProcessor() {
		System.out.println("BookDetailsProcessor.BookDetailsProcessor()");
	}
	
	public String process(String item) throws Exception {
		System.out.println("BookDetailsProcessor.process()");	
		String bookWithTitle = null;
		
		switch(item.toUpperCase()) {
			case "CRJ" :
				bookWithTitle = item + "by HS and PN";
				break;
			case "TIJ" :
				bookWithTitle = item + "by BE";
				break;
			case "HFJ" :
				bookWithTitle = item + "by KS";
				break;
			case "EJ" :
				bookWithTitle = item + "by JB";
				break;
			case "BBJ" :
				bookWithTitle = item + "by RNR";
				break;
			default :
				bookWithTitle = "Wrong Book Name.";
		}
		return bookWithTitle;
	}
}
