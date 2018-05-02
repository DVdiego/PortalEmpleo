/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portaempleog6.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta")
    , @NamedQuery(name = "Oferta.findByIdEmpresa", query = "SELECT o FROM Oferta o WHERE o.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "Oferta.findByNombreOferta", query = "SELECT o FROM Oferta o WHERE o.nombreOferta = :nombreOferta")
    , @NamedQuery(name = "Oferta.findByDescripcion", query = "SELECT o FROM Oferta o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Oferta.findByFechaIncorporacion", query = "SELECT o FROM Oferta o WHERE o.fechaIncorporacion = :fechaIncorporacion")
    , @NamedQuery(name = "Oferta.findByPuestoTrabajo", query = "SELECT o FROM Oferta o WHERE o.puestoTrabajo = :puestoTrabajo")
    , @NamedQuery(name = "Oferta.findByRequisitosMinimos", query = "SELECT o FROM Oferta o WHERE o.requisitosMinimos = :requisitosMinimos")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oferta")
    private Integer idOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private int idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_oferta")
    private String nombreOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_incorporacion")
    @Temporal(TemporalType.DATE)
    private Date fechaIncorporacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "puesto_trabajo")
    private String puestoTrabajo;
    @Size(max = 140)
    @Column(name = "requisitos_minimos")
    private String requisitosMinimos;

    public Oferta() {
    }

    public Oferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(Integer idOferta, int idEmpresa, String nombreOferta, String descripcion, Date fechaIncorporacion, String puestoTrabajo) {
        this.idOferta = idOferta;
        this.idEmpresa = idEmpresa;
        this.nombreOferta = nombreOferta;
        this.descripcion = descripcion;
        this.fechaIncorporacion = fechaIncorporacion;
        this.puestoTrabajo = puestoTrabajo;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public String getRequisitosMinimos() {
        return requisitosMinimos;
    }

    public void setRequisitosMinimos(String requisitosMinimos) {
        this.requisitosMinimos = requisitosMinimos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pse.portaempleog6.entities.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
