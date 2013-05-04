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
@javax.persistence.Table(name = "DATO_CONTACTO", schema = "BARCELONAFC", catalog = "")
@Entity
public class DatoContactoEntity {
    private int id;

    @javax.persistence.Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String datoValor;

    @javax.persistence.Column(name = "DATO_VALOR")
    @Basic
    public String getDatoValor() {
        return datoValor;
    }

    public void setDatoValor(String datoValor) {
        this.datoValor = datoValor;
    }

    private BigInteger tipoContactoId;

    @javax.persistence.Column(name = "TIPO_CONTACTO_ID")
    @Basic
    public BigInteger getTipoContactoId() {
        return tipoContactoId;
    }

    public void setTipoContactoId(BigInteger tipoContactoId) {
        this.tipoContactoId = tipoContactoId;
    }

    private int socioId;

    @javax.persistence.Column(name = "SOCIO_ID")
    @Basic
    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatoContactoEntity that = (DatoContactoEntity) o;

        if (id != that.id) return false;
        if (socioId != that.socioId) return false;
        if (datoValor != null ? !datoValor.equals(that.datoValor) : that.datoValor != null) return false;
        if (tipoContactoId != null ? !tipoContactoId.equals(that.tipoContactoId) : that.tipoContactoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datoValor != null ? datoValor.hashCode() : 0);
        result = 31 * result + (tipoContactoId != null ? tipoContactoId.hashCode() : 0);
        result = 31 * result + socioId;
        return result;
    }
}
