package com.nesryne.wallet.service.mapper;

import java.util.List;

<<<<<<< HEAD
public interface EntityMapper<D,E> {
    E toEntity(D dto);
    D toDto(E entity);
    List <E> toEntity(List<D> dtoList);
    List <D> toDto(List<E> entityList);
    
}
=======
public interface EntityMapper <D, E>{



        E toEntity(D dto);
    
        D toDto(E entity);
    
        List <E> toEntity(List<D> dtoList);
    
        List <D> toDto(List<E> entityList);
    }
    
    


>>>>>>> 97872aa80bb8e52c8c08285c30479868b87c1364
