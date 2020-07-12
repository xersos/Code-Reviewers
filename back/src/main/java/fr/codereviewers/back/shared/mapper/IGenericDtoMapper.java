package fr.codereviewers.back.shared.mapper;

public interface IGenericDtoMapper<ENTITY, DTO> {
    DTO entityToDTO(ENTITY entity);
}
