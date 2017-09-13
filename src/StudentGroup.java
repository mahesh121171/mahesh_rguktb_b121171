import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException {
		// Add your implementation here
		if(students==null)throw new IllegalArgumentException();
		this.students=students;

	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {
		// Add your implementation here
		if (index<0 || index>=students.length) {
			throw new IllegalArgumentException();
		}
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException {
		// Add your implementation here
		if(student == null || index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		students[index]=student;
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();	
		}
		Student s[]=new Student[students.length+1];
		s[0]=student;
		for (int i=0;i<students.length ;++i ) 
		{
			s[i+1]=students[i];
		}
		students=s;
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();	
		}
		Student s[]=new Student[students.length+1];
		s[s.length-1]=student;
		for (int i=0;i<students.length ;++i ) 
		{
			s[i]=students[i];
		}
		students=s;
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException  {
		// Add your implementation here
		if(student == null || index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] s=new Student[students.length+1];
		for (int i=0;i<index ;i++ ) {
			s[i]=students[i];
		}
		s[index]=student;
		for (int i=index+1,j=index;i<s.length && j<students.length;++j,i++ ) {
			s[i]=students[j];
		}
		students=s;
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] s=new Student[students.length-1];
		for (int i=0,j=0;i<s.length ;j++ ) 
		{
			if(j!=index)
				s[i++]=students[j];
		}
		students=s;
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		int index=-1;
		for (int i=0;i<students.length ;++i ) {
			if(student.equals(students[i]))
				index=i;
		}
		if(index!=-1)
			remove(index);
		else
			throw new IllegalArgumentException("Student not exist");
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] s=new Student[index+1];
		for (int i=0;i<=index ;i++ ) {
			s[i]=students[i];
		}
		students=s;
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException 
	{
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		int index=-1;
		for (int i=0;i<students.length ;++i ) {
			if(student.equals(students[i]))
				index=i;
		}
		if(index!=-1)
		{
			Student[] s=new Student[index+1];
			for (int i=0;i<=index ;i++ ) {
				s[i]=students[i];
			}
			students=s;
		}
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		Student[] s=new Student[students.length-index];
		for (int i=index,j=0;i<students.length ;++j,i++ ) {
			s[j]=students[i];
		}
		students=s;
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		int index=-1;
		for (int i=0;i<students.length ;++i ) {
			if(student.equals(students[i]))
				index=i;
		}
		Student[] s=new Student[students.length-index];
		for (int i=index,j=0;i<students.length ;++j,i++ ) {
			s[j]=students[i];
		}
		students=s;
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int i=0;i<students.length ;++i ) {
			for (int j=0;j<students.length-i-1 ;++j ) {
				if (students[j].compareTo(students[j+1])>0)
				{
					Student temp;
					temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double mark=students[0].getAvgMark();
		for (int i=1;i<students.length ;++i ) 
		{
			if(students[i].getAvgMark()>mark)
				mark=students[0].getAvgMark();	
		}
		int count=0;
		for (int i=0;i<students.length ;++i ) 
		{
			if(students[i].getAvgMark()==mark)
				count++;	
		}
		Student[] s=new Student[count];
		for (int i=0,j=0;i<s.length ;++i ) 
		{
			if(students[i].getAvgMark()==mark)
				s[j++]=students[i];	
		}
		return s;
	}

	@Override
	public Student getNextStudent(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		int index=-1;
		for (int i=0;i<students.length ;++i ) {
			if(student.equals(students[i]))
				index=i;
		}
		if(index!=-1)
		{
			return students[index+1];
		}
		return null;
	}
}
