//*****************************************************************************
// Name:         Michael Kevin Hernandez
// Date:         November 17, 2007
// Program:      forestObject.java
/* Description:  This program is the object that will deal with the forests, 
                 where it will do:
                     * Display the current forest
                       (with tree heights to 2 decimal places).
                     * Discard the current forest and create a new forest.
                     * Simulate a year's growth in the current forest.
                     * Reap the current forest.
                     * Save the information about the current forest to file
                       (named after the forest).
                     * Discard the current forest and load the information
                       about a forest from a file.

*/
// Course:       CSC 120
//*****************************************************************************
import java.util.*;
import java.io.*;
//=============================================================================
public class forestObject implements Serializable {
//-----------------------------------------------------------------------------
    private String name;
    private int    TREE_MAX = 10;
    private float[] growthRate;
    private float[] treeHeight;
    private float[] forest = new float[TREE_MAX];
    private final float minH = 0f;
    private final float maxH = 5f;
    private final float minG = .50f;
    private final float maxG = 1.0f;
//-----------------------------------------------------------------------------
    public forestObject(String name) {

        this.name = name;
        setForest();
   }
//-----------------------------------------------------------------------------
    public String getName() {

        return name;
    }
//-----------------------------------------------------------------------------
    public void setForest() {

        Random generator = new Random();
        treeHeight = new float[TREE_MAX];
        growthRate = new float[TREE_MAX];

        for (int i = 0; i < forest.length; i++) {
            treeHeight[i] = minH + (float) Math.random() * (maxH-minH);
            growthRate[i] = minG + (float) Math.random() * (maxG-minG);
        }

    }
//-----------------------------------------------------------------------------
    public void display() {

       System.out.println(name);
       for (int i = 0; i < forest.length; i++){
           System.out.printf("%2d: %.2f (%.2f%% pa)\n", (i+1), (treeHeight[i]), (growthRate[i]*100));

       }

    }
//-----------------------------------------------------------------------------
    public void year() {

       for (int j = 0; j < forest.length; j++){
           treeHeight[j]*= growthRate[j] + 1;
       }

    }
//-----------------------------------------------------------------------------
    public void reap(float reapHeight) {

        Random generator = new Random();

        for (int i = 0; i < forest.length; i++){
             if (treeHeight[i] > reapHeight) {
                 System.out.println("cut " + (i + 1) + " :  " + treeHeight[i]
                                    + " (" + growthRate[i] + "% pa)");
                 treeHeight[i] = minH + (float) Math.random() * (maxH-minH);
                 growthRate[i] = minG + (float) Math.random() * (maxG-minG);
                 System.out.println("new " + (i + 1) + " :  " + treeHeight[i]
                                    + " (" + growthRate[i] + "% pa)");
             } else {
                 treeHeight[i] = treeHeight[i];
                 growthRate[i] = growthRate[i];
             }
        }

    }
//-----------------------------------------------------------------------------
}
//=============================================================================
