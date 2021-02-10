package com.company;

import java.util.Random;

public class Main{
    public static int bossHealth = 2000;
    public static int bossDamage= 80;
    public static String bossDefenseType = "";
    public static int[]heroesHealth = {260, 270, 300, 400,450,350, 500, 600};
    public static int[]heroesDamage = {18, 20, 5, 0,20,35,25,45};
    public static String[] heroesAttackType={"Physical", "Magical", "Mental","Medic", "Golem","Lucky","Berserk", "Thor"};

    public static void main(String[] args) {
        while (!isFinished()){
            round();
        }

        }



    public static void round(){
        printStatistics();
        System.out.println("Round was started!");
        heroesHit();
        changeBossDefenceType();
        bossHit();
        medic();
        printStatistics();

    }



    public static void printStatistics(){
        System.out.println("-------------------");
        System.out.println("Boss health:"+bossHealth);
        System.out.println("Warrior health:"+heroesHealth[0]);
        System.out.println("Magic health:"+heroesHealth[1]);
        System.out.println("Kinetic health:"+heroesHealth[2]);
        System.out.println("Medic health:"+heroesHealth[3]);
        System.out.println("golem "+heroesHealth[4]);
        System.out.println("lucky "+heroesDamage[5]);
        System.out.println("berserk "+heroesHealth[6]);
        System.out.println("thor "+heroesHealth[7]);
        System.out.println("-------------------");
    }
    public static void bossHit(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i]>0 && bossHealth>0){
                if (heroesHealth[i]-bossDamage<0) heroesHealth[i]=0;
                else heroesHealth[i]=heroesHealth[i]-bossDamage;
            }

        }
    }
    public static void medic(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[3] > 0 && heroesHealth[i] > 0 && heroesHealth[i] < 100) {
                Random random = new Random();
                int random1 = random.nextInt(50);
                heroesHealth[i] = heroesHealth[i] + random1;
                System.out.println("medical heals[" + heroesAttackType[i] + "] by [" + random1 + "]");
                break;

            }
            if (heroesHealth[4] > 0) {
                heroesHealth[4] = heroesHealth[4] - (bossDamage - (bossDamage / 5));
            } else {
                heroesHealth[4] = heroesHealth[4] - bossDamage;
            }


            if (heroesHealth[5] > 0) {
                heroesHealth[i] = heroesHealth[i] - bossDamage;
            } else {
                heroesHealth[i] = heroesHealth[i] + bossDamage;

            }
            if (heroesHealth[6]>0){
                heroesHealth[i]= (bossDamage/2)+heroesDamage[6];
            } else {
                heroesHealth[i] = heroesHealth[i] + bossDamage;
            }
            if (heroesHealth[7]>0){
                heroesHealth[7]=bossHealth-heroesDamage[7];
            }
            else {bossDamage=0;

            }}

        }








    public static void heroesHit(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth>0 && heroesHealth[i]>0){
                if (bossHealth-heroesHealth[i]<0)bossHealth=0;
                    else bossHealth= bossHealth-heroesDamage[i];
            }

        }


    }




    public static boolean isFinished(){
        if (bossHealth <=0){
            System.out.println("Heroes won!!!");
            return true;
        }
        if (heroesHealth[0]<= 0 && heroesHealth[1]<=0 &&heroesHealth[2]<=0){
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }
    public static void changeBossDefenceType(){
        Random random= new Random();
        int randomIndex= random.nextInt(heroesAttackType.length);
        bossDefenseType= heroesAttackType[randomIndex];
        System.out.println("boss defence type:"+ bossDefenseType);

    }

}
