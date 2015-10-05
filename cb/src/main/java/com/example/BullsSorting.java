//This program analyzes basketball stats 
package com.example;

import java.text.DecimalFormat;

public class BullsSorting {
    public static void main(String args[])
    {
        String namesArray[] = {"Brooks", "Bairstow", "Rose", "McDermott", "Moore", "Butler",
                                "Noah", "Hinrich", "Dunleavy", "Mohammed", "Mirotic", "Gasol",
                                "Gibson", "Snell"};
        double pointsScored[] = {11.6, 0.6, 17.7, 3.0, 2.7, 20.0, 7.2, 5.7, 9.4, 1.2, 10.2,
                                 18.5, 10.3, 6.0};
        double averagePoints = 0;

        double reboundNum[] = {2.0, 0.4, 3.2, 1.2, 0.8, 5.8, 9.6, 1.8, 3.9, 1.7, 4.9, 11.8, 6.4, 2.4};

        double threePointPercentage[] = {38.7, 0.0, 28.0, 31.7, 34.2, 37.8, 0.0, 34.5, 40.7, 0.0,
                                         31.6, 46.2, 0.0, 37.1};
        double temp = 0;
        double reboundTemp = 0;
        String nameTemp = "";
        double averageRebounds = 0;

        double roseStats[] = {3.2, 81.3, 0.7}; //order: rebounds, free throws, steals
        double butlerStats[] = {5.8, 83.4, 1.8}; //order: rebounds, free throws, steals

        int roseIsBetter = 0;
        int butlerIsBetter = 0;

        /* Calculate average points scored by team.  This is included as a stat
         on the website, but if we want the average for the ENTIRE team
         (even though they don't all play at the same time) then we can
          add up each player's average number of points scored. */
        for (int i = 0; i < pointsScored.length; i++)
        {
            averagePoints += pointsScored[i];
        }

        System.out.println("The average number of points scored by the team is: " + averagePoints);

        // Calc and display average number of rebounds for top 3 3 point percentage shooters
        // Bubble sort everything that might be affected by the sort.
        for (int i = 0; i < threePointPercentage.length; i++)
        {
            for (int x = 0; x < (threePointPercentage.length) - 1; x++)
            {
                if (threePointPercentage[x] < threePointPercentage[x+1])
                {
                    temp = threePointPercentage[x];
                    reboundTemp = reboundNum[x];
                    nameTemp = namesArray[x];
                    threePointPercentage[x] = threePointPercentage[x+1];
                    reboundNum[x] = reboundNum[x+1];
                    namesArray[x] = namesArray[x+1];
                    threePointPercentage[x+1] = temp;
                    reboundNum[x+1] = reboundTemp;
                    namesArray[x+1] = nameTemp;
                }
            }
        }

        //Now that everything is sorted, in descending order, take the first 3 rebound elements
        // and average them.
        for (int i = 0; i < 3; i++)
        {
            averageRebounds += reboundNum[i];
        }
        averageRebounds = averageRebounds/3;
        System.out.println("The average number of rebounds for the top three 3 point " +
                            "percentage shooters is: " + averageRebounds);

        //Determine if Rose or Butler is better player
        // using special arrays with only their relevant stats
        for (int i = 0; i < roseStats.length; i++)
        {
            if (roseStats[i] > butlerStats[i])
            {
                roseIsBetter++;
            }
            else
            {
                butlerIsBetter++;
            }
        }
        if (roseIsBetter > butlerIsBetter)
        {
            System.out.println("Based on the stats, Rose is better.");
        }
        else if (butlerIsBetter > roseIsBetter)
        {
            System.out.println("Based on the stats, Butler is better.");
        }
        else
        {
            System.out.println("Based on the stats, Rose and Butler are equal");
        }
    }
}
