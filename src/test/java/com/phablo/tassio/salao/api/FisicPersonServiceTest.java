package com.phablo.tassio.salao.api;

import com.phablo.tassio.salao.api.model.FisicPerson;
import com.phablo.tassio.salao.api.model.dto.FisicPersonDTO;
import com.phablo.tassio.salao.api.model.mapper.FisicPersonMapper;
import com.phablo.tassio.salao.api.repository.FisicPersonRepository;
import com.phablo.tassio.salao.api.service.FisicPersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class FisicPersonServiceTest {

    @Mock
    private FisicPersonRepository repository;

    @Mock
    private FisicPersonMapper mapper;

    @InjectMocks
    private FisicPersonService service = new FisicPersonService();

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

    @Test
    public void cadastrarPessoa() {

        FisicPerson FisicPersonMock = Mockito.mock(FisicPerson.class);
        FisicPersonDTO fisicPersonDTOMock = Mockito.mock(FisicPersonDTO.class);

        Mockito.when(mapper.personToPersonDto(FisicPersonMock)).thenReturn(fisicPersonDTOMock);
        Mockito.when(mapper.personDTOToFisicPerson(fisicPersonDTOMock)).thenReturn(FisicPersonMock);
        Mockito.when(FisicPersonMock.getId()).thenReturn(1l);
        Mockito.when(repository.save(FisicPersonMock)).thenReturn(FisicPersonMock);
        service.cadastrarPessoa(fisicPersonDTOMock);
        Mockito.verify(repository, Mockito.times(1)).save(FisicPersonMock);
        Mockito.verify(FisicPersonMock, Mockito.times(1)).getId();
    }

    @Test
    public void listarPessoas() {

        List<FisicPerson> pessoas = new ArrayList<>();

        Mockito.when(repository.findAll()).thenReturn(pessoas);
        service.listarPessoas();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

}
