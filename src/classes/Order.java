package classes;
// Generated 17-dic-2022 22:17:30 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "order",
         catalog = "virtual_market"
)
public class Order implements java.io.Serializable {

    private Integer id;
    private User user;
    private String description;
    private Date entryDate;
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>(0);

    public Order() {
    }

    public Order(User user, String description, Date entryDate) {
        this.user = user;
        this.description = description;
        this.entryDate = entryDate;
    }

    public Order(User user, String description, Date entryDate, Set<OrderProduct> orderProducts) {
        this.user = user;
        this.description = description;
        this.entryDate = entryDate;
        this.orderProducts = orderProducts;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entryDate", nullable = false, length = 19)
    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    public Set<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

}
