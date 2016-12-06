package com.javarush.test.level14.lesson08.home05;



/**
 * Created by Rumata on 07.10.2016.
 */
public class Computer
{
    private Mouse mouse;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Computer(Mouse mouse, Monitor monitor, Keyboard keyboard)
    {
        this.mouse = mouse;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }
}
