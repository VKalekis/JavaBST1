class Employee implements Comparable{

    private String name;
    private double salary;

    public Employee(String n, double s){
        name=n;
        salary=s;
    }

    public String getName(){
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int compareTo(Object otherObject){
        Employee other=(Employee)otherObject;
        if (name.compareTo(other.name)<0)
            return 1;
        else
            return -1;
    }
}