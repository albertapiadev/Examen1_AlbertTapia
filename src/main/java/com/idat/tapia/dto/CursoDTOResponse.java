package com.idat.tapia.dto;

public class CursoDTOResponse {

    private int idCursoDTO;
    private String cursoDTO;
    private String descripcionDTO;
    private int idMallaDTO;

    public int getIdCursoDTO() {
        return idCursoDTO;
    }

    public void setIdCursoDTO(int idCursoDTO) {
        this.idCursoDTO = idCursoDTO;
    }

    public String getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(String cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    public String getDescripcionDTO() {
        return descripcionDTO;
    }

    public void setDescripcionDTO(String descripcionDTO) {
        this.descripcionDTO = descripcionDTO;
    }

    public int getIdMallaDTO() {
        return idMallaDTO;
    }

    public void setIdMallaDTO(int idMallaDTO) {
        this.idMallaDTO = idMallaDTO;
    }
}
