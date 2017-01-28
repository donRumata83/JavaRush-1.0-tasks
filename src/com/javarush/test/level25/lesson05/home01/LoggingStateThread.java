package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Rumata on 28.01.2017.
 */
public class LoggingStateThread extends Thread
{
    Thread target;

    public LoggingStateThread(Thread target)
    {
        super();
        this.setDaemon(true);
        this.target = target;
    }

    @Override
    public void run()
    {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != target.getState())
            {
                state = target.getState();
                System.out.println(state);
            }
        }
    }
}
