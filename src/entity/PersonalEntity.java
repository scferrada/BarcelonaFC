package entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "PERSONAL", schema = "BARCELONAFC", catalog = "")
@Entity
public class PersonalEntity {

    private Integer id;
    private String nombre;
    private String apellido;
    private Timestamp fechaNacimiento;
    private Integer contratado;
    private Integer valorBase;
    private ContratoEntity contrato;
    private TipoPersonalEntity tipoPersonal;
    private NacionalidadEntity nacionalidad;
    @Transient
    private static Map<String, Double> factors;

    static {
        factors = new HashMap<String, Double>();
        factors.put("arquero", 1.0);
        factors.put("defenza", 1.2);
        factors.put("mediocampista", 1.5);
        factors.put("delantero", 2.0);
        factors.put("fisioterapeuta", 0.0);
        factors.put("doctor", 0.0);
        factors.put("directivo", 0.0);
        factors.put("tecnico", 0.0);
    }

    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONAL")
    @SequenceGenerator(name = "SEQ_PERSONAL", sequenceName = "SEQ_PERSONAL")
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

    @javax.persistence.Column(name = "CONTRATADO")
    @Basic
    public Integer getContratado() {
        return contratado;
    }

    public void setContratado(Integer contratado) {
        this.contratado = contratado;
    }

    @javax.persistence.Column(name = "VALOR_BASE")
    @Basic
    public Integer getValorBase() {
        return valorBase;
    }

    public void setValorBase(Integer valorBase) {
        this.valorBase = valorBase;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "CONTRATO_ID", referencedColumnName = "ID")
    public ContratoEntity getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEntity contrato) {
        this.contrato = contrato;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "NACIONALIDAD_ID", referencedColumnName = "ID", nullable = false)
    public NacionalidadEntity getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(NacionalidadEntity nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @javax.persistence.JoinColumn(name = "TIPO_PERSONAL_ID", referencedColumnName = "ID", nullable = false)
    public TipoPersonalEntity getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(TipoPersonalEntity tipoPersonalByTipoPersonalId) {
        this.tipoPersonal = tipoPersonalByTipoPersonalId;
    }

    @Transient
    public double getValorMercado(){
        return factors.get(tipoPersonal.getTipo())*valorBase;
    }
    public void setValorMercado(double valorMercado){
        this.valorBase = (int) (valorMercado/factors.get(tipoPersonal.getTipo()));
    }

    @Override
    public String toString() {
        return "PersonalEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", contratado=" + contratado +
                ", valorBase=" + valorBase +
                ", contrato=" + contrato +
                ", tipoPersonal=" + tipoPersonal +
                ", nacionalidad=" + nacionalidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalEntity)) return false;

        PersonalEntity that = (PersonalEntity) o;

        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (contratado != null ? !contratado.equals(that.contratado) : that.contratado != null) return false;
        if (contrato != null ? !contrato.equals(that.contrato) : that.contrato != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(that.nacionalidad) : that.nacionalidad != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tipoPersonal != null ? !tipoPersonal.equals(that.tipoPersonal) : that.tipoPersonal != null) return false;
        if (valorBase != null ? !valorBase.equals(that.valorBase) : that.valorBase != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (contratado != null ? contratado.hashCode() : 0);
        result = 31 * result + (valorBase != null ? valorBase.hashCode() : 0);
        result = 31 * result + (contrato != null ? contrato.hashCode() : 0);
        result = 31 * result + (tipoPersonal != null ? tipoPersonal.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        return result;
    }
}
