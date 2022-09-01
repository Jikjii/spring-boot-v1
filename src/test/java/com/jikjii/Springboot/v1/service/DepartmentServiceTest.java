package com.jikjii.Springboot.v1.service;

import com.jikjii.Springboot.v1.entity.Department;
import com.jikjii.Springboot.v1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("NYC")
                        .departmentCode("It-06")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    // test case
    @Test
    @DisplayName("Get Data based on Valid Department Name")
    //@Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}