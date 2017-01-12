package com.javarush.test.level23.lesson13.big01;

/**
 * Created by Rumata on 12.01.2017.
 */
public class Room
{
    public int width;
    public int height;
    public Snake snake;
    public Mouse mouse;
    public static Room game;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Snake getSnake()
    {
        return snake;
    }

    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake)
    {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public void run() {}
    public void print() {}

    public void createMouse()
    {
        mouse = new Mouse((int)Math.random()* width, (int)Math.random()*height);
    }
     public void eatMouse() {createMouse();}

    public static void main(String[] args)
    {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);

    }
}
