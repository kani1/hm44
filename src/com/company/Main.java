package com.company;

import java.util.Random;

public class Main{
    public static int bossHealth = 700;
    public static int bossDamage= 200;
    public static String bossDefenseType = "";
    public static int[]heroesHealth = {260, 270, 300, 400};
    public static int[]heroesDamage = {18, 20, 5, 30};
    public static String[] heroesAttackType={"Physical", "Magical", "Mental","Medic"};
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
        printStatistics();

    }

    public static void printStatistics(){
        System.out.println("-------------------");
        System.out.println("Boss health:"+bossHealth);
        System.out.println("Warrior health:"+heroesHealth[0]);
        System.out.println("Magic health:"+heroesHealth[1]);
        System.out.println("Kinetic health:"+heroesHealth[2]);
        System.out.println("Medic health:" + heroesHealth[3]);
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
            if (heroesHealth[i]>0 && heroesHealth[i]<100);
            if ( )


        }

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
