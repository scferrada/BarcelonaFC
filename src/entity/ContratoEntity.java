package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "CONTRATO", schema = "BARCELONAFC", catalog = "")
@Entity
public class ContratoEntity {

    private Integer id;
    private Timestamp fechaInicio;
    private Timestamp fechaExpiracion;
    private Integer mensualidad;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTRATO")
    @SequenceGenerator(name = "SEQ_CONTRATO", sequenceName = "SEQ_CONTRATO")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "FECHA_INICIO")
    @Basic
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @javax.persistence.Column(name = "FECHA_EXPIRACION")
    @Basic
    public Timestamp getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Timestamp fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @javax.persistence.Column(name = "MENSUALIDAD")
    @Basic
    public Integer getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(Integer mensualidad) {
        this.mensualidad = mensualidad;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaExpiracion != null ? fechaExpiracion.hashCode() : 0);
        result = 31 * result + mensualidad;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContratoEntity that = (ContratoEntity) o;

        if (fechaExpiracion != null ? !fechaExpiracion.equals(that.fechaExpiracion) : that.fechaExpiracion != null)
            return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (mensualidad != null ? !mensualidad.equals(that.mensualidad) : that.mensualidad != null) return false;

        return true;
    }
}
