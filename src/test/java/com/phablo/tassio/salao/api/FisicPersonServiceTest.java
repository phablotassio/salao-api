package com.phablo.tassio.salao.api;

import com.phablo.tassio.salao.api.mapper.EmployeeMapper;
import com.phablo.tassio.salao.api.repository.EmployeeRepository;
import com.phablo.tassio.salao.api.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class FisicPersonServiceTest {

    @Mock
    private EmployeeRepository repository;

    @Mock
    private EmployeeMapper mapper;

    @InjectMocks
    private EmployeeService service = new EmployeeService();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        HttpServletRequest mockRequest = new MockHttpServletRequest();
        ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(mockRequest);
        RequestContextHolder.setRequestAttributes(servletRequestAttributes);
    }

    @After
    public void teardown() {
        RequestContextHolder.resetRequestAttributes();
    }

//    @Test
//    public void cadastrarPessoa() {
//
//        FisicPerson FisicPersonMock = Mockito.mock(FisicPerson.class);
//        EmployeeRequestDTO fisicPersonDTOMock = Mockito.mock(EmployeeRequestDTO.class);
//
//        Mockito.when(mapper.employeeToEmployeeResponseDto(FisicPersonMock)).thenReturn(fisicPersonDTOMock);
//        Mockito.when(mapper.employeeRequestDTOToEmployee(fisicPersonDTOMock)).thenReturn(FisicPersonMock);
//        Mockito.when(FisicPersonMock.getId()).thenReturn(1l);
//        Mockito.when(repository.save(FisicPersonMock)).thenReturn(FisicPersonMock);
//        service.cadastrarPessoa(fisicPersonDTOMock);
//        Mockito.verify(repository, Mockito.times(1)).save(FisicPersonMock);
//        Mockito.verify(FisicPersonMock, Mockito.times(1)).getId();
//    }

//    @Test
//    public void listarPessoas() {
//
//        List<FisicPerson> pessoas = new ArrayList<>();
//
//        Mockito.when(repository.findAll()).thenReturn(pessoas);
//        service.listarPessoas();
//        Mockito.verify(repository, Mockito.times(1)).findAll();
//    }

}
