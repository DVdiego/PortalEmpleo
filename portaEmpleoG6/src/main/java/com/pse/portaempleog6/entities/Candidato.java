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
@Table(name = "candidato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByIdCandidato", query = "SELECT c FROM Candidato c WHERE c.idCandidato = :idCandidato")
    , @NamedQuery(name = "Candidato.findByEmail", query = "SELECT c FROM Candidato c WHERE c.email = :email")
    , @NamedQuery(name = "Candidato.findByNombreCandidato", query = "SELECT c FROM Candidato c WHERE c.nombreCandidato = :nombreCandidato")
    , @NamedQuery(name = "Candidato.findByApellidoCandidato", query = "SELECT c FROM Candidato c WHERE c.apellidoCandidato = :apellidoCandidato")
    , @NamedQuery(name = "Candidato.findByFechaNacimiento", query = "SELECT c FROM Candidato c WHERE c.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Candidato.findByNumeroTarjeta", query = "SELECT c FROM Candidato c WHERE c.numeroTarjeta = :numeroTarjeta")
    , @NamedQuery(name = "Candidato.findByNumeroTelefono", query = "SELECT c FROM Candidato c WHERE c.numeroTelefono = :numeroTelefono")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_candidato")
    private Integer idCandidato;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_candidato")
    private String nombreCandidato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido_candidato")
    private String apellidoCandidato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;
    @Size(max = 9)
    @Column(name = "numero_telefono")
    private String numeroTelefono;

    public Candidato() {
    }

    public Candidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Candidato(Integer idCandidato, String email, String nombreCandidato, String apellidoCandidato, Date fechaNacimiento, String numeroTarjeta) {
        this.idCandidato = idCandidato;
        this.email = email;
        this.nombreCandidato = nombreCandidato;
        this.apellidoCandidato = apellidoCandidato;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTarjeta = numeroTarjeta;
    }

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getApellidoCandidato() {
        return apellidoCandidato;
    }

    public void setApellidoCandidato(String apellidoCandidato) {
        this.apellidoCandidato = apellidoCandidato;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidato != null ? idCandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.idCandidato == null && other.idCandidato != null) || (this.idCandidato != null && !this.idCandidato.equals(other.idCandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pse.portaempleog6.entities.Candidato[ idCandidato=" + idCandidato + " ]";
    }
    
}
