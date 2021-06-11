/**
 * 
 */
package com.java.techhub.email.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mahes
 *
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

	private String firstName;
	
	private String lastName;
	
	private String location;
	
	private List<TargetEmail> emails;
	
}
