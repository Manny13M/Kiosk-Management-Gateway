package ca.sheridancollege.martmanu.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Toothbrush {

	private Long id;
	
	private String name;
	
	private double price;
	
	private int quantity;
	
	private String employeeName;

}
