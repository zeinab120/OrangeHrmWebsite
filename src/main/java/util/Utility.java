package util;

import java.util.Random;


public class Utility {

    public static String getRandomFirstName() {
        String[] names = {"Evelyn" , "Isabella" ,"Zeinab","Scarlett" ,"Victoria" ,"Elizabeth" ,"Abigail" ,"Harper" ,"Charlotte",
                "Sophia","William", "Matthew", "Mohamed", "Oliver", "Alexander","Michael","Henry","Benjamin","Henry"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }




}


