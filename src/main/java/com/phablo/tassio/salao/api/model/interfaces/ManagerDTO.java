package com.phablo.tassio.salao.api.model.interfaces;

import java.io.Serializable;

public interface ManagerDTO< T, Long extends Serializable> {

    ApplicationDTO convertToDTO(T clazz);
    T convertToEntity(ApplicationDTO simpleDTO);

}
