package com.phablo.tassio.salao.api;

import com.phablo.tassio.salao.api.model.Pessoa;
import com.phablo.tassio.salao.api.repository.PessoaRepository;
import com.phablo.tassio.salao.api.service.PessoaService;
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
        Pessoa pessoaMock = Mockito.mock(Pessoa.class);

        PessoaService pessoaService = new PessoaService(pessoaRepositoryMock);

        Mockito.when(pessoaMock.getId()).thenReturn(1l);
        Mockito.when(pessoaRepositoryMock.save(pessoaMock)).thenReturn(pessoaMock);
        pessoaService.cadastrarPessoa(pessoaMock);
        Mockito.verify(pessoaRepositoryMock, Mockito.times(1)).save(pessoaMock);
        Mockito.verify(pessoaMock, Mockito.times(1)).getId();

    }

    @Test
    public void listarPessoas() {

        PessoaRepository pessoaRepositoryMock = Mockito.mock(PessoaRepository.class);
        PessoaService pessoaService = new PessoaService(pessoaRepositoryMock);
        List<Pessoa> pessoas = new ArrayList<>();

        Mockito.when(pessoaRepositoryMock.findAll()).thenReturn(pessoas);
        pessoaService.listarPessoas();
        Mockito.verify(pessoaRepositoryMock, Mockito.times(1)).findAll();


    }

}
