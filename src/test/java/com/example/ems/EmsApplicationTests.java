package com.example.ems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmsApplicationTests {

    //    @Autowired
//    private EmployeeDto employeeDto;
    @Test
    void contextLoads() {
    }

    //use test anno, can change the db config also via app.prop, tear down, before each, if we have tested repo
    // then for service we ll use mockito
//    public void testaddemp(){
//        EmployeeDto employeeDto1=new EmployeeDto();
//        employeeDto1.setId(1);
//        emp=emplrepo;
//        assertThat(actual is equal to expected);// static method
//    }


}
