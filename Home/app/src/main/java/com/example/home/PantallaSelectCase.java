package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class PantallaSelectCase extends AppCompatActivity {
    private ArrayList<Arma> armasShattered = new ArrayList<Arma>();
    private ArrayList<Arma> armasCs20 = new ArrayList<Arma>();
    private ArrayList<Arma> armasPrisma = new ArrayList<Arma>();
    private ArrayList<Arma> armasDangerZone = new ArrayList<Arma>();
    private ArrayList<Arma> armasHorizon = new ArrayList<Arma>();
    private ArrayList<Arma> armasClutch = new ArrayList<Arma>();

    private Caja cajaShatteredWeb;
    private Caja cajaCs20;
    private Caja cajaPrisma;
    private Caja cajaDangerZone;
    private Caja cajaHorizon;
    private Caja cajaClutch;
    private ArrayList<Caja> cajas;

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_select_case);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            user = (Usuario) bundle.getSerializable("user2");
            TextView userName=findViewById(R.id.tvUserName);
            TextView userMoney=findViewById(R.id.tvUserMoney);
            userName.setText(user.getUser());
            userMoney.setText(String.valueOf(user.getDinero()));
        }



        GridView grid = (GridView) findViewById(R.id.caseList);

        armasShattered.add(new Arma("Karambit","Lore","De aspecto encubierto",1456.74,R.drawable.karambit_lore));
        armasShattered.add(new Arma("AWP","Containment Breach","De aspecto encubierto",133.45,R.drawable.awp_cont_breach));
        armasShattered.add(new Arma("MAC-10","Stalker","De aspecto encubierto",54.93,R.drawable.mac10_stalker));
        armasShattered.add(new Arma("SG 553","Colony IV","De tipo clasificado",50.50,R.drawable.sg553_colony_iv));
        armasShattered.add(new Arma("SSG 08","Bloodshot","De aspecto encubierto",28.70,R.drawable.ssg08_bloodshot));
        armasShattered.add(new Arma("Tec-9","Decimator","De tipo clasificado",9.10,R.drawable.tec9_decimator));
        armasShattered.add(new Arma("AK-47","Rat Rod","De tipo clasificado",10.22,R.drawable.ak47_rat_rod));
        armasShattered.add(new Arma("AUG","Artic Wolf","De tipo restringido",4.63,R.drawable.aug_artic_wolf));
        armasShattered.add(new Arma("P2000","Obsidian","De tipo restringido",2.80,R.drawable.p2000_obsidian));
        armasShattered.add(new Arma("MP7","Neon Ply","De tipo restringido",2.63,R.drawable.mp7_neon_ply));
        armasShattered.add(new Arma("PP-Bizon","Embargo","De tipo restringido",2.49,R.drawable.pp_bizon_embargo));
        armasShattered.add(new Arma("Dual Berettas","Balance","De tipo restringido",0.55,R.drawable.dual_berettas_balance));
        armasShattered.add(new Arma("MP5-SD","Acid Wash","De grado militar",0.41,R.drawable.mp5_acid_wash));
        armasShattered.add(new Arma("Nova","Plume","De grado militar",0.55,R.drawable.nova_plume));
        armasShattered.add(new Arma("R8 Revolver","Memento","De grado militar",0.49,R.drawable.revolver_memento));
        armasShattered.add(new Arma("M249","Warbird","De grado militar",0.62,R.drawable.m249_warbird));
        armasShattered.add(new Arma("G3SG1","Black Sand","De grado militar",0.49,R.drawable.g3sg1_black_sand));
        armasShattered.add(new Arma("SCAR-20","Torn","De grado militar",0.43,R.drawable.scar20_torn));

        armasCs20.add(new Arma("Butterfly Knife","Doppler","De aspecto encubierto",578.87,R.drawable.butterfly_knife_doppler));
        armasCs20.add(new Arma("AWP","Wildfire","De aspecto encubierto",149.89,R.drawable.awp_wildfire));
        armasCs20.add(new Arma("FAMAS","Commemoration","De aspecto encubierto",19.97,R.drawable.famas_commemoration));
        armasCs20.add(new Arma("MP9","Hydra","De tipo clasificado",12.17,R.drawable.mp9_hydra));
        armasCs20.add(new Arma("AUG","Death by Puppy","De tipo clasificado",7.79,R.drawable.aug_death_by_puppy));
        armasCs20.add(new Arma("P90","Nostalgia","De tipo clasificado",8.27,R.drawable.p90_nostalgia));
        armasCs20.add(new Arma("MP5-SD","Agent","De tipo restringido",3.94,R.drawable.mp5_agent));
        armasCs20.add(new Arma("UMP-45","Plastique","De tipo restringido",1.35,R.drawable.ump_plastique));
        armasCs20.add(new Arma("P250","Inferno","De tipo restringido",0.91,R.drawable.p250_inferno));
        armasCs20.add(new Arma("M249","Aztec","De tipo restringido",0.93,R.drawable.m249_aztec));
        armasCs20.add(new Arma("Five-Seven","Buddy","De tipo restringido",0.89,R.drawable.five_seven_buddy));
        armasCs20.add(new Arma("Glock-18","Sacrifice","De grado militar",1.90,R.drawable.glock_sacrifice));
        armasCs20.add(new Arma("FAMAS","Decommissioned","De grado militar",0.53,R.drawable.famas_decommissioned));
        armasCs20.add(new Arma("MAC-10","Classic Crate","De grado militar",0.27,R.drawable.mac10_classic_crate));
        armasCs20.add(new Arma("MAG-7","Popdog","De grado militar",0.20,R.drawable.mag7_popdog));
        armasCs20.add(new Arma("Dual Berettas","Elite 1.6","De grado militar",0.18,R.drawable.dual_berettas_elite));
        armasCs20.add(new Arma("SCAR-20","Assault","De grado militar",0.18,R.drawable.scar20_assault));
        armasCs20.add(new Arma("Tec-9","Flash Out","De grado militar",0.18,R.drawable.tec9_flash_out));

        armasPrisma.add(new Arma("Shadow Daggers","Slaughter","De aspecto encubierto",109.26,R.drawable.shadow_daggers_slaughter));
        armasPrisma.add(new Arma("M4A4","The Emperor","De aspecto encubierto",149.83,R.drawable.m4a4_the_emperor));
        armasPrisma.add(new Arma("Five-Seven","Angry Mob","De aspecto encubierto",12.04,R.drawable.five_seven_angry_mob));
        armasPrisma.add(new Arma("AUG","Momentum","De tipo clasificado",22.77,R.drawable.aug_momentum));
        armasPrisma.add(new Arma("XM1014","Incinegator","De tipo clasificado",9.06,R.drawable.xm1014_incinegator));
        armasPrisma.add(new Arma("R8-Revolver","Skull Crusher","De tipo clasificado",1.84,R.drawable.revolver_skull_crusher));
        armasPrisma.add(new Arma("AWP","Atheris","De tipo restringido",12.18,R.drawable.awp_atheris));
        armasPrisma.add(new Arma("Desert Eagle","Light Rail","De tipo restringido",3.54,R.drawable.desert_eagle_light_rail));
        armasPrisma.add(new Arma("UMP-45","Moonrise","De tipo restringido",0.87,R.drawable.ump_moonrise));
        armasPrisma.add(new Arma("MP5-SD","Gauss","De tipo restringido",1.01,R.drawable.mp5_gauss));
        armasPrisma.add(new Arma("Tec-9","Bamboozle","De tipo restringido",1.01,R.drawable.tec9_bamboozle));
        armasPrisma.add(new Arma("AK-47","Uncharted","De grado militar",1.47,R.drawable.ak47_uncharted));
        armasPrisma.add(new Arma("P90","Off World","De grado militar",0.41,R.drawable.p90_off_world));
        armasPrisma.add(new Arma("P250","Verdigris","De grado militar",0.46,R.drawable.p250_verdigris));
        armasPrisma.add(new Arma("MAC-10","Whitefish","De grado militar",0.47,R.drawable.mac10_whitefish));
        armasPrisma.add(new Arma("Galil AR","Akoben","De grado militar",0.41,R.drawable.galil_akoben));
        armasPrisma.add(new Arma("FAMAS","Crypsis","De grado militar",0.44,R.drawable.famas_crypsis));
        armasPrisma.add(new Arma("MP7","Mischief","De grado militar",0.34,R.drawable.mp7_mischief));

        armasDangerZone.add(new Arma("Huntsman Knife","Tiger Tooth","De aspecto encubierto",194.79,R.drawable.huntsman_knife_tiger_tooth));
        armasDangerZone.add(new Arma("AWP","Wildfire","De aspecto encubierto",0.0,R.drawable.awp_wildfire));
        armasDangerZone.add(new Arma("AK-47","Asiimov","De aspecto encubierto",145.29,R.drawable.ak47_asiimov));
        armasDangerZone.add(new Arma("AWP","Neo-Noir","De aspecto encubierto",54.82,R.drawable.awp_neo_noir));
        armasDangerZone.add(new Arma("Desert Eagle","Mecha Industries","De tipo clasificado",8.68,R.drawable.desert_eagle_mecha_industries));
        armasDangerZone.add(new Arma("MP5-SD","Phosphor","De tipo clasificado",7.94,R.drawable.mp5_phosphor));
        armasDangerZone.add(new Arma("UMP-45","Momentum","De tipo clasificado",7.94,R.drawable.ump_momentum));
        armasDangerZone.add(new Arma("USP-S","Flashback","De tipo restringido",1.40,R.drawable.usp_flashback));
        armasDangerZone.add(new Arma("P250","Nevermore","De tipo restringido",1.05,R.drawable.p250_nevermore));
        armasDangerZone.add(new Arma("Galil AR","Signal","De tipo restringido",1.00,R.drawable.galil_signal));
        armasDangerZone.add(new Arma("MAC-10","Pipe Down","De tipo restringido",1.34,R.drawable.mac10_pipe_down));
        armasDangerZone.add(new Arma("G3SG1","Scavenger","De tipo restringido",0.98,R.drawable.g3sg1_scavenger));
        armasDangerZone.add(new Arma("M4A4","Magnesium","De grado militar",1.84,R.drawable.m4a4_magnesium));
        armasDangerZone.add(new Arma("SG 553","Danger Close","De grado militar",0.57,R.drawable.sg553_danger_close));
        armasDangerZone.add(new Arma("Glock-18","Oxide Blaze","De grado militar",0.34,R.drawable.glock_oxide_blaze));
        armasDangerZone.add(new Arma("Tec-9","Fubar","De grado militar",0.70,R.drawable.tec9_fubar));
        armasDangerZone.add(new Arma("MP9","Modest Threat","De grado militar",0.20,R.drawable.mp9_modest_threat));
        armasDangerZone.add(new Arma("Sawed-Off","Black-Sand","De grado militar",0.25,R.drawable.sawed_off_black_sand));
        armasDangerZone.add(new Arma("Nova","Wood Fired","De grado militar",0.22,R.drawable.nova_wood_fired));

        armasHorizon.add(new Arma("Stilleto Knife","Fade","De aspecto encubierto",275.17,R.drawable.stiletto_knife_fade));
        armasHorizon.add(new Arma("AK-47","Neon Rider","De aspecto encubierto",81.59,R.drawable.ak47_neon_rider));
        armasHorizon.add(new Arma("Desert Eagle","Code Red","De aspecto encubierto",52.95,R.drawable.desert_eagle_code_red));
        armasHorizon.add(new Arma("M4A1-S","Nightmare","De tipo clasificado",18.94,R.drawable.m4a1_nightmare));
        armasHorizon.add(new Arma("Sawed-Off","Devourer","De tipo clasificado",6.30,R.drawable.sawed_off_devourer));
        armasHorizon.add(new Arma("FAMAS","Eye of Athena","De tipo clasificado",6.76,R.drawable.famas_eye_of_athena));
        armasHorizon.add(new Arma("AWP","PAW","De tipo restringido",3.87,R.drawable.awp_paw));
        armasHorizon.add(new Arma("CZ75-Auto","Eco","De tipo restringido",2.12,R.drawable.cz75_eco));
        armasHorizon.add(new Arma("MP7","Powercore","De tipo restringido",1.32,R.drawable.mp7_powercore));
        armasHorizon.add(new Arma("Nova","Toy Soldier","De tipo restringido",1.47,R.drawable.nova_toy_soldier));
        armasHorizon.add(new Arma("G3SG1","High Seas","De tipo restringido",1.08,R.drawable.g3sg1_high_seas));
        armasHorizon.add(new Arma("Glock-18","Warhawk","De grado militar",0.59,R.drawable.glock_warhawk));
        armasHorizon.add(new Arma("P90","Traction","De grado militar",0.67,R.drawable.p90_traction));
        armasHorizon.add(new Arma("AUG","Amber SlipStream","De grado militar",0.23,R.drawable.aug_amber_slipstream));
        armasHorizon.add(new Arma("MP9","Capillary","De grado militar",0.27,R.drawable.mp9_capillary));
        armasHorizon.add(new Arma("Tec-9","Snek-9","De grado militar",0.27,R.drawable.tec9_snek9));
        armasHorizon.add(new Arma("R8 Revolver","Survivalist","De grado militar",0.22,R.drawable.revolver_survivalist));
        armasHorizon.add(new Arma("Dual Berettas","Shred","De grado militar",0.22,R.drawable.dual_berettas_shred));

        armasClutch.add(new Arma("Skeleton Knife","Slaughter","De aspecto encubierto",1378.49,R.drawable.skeleton_knife_slaughter));
        armasClutch.add(new Arma("M4A4","Neo-Noir","De aspecto encubierto",107.10,R.drawable.m4a4_neo_noir));
        armasClutch.add(new Arma("MP7","Bloodsport","De aspecto encubierto",6.78,R.drawable.mp7_bloodsport));
        armasClutch.add(new Arma("USP-S","Cortex","De tipo clasificado",16.97,R.drawable.usp_cortex));
        armasClutch.add(new Arma("AWP","Mortis","De tipo clasificado",7.05,R.drawable.awp_mortis));
        armasClutch.add(new Arma("AUG","Stymphalian","De tipo clasificado",5.49,R.drawable.aug_stymphalian));
        armasClutch.add(new Arma("Glock-18","Moonrise","De tipo restringido",1.49,R.drawable.glock_moonrise));
        armasClutch.add(new Arma("UMP-45","Artic Wolf","De tipo restringido",1.53,R.drawable.ump_arctic_wolf));
        armasClutch.add(new Arma("MAG-7","SWAG-7","De tipo restringido",1.45,R.drawable.mag7_swag7));
        armasClutch.add(new Arma("Nova","Wild Six","De tipo restringido",1.06,R.drawable.nova_wild_six));
        armasClutch.add(new Arma("Negev","Lionfish","De tipo restringido",1.07,R.drawable.negev_lionfish));
        armasClutch.add(new Arma("SG553","Aloha","De grado militar",0.34,R.drawable.sg553_aloha));
        armasClutch.add(new Arma("R8 Revolver","Grip","De grado militar",0.27,R.drawable.revolver_grip));
        armasClutch.add(new Arma("Five-Seven","Flame Test","De grado militar",0.18,R.drawable.five_seven_flame_test));
        armasClutch.add(new Arma("P200","Urban-Hazard","De grado militar",0.21,R.drawable.p2000_urban_hazard));
        armasClutch.add(new Arma("MP9","Black Sand","De grado militar",0.23,R.drawable.mp9_black_sand));
        armasClutch.add(new Arma("PP-Bizon","Night Riot","De grado militar",0.20,R.drawable.pp_bizon_night_riot));
        armasClutch.add(new Arma("XM1014","Oxide Blaze","De grado militar",0.18,R.drawable.xm1014_oxide_blaze));

        cajas = new ArrayList<Caja>();
        cajaShatteredWeb = new Caja("Caja de Shattered Web", 3.33,armasShattered,R.drawable.case_shattered_web);
        cajaCs20 = new Caja("Caja CS20", 2.66,armasCs20,R.drawable.case_cs20);
        cajaPrisma = new Caja("Caja Prisma", 2.54,armasPrisma,R.drawable.case_prisma);
        cajaDangerZone = new Caja("Caja Danger Zone", 2.54,armasDangerZone,R.drawable.case_danger_zone);
        cajaHorizon = new Caja("Caja Horizon", 2.52,armasHorizon,R.drawable.case_horizon);
        cajaClutch = new Caja("Caja Clutch", 2.53,armasClutch,R.drawable.case_clutch);

        cajas.add(cajaShatteredWeb);
        cajas.add(cajaCs20);
        cajas.add(cajaClutch);
        cajas.add(cajaHorizon);
        cajas.add(cajaDangerZone);
        cajas.add(cajaPrisma);



        CaseListAdapter caseAdapter = new CaseListAdapter(this,cajas);
        caseAdapter.recibirUsuario(user);
        grid.setAdapter(caseAdapter);



    }

    public void PantallaInventario(View view) {
        Intent it = new Intent(this,PantallaInventario.class);
        Bundle b2 = new Bundle();
        b2.putSerializable("item", user);
        it.putExtras(b2);
        startActivity(it);
    }

    public void Preferencias(View view) {
        Intent it = new Intent(this,SettingsActivity.class);
        startActivity(it);
    }

}
