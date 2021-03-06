package com.example.tartarus;

// importing all needed imports

import java.util.ArrayList;

import monster.lizardMan_Monster;
import weapon.fist_Weapon;
import weapon.holySword_Weapon;
import weapon.knife_Weapon;
import monster.slime_Monster;
import weapon.rapier_Weapon;
import weapon.sword_Weapon;

/**
 *  description: this class progresses the story and sets up methods for every room in the game and the battle mechanic
 */
public class Story {

    Main2Activity gs;

    // creates new player for the story
    Player player = new Player();
    //creates monsters for the player to beat
    slime_Monster monster1 = new slime_Monster();
    lizardMan_Monster monster2 = new lizardMan_Monster();

    ArrayList<Integer> killedtotal = new ArrayList<Integer>() ;


        // button story directonals <tells what room in the story you next will go to>
    String nextAction1, nextAction2, nextAction3, nextAction4;

    // checks if you clicked restart in the title screen of the app
    int restart = MainActivity.restart;

    // story based conditonal ints
    int bronzering = 0;
    int silverRing= 0;
    int killedPeople = 0;

    /**
     * decription: constructor
     * @param gs
     */
    public Story(Main2Activity gs){
        this.gs = gs;
    }

    /**
     * description: sets player stats and checks if you wanted to restart your game
     */

    public void startup(){

            player.hp = 15;
            player.currentWeapon = new fist_Weapon();
            gs.hpNumber.setText("" + player.hp);
            gs.weaponName.setText(player.currentWeapon.name);

            if(restart == 1){
               gs.newGame();
            }
    }


    /**
     * description: switch statment to use the next method & set up what room you can go to next
     * @param nextEvent
     */
    public void possibleEvent(String nextEvent){


        switch(nextEvent){

            case "townGate": townGate(); break;
            case "guardTalk": guardTalk(); break;
            case "forkInTheRoad": crossRoad(); break;
            case "drunkenEncounter": drunkenEncounter(); break;
            case "drunkenCorpse": drunkenCorpse(); break;
            case "naturalSpring": naturalSpring(); break;
            case "longHallway": longHallway(); break;
            case "drunkenEncounter2": drunkenEncounter2(); break;
            case "longHallway2": longHallway2(); break;
            case "emptyRoom1": emptyRoom1(); break;
            case "oldWoman": oldWoman(); break;
            case "chestOne": chestOne(); break;
            case "oracle": oracle(); break;
            case "chestTwo": chestTwo(); break;
            case "emptyRoom2": emptyRoom2(); break;
            case "lose": lose(); break;
            case "toTitle": toTitle(); break;
            case "win1": win1(); break;
            case "monsterAttack1": monsterAttack1(); break;
            case "playerAttack1": playerAttack1(); break;
            case "fightOne": fightOne(); break;
            case "firstEncounter": firstEncounter(); break;
            case "secondEncounter": secondEncounter(); break;
            case "win2": win2(); break;
            case "monsterAttack2": monsterAttack2(); break;
            case "playerAttack2": playerAttack2(); break;
            case "fightTwo": fightTwo(); break;
            case "chestThree": chestThree(); break;
            case "skeleton": skeleton(); break;
            case "courtYard": courtYard(); break;
            case "helpman": helpman(); break;
            case "watchman": watchman(); break;
            case "alley": alley(); break;
            case "roadToCastle": roadToCastle(); break;
            case "castleGate": castleGate(); break;
            case "throneRoom": throneRoom(); break;
            case "endingOne": endingOne();  break;
            case "endingTwo": endingTwo();  break;
            case "endingThree": endingThree(); break;
            case "endingFour": endingFour(); break;
            case "newgame": gs.goToTitle(); break;




        }
    }

    // all lines after this are method dictating the text that will be presented in the game screen in main activity 2.java
    // some go and set player values depending on the room and what happens in it

    public void drunkenCorpse() {

        gs.storyImage.setImageResource(R.mipmap.deadbodyout);

        gs.mainAreaText.setText("you see the outline of drunken man you killed. And you throw up a little. \n And then turn back from where you came");

        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "townGate";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";
    }

