package ru.intodayer.quizproject.dto.converter;


public interface DTOConverter<E, D> {

    E convertDTOToEntity(D dto);

    D convertEntityToDTO(E entity);

}
