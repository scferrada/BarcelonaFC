package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 04:31 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "NACIONALIDAD", schema = "BARCELONAFC", catalog = "")
@Entity
public class NacionalidadEntity {

    private Integer id;
    private String pais;

    @javax.persistence.Column(name = "ID")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "PAIS")
    @Basic
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NacionalidadEntity that = (NacionalidadEntity) o;

        if (!id.equals(that.id)) return false;
        return !(pais != null ? !pais.equals(that.pais) : that.pais != null);

    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (pais != null ? pais.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "NacionalidadEntity{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                '}';
    }
}
