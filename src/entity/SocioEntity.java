package entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "SOCIO", schema = "BARCELONAFC", catalog = "")
@Entity
public class SocioEntity {

    private Integer id;
    private String nombre;
    private String apellido;
    private Timestamp fechaNacimiento;
    private Integer derechoAsiento;
    private ContratoEntity contrato;
    private NacionalidadEntity nacionalidad;

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOCIO")
    @SequenceGenerator(name = "SEQ_SOCIO", sequenceName = "SEQ_SOCIO")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "NOMBRE")
    @Basic
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @javax.persistence.Column(name = "APELLIDO")
    @Basic
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @javax.persistence.Column(name = "FECHA_NACIMIENTO")
    @Basic
    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @javax.persistence.Column(name = "DERECHO_ASIENTO")
    @Basic
    public Integer getDerechoAsiento() {
        return derechoAsiento;
    }

    public void setDerechoAsiento(Integer derechoAsiento) {
        this.derechoAsiento = derechoAsiento;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRATO_ID", referencedColumnName = "ID", nullable = false)
    public ContratoEntity getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEntity contrato) {
        this.contrato = contrato;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NACIONALIDAD_ID", referencedColumnName = "ID")
    public NacionalidadEntity getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(NacionalidadEntity nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SocioEntity)) return false;

        SocioEntity that = (SocioEntity) o;

        if (!id.equals(that.id)){
            System.out.println("false cause id");return false;}
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null){
            System.out.println("false cause last name"); return false;}
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null){
            System.out.println("false cause name"); return false;}
        System.out.println("all ok");
        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
//        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
//        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
//        result = 31 * result + (derechoAsiento != null ? derechoAsiento.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "SocioEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", derechoAsiento=" + derechoAsiento +
                ", contrato=" + contrato +
                ", nacionalidad=" + nacionalidad +
                '}';
    }
}
