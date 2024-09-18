package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Rutina")
public class Rutina {
    @PrimaryKeyJoinColumn
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deportista",referencedColumnName = "id")
    private Deportista deportista;
    @ManyToOne
    @JoinColumn(name="diasDeEntrenamiento", referencedColumnName = "id")
    private List<DiaDeEntrenamiento> diasDeEntrenamiento;
    @OneToOne
    @JoinColumn(name="rutinaAnterior", referencedColumnName = "id")
    private Rutina rutinaAnterior;

    public Rutina() {
        this.diasDeEntrenamiento = new ArrayList<>();
    }

    public void agregarDiaDeEntrenamiento(DiaDeEntrenamiento diaDeEntrenamiento) {
        this.diasDeEntrenamiento.add(diaDeEntrenamiento);
    }
}
