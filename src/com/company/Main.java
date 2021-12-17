package com.company;

/*
Coachella

Your job as a programmer is to manage the guest list for Coachella.
You are given the VIP list by artist name and the number of guests following (them to the show).

Use Java to complete this Question.
Comment your code at each class (including your name) and comment at each method's function.

1) Read and output the guest list from a file called GuestData.txt
2) Output the total number of VIP passes.
______________________________________________
3) Output the guest list and VIP passes after adding 45% to the number of passes for each guest.
4) Output the total number of passes which has changed.


Guest List
Scooby Doo,12
Lady Gaga,54
Lindsay Lohan,12
Taylor Swift,233
Adele,12
Shia LaBeouf,14
 */
public class Main {

    public static void main(String[] args) {
        CoachellaManager coachellaManager = new CoachellaManager("GuestData.txt");
        coachellaManager.writeToFile("NewFile.txt");
        coachellaManager.sortList();
        coachellaManager.printGuestList();
        coachellaManager.printAllPassesNumber();
        coachellaManager.changePassesAmountBy45Percent();
        coachellaManager.printAllPassesNumber();
        coachellaManager.writeToFile("NewFile.txt");
        coachellaManager.writeToFile("GuestData.txt");


    }
}
