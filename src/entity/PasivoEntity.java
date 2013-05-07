package entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "PASIVO", schema = "BARCELONAFC", catalog = "")
@Entity
public class PasivoEntity {
    private int id;
    private int valor;
    private BigInteger estadoPasivoId;
    private EstadoPasivoEntity estadoPasivo;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PASIVO")
    @SequenceGenerator(name = "SEQ_PASIVO", sequenceName = "SEQ_PASIVO")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "VALOR")
    @Basic
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @javax.persistence.Column(name = "ESTADO_PASIVO_ID")
    @Basic
    public BigInteger getEstadoPasivoId() {
        return estadoPasivoId;
    }

    public void setEstadoPasivoId(BigInteger estadoPasivoId) {
        this.estadoPasivoId = estadoPasivoId;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ESTADO_PASIVO_ID", referencedColumnName = "ID", nullable = false)
    public EstadoPasivoEntity getEstadoPasivo() {
        return estadoPasivo;
    }

    public void setEstadoPasivo(EstadoPasivoEntity estadoPasivo) {
        this.estadoPasivo = estadoPasivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PasivoEntity that = (PasivoEntity) o;

        if (id != that.id) return false;
        if (valor != that.valor) return false;
        if (estadoPasivoId != null ? !estadoPasivoId.equals(that.estadoPasivoId) : that.estadoPasivoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + valor;
        result = 31 * result + (estadoPasivoId != null ? estadoPasivoId.hashCode() : 0);
        return result;
    }
}