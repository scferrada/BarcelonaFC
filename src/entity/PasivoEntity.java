package entity;

import javax.persistence.*;

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
    private Integer id;
    private Integer valor;
    private EstadoPasivoEntity estadoPasivo;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PASIVO")
    @SequenceGenerator(name = "SEQ_PASIVO", sequenceName = "SEQ_PASIVO")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "VALOR")
    @Basic
    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + valor;
        return result;
    }
}
