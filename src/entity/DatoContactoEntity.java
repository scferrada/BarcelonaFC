package entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "DATO_CONTACTO", schema = "BARCELONAFC", catalog = "")
@Entity
public class DatoContactoEntity {

    private int id;
    private String datoValor;
    private SocioEntity socio;
    private TipoContactoEntity tipoContacto;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DATO_CONTACTO")
    @SequenceGenerator(name = "SEQ_DATO_CONTACTO", sequenceName = "SEQ_DATO_CONTACTO")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "DATO_VALOR")
    @Basic
    public String getDatoValor() {
        return datoValor;
    }

    public void setDatoValor(String datoValor) {
        this.datoValor = datoValor;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "SOCIO_ID", referencedColumnName = "ID", nullable = false)
    public SocioEntity getSocio() {
        return socio;
    }

    public void setSocio(SocioEntity socio) {
        this.socio = socio;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "TIPO_CONTACTO_ID", referencedColumnName = "ID", nullable = false)
    public TipoContactoEntity getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(TipoContactoEntity tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatoContactoEntity that = (DatoContactoEntity) o;

        if (id != that.id) return false;
        if (datoValor != null ? !datoValor.equals(that.datoValor) : that.datoValor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datoValor != null ? datoValor.hashCode() : 0);
        return result;
    }
}
