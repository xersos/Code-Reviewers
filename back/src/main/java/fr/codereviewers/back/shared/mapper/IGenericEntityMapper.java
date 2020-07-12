package fr.codereviewers.back.shared.mapper;

public interface IGenericEntityMapper<ENTITY, DTO> {
    ENTITY dtoToEntity(DTO dto);
}
