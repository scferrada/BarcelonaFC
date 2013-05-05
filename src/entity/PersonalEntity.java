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
@javax.persistence.Table(name = "PERSONAL", schema = "BARCELONAFC", catalog = "")
@Entity
public class PersonalEntity {
    private int id;

    @javax.persistence.Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private BigInteger contratado;

    @javax.persistence.Column(name = "CONTRATADO")
    @Basic
    public BigInteger getContratado() {
        return contratado;
    }

    public void setContratado(BigInteger contratado) {          // cambio de prueba
        this.contratado = contratado;
    }

    private int valorBase;

    @javax.persistence.Column(name = "VALOR_BASE")
    @Basic
    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
        this.valorBase = valorBase;
    }

    private int tipoPersonalId;

    @javax.persistence.Column(name = "TIPO_PERSONAL_ID")
    @Basic
    public int getTipoPersonalId() {
        return tipoPersonalId;
    }

    public void setTipoPersonalId(int tipoPersonalId) {
        this.tipoPersonalId = tipoPersonalId;
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

        PersonalEntity that = (PersonalEntity) o;

        if (contratoId != that.contratoId) return false;
        if (id != that.id) return false;
        if (nacionalidadId != that.nacionalidadId) return false;
        if (tipoPersonalId != that.tipoPersonalId) return false;
        if (valorBase != that.valorBase) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (contratado != null ? !contratado.equals(that.contratado) : that.contratado != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (contratado != null ? contratado.hashCode() : 0);
        result = 31 * result + valorBase;
        result = 31 * result + tipoPersonalId;
        result = 31 * result + nacionalidadId;
        result = 31 * result + contratoId;
        return result;
    }
}
