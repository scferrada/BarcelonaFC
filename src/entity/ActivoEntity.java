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

    private int id;
    private int valor;
    private TipoActivoEntity tipoActivo;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACTIVO")
    @SequenceGenerator(name = "SEQ_ACTIVO", sequenceName = "SEQ_ACTIVO")
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

    @ManyToOne
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
        if (o == null || getClass() != o.getClass()) return false;

        ActivoEntity that = (ActivoEntity) o;

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
