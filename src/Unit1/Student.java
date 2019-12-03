package Unit1;

/**
 * The type Student.
 * @author 22browner
 * @version 09/04/2019
 */

// name and declaration of the class
public class Student {
	// declare provate data of a class
	// class feilds, instance variables, class data
	private String firstname, lastname;
	private int age, grade;

	/**
	 *
	 * @param fn First name of this student; a String
	 * @param ln Last name of this student; a String
	 * @param a Age of this student, an int
	 * @param g Grade of this student, an int
	 */

	public Student(String fn, String ln, int a, int g)	{
		firstname = fn;
		lastname = ln;
		age = a;
		grade = g;
	}

	/**
	 * Sets grade.
	 *
	 * @param newGrade the new grade
	 */

	/// ACCESSPR METHODS AND MUTAOR METHODS ///
	public String getFirstname() {
		return firstname;
	}

	public void setGrade(int newGrade)	{
		grade = newGrade;
	}

	public static void main(String[] args) {
		Student s1 = new Student("Ryan", "Kirschner", 17, 12);
		Student s2 = new Student("Declan", "Ross", 15, 11);
		System.out.println(s1);

	}
}
