package com.cayoticreations.lifesim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    ProgressBar healthbar, hungerbar, energybar, happinessbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        if (StatsPage.newgamestatus){
            StatsPage.setNewGameNumbers();
            StatsPage.newgamestatus = false;
        }
        update_first();
    }

    /* --MISC METHODS-- */
    public void update_first(){
        healthbar = (ProgressBar) findViewById(R.id.HealthBar);
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        healthbar.setProgress(StatsPage.healthpoints);
        hungerbar.setProgress(StatsPage.hungerpoints);
        energybar.setProgress(StatsPage.energypoints);
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_health();
        update_hunger();
        update_energy();
        update_happiness();
        update_cash();
        update_loan();
        update_rent();
        update_day();
        update_time();
        CheckedTextView check = (CheckedTextView) findViewById(R.id.DrinkWater);
        check.setChecked(true);
        CheckedTextView check2 = (CheckedTextView) findViewById(R.id.EatFromGarbage);
        check2.setChecked(true);
        CheckedTextView check3 = (CheckedTextView) findViewById(R.id.SleepOnGround);
        check3.setChecked(true);
        CheckedTextView check4 = (CheckedTextView) findViewById(R.id.TalkToStranger);
        check4.setChecked(true);
        CheckedTextView check5 = (CheckedTextView) findViewById(R.id.Beggar);
        check5.setChecked(true);
    }

    public void close_scrolls(View view){
        ScrollView healscroll = (ScrollView) findViewById(R.id.healscroll);
        ScrollView eatscroll = (ScrollView) findViewById(R.id.eatscroll);
        ScrollView sleepscroll = (ScrollView) findViewById(R.id.sleepscroll);
        ScrollView funscroll = (ScrollView) findViewById(R.id.funscroll);
        ScrollView workscroll = (ScrollView) findViewById(R.id.workscroll);
        ScrollView schoolscroll = (ScrollView) findViewById(R.id.schoolscroll);
        ScrollView storescroll = (ScrollView) findViewById(R.id.storescroll);
        ScrollView loanscroll = (ScrollView) findViewById(R.id.loanscroll);
        if (healscroll.getVisibility() == View.VISIBLE){
            healscroll.setVisibility(View.GONE);
        }
        if (eatscroll.getVisibility() == View.VISIBLE){
            eatscroll.setVisibility(View.GONE);
        }
        if (sleepscroll.getVisibility() == View.VISIBLE){
            sleepscroll.setVisibility(View.GONE);
        }
        if (funscroll.getVisibility() == View.VISIBLE){
            funscroll.setVisibility(View.GONE);
        }
        if (workscroll.getVisibility() == View.VISIBLE){
            workscroll.setVisibility(View.GONE);
        }
        if (schoolscroll.getVisibility() == View.VISIBLE){
            schoolscroll.setVisibility(View.GONE);
        }
        if (storescroll.getVisibility() == View.VISIBLE){
            storescroll.setVisibility(View.GONE);
        }
        if (loanscroll.getVisibility() == View.VISIBLE){
            loanscroll.setVisibility(View.GONE);
        }
    }

    /* --UPDATE STATUS NUMBERS-- */
    public void update_health(){
        final TextView updatehealth = (TextView) findViewById(R.id.healthstatus);
        updatehealth.setText(getString((R.string.action_healthstatus), StatsPage.healthpoints));
    }

    public void update_hunger(){
        final TextView updatehunger = (TextView) findViewById(R.id.hungerstatus);
        updatehunger.setText(getString((R.string.action_hungerstatus), StatsPage.hungerpoints));
    }

    public void update_energy(){
        final TextView updateenergy = (TextView) findViewById(R.id.energystatus);
        updateenergy.setText(getString((R.string.action_energystatus), StatsPage.energypoints));
    }

    public void update_happiness(){
        final TextView updatehappiness = (TextView) findViewById(R.id.happinessstatus);
        updatehappiness.setText(getString((R.string.action_happinessstatus), StatsPage.happinesspoints));
    }

    public void update_cash(){
        final TextView updatecash = (TextView) findViewById(R.id.cashstatus);
        updatecash.setText(getString((R.string.action_cashstatus), StatsPage.cashcount));
    }

    public void update_loan(){
        final TextView updateloan = (TextView) findViewById(R.id.loanstatus);
        updateloan.setText(getString((R.string.action_loanstatus), StatsPage.loancount));
    }

    public void update_rent(){
        final TextView updaterent = (TextView) findViewById(R.id.rentstatus);
        updaterent.setText(getString((R.string.action_rentstatus), StatsPage.rentcount));
    }

    public void update_day(){
        final TextView updateday = (TextView) findViewById(R.id.daystatus);
        updateday.setText(getString((R.string.action_daystatus), StatsPage.daycount));
    }

    public void update_time(){
        if (StatsPage.timecount == 25){
            if(StatsPage.rentcount > 0){
                StatsPage.rentcount--;
            }
            StatsPage.daycount++;
            StatsPage.timecount = 0;
            update_day();
        }
        final TextView updatetime = (TextView) findViewById(R.id.timestatus);
        String numbertostring = String.format("%02d", StatsPage.timecount);
        updatetime.setText(getString((R.string.action_timestatus), numbertostring));
    }

    public void update_checks(){
        if(StatsPage.sloppyclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoForAWalk);
            check.setChecked(true);
        }
        if(StatsPage.buspassbool && StatsPage.sloppyclothesbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BuyABandage);
            check.setChecked(true);
        }
        if(StatsPage.buspassbool && StatsPage.casualclothesbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BuyAntiseptic);
            check.setChecked(true);
        }
        if(StatsPage.housebool && StatsPage.installsinkbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.WashHands);
            check.setChecked(true);
        }
        if(StatsPage.housebool && StatsPage.installsinkbool && StatsPage.installshowerbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Shower);
            check.setChecked(true);
        }
        if(StatsPage.housebool && StatsPage.installshowerbool && StatsPage.cheapbedbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.RestInBed);
            check.setChecked(true);
        }
        if(StatsPage.apartmentbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.TakeMedication);
            check.setChecked(true);
        }
        if(StatsPage.condobool && StatsPage.buspassbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToUrgentCare);
            check.setChecked(true);
        }
        if(StatsPage.housebool && StatsPage.carbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToHospital);
            check.setChecked(true);
        }
        if(StatsPage.mansionbool && StatsPage.sportscarbool && StatsPage.blacktiesuitbool){
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToPrivatePractice);
            check.setChecked(true);
        }

        if(StatsPage.sloppyclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BegForFood);
            check.setChecked(true);
        }
        if(StatsPage.ultracasualclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BuyFastFood);
            check.setChecked(true);
        }
        if(StatsPage.apartmentbool && StatsPage.installfridgebool) {
            CheckedTextView check1 = (CheckedTextView) findViewById(R.id.SearchTheFridge);
            check1.setChecked(true);
        }
        if(StatsPage.installfridgebool && StatsPage.condobool && StatsPage.installstovebool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.MakeAHomemadeMeal);
            check.setChecked(true);
        }
        if(StatsPage.casualclothesbool && StatsPage.condobool && StatsPage.buspassbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.VisitADiner);
            check.setChecked(true);
        }
        if(StatsPage.businesscasualclothesbool && StatsPage.housebool && StatsPage.buspassbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.VisitALocalRestaurant);
            check.setChecked(true);
        }
        if(StatsPage.businessclothesbool && StatsPage.housebool && StatsPage.carbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.TakeADateToDinner);
            check.setChecked(true);
        }
        if(StatsPage.businessclothesbool && StatsPage.bighousebool && StatsPage.sportscarbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.VisitA5StarRestaurant);
            check.setChecked(true);
        }
        if(StatsPage.blacktiesuitbool && StatsPage.mansionbool && StatsPage.sportscarbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.HireAPrivateChef);
            check.setChecked(true);
        }
        if(StatsPage.sloppyclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.VisitTheHomelessShelter);
            check.setChecked(true);
        }
        if(StatsPage.casualclothesbool && StatsPage.buspassbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToShadyHotel);
            check.setChecked(true);
        }
        if(StatsPage.apartmentbool && StatsPage.cheapbedbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.SleepOnCheapBed);
            check.setChecked(true);
        }
        if(StatsPage.condobool && StatsPage.comfortablebedbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.SleepOnComfortableBed);
            check.setChecked(true);
        }
        if(StatsPage.casualclothesbool && StatsPage.carbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToHotel);
            check.setChecked(true);
        }
        if(StatsPage.housebool && StatsPage.memoryfoambedbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.SleepOnMemoryFoamBed);
            check.setChecked(true);
        }
        if(StatsPage.bighousebool && StatsPage.luxuriousbedbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.SleepOnLuxuriousBed);
            check.setChecked(true);
        }
        if(StatsPage.mansionbool && StatsPage.sportscarbool && StatsPage.businessclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoTo5StarHotel);
            check.setChecked(true);
        }
        if(StatsPage.basketballbool && StatsPage.sloppyclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToLocalPark);
            check.setChecked(true);
        }
        if(StatsPage.buspassbool && StatsPage.ultracasualclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToMovieTheater);
            check.setChecked(true);
        }
        if(StatsPage.buspassbool && StatsPage.casualclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoToAConcert);
            check.setChecked(true);
        }
        if(StatsPage.condobool && StatsPage.stereobool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BlastSomeMusic);
            check.setChecked(true);
        }
        if(StatsPage.housebool && StatsPage.televisionbool && StatsPage.couchbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.WatchTelevision);
            check.setChecked(true);
        }
        if(StatsPage.skiisbool && StatsPage.winterclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GoSkiing);
            check.setChecked(true);
        }
        if(StatsPage.sportscarbool && StatsPage.businesscasualclothesbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.GetAPrivateTour);
            check.setChecked(true);
        }
        if(StatsPage.mansionbool && StatsPage.athleticclothesbool && StatsPage.privatetenniscourtbool) {
            CheckedTextView check = (CheckedTextView) findViewById(R.id.PlayTennisOnPrivateCourt);
            check.setChecked(true);
        }
    }

    /* --MAIN BUTTONS-- */
    public void go_to_heal (View view) {
        ScrollView healscroll = (ScrollView) findViewById(R.id.healscroll);
        if (healscroll.getVisibility() == View.VISIBLE) {
            healscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            healscroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_eat (View view) {
        ScrollView eatscroll = (ScrollView) findViewById(R.id.eatscroll);
        if (eatscroll.getVisibility() == View.VISIBLE) {
            eatscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            eatscroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_sleep (View view) {
        ScrollView sleepscroll = (ScrollView) findViewById(R.id.sleepscroll);
        if (sleepscroll.getVisibility() == View.VISIBLE) {
            sleepscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            sleepscroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_fun (View view) {
        ScrollView funscroll = (ScrollView) findViewById(R.id.funscroll);
        if (funscroll.getVisibility() == View.VISIBLE) {
            funscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            funscroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_work (View view) {
        ScrollView workscroll = (ScrollView) findViewById(R.id.workscroll);
        if (workscroll.getVisibility() == View.VISIBLE) {
            workscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            workscroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_school (View view) {
        ScrollView schoolscroll = (ScrollView) findViewById(R.id.schoolscroll);
        if (schoolscroll.getVisibility() == View.VISIBLE) {
            schoolscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            schoolscroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_store (View view) {
        ScrollView storescroll = (ScrollView) findViewById(R.id.storescroll);
        if (storescroll.getVisibility() == View.VISIBLE) {
            storescroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            storescroll.setVisibility(View.VISIBLE);
        }
    }

    public void go_to_loan (View view) {
        ScrollView loanscroll = (ScrollView) findViewById(R.id.loanscroll);
        if (loanscroll.getVisibility() == View.VISIBLE) {
            loanscroll.setVisibility(View.GONE);
        }
        else {
            close_scrolls(view);
            loanscroll.setVisibility(View.VISIBLE);
        }
    }

    /* --HEAL METHODS-- */
    public void do_drink_water (View view){
        healthbar = (ProgressBar) findViewById(R.id.HealthBar);
        if(StatsPage.healthpoints < 100) {
            StatsPage.healthpoints = (StatsPage.healthpoints + 3);
            healthbar.setProgress(StatsPage.healthpoints);
            update_health();
        }
        StatsPage.timecount++;
        update_time();
    }

    public void do_go_for_a_walk (View view){
        if (StatsPage.sloppyclothesbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 4);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_buy_a_bandage (View view){
        if (StatsPage.cashcount >= 1 && StatsPage.buspassbool && StatsPage.sloppyclothesbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 5);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_buy_antiseptic (View view){
        if (StatsPage.cashcount >= 3 && StatsPage.buspassbool && StatsPage.casualclothesbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 7);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_wash_hands (View view){
        if(StatsPage.housebool && StatsPage.installsinkbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 9);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_shower (View view){
        if(StatsPage.installshowerbool && StatsPage.installsinkbool && StatsPage.housebool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 11);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_rest_in_bed (View view){
        if (StatsPage.housebool && StatsPage.installshowerbool && StatsPage.cheapbedbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 13);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_take_medication (View view){
        if (StatsPage.cashcount >= 30 && StatsPage.apartmentbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 15);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_urgent_care (View view){
        if (StatsPage.cashcount >= 50 && StatsPage.condobool && StatsPage.buspassbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 17);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_hospital (View view){
        if(StatsPage.cashcount >= 200 && StatsPage.housebool && StatsPage.carbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 20);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_private_practice (View view){
        if(StatsPage.cashcount >= 400 && StatsPage.mansionbool
                && StatsPage.sportscarbool && StatsPage.blacktiesuitbool) {
            healthbar = (ProgressBar) findViewById(R.id.HealthBar);
            if (StatsPage.healthpoints < 100) {
                StatsPage.healthpoints = (StatsPage.healthpoints + 25);
                healthbar.setProgress(StatsPage.healthpoints);
                update_health();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    /* --EAT METHODS-- */
    public void do_eat_from_garbage (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        if(StatsPage.hungerpoints < 100) {
            StatsPage.hungerpoints = (StatsPage.hungerpoints + 3);
            hungerbar.setProgress(StatsPage.hungerpoints);
            update_hunger();
        }
        StatsPage.timecount++;
        update_time();
    }

    public void do_beg_for_food (View view){
        if(StatsPage.sloppyclothesbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 5);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_buy_fast_food (View view){
        if(StatsPage.cashcount >= 5 && StatsPage.ultracasualclothesbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 7);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_search_the_fridge (View view){
        if(StatsPage.cashcount >= 8 && StatsPage.apartmentbool && StatsPage.installfridgebool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 9);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_make_a_homemade_meal (View view){
        if(StatsPage.cashcount >= 10 && StatsPage.installfridgebool && StatsPage.condobool
                && StatsPage.installstovebool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 11);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_visit_a_diner (View view){
        if(StatsPage.cashcount >= 20 && StatsPage.casualclothesbool && StatsPage.condobool
                && StatsPage.buspassbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 13);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_visit_a_local_restaurant (View view){
        if(StatsPage.cashcount >= 40 && StatsPage.businesscasualclothesbool
                && StatsPage.businesscasualclothesbool
                && StatsPage.housebool && StatsPage.buspassbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 15);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_take_a_date_to_dinner (View view){
        if(StatsPage.cashcount >= 125 && StatsPage.businessclothesbool
                && StatsPage.housebool && StatsPage.carbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 18);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_visit_a_5_star_restaurant (View view){
        if(StatsPage.cashcount >= 250 && StatsPage.bighousebool && StatsPage.businessclothesbool
                && StatsPage.sportscarbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 25);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_hire_a_private_chef (View view){
        if(StatsPage.cashcount >= 300 && StatsPage.blacktiesuitbool && StatsPage.mansionbool
                && StatsPage.sportscarbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            if (StatsPage.hungerpoints < 100) {
                StatsPage.hungerpoints = (StatsPage.hungerpoints + 33);
                hungerbar.setProgress(StatsPage.hungerpoints);
                update_hunger();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    /* --SLEEP METHODS-- */
    public void do_sleep_on_ground (View view){
        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        if(StatsPage.energypoints < 100) {
            StatsPage.energypoints = (StatsPage.energypoints + 3);
            energybar.setProgress(StatsPage.energypoints);
            update_energy();
        }
        StatsPage.timecount++;
        update_time();
    }

    public void do_visit_the_homeless_shelter (View view){
        if(StatsPage.sloppyclothesbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 5);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_shady_hotel (View view){
        if(StatsPage.cashcount >= 20 && StatsPage.casualclothesbool && StatsPage.buspassbool)
        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        if(StatsPage.energypoints < 100) {
            StatsPage.energypoints = (StatsPage.energypoints + 8);
            energybar.setProgress(StatsPage.energypoints);
            update_energy();
        }
        StatsPage.timecount++;
        update_time();
    }

    public void do_sleep_on_cheap_bed (View view){
        if(StatsPage.apartmentbool && StatsPage.cheapbedbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 10);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_sleep_on_comfortable_bed (View view){
        if(StatsPage.condobool && StatsPage.comfortablebedbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 12);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_hotel (View view){
        if(StatsPage.cashcount >= 100 && StatsPage.casualclothesbool && StatsPage.carbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 14);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_sleep_on_memory_foam_bed (View view){
        if(StatsPage.housebool && StatsPage.memoryfoambedbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 15);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_sleep_on_luxurious_bed (View view){
        if(StatsPage.bighousebool && StatsPage.luxuriousbedbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 18);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_5_star_hotel (View view){
        if(StatsPage.cashcount >= 100 && StatsPage.mansionbool && StatsPage.sportscarbool
                &&StatsPage.businessclothesbool) {
            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            if (StatsPage.energypoints < 100) {
                StatsPage.energypoints = (StatsPage.energypoints + 20);
                energybar.setProgress(StatsPage.energypoints);
                update_energy();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    /* --FUN METHODS-- */
    public void do_talk_to_stranger (View view){
        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        if(StatsPage.happinesspoints < 100) {
            StatsPage.happinesspoints = (StatsPage.happinesspoints + 3);
            happinessbar.setProgress(StatsPage.happinesspoints);
            update_happiness();
        }
        StatsPage.timecount++;
        update_time();
    }

    public void do_go_to_local_park (View view){
        if(StatsPage.basketballbool && StatsPage.sloppyclothesbool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 5);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_movie_theater (View view) {
        if (StatsPage.cashcount >= 15 && StatsPage.buspassbool && StatsPage.ultracasualclothesbool){
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 7);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_to_a_concert (View view){
        if (StatsPage.cashcount >= 45 && StatsPage.buspassbool && StatsPage.casualclothesbool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 9);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_blast_some_music (View view){
        if(StatsPage.condobool && StatsPage.stereobool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 11);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_watch_television (View view){
        if(StatsPage.housebool && StatsPage.televisionbool && StatsPage.couchbool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 13);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_go_skiing (View view){
        if(StatsPage.cashcount >= 85 && StatsPage.skiisbool && StatsPage.winterclothesbool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 15);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_get_a_private_tour (View view){
        if(StatsPage.cashcount >= 200 && StatsPage.sportscarbool
                && StatsPage.businesscasualclothesbool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 17);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_play_tennis_on_private_court (View view){
        if(StatsPage.mansionbool && StatsPage.athleticclothesbool
                && StatsPage.privatetenniscourtbool) {
            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            if (StatsPage.happinesspoints < 100) {
                StatsPage.happinesspoints = (StatsPage.happinesspoints + 19);
                happinessbar.setProgress(StatsPage.happinesspoints);
                update_happiness();
            }
            StatsPage.timecount++;
            update_time();
        }
    }

    /* --WORK METHODS-- */
    public void do_beggar (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 2);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_dish_washer (View view){
        if(StatsPage.sloppyclothesbool) {
            hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
            StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
            if (StatsPage.hungerpoints < 0) {
                StatsPage.healthpoints = (StatsPage.healthpoints - 10);
                update_health();
                StatsPage.hungerpoints = 0;
            }
            hungerbar.setProgress(StatsPage.hungerpoints);
            update_hunger();

            energybar = (ProgressBar) findViewById(R.id.EnergyBar);
            StatsPage.energypoints = (StatsPage.energypoints - 5);
            if (StatsPage.energypoints < 0) {
                StatsPage.healthpoints = (StatsPage.healthpoints - 10);
                update_health();
                StatsPage.energypoints = 0;
            }
            energybar.setProgress(StatsPage.energypoints);
            update_energy();

            happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
            StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
            if (StatsPage.happinesspoints < 0) {
                StatsPage.healthpoints = (StatsPage.healthpoints - 10);
                update_health();
                StatsPage.happinesspoints = 0;
            }
            happinessbar.setProgress(StatsPage.happinesspoints);
            update_happiness();

            StatsPage.cashcount = (StatsPage.cashcount + 7);
            update_cash();

            StatsPage.timecount++;
            update_time();
        }
    }

    public void do_sales_associate (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 9);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_bartender (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 15);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_manager (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 18);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_general_manager (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 20);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_district_manager (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 25);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_vice_president (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 35);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_senior_vice_president (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 50);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    public void do_ceo (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.cashcount = (StatsPage.cashcount + 100);
        update_cash();

        StatsPage.timecount++;
        update_time();
    }

    /* --SCHOOL METHODS-- */
    public void do_ged_training (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_math_course (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_bartending_course (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_management_course (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_senior_management_course (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_associates_of_business_administration (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_bachelors_of_business_administration (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_masters_of_business_administration (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    public void do_doctorate_of_business_administration (View view){
        hungerbar = (ProgressBar) findViewById(R.id.HungerBar);
        StatsPage.hungerpoints = (StatsPage.hungerpoints - 5);
        if (StatsPage.hungerpoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.hungerpoints = 0;
        }
        hungerbar.setProgress(StatsPage.hungerpoints);
        update_hunger();

        energybar = (ProgressBar) findViewById(R.id.EnergyBar);
        StatsPage.energypoints = (StatsPage.energypoints - 5);
        if (StatsPage.energypoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.energypoints = 0;
        }
        energybar.setProgress(StatsPage.energypoints);
        update_energy();

        happinessbar = (ProgressBar) findViewById(R.id.HappinessBar);
        StatsPage.happinesspoints = (StatsPage.happinesspoints - 5);
        if (StatsPage.happinesspoints < 0){
            StatsPage.healthpoints = (StatsPage.healthpoints - 10);
            update_health();
            StatsPage.happinesspoints = 0;
        }
        happinessbar.setProgress(StatsPage.happinesspoints);
        update_happiness();

        StatsPage.timecount++;
        update_time();
    }

    /* --STORE METHODS-- */
    public void do_basketball (View view){
        if (StatsPage.cashcount >= 15 && !StatsPage.basketballbool) {
            StatsPage.basketballbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 15);
            update_cash();
            CheckedTextView basketballcheck = (CheckedTextView) findViewById(R.id.Basketball);
            basketballcheck.setChecked(true);
            update_checks();
        }
    }

    public void do_sloppy_clothes (View view){
        if (StatsPage.cashcount >= 20 && !StatsPage.sloppyclothesbool) {
            StatsPage.sloppyclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 20);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.SloppyClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_ultra_casual_clothes (View view){
        if (StatsPage.cashcount >= 40 && !StatsPage.ultracasualclothesbool) {
            StatsPage.ultracasualclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 40);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.UltraCasualClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_bus_pass (View view){
        if (StatsPage.cashcount >= 55 && !StatsPage.buspassbool) {
            StatsPage.buspassbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 55);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BusPass);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_casual_clothes (View view){
        if (StatsPage.cashcount >= 60 && !StatsPage.casualclothesbool) {
            StatsPage.casualclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 60);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.CasualClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_athletic_clothes (View view){
        if (StatsPage.cashcount >= 70 && !StatsPage.athleticclothesbool) {
            StatsPage.athleticclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 70);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.AthleticClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_winter_clothes (View view){
        if (StatsPage.cashcount >= 75 && !StatsPage.winterclothesbool) {
            StatsPage.winterclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 75);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.WinterClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_stereo (View view){
        if (StatsPage.cashcount >= 175 && !StatsPage.stereobool) {
            StatsPage.stereobool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 175);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Stereo);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_television (View view){
        if (StatsPage.cashcount >= 200 && !StatsPage.televisionbool) {
            StatsPage.televisionbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 200);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Television);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_business_casual_clothes (View view){
        if (StatsPage.cashcount >= 250 && !StatsPage.businesscasualclothesbool) {
            StatsPage.businesscasualclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 250);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BusinessCasualClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_business_clothes (View view){
        if (StatsPage.cashcount >= 300 && !StatsPage.businessclothesbool) {
            StatsPage.businessclothesbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 300);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BusinessClothes);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_cheap_bed (View view){
        if (StatsPage.cashcount >= 325 && !StatsPage.cheapbedbool) {
            StatsPage.cheapbedbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 325);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.CheapBed);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_install_sink (View view){
        if (StatsPage.cashcount >= 400 && !StatsPage.installsinkbool) {
            StatsPage.installsinkbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 400);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.InstallSink);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_black_tie_suit (View view){
        if (StatsPage.cashcount >= 500 && !StatsPage.blacktiesuitbool) {
            StatsPage.blacktiesuitbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 500);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BlackTieSuit);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_install_stove (View view){
        if (StatsPage.cashcount >= 800 && !StatsPage.installstovebool) {
            StatsPage.installstovebool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 800);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.InstallStove);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_apartment (View view){
        if (StatsPage.cashcount >= 1000 && !StatsPage.apartmentbool) {
            StatsPage.apartmentbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 1000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Apartment);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_couch (View view){
        if (StatsPage.cashcount >= 1300 && !StatsPage.couchbool) {
            StatsPage.couchbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 1300);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Couch);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_install_shower (View view){
        if (StatsPage.cashcount >= 1400 && !StatsPage.installshowerbool) {
            StatsPage.installshowerbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 1400);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.InstallShower);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_comfortable_bed (View view){
        if (StatsPage.cashcount >= 1500 && !StatsPage.comfortablebedbool) {
            StatsPage.comfortablebedbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 1500);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.ComfortableBed);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_skiis (View view){
        if (StatsPage.cashcount >= 1600 && !StatsPage.skiisbool) {
            StatsPage.skiisbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 1600);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Skiis);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_install_fridge (View view){
        if (StatsPage.cashcount >= 2600 && !StatsPage.installfridgebool) {
            StatsPage.installfridgebool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 2600);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.InstallFridge);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_memory_foam_bed (View view){
        if (StatsPage.cashcount >= 3000 && !StatsPage.memoryfoambedbool) {
            StatsPage.memoryfoambedbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 3000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.MemoryFoamBed);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_condo (View view){
        if (StatsPage.cashcount >= 3750 && !StatsPage.condobool) {
            StatsPage.condobool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 3750);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Condo);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_house (View view){
        if (StatsPage.cashcount >= 5000 && !StatsPage.housebool) {
            StatsPage.housebool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 5000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.House);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_luxurious_bed (View view){
        if (StatsPage.cashcount >= 6000 && !StatsPage.luxuriousbedbool) {
            StatsPage.luxuriousbedbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 6000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.LuxuriousBed);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_big_house (View view){
        if (StatsPage.cashcount >= 7500 && !StatsPage.bighousebool) {
            StatsPage.bighousebool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 7500);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.BigHouse);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_mansion (View view){
        if (StatsPage.cashcount >= 10000 && !StatsPage.mansionbool) {
            StatsPage.mansionbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 10000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Mansion);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_car (View view){
        if (StatsPage.cashcount >= 35000 && !StatsPage.carbool) {
            StatsPage.carbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 35000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.Car);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_private_tennis_court (View view){
        if (StatsPage.cashcount >= 65000 && !StatsPage.privatetenniscourtbool) {
            StatsPage.privatetenniscourtbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 65000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.PrivateTennisCourt);
            check.setChecked(true);
            update_checks();
        }
    }

    public void do_sports_car (View view){
        if (StatsPage.cashcount >= 250000 && !StatsPage.sportscarbool) {
            StatsPage.sportscarbool = true;
            StatsPage.cashcount = (StatsPage.cashcount - 250000);
            update_cash();
            CheckedTextView check = (CheckedTextView) findViewById(R.id.SportsCar);
            check.setChecked(true);
            update_checks();
        }
    }

    /* --STORE METHODS-- */
    public void do_pay_100 (View view){
        if (StatsPage.cashcount >= 100) {
            StatsPage.cashcount = (StatsPage.cashcount - 100);
            update_cash();
            StatsPage.loancount = (StatsPage.loancount - 100);
            update_loan();
        }
    }

    public void do_pay_1000 (View view){
        if (StatsPage.cashcount >= 1000) {
            StatsPage.cashcount = (StatsPage.cashcount - 1000);
            update_cash();
            StatsPage.loancount = (StatsPage.loancount - 1000);
            update_loan();
        }
    }

    public void do_pay_10000 (View view){
        if (StatsPage.cashcount >= 10000) {
            StatsPage.cashcount = (StatsPage.cashcount - 10000);
            update_cash();
            StatsPage.loancount = (StatsPage.loancount - 1000);
            update_loan();
        }
    }

    public void do_pay_100000 (View view){
        if (StatsPage.cashcount >= 100000) {
            StatsPage.cashcount = (StatsPage.cashcount - 100000);
            update_cash();
            StatsPage.loancount = (StatsPage.loancount - 100000);
            update_loan();
        }
    }

    public void do_pay_1000000 (View view){
        if (StatsPage.cashcount >= 1000000) {
            StatsPage.cashcount = (StatsPage.cashcount - 1000000);
            update_cash();
            StatsPage.loancount = (StatsPage.loancount - 1000000);
            update_loan();
        }
    }
}