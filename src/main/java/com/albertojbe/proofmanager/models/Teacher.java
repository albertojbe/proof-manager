package com.albertojbe.proofmanager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TEACHER")
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    Set<Discipline> disciplines = new HashSet<>();

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    Set<Proof> proofs = new HashSet<>();

}
