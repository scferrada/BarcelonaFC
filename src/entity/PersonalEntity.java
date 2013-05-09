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

    private int id;
    private String nombre;
    private String apellido;
    private Timestamp fechaNacimiento;
    private BigInteger contratado;
    private int valorBase;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public BigInteger getContratado() {
        return contratado;
    }

    public void setContratado(BigInteger contratado) {
        this.contratado = contratado;
    }

    @javax.persistence.Column(name = "VALOR_BASE")
    @Basic
    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
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

    @ManyToOne
    @javax.persistence.JoinColumn(name = "NACIONALIDAD_ID", referencedColumnName = "ID", nullable = false)
    public NacionalidadEntity getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(NacionalidadEntity nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @ManyToOne
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalEntity that = (PersonalEntity) o;

        if (id != that.id) return false;
        if (valorBase != that.valorBase) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (contratado != null ? !contratado.equals(that.contratado) : that.contratado != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        return !(nombre != null ? !nombre.equals(that.nombre) : that.nombre != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (contratado != null ? contratado.hashCode() : 0);
        result = 31 * result + valorBase;
        return result;
    }
}
