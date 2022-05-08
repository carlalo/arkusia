package de.arkusia.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import javafx.application.*;

public class LoadController
{
    @FXML
    Arc balken;

    @FXML
    Label prozent;

    public LoadController()
    {

    }

    public void setProgress(int percent)
    {
        if(percent<0)
        {
            percent=0;
        }
        if(percent>100)
        {
            percent=100;
        }

        double degree=percent*3.6;
        if(degree<=0)
        {
            degree=0;
        }
        int upOrDown=1;
        double actualLength=balken.getLength();
        if(actualLength>degree)
        {
            upOrDown=-1;
        }

        int maxWaitTime=15;
        int minWaitTime=5;
        int howFastFaster=1;

        int waitTime=maxWaitTime;

        if(upOrDown==1)
        {
            double split=Math.abs(degree-actualLength)/10*9;
            while(actualLength<degree)
            {
                actualLength=actualLength+(0.4*upOrDown);
                balken.setLength(actualLength);
                System.out.println("Added next step. Actual Degree is: "+balken.getLength());
                
                String text=String.format("%d%%",toPercent(balken.getLength()));
                Platform.runLater(()->prozent.setText(text));
                sleep(waitTime);
                if(actualLength<split)
                {
                    if(waitTime>minWaitTime)
                    {
                        waitTime=waitTime-howFastFaster;
                    }
                }else
                {
                    if(waitTime<maxWaitTime)
                    {
                        waitTime=waitTime+howFastFaster;
                    }
                }
            }
        }else
        {
            double split=Math.abs(degree-actualLength)/10*1;
            while(actualLength>degree)
            {
                actualLength=actualLength+(0.4*upOrDown);
                balken.setLength(actualLength);
                System.out.println("Added next step. Actual Degree is: "+balken.getLength());
                
                String text=String.format("%d%%",toPercent(balken.getLength()));
                Platform.runLater(()->prozent.setText(text));
                sleep(waitTime);
                if(actualLength>split)
                {
                    if(waitTime>minWaitTime)
                    {
                        waitTime=waitTime-howFastFaster;
                    }
                }else
                {
                    if(waitTime<maxWaitTime)
                    {
                        waitTime=waitTime+howFastFaster;
                    }
                }
            }
        }

    }

    public void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }catch(Exception e)
        {
            System.out.println("Failed to wait.");
        }
    }
    
    private static long toPercent(Double degrees) {
        return Math.round(degrees/3.6);
    }
}
