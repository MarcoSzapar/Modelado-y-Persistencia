package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="diaDeEntrenamiento")
public class DiaDeEntrenamiento {
  @PrimaryKeyJoinColumn
  @GeneratedValue
  private Long id;
  @OneToMany
  @JoinColumn(name="ejercicios", referencedColumnName = "id")
  private List<Ejercicio> ejercicios;
 @Column(name ="orden_duracion_rutina",nullable = false)
  private Integer numero; // representa el orden en la duracion de la rutina.
  @OneToOne
  @JoinColumn(name="siguienteDia", referencedColumnName = "id")
  private DiaDeEntrenamiento siguienteDia;


  public DiaDeEntrenamiento() {
    this.ejercicios = new ArrayList<>();
  }
  public void agregarEjercicio(Ejercicio ejercicio) {
    this.ejercicios.add(ejercicio);
  }
}
