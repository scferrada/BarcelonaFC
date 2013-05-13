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

    @ManyToOne(cascade = CascadeType.ALL)
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
        if (!(o instanceof PasivoEntity)) return false;

        PasivoEntity that = (PasivoEntity) o;

        if (estadoPasivo != null ? !estadoPasivo.equals(that.estadoPasivo) : that.estadoPasivo != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (valor != null ? valor.hashCode() : 0);
//        result = 31 * result + (estadoPasivo != null ? estadoPasivo.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "PasivoEntity{" +
                "id=" + id +
                ", valor=" + valor +
                ", estadoPasivo=" + estadoPasivo +
                '}';
    }
}
