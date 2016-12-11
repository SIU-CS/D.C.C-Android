package com.example.chris.studygroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static Intent Login,Group,Calendar,Profile,Search;

    public static GroupTree tree;//main tree
    public static UserProfile user;
    public static String[] subjects;
    public static LinkedList currentGrp;

    Button butFind,remOne,remTwo,remThree,remFour,remFive;
    Button[] remove;
    EditText txtSearch;
    TextView itemOne,itemTwo,itemThree,itemFour,itemFive,itemSix;
    TextView[] groupList;
    GenData[] groups;

    FloatingActionButton butSearch, butHome, butAdd, butPro, butCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        remove = new Button[5];
        groupList= new TextView[5];

        butHome = (FloatingActionButton) findViewById(R.id.butHome);
        butSearch = (FloatingActionButton) findViewById(R.id.butSearch);
        butAdd = (FloatingActionButton) findViewById(R.id.butAdd);
        butPro = (FloatingActionButton) findViewById(R.id.butPro);
        butCal = (FloatingActionButton) findViewById(R.id.butCal);

        butFind = (Button) findViewById(R.id.butFind0);
        txtSearch = (EditText) findViewById(R.id.txtSearch0);

        itemOne =(TextView) findViewById(R.id.itemOne0);
        itemTwo =(TextView) findViewById(R.id.itemTwo0);
        itemThree =(TextView) findViewById(R.id.itemThree0);
        itemFour =(TextView) findViewById(R.id.itemFour0);
        itemFive =(TextView) findViewById(R.id.itemFive0);

        remOne = (Button) findViewById(R.id.remOne);
        remTwo = (Button) findViewById(R.id.remtwo);
        remThree = (Button) findViewById(R.id.remThree);
        remFour = (Button) findViewById(R.id.remFour);
        remFive = (Button) findViewById(R.id.remFive);

        butHome.setOnClickListener(this);
        butSearch.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butPro.setOnClickListener(this);
        butCal.setOnClickListener(this);

        butFind.setOnClickListener(this);

        remOne.setOnClickListener(this);
        remTwo.setOnClickListener(this);
        remThree.setOnClickListener(this);
        remFour.setOnClickListener(this);
        remFive.setOnClickListener(this);

        remOne.setVisibility(View.INVISIBLE);
        remTwo.setVisibility(View.INVISIBLE);
        remThree.setVisibility(View.INVISIBLE);
        remFour.setVisibility(View.INVISIBLE);
        remFive.setVisibility(View.INVISIBLE);

        groupList[0]=itemOne;
        groupList[1]=itemTwo;
        groupList[2]=itemThree;
        groupList[3]=itemFour;
        groupList[4]=itemFive;

        remove[0]=remOne;
        remove[1]=remTwo;
        remove[2]=remThree;
        remove[3]=remFour;
        remove[4]=remFive;


        groups= new LinkedList[]{};
        user= new UserProfile("guest","guest@siu.edu","password"); ///will change to get user from login screen.

        tree = new GroupTree();
        subjects= new String[]{"ACCOUNTING", "ADVANCED ENERGY & FUELS MGMT", "AEROSPACE STUDIES", "AFRICANA STUDIES", "AGRIBUSINESS ECONOMICS",
                "ARGRICULTURAL SCIENCES", "AGRICULTURAL SYSTEMS & EDUCAT.", "AGRICULTURE", "ALLIED HEALTH", "ANIMAL SCIENCE", "ANTHROPOLOGY",
                "ARCHITECTURAL STUDIES", "ARMY MILITARY SCIENCE", "ART AND DESIGN", "AUTOMOTIVE TECHNOLOGY", "AVIATION FLIGHT", "AVIATION MANAGEMENT", "AVIATION TECHNOLOGIES",
                "BEHAVIOR ANALYSIS AND THERAPY", "BIOCHEMISTRY", "BIOLOGY", "BIOMEDICAL ENGINEERING", "BUSINESS", "BUSINESS ADMINISTRATION", "CHEMISTRY AND BIOCHEMISTRY", "CHINESE",
                "CINEMA AND PHOTOGRAPHY", "CIVIL ENGINEERING", "CLASSICS", "COMMUNICATION DISORDERS & SCI.", "COMMUNICATION STUDIES",
                "COMPUTER SCIENCE", "COUNSELING", "CRIMINOLOGY & CRIMINAL JUSTICE", "CROP, SOIL, ENVIRONMENTAL MGMT", "CURRICULUM AND INSTRUCTION",
                "DENTAL HYGIENE", "EAST ASIA", "ECONOMICS", "EDU. ADMIN. & HIGHER EDUC.", "EDUCATION",
                "ELECTRICAL & COMPUTER ENGINEERING", "ELECTRONIC SYSTEMS TECHNOLGIES", "ENGINEERING", "ENGINEERING TECHNOLOGY", "ENGLISH",
                "ENVIRONMENTAL RESOURCES & POLICY", "FASHION DESIGN & MERCHANDISING", "FERMENTATION SCIENCE", "FINANCE", "FIRE SCIENCE MANAGEMENT", "FOOD & NUTRITION", "FOREIGN LANGUAGES",
                "FORESTRY", "FRENCH", "GEOGRAPHY", "GEOLOGY", "GERMAN", "GERONTOLOGY", "HEALTH ADMINISTRATION", "HEALTH CARE MANAGEMENT", "HEALTH EDUCATION", "HEALTH INFORMATICS",
                "HISTORY", "HISOTECHNOLOGY", "HORTICULTURE", "HOSPITALITY & TOURISM ADMINISTRATION", "HUMAN NUTRITION & DIETETICS",
                "INDUSTRIAL MANAGEMENT & APPLIED ENGINEERING", "INFORMATION SYSTEMS & APPLIED TECHNOLOGY",
                "JOURNALISM", "KINESIOLOGY", "LIBERAL ARTS", "LINGUISTICS", "MANAGEMENT", "MARKETING", "MASS COMMUNICATION & MEDIA ARTS",
                "MATHEMATICS", "MECHANICAL ENGINEERING", "MEDICAL EDUCATION PREPARATION", "MICROBIOLOGY", "MINING ENGINEERING", "MOLECULAR BIOLOGY, MICRO BIOCHEMISTRY",
                "MORTUARY SCIENCE & FUNERAL SERVICE", "MUSIC", "PARALEGAL STUDIES, LEGAL ASSISTANCE", "PHARMACOLOGY", "PHILOSOPHY",
                "PHYSICAL THERAPIST ASSISTANT", "PHYSICIAN ASSISTANT", "PHYSICS", "PHYSIOLOGY", "PLANT BIOLOGY", "PLANT, SOIL, & AGRICULTURAL SYSTEMS", "POLITICAL SCIENCE",
                "PSYCHOLOGY", "QUANTITATIVE METHODS", "RADIO, TV, AND DIGITAL MEDIA", "RADIOLOGIC SCIENCES", "RECREATION", "REHABILITATION", "SCHOOL OF MEDICINE", "SOCIAL WORK", "SOCIOLOGY", "SPANISH",
                "SPECIAL EDUCATION", "TECHNICAL & RESOURCE MANAGEMENT", "THEATER", "UNIVERSITY HONORS", "WOMEN, GENDER, & SEX. STUDIES", "WORKFORCE EDUCATION. & DEVELOPMENT", "ZOOLOGY"};
        tree.addSubArr(subjects);




        Group = new Intent(this, Group.class);
        Calendar = new Intent(this, Calendar.class);
        Profile = new Intent(this, Profile.class);
        Search = new Intent(this, Search.class);

        Login = new Intent(this, LoginScreen.class);
        startActivity(Login);
        updateList();


