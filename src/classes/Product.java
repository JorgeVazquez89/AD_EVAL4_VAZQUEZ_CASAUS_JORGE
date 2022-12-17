package classes;
// Generated 11-dic-2022 21:47:38 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="virtual_market"
    , uniqueConstraints = @UniqueConstraint(columnNames="description") 
)
public class Product  implements java.io.Serializable {


     private Integer id;
     private String description;
     private float price;
     private float weight;
     private int stock;
     private Date entryDate;
     private Date modificationDate;
     private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>(0);

    public Product() {
    }

	
    public Product(String description, float price, float weight, int stock, Date entryDate) {
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.stock = stock;
        this.entryDate = entryDate;
    }
    public Product(String description, float price, float weight, int stock, Date entryDate, Date modificationDate, Set<OrderProduct> orderProducts) {
       this.description = description;
       this.price = price;
       this.weight = weight;
       this.stock = stock;
       this.entryDate = entryDate;
       this.modificationDate = modificationDate;
       this.orderProducts = orderProducts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="description", unique=true, nullable=false, length=250)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="price", nullable=false, precision=12, scale=0)
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

    
    @Column(name="weight", nullable=false, precision=12, scale=0)
    public float getWeight() {
        return this.weight;
    }
    
    public void setWeight(float weight) {
        this.weight = weight;
    }

    
    @Column(name="stock", nullable=false)
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="entryDate", nullable=false, length=19)
    public Date getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modificationDate", length=19)
    public Date getModificationDate() {
        return this.modificationDate;
    }
    
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }
    
    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }




}


