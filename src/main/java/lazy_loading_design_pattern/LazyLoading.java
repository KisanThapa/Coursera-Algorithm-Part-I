/*
   Java program to illustrate
   virtual proxy in
   Lazy Loading Design Pattern
 */

package lazy_loading_design_pattern;

import java.util.ArrayList;
import java.util.List;

interface ContactList {
    List<Employee> getEmployeeList();
}

class Company {
    String companyName;
    String companyAddress;
    String companyContactNo;
    ContactList contactList;

    public Company(String companyName, String companyAddress,
                   String companyContactNo, ContactList contactList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyContactNo = companyContactNo;
        this.contactList = contactList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyContactNo() {
        return companyContactNo;
    }

    public void setCompanyContactNo(String companyContactNo) {
        this.companyContactNo = companyContactNo;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }
}

class ContactListImplement implements ContactList {

    private static List<Employee> getEmpList() {
        List<Employee> empList = new ArrayList<Employee>(5);

        empList.add(new Employee("Lokesh", 2565.55, "SE"));
        empList.add(new Employee("Kushagra", 22574, "Manager"));
        empList.add(new Employee("Susmit", 3256.77, "G4"));
        empList.add(new Employee("Vikram", 4875.54, "SSE"));
        empList.add(new Employee("Achint", 2847.01, "SE"));

        return empList;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return getEmpList();
    }
}

class ContactListProxyImpl implements ContactList {

    private ContactList contactList;

    @Override
    public List<Employee> getEmployeeList() {
        if (contactList == null) {
            System.out.println("Fetching list of employees");
            contactList = new ContactListImplement();
        }

        return contactList.getEmployeeList();
    }
}

class Employee {
    private String employeeName;

    private double employeeSalary;
    private String employeeDesignation;

    public Employee(String employeeName,
                    double employeeSalary, String employeeDesignation) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public String toString() {
        return "Employee Name: " + employeeName + ", " +
                "EmployeeDesignation:" + employeeDesignation + " ," +
                "Employee Salary:" + employeeSalary;
    }
}

public class LazyLoading {
    public static void main(String[] args) {
        ContactList contactList = new ContactListProxyImpl();
        Company company = new Company
                ("ABC Company", "Germany", "+1-11-28458965", contactList);

        System.out.println("Company Name: " + company.getCompanyName());
        System.out.println("Company Address: " + company.getCompanyAddress());
        System.out.println("Company Contact No.: " + company.getCompanyContactNo());
        System.out.println("Requesting for contact list");

        contactList = company.getContactList();
        List<Employee> empList = contactList.getEmployeeList();
        for (Employee emp : empList) {
            System.out.println(emp);
        }

        /**
         * In the above code have a Company object is created
         * with a proxy ContactList object. At this time,
         * the Company object holds a proxy reference,
         * not the real ContactList object’s reference,
         * so there no employee list loaded into the memory.
         */
    }
}