    public void townGate(){



        if(player.currentWeapon.damage > 16){
            gs.mainAreaText.setText("you see a towngate. And guards are standing infront. \n What do you do?");

            gs.action1.setText("Walk up to guard");
            gs.action2.setText("Beat drunken man");
            gs.action3.setText("Walk into a place covered with trees");
            gs.action4.setText("leave townGate");

            nextAction1 = "guardTalk";
            nextAction2 = "drunkenEncounter2";
            nextAction3 = "oldWoman";
            nextAction4 = "forkInTheRoad";

           gs.storyImage.setImageResource(R.mipmap.towngate);




        }
        else{
            gs.mainAreaText.setText("you see a towngate. And guards are standing infront. \n What do you do?");

            gs.action1.setText("Walk up to guard");
            gs.action2.setText("talk to drunken man");
            gs.action3.setText("Walk into a place covered with trees");
            gs.action4.setText("leave townGate");

            nextAction1 = "guardTalk";
            nextAction2 = "drunkenEncounter";
            nextAction3 = "oldWoman";
            nextAction4 = "forkInTheRoad";

            gs.storyImage.setImageResource(R.mipmap.towngate);


        }

    }

    public void oldWoman(){

        gs.storyImage.setImageResource(R.mipmap.savewoman);

        gs.saveing();

        gs.mainAreaText.setText("you see a old woman in a shed.\n And she tells you she is the breaker of fates.\n She grabs your hand a saves a chunk of your soul.\n (Save Done.)");

        gs.action1.setText("Go back");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "townGate";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";




    }

    public void courtYard(){

        gs.storyImage.setImageResource(R.mipmap.courtyard);

        if(player.hp <= 0){

            lose();

        }

        gs.mainAreaText.setText("you walk though the town gate and see a well, \n  alley to the west and some houses to the east.\n\n What do you do?");

        gs.action1.setText("Go north");
        gs.action2.setText("Go south");
        gs.action3.setText("Go west");
        gs.action4.setText("");

        nextAction1 = "roadToCastle";
        nextAction2 = "townGate";
        nextAction3 = "alley";
        nextAction4 = "";



    }

    public void roadToCastle(){

        gs.storyImage.setImageResource(R.mipmap.roadtocastle);

        gs.mainAreaText.setText("You are on a road and a huge castle is in the distance. \n\n What do you do.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go south");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "castleGate";
        nextAction2 = "courtYard";
        nextAction3 = "";
        nextAction4 = "";


    }

    public void castleGate(){

        gs.storyImage.setImageResource(R.mipmap.castlegate);

        gs.mainAreaText.setText("You are at the castle gate. The\n You though the gate.\n\n What do you do.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go south");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "throneRoom";
        nextAction2 = "roadToCastle";
        nextAction3 = "";
        nextAction4 = "";
    }

