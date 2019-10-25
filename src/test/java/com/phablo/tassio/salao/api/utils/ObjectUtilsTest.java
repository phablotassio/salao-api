package com.phablo.tassio.salao.api.utils;

import com.phablo.tassio.salao.api.model.dto.EmailDto;
import com.phablo.tassio.salao.api.model.dto.PersonDto;
import com.phablo.tassio.salao.api.model.dto.Type;
import org.junit.Test;

import static com.phablo.tassio.salao.api.utils.ObjectUtils.applyChangesOnObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ObjectUtilsTest {


    @Test
    public void name() {

        EmailDto emailDto = new EmailDto();
        emailDto.setDesc("dsadsadsa");
        emailDto.setType(Type.COMMERCIAL);


        PersonDto source = new PersonDto("null", emailDto);
        PersonDto target = new PersonDto("nao", new EmailDto("not null", Boolean.TRUE));

        applyChangesOnObject(source, target);

        assertNotNull(target.getEmailDto().getMain());
        assertEquals(emailDto.getDesc(), target.getEmailDto().getDesc());
        assertEquals(source.getName(), target.getName());
        assertEquals(target.getEmailDto().getType(), source.getEmailDto().getType());

        target.getEmailDto().setType(Type.PESSOAL);
        ;
        applyChangesOnObject(source, target);

        assertNotNull(target.getEmailDto().getType());

    }


}