package com.server.domain.entities;

import com.server.domain.enums.SaleType;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "receipts")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Sale extends BaseEntity {

    @Column(nullable = false)
    private String rentId;

    @Column(nullable = false)
    private String carBrand;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    private User buyer;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
    private Double pricePaid;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SaleType type;

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer()
                .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) {
            return false;
        }
        Sale sale = (Sale) o;
        return getId() != null && Objects.equals(getId(), sale.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass().hashCode() : getClass().hashCode();
    }
}
