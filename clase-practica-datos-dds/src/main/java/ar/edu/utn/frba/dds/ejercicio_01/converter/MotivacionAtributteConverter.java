package ar.edu.utn.frba.dds.ejercicio_01.converter;


import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.*;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
    public class MotivacionAtributteConverter implements AttributeConverter<Motivacion, String>{

        @Override
        public String convertToDatabaseColumn(Motivacion motiv){
            String referenceMotivacion ="";

            if (motiv instanceof BajarDePeso){
                referenceMotivacion= "BajarDePeso";
            }
            if (motiv instanceof Mantener){
                referenceMotivacion = "Mantener";
            }
            if (motiv instanceof Tonificar){
                referenceMotivacion = "Tonificar";
            }
            return referenceMotivacion;

        }
        @Override
        public Motivacion convertToEntityAttribute(String referenceMotivacion){
            Motivacion a_instanciar = null; // yo

            if(referenceMotivacion.compareTo("BajarDePeso") ==0){
                a_instanciar = new BajarDePeso(); //esto deberia hacerse con un service locator asi no se instancian de mas en el sistemas pero toy tapado de laburo
            }

            if(referenceMotivacion.compareTo("Mantener") ==0){
                a_instanciar =  new Mantener();
            }
            if(referenceMotivacion.compareTo("Tonificar") ==0){
                a_instanciar = new Tonificar();
            }

            return a_instanciar;

        }
    }

