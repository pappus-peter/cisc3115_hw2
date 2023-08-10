package assignment;

import java.io.* ;
import java.util.*;

class Name {
	private String last; 
	private String first; 
	
	public Name(String last, String first) {
		this.last = last; 
		this.first = first; 
	}
	public Name(String first) {
		this("",first); 
	}
	
	public String getFormal() {
		return this.first + " " + this.last;
	}
	public String getOfficial() {
		return this.last + ", " + this.first;
	}
	public String getInitals() {
		return this.first.substring(0,1) + "." + this.last.substring(0,1) + "."; 
	}
	public boolean equals(Name other) {
		return this.first.equals(other.first ) && this.last.equals(other.last);
	}
	
	public String toString() {
		return first + " " + last;
	}
	public static Name read(Scanner scanner) {
		if(!scanner.hasNext()) {
			return null;
		}
		String last = scanner.next(); 
		String first = scanner.next();
		return new Name(last, first); 
	}


	
	public static void main( String[] args) throws IOException{
		Scanner sc = new Scanner(new File("names.text")); 
		int count = 0; 
		String nameTemp = ""; 
		
		Name name = read(sc); 
		while(name != null) {
			if(name.toString().equals(nameTemp)) {
				System.out.println("Duplicate name \"" + name + "\" discovered"); 
			}else {
				System.out.println("name: " + name);  
				System.out.println("formal: " + name.getFormal()); 
				System.out.println("official: " + name.getOfficial());
				System.out.println("initials: " + name.getInitals());
				System.out.println(); 
			}
			count++; 
			nameTemp = name.toString(); 
			name = read(sc); 
		}
		System.out.println("---"); 
		System.out.println(count + " names processed."); 
		
	}

}
