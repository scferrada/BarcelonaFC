package entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ACTIVO", schema = "BARCELONAFC", catalog = "")
@Entity
public class ActivoEntity {

    private Integer id;
    private Integer valor;
    private TipoActivoEntity tipoActivo;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVO")
    @SequenceGenerator(name = "SEQ_ACTIVO", sequenceName = "SEQ_ACTIVO")
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
    @javax.persistence.JoinColumn(name = "TIPO_ACTIVO_ID", referencedColumnName = "ID", nullable = false)
    public TipoActivoEntity getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(TipoActivoEntity tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivoEntity)) return false;

        ActivoEntity that = (ActivoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoActivo != null ? !tipoActivo.equals(that.tipoActivo) : that.tipoActivo != null) return false;
        return !(valor != null ? !valor.equals(that.valor) : that.valor != null);

    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (valor != null ? valor.hashCode() : 0);
//        result = 31 * result + (tipoActivo != null ? tipoActivo.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "ActivoEntity{" +
                "id=" + id +
                ", valor=" + valor +
                ", tipoActivo=" + tipoActivo +
                '}';
    }
}
