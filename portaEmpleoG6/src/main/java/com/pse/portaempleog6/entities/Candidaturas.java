/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pse.portaempleog6.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "candidaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidaturas.findAll", query = "SELECT c FROM Candidaturas c")
    , @NamedQuery(name = "Candidaturas.findByIdCandidatura", query = "SELECT c FROM Candidaturas c WHERE c.idCandidatura = :idCandidatura")
    , @NamedQuery(name = "Candidaturas.findByIdCandidato", query = "SELECT c FROM Candidaturas c WHERE c.idCandidato = :idCandidato")
    , @NamedQuery(name = "Candidaturas.findByIdOferta", query = "SELECT c FROM Candidaturas c WHERE c.idOferta = :idOferta")})
public class Candidaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_candidatura")
    private Integer idCandidatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_candidato")
    private int idCandidato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oferta")
    private int idOferta;

    public Candidaturas() {
    }

    public Candidaturas(Integer idCandidatura) {
        this.idCandidatura = idCandidatura;
    }

    public Candidaturas(Integer idCandidatura, int idCandidato, int idOferta) {
        this.idCandidatura = idCandidatura;
        this.idCandidato = idCandidato;
        this.idOferta = idOferta;
    }

    public Integer getIdCandidatura() {
        return idCandidatura;
    }

    public void setIdCandidatura(Integer idCandidatura) {
        this.idCandidatura = idCandidatura;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidatura != null ? idCandidatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidaturas)) {
            return false;
        }
        Candidaturas other = (Candidaturas) object;
        if ((this.idCandidatura == null && other.idCandidatura != null) || (this.idCandidatura != null && !this.idCandidatura.equals(other.idCandidatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pse.portaempleog6.entities.Candidaturas[ idCandidatura=" + idCandidatura + " ]";
    }
    
}
