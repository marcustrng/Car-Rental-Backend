package com.server.domain.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "cars")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Car extends BaseEntity {

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer trunkCapacity;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer seats;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Double litersPerHundredKilometers;

    @Column(nullable = false)
    private Double pricePerDay;

    @Column(nullable = false)
    private Integer count;

    @OneToMany
    @Exclude
    private Set<Rent> activeRents = new HashSet<>();

    public boolean isAvailable(LocalDate startDate, LocalDate endDate) {
        long rents = this.getActiveRents()
                .stream()
                .filter(r -> (!startDate.isBefore(r.getStartDate()) && !startDate.isAfter(r.getEndDate()))
                        || (!endDate.isAfter(r.getEndDate()) && !endDate.isBefore(r.getStartDate()))
                        || (endDate.isAfter(r.getEndDate()) && startDate.isBefore(r.getStartDate())))
                .count();

        return rents < this.getCount();
    }

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
        Car car = (Car) o;
        return getId() != null && Objects.equals(getId(), car.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass().hashCode() : getClass().hashCode();
    }
}
