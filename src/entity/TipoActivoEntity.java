package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 03-05-13
 * Time: 02:47 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "TIPO_ACTIVO", schema = "BARCELONAFC", catalog = "")
@Entity
public class TipoActivoEntity {
    private BigInteger id;

    @javax.persistence.Column(name = "ID")
    @Id
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    private String tipo;

    @javax.persistence.Column(name = "TIPO")
    @Basic
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String descripcion;

    @javax.persistence.Column(name = "DESCRIPCION")
    @Basic
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoActivoEntity that = (TipoActivoEntity) o;

        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
