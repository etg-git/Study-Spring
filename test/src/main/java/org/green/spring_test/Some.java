package org.green.spring_test;

import org.springframework.stereotype.Component;

/*
 * 	Annotation
 * 		@Component : bean으로 등록
 * 
 * 		@Controller : 
 * 		@Repository : DAO
 * 		@Service : Command
 */
@Component
public class Some {
	private String contents;

	public Some(String contents) {
		super();
		this.contents = contents;
	}
	
	public Some() {
		
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Some [contents=" + contents + "]";
	}
	
}
