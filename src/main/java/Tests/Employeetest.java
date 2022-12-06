package Tests;
import entities.Employee;
import org.junit.Test;



import static org.junit.Assert.*;

public class Employeetest {
//This is a place where we can write tests for all of our methods.
    @Test
    public void employee_name()
    {
        Employee employee = new Employee("harry","123");
        assertEquals(employee.getPassword(),"1234");
//        assertNotEquals();
//        assertTrue();
//        assertNull();
//        assertNotNull();

    }
}
