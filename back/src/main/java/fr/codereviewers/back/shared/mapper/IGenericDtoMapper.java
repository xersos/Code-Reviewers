package fr.codereviewers.back.mapper;

public interface IGenericDtoMapper<ENTITY, DTO> {
    DTO entityToDTO(ENTITY entity);
}
