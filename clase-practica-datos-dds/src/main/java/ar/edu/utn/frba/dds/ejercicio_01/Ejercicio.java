package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="ejercicio")
public class Ejercicio {
    @PrimaryKeyJoinColumn
    @GeneratedValue
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "detalle", nullable = false)
    private String detalle;
}
