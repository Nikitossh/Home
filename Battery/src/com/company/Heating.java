package com.company;

/** Отопление комнаты.
 * Батарея(Battery) остоит из трубы(Tube), вентиля(Valve) и радиатора(Radiator)
 * Включаем воду(Water) в трубу, и включаем батарею(поворачиваем вентиль вправо)
 *
 * Ver 0.01 сделанная в честь включения отопления 25.10.2018
 * */

public class Heating {

    public static void main(String[] args) {
        Valve valve = new Valve();
        Tube tube = new Tube();
        Radiator  radiator  = new Radiator ();
        Battery battery = new Battery(valve, tube, radiator);
        tube.water = Water.fill();
        battery.turnOn();
    }
}

class Radiator {
    Water water;

    void warm() {
        System.out.println(this.getClass().getSimpleName() + " heating with " + water.name + " in it");
    }
}

class Battery {
    private Valve valve;
    private Tube tube;
    private Radiator radiator;

    Battery(Valve valve, Tube tube, Radiator radiator) {
        this.valve = valve;
        this.tube = tube;
        this.radiator = radiator;
    }

    private void heat() {
        if (radiator.water != null && tube.water != null)
            radiator.warm();
    }

    public void turnOn() {
        this.radiator.water = Water.fill();
        valve.turnRight();
        this.heat();
    }
}

class Valve {
    private boolean isOn = false;

    void turnRight() {
        this.isOn = true;
    }

}

class Water {
    String name = "Very Hot Water";

    public static Water fill() {
        return new Water();
    }
}

class Tube {
    Water water;
}