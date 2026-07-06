package com.tecsup.mshistorial.dto;

public class TicketDTO {

    private Long id;
    private String titulo;
    private String estado;
    private Long creadorId;
    private Long responsableId;

    public TicketDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Long getCreadorId() { return creadorId; }
    public void setCreadorId(Long creadorId) { this.creadorId = creadorId; }

    public Long getResponsableId() { return responsableId; }
    public void setResponsableId(Long responsableId) { this.responsableId = responsableId; }
}