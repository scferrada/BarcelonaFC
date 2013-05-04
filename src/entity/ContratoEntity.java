package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 03-05-13
 * Time: 02:47 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "CONTRATO", schema = "BARCELONAFC", catalog = "")
@Entity
public class ContratoEntity {
    private int id;

    @javax.persistence.Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Timestamp fechaInicio;

    @javax.persistence.Column(name = "FECHA_INICIO")
    @Basic
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    private Timestamp fechaExpiracion;

    @javax.persistence.Column(name = "FECHA_EXPIRACION")
    @Basic
    public Timestamp getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Timestamp fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    private int mensualidad;

    @javax.persistence.Column(name = "MENSUALIDAD")
    @Basic
    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContratoEntity that = (ContratoEntity) o;

        if (id != that.id) return false;
        if (mensualidad != that.mensualidad) return false;
        if (fechaExpiracion != null ? !fechaExpiracion.equals(that.fechaExpiracion) : that.fechaExpiracion != null)
            return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaExpiracion != null ? fechaExpiracion.hashCode() : 0);
        result = 31 * result + mensualidad;
        return result;
    }
}