//-----------------------------------------------------------------------------------------------------------------------------------+
//                Test for Linked List                                                                                               |
//-----------------------------------------------------------------------------------------------------------------------------------+




        GenData chris, demarco,colten;




        chris=new UserProfile("Chris","ckyser2@gmail.com","password");

        demarco=new UserProfile("Demarco","demarco2@gmail.com","password");

        colten=new UserProfile("Colten","colten@gmail.com","password");



        System.out.println(tree.toString());
        chris.createGroup("group","ACCOUNTING");
        chris.createGroup("test","ACCOUNTING");
        tree.addUser(chris,"group");
        tree.addUser(demarco,"group");
        tree.addUser(colten,"group");
        System.out.println(tree.toString());
        GenData group =tree.getGroup("group");




//-----------------------------------------------------------------------------------------------------------------------------------+
//                Test for Queue                                                                                             |
//-----------------------------------------------------------------------------------------------------------------------------------+

        Message a = new Message("test","this is a test meassg1e");
        Message b = new Message("test","this is a test meassge2");

        Message c = new Message("test","this is a test meassge3");
        Message d = new Message("test","this is a test meassge4");
        Message e = new Message("test","this is a test meassge5");
        Message f = new Message("test","this is a test meassge6");
        Message g = new Message("test","this is a test meassge7");
        Message h = new Message("test","this is a test meassge8");
        Message i = new Message("test","this is a test meassge9");

        Queue q = new Queue(5);
        q.push(a);
        q.push(b);
        q.push(c);
        System.out.println(q.toString());
        q.push(d);
        q.push(e);
        q.push(f);
        System.out.println(q.toString());
        q.push(g);
        q.push(h);
        q.push(i);

        System.out.println(q.toString());


    }

//-----------------------------------------------------------------------------------------------------------------------------------+
//                Button Handler                                                                                                     |
//-----------------------------------------------------------------------------------------------------------------------------------+

    @Override
    public void onClick(View v) {
        if( v ==butHome){

        }
        else if( v==butSearch){
            startActivity(Search);
        }
        else if(v==butAdd){
            startActivity(Group);
        }
        else if ( v==butPro){
            startActivity(Profile);
        }
        else if (v == butCal) {
            startActivity(Calendar);
        }
        else if (v == butFind){
            updateList();
        }
        else if(v == remOne){

            tree.removeGroup(groups[0].getId());
            user.removeGroup(groups[0].getId());
            updateList();

        }
        else if(v == remTwo){
            tree.removeGroup(groups[1].getId());
            user.removeGroup(groups[1].getId());
            updateList();

        }
        else if(v == remThree){
            tree.removeGroup(groups[2].getId());
            user.removeGroup(groups[2].getId());
            updateList();
        }
        else if(v == remFour){
            tree.removeGroup(groups[3].getId());
            user.removeGroup(groups[3].getId());
            updateList();
        }
        else if(v == remFive){
            tree.removeGroup(groups[4].getId());
            user.removeGroup(groups[4].getId());
            updateList();
        }

        }
    public void updateList(){
        if(user.getCreatedGroups().getLength()!=0) groups=user.getCreatedGroups().toArr();



        for(int x=0;x<groups.length&&x<4;x++){
            groupList[x].setText(" ");
            remove[x].setVisibility(View.INVISIBLE);
            if(groups[x]!=null){
                groupList[x].setText(" "+groups[x].toString());
                remove[x].setVisibility(View.VISIBLE);

            }

        }
    }

}
