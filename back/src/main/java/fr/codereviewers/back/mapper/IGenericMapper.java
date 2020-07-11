package fr.codereviewers.back.mapper;

public interface IGenericMapper<ENTITY, DTO> {
    DTO entityToDTO(ENTITY entity);
    ENTITY dtoToEntity(DTO dto);
}
