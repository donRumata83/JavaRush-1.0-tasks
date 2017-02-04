package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Rumata on 03.02.2017.
 */
public class SpaceShip extends BaseObject
{
    private double dx = 0;
    public SpaceShip(double x, double y)
    {
        super(x, y, 3);

    }

    @Override
    public double getX()
    {
        return super.getX();
    }

    @Override
    public double getY()
    {
        return super.getY();
    }

    @Override
    public double getRadius()
    {
        return super.getRadius();
    }

    @Override
    public boolean isAlive()
    {
        return super.isAlive();
    }

    @Override
    public void move()
    {
        super.move();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
    }

    @Override
    public void setX(double x)
    {
        super.setX(x);
    }

    @Override
    public void setY(double y)
    {
        super.setY(y);
    }

    @Override
    public void setRadius(double radius)
    {
        super.setRadius(radius);
    }

    public void moveLeft() {dx = -1;}
    public void moveRight() {dx = 1;}
}
