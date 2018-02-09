package br.com.lancheria.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "order_items", joinColumns = {
            @JoinColumn(name = "order_id", nullable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "snack_id", nullable = false) })
    private List<Snack> snacks;
}
