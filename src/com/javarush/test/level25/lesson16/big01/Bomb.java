package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Rumata on 03.02.2017.
 */
public class Bomb extends BaseObject
{
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

    public Bomb(double x, double y, double radius)
    {
        super(x, y, 1);
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
        this.setY(this.getY() +1);
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.setPoint(x,y,'B');
    }
}
