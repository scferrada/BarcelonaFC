package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 03-05-13
 * Time: 02:47 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SOCIO", schema = "BARCELONAFC", catalog = "")
@Entity
public class SocioEntity {
    private int id;

    @javax.persistence.Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int nacionalidadId;

    @javax.persistence.Column(name = "NACIONALIDAD_ID")
    @Basic
    public int getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(int nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    private String nombre;

    @javax.persistence.Column(name = "NOMBRE")
    @Basic
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String apellido;

    @javax.persistence.Column(name = "APELLIDO")
    @Basic
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private Timestamp fechaNacimiento;

    @javax.persistence.Column(name = "FECHA_NACIMIENTO")
    @Basic
    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private BigInteger derechoAsiento;

    @javax.persistence.Column(name = "DERECHO_ASIENTO")
    @Basic
    public BigInteger getDerechoAsiento() {
        return derechoAsiento;
    }

    public void setDerechoAsiento(BigInteger derechoAsiento) {
        this.derechoAsiento = derechoAsiento;
    }

    private int contratoId;

    @javax.persistence.Column(name = "CONTRATO_ID")
    @Basic
    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocioEntity that = (SocioEntity) o;

        if (contratoId != that.contratoId) return false;
        if (id != that.id) return false;
        if (nacionalidadId != that.nacionalidadId) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (derechoAsiento != null ? !derechoAsiento.equals(that.derechoAsiento) : that.derechoAsiento != null)
            return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nacionalidadId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (derechoAsiento != null ? derechoAsiento.hashCode() : 0);
        result = 31 * result + contratoId;
        return result;
    }
}
