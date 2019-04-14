package com.phablo.tassio.salao.api;

import com.phablo.tassio.salao.api.model.Person;
import com.phablo.tassio.salao.api.model.dto.PersonDTO;
import com.phablo.tassio.salao.api.repository.PessoaRepository;
import com.phablo.tassio.salao.api.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PessoaServiceTest {

    @Before
    public void setup() {
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

        PessoaRepository pessoaRepositoryMock = Mockito.mock(PessoaRepository.class);
        Person pessoaMock = Mockito.mock(Person.class);
        PersonDTO personDTOMock = Mockito.mock(PersonDTO.class);

        PersonService pessoaService = new PersonService(pessoaRepositoryMock);

        Mockito.when(pessoaMock.getId()).thenReturn(1l);
        Mockito.when(pessoaRepositoryMock.save(pessoaMock)).thenReturn(pessoaMock);
        pessoaService.cadastrarPessoa(personDTOMock);
        Mockito.verify(pessoaRepositoryMock, Mockito.times(1)).save(pessoaMock);
        Mockito.verify(pessoaMock, Mockito.times(1)).getId();

    }

    @Test
    public void listarPessoas() {

        PessoaRepository pessoaRepositoryMock = Mockito.mock(PessoaRepository.class);
        PersonService pessoaService = new PersonService(pessoaRepositoryMock);
        List<Person> pessoas = new ArrayList<>();

        Mockito.when(pessoaRepositoryMock.findAll()).thenReturn(pessoas);
        pessoaService.listarPessoas();
        Mockito.verify(pessoaRepositoryMock, Mockito.times(1)).findAll();


    }

}
