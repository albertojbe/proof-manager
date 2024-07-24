package com.albertojbe.proofmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_DISCPLIN")
public class Discipline implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int period;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @JsonManagedReference
    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private Set<Proof> proofs = new HashSet<>();
}
