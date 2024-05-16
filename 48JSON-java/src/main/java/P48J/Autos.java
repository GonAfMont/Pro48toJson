package P48J;

import com.google.gson.*;
import P48J.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Autos")
@XmlType(propOrder = {"auto"})
@XmlAccessorType(XmlAccessType.FIELD)


public class Autos {
    @XmlElementWrapper(name = "autos")
    @XmlElement(name = "Auto")
    private Auto[] Auto;

    public Autos() {} 

    public Autos(Auto[] Auto) {
        this.Auto = Auto;
    }

    public Auto[] getAutos() {
        return Auto;
    }

    public void setAutos(Auto[] Auto) {
        this.Auto = Auto;
    }

    public void ImpAutos() {
        for (int i = 0; i < Auto.length; i++) {
            Auto[i].ImpAuto();
        }
    }

    public void añadirAutos(Auto newAuto) {
    	Auto[] newArray = new Auto[Auto.length + 1];
        System.arraycopy(Auto, 0, newArray, 0, Auto.length);
        newArray[Auto.length] = newAuto;
        this.Auto = newArray;
    }

    public void buscarAutos(String modelo) {
        for (Auto Auto : Auto) {
            if (Auto.getMarca().equals(modelo)) {
                Auto.ImpAuto();
            }
        }
    }
} 