    public void throneRoom(){


        if(killedPeople == 0){

            gs.storyImage.setImageResource(R.mipmap.goodending);
            // best ending

            gs.mainAreaText.setText("King: You are the righteous hero we needed\n thankyou for all your service\n You are a true hero");
            gs.action1.setText(">");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "endingOne";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }
        else if(killedPeople ==1){

            gs.storyImage.setImageResource(R.mipmap.badending);
            // bad endng

            gs.mainAreaText.setText("King: You are the not hero we needed\n thank you for all your service but...\n ... you have killed some one");
            gs.action1.setText(">");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "endingTwo";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else if (killedPeople == 2){

            gs.storyImage.setImageResource(R.mipmap.okending);
            // so so ending

            gs.mainAreaText.setText("King: You are the hero we needed\n thankyou for all your service\n You are a hero ");
            gs.action1.setText(">");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "endingThree";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }
        else if(killedPeople == 3){

            gs.storyImage.setImageResource(R.mipmap.okending);
            //ok ending

            gs.mainAreaText.setText("King: You are the not hero we needed\n thank you for all your service but...\n ... you have killed too many ...");
            gs.action1.setText(">");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "endingFour";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
    }

    public void endingFour(){

        gs.storyImage.setImageResource(R.mipmap.gameover);

        gs.mainAreaText.setText(" you win \n life is precious");
        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "newgame";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void endingThree(){

        gs.storyImage.setImageResource(R.mipmap.gameover);

        gs.mainAreaText.setText("you win");
        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "newgame";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void endingTwo(){

        gs.storyImage.setImageResource(R.mipmap.gameover);


        gs.mainAreaText.setText("you win \n but at what cost ...");
        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "newgame";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void endingOne(){

        gs.storyImage.setImageResource(R.mipmap.gameover);


        gs.mainAreaText.setText("you win");
        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "newgame";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";



    }


    public void alley(){

        if(!player.currentWeapon.name.equals("Holy Sword")){

            gs.storyImage.setImageResource(R.mipmap.alley);


            gs.mainAreaText.setText("you walk into the alley.\n And see a man being beat up\n he is close to death \n What do you do?");

            gs.action1.setText("watch");
            gs.action2.setText("help");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "watchman";
            nextAction2 = "helpman";
            nextAction3 = "";
            nextAction4 = "";

        }
        else{

            gs.storyImage.setImageResource(R.mipmap.alleyhelpwatch);


            gs.mainAreaText.setText("you walk into the alley.\n And see a pool of blood. \n\n What do you do?");

            gs.action1.setText("Go back");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "courtYard";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }


    }

    public void watchman(){

        gs.storyImage.setImageResource(R.mipmap.alleyhelpwatch);

        killedtotal.add(1);

        killedPeople = killedPeople + 1;

        gs.mainAreaText.setText("you watch the man explode in the alley.\n and the men run away\n What do you do?");

        gs.action1.setText("Go back");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "courtYard";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void helpman(){

        gs.storyImage.setImageResource(R.mipmap.alleyhelpwatch);

        killedtotal.add(1);

        killedPeople = killedPeople + 2;

        player.hp = player.hp - 10;
        gs.hpNumber.setText("" + player.hp);

        player.currentWeapon = new holySword_Weapon();
        gs.weaponName.setText(player.currentWeapon.name);

        gs.mainAreaText.setText("you helped and you fought and turn them into a pool of blood easily then you heal  \n the man getting beaten in the alley he gives you a sword and runs away\n  (You lose 10 hp.) \n (You obtain a Holy Sword.)");

        gs.action1.setText("Go back");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "courtYard";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";


    }



    public void guardTalk(){


        if (bronzering == 1 && silverRing ==1){

            gs.storyImage.setImageResource(R.mipmap.talkguard);


            gs.mainAreaText.setText("you walk up to the town gate.\n And the guards say thanks for helping with that monster. \n Welcome to town. \n What do you do?");

            gs.action1.setText("Go though gate");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "courtYard";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }
        else if(silverRing == 0) {

            gs.storyImage.setImageResource(R.mipmap.talkguard);

            gs.mainAreaText.setText("you walk up to the town gate.\n And guards are stopping you from moving foward. \n What do you do?");

            gs.action1.setText("Go back");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "townGate";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }

    }

    public void crossRoad() {

        gs.storyImage.setImageResource(R.mipmap.crossroad);


        gs.mainAreaText.setText("You are at a crossroad in a labyrinth.\n If you go south, you will go back to the town.\n\n What do you do.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go east");
        gs.action3.setText("Go south");
        gs.action4.setText("Go west");

        nextAction1 = "townGate";
        nextAction2 = "longHallway";
        nextAction3 = "naturalSpring";
        nextAction4 = "firstEncounter";



    }

    public void longHallway(){

        gs.storyImage.setImageResource(R.mipmap.longhallway);


        gs.mainAreaText.setText("You are are in a long dark hallway.\n If you go eest, you will go back to the crossroad.\n\n What do you do.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go east");
        gs.action3.setText("Go west");
        gs.action4.setText("");

        nextAction1 = "naturalSpring";
        nextAction2 = "longHallway2";
        nextAction3 = "townGate";
        nextAction4 = "";

    }

    public void longHallway2(){

        gs.storyImage.setImageResource(R.mipmap.longhallway);


        gs.mainAreaText.setText("You are deep in a hallway in the labyrinth.\n If you go west, you will go back near the the beginning of the hallway.\n\n What do you do.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go east");
        gs.action3.setText("Go south");
        gs.action4.setText("Go west");

        nextAction1 = "emptyRoom1";
        nextAction2 = "oracle";
        nextAction3 = "chestOne";
        nextAction4 = "longHallway";

    }

    public void oracle(){

        gs.storyImage.setImageResource(R.mipmap.oracle);


        gs.mainAreaText.setText("You see a strangely white eyed man in a bush and he says come ... come....\n he says you shall destroy the thing that has been hurting the people of the labyrinth \n What do you do.");

        gs.action1.setText("Go Back");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "longHallway2";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";




    }



    public void chestOne(){



        if(player.currentWeapon.name.equals("Fist")){

            gs.storyImage.setImageResource(R.mipmap.openchest);

            gs.mainAreaText.setText("You see a room with a chest in a room and you walk foward and open it.\n (You obtain a knife.)");

            player.currentWeapon = new knife_Weapon();
            gs.weaponName.setText(player.currentWeapon.name);

            gs.action1.setText("Go north");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "longHallway2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else{

            gs.storyImage.setImageResource(R.mipmap.openchest);


            gs.mainAreaText.setText("You see a room with a empty chest in it.\n\n What do you do? ");

            gs.action1.setText("Go north");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "longHallway2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }


    }

    public void chestTwo(){

        gs.storyImage.setImageResource(R.mipmap.openchest);


        if(player.currentWeapon.name.equals("Fist") || player.currentWeapon.name.equals("Knife")){
            gs.mainAreaText.setText("You see a room with a chest in a room and you walk foward and open it.\n (You obtain a sword.)");

            player.currentWeapon = new sword_Weapon();
            gs.weaponName.setText(player.currentWeapon.name);

            gs.action1.setText("Go south");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "emptyRoom1";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else{
            gs.mainAreaText.setText("You see a room with a empty chest in it.\n\n What do you do? ");

            gs.action1.setText("Go south");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "emptyRoom1";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }


    }

    public void chestThree(){

        gs.storyImage.setImageResource(R.mipmap.openchest);


        if(player.currentWeapon.name.equals("Fist") || player.currentWeapon.name.equals("Knife") || player.currentWeapon.name.equals("Sword")){
           gs.mainAreaText.setText("You see a room with a chest in a room and you walk foward and open it.\n (You obtain a rapier.)");

           player.currentWeapon = new rapier_Weapon();
           gs.weaponName.setText(player.currentWeapon.name);

           gs.action1.setText("Go east");
           gs.action2.setText("");
           gs.action3.setText("");
           gs.action4.setText("");

           nextAction1 = "skeleton";
           nextAction2 = "";
           nextAction3 = "";
           nextAction4 = "";
       }
       else{
           gs.mainAreaText.setText("You see a room with a empty chest in it.\n\n What do you do? ");

           gs.action1.setText("Go east");
           gs.action2.setText("");
           gs.action3.setText("");
           gs.action4.setText("");

           nextAction1 = "skeleton";
           nextAction2 = "";
           nextAction3 = "";
           nextAction4 = "";
       }

    }



    public void emptyRoom1(){

        gs.storyImage.setImageResource(R.mipmap.emptyroom);


        gs.mainAreaText.setText("You turn the corner to spot a empty room.\n You see nothing but darkness and dripping.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go south");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "chestTwo";
        nextAction2 = "longHallway2";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void emptyRoom2(){

        gs.storyImage.setImageResource(R.mipmap.emptyroom);


        gs.mainAreaText.setText("You turn the corner to spot a empty room.\n You see nothing but darkness and dripping.");
        gs.action1.setText("Go north");
        gs.action2.setText("Go south");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "naturalSpring";
        nextAction2 = "secondEncounter";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void naturalSpring(){

        gs.storyImage.setImageResource(R.mipmap.oasis);


        if(player.hp < 100){
           gs.mainAreaText.setText("You walk up to a natural spring.\n You drink the water and heal \n\n (You gain 3 hp.)");

           player.hp =player.hp+ 3;
           gs.hpNumber.setText("" + player.hp);

           gs.action1.setText("Go north");
           gs.action2.setText("Go south");
           gs.action3.setText("Go west");
           gs.action4.setText("");

           nextAction1 = "forkInTheRoad";
           nextAction2 = "emptyRoom2";
           nextAction3 = "skeleton";
           nextAction4 = "";
       }
       else{
           gs.mainAreaText.setText("You walk up to a natural spring.\n You drink the water but you are already healed \n\n (You gain no hp.)");

           gs.action1.setText("Go north");
           gs.action2.setText("Go south");
           gs.action3.setText("Go west");
           gs.action4.setText("");

           nextAction1 = "forkInTheRoad";
           nextAction2 = "emptyRoom2";
           nextAction3 = "skeleton";
           nextAction4 = "";

       }



    }

    public void skeleton(){

        if(player.hp < 100) {

           gs.storyImage.setImageResource(R.mipmap.skeletonherb);

            gs.mainAreaText.setText("You see a skeleton and a heart shape herb in his hand.\n You take the herb and eat it and heal \n\n (You gain 5 hp.)");

            player.hp = player.hp + 5;
            gs.hpNumber.setText("" + player.hp);

            gs.action1.setText("Go west");
            gs.action2.setText("Go east");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "chestThree";
            nextAction2 = "naturalSpring";
            nextAction3 = "";
            nextAction4 = "";
        }
        else{

            gs.storyImage.setImageResource(R.mipmap.skeletonnoherbl);

            gs.mainAreaText.setText("You see a skeleton and where you plucked all those herbs out.\n\n What do you do?");

            gs.action1.setText("Go west");
            gs.action2.setText("Go east");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "chestThree";
            nextAction2 = "naturalSpring";
            nextAction3 = "";
            nextAction4 = "";
        }
    }

    public void drunkenEncounter(){

        gs.storyImage.setImageResource(R.mipmap.drunkencounter);


        // player current hp

        gs.mainAreaText.setText("You walk up to drunken man.\n the drunken man hits you with a rusty club.\n You are over powered and he says bring me a drink. \n (You lose 5 hp.)");

        player.hp = player.hp - 5;
        gs.hpNumber.setText("" + player.hp);



        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "townGate";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";

        if(player.hp <= 0){

            lose();

        }

    }

    public void drunkenEncounter2(){

        gs.storyImage.setImageResource(R.mipmap.drunkand);


        gs.mainAreaText.setText("You walk up to drunken man.\n the drunken man hits you with a rusty club.\n You hit him with all your might and kill him. \n (You lose 5 hp.)");

        player.hp = player.hp - 5;
        gs.hpNumber.setText("" + player.hp);

        killedtotal.add(1);

        killedPeople =+ 1;

        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "townGate";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";

        if(player.hp <= 0){

            lose();

        }

    }

    public void firstEncounter() {
        if (bronzering == 1) {

            gs.storyImage.setImageResource(R.mipmap.emptyroom);


            gs.mainAreaText.setText("This is where you defeated the slime.\n\n What do you do");

            gs.action1.setText("Go east");
            gs.action2.setText("Go west");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "forkInTheRoad";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";


        }
        else {

            gs.storyImage.setImageResource(R.mipmap.slime);


            gs.mainAreaText.setText("You encounter a " + monster1.name + "!");
            gs.action1.setText("Fight");
            gs.action2.setText("Run");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "fightOne";
            nextAction2 = "forkInTheRoad";
            nextAction3 = "";
            nextAction4 = "";
        }

    }

    public void fightOne(){

        gs.storyImage.setImageResource(R.mipmap.slime);


        gs.mainAreaText.setText(monster1.name + ": " + monster1.hp + "\n\n What do you do?");
        gs.action1.setText("Attack");
        gs.action2.setText("Run");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "playerAttack1";
        nextAction2 = "forkInTheRoad";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void playerAttack1() {

        // sets image
        gs.storyImage.setImageResource(R.mipmap.slime);

        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);

        gs.mainAreaText.setText("you attacked the " + monster1.name + " and gave "+ playerDamage + " damage!");

        monster1.hp = monster1.hp - playerDamage;

        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        if (monster1.hp>0) {
            nextAction1 = "monsterAttack1";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else if (monster1.hp<1) {
            nextAction1 = "win1";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
    }

    public void monsterAttack1() {

        gs.storyImage.setImageResource(R.mipmap.slime);


        int monsterDamage = new java.util.Random().nextInt(monster1.attack);

        gs.mainAreaText.setText(monster1.attackMessage + "\n You received " + monsterDamage + " damage!");

        player.hp = player.hp - monsterDamage;
        gs.hpNumber.setText("" + player.hp);



        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        if(player.hp>0) {
            nextAction1 = "fightOne";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else if (player.hp<1) {
            nextAction1 = "lose";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
    }

    public void win1() {



        if (bronzering == 1) {

            gs.storyImage.setImageResource(R.mipmap.emptyroom);


            gs.mainAreaText.setText("This is where you defeated the " + monster1.name + "." + "\n\n What do you do");

            gs.action1.setText("Go east");
            gs.action2.setText("Go west");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "forkInTheRoad";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";


        } else {

            gs.storyImage.setImageResource(R.mipmap.bronzering);

            gs.mainAreaText.setText("You defeated the slime! The monster droped a ring!\n\n(You obtained a Bronze Ring!)");

            bronzering = 1;

            gs.action1.setText("Go east");
            gs.action2.setText("Go west");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "forkInTheRoad";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }
    }

    public void lose() {

        gs.storyImage.setImageResource(R.mipmap.gameover);


        gs.mainAreaText.setText("You are dead!\n\nGAME OVER");

        gs.action1.setText("To the title screen");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "toTitle";
        nextAction2 = "";
        nextAction3 = "";
        nextAction4 = "";



    }

    public void toTitle(){
        gs.goToTitle();
    }


    // turn based fighting
    public void secondEncounter() {
        if (silverRing == 1) {

            gs.storyImage.setImageResource(R.mipmap.lizardman);


            gs.mainAreaText.setText("This is where you defeated the " + monster2.name + ".\n\n What do you do");

            gs.action1.setText("Go back");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "emptyRoom2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else {

            gs.storyImage.setImageResource(R.mipmap.lizardman);


            gs.mainAreaText.setText("You encounter a " + monster2.name + "!");

            gs.action1.setText("Fight");
            gs.action2.setText("Run");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "fightTwo";
            nextAction2 = "emptyRoom2";
            nextAction3 = "";
            nextAction4 = "";
        }

    }

    public void fightTwo(){

        gs.storyImage.setImageResource(R.mipmap.lizardman);

        gs.mainAreaText.setText(monster2.name + ": " + monster2.hp + "\n\n What do you do?");
        gs.action1.setText("Attack");
        gs.action2.setText("Run");
        gs.action3.setText("");
        gs.action4.setText("");

        nextAction1 = "playerAttack2";
        nextAction2 = "emptyRoom2";
        nextAction3 = "";
        nextAction4 = "";

    }

    public void playerAttack2() {

        gs.storyImage.setImageResource(R.mipmap.lizardman);

        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);

        gs.mainAreaText.setText("you attacked the " + monster2.name + " and gave "+ playerDamage + " damage!");

        monster2.hp = monster2.hp - playerDamage;

        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        if (monster2.hp>0) {
            nextAction1 = "monsterAttack2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else if (monster2.hp<1) {
            nextAction1 = "win2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
    }

    public void monsterAttack2() {

        gs.storyImage.setImageResource(R.mipmap.lizardman);

        int monsterDamage = new java.util.Random().nextInt(monster2.attack);

        gs.mainAreaText.setText(monster2.attackMessage + "\n You received " + monsterDamage + " damage!");

        player.hp = player.hp - monsterDamage;
        gs.hpNumber.setText("" + player.hp);

        gs.action1.setText(">");
        gs.action2.setText("");
        gs.action3.setText("");
        gs.action4.setText("");

        if(player.hp>0) {
            nextAction1 = "fightTwo";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
        else if (player.hp<1) {
            nextAction1 = "lose";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";
        }
    }

    public void win2() {


        if (silverRing == 1) {

            gs.storyImage.setImageResource(R.mipmap.emptyroom);

            gs.mainAreaText.setText("This is where you defeated the " + monster2.name + "." + "\n\n What do you do");

            gs.action1.setText("Go north");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "emptyRoom2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";


        } else {

            gs.storyImage.setImageResource(R.mipmap.silverring);

            gs.mainAreaText.setText("You defeated the lizard man!\n The monster droped a ring!\n\n(You obtained a Silver Ring!)");

            silverRing = 1;

            gs.action1.setText("Go north");
            gs.action2.setText("");
            gs.action3.setText("");
            gs.action4.setText("");

            nextAction1 = "emptyRoom2";
            nextAction2 = "";
            nextAction3 = "";
            nextAction4 = "";

        }
    }




}
