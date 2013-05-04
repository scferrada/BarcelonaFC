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
@javax.persistence.Table(name = "ACTIVO", schema = "BARCELONAFC", catalog = "")
@Entity
public class ActivoEntity {
    private int id;

    @javax.persistence.Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int valor;

    @javax.persistence.Column(name = "VALOR")
    @Basic
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    private BigInteger tipoActivoId;

    @javax.persistence.Column(name = "TIPO_ACTIVO_ID")
    @Basic
    public BigInteger getTipoActivoId() {
        return tipoActivoId;
    }

    public void setTipoActivoId(BigInteger tipoActivoId) {
        this.tipoActivoId = tipoActivoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivoEntity that = (ActivoEntity) o;

        if (id != that.id) return false;
        if (valor != that.valor) return false;
        if (tipoActivoId != null ? !tipoActivoId.equals(that.tipoActivoId) : that.tipoActivoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + valor;
        result = 31 * result + (tipoActivoId != null ? tipoActivoId.hashCode() : 0);
        return result;
    }
}
