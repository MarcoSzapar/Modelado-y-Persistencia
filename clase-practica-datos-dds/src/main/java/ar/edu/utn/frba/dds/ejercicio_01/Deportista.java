package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Deportista")
public class Deportista {
    @PrimaryKeyJoinColumn
    @GeneratedValue
    private Long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="nombre", nullable = false)
    private String apellido;

    @ElementCollection
    @CollectionTable(name = "contactos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "cadena")
    private List<String> contactos;
    @ManyToOne
    @JoinColumn(name="id", nullable = false)
    private Motivacion motivacionPrincipal;
    @Column(name = "pesoInicial(kgs)", nullable = false)
    private Double pesoInicialEnKilos;

    public void agregarContacto(String contacto) {
        contactos.add(contacto);
    }

    public Deportista(){
        this.contactos = new ArrayList<>();
    }

}
