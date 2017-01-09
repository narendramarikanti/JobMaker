package com.nsds.jobmaker.activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsds.jobmaker.R;
import com.nsds.jobmaker.adapter.ViewPagerAdapter;
import com.nsds.jobmaker.callback.ChangeTab;
import com.nsds.jobmaker.fragments.Recent_Updates;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ChangeTab {

    private Activity mActivity;
    private int pos;
    public Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    NavigationView navigationView;
    private int[] tabIcons = {
            R.mipmap.recent_red1,
            R.mipmap.industries_red1,
            R.mipmap.maps_red1
    };
    private int[] utabIcons = {
            R.mipmap.recent_black1,
            R.mipmap.industries_black1,
            R.mipmap.maps_black1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        //set toolbar

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        fillWithTestData();

        // set view pager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        //set tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons(0);



        // call when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pos = tab.getPosition();
                viewPager.setCurrentItem(pos);
                View view = (View) tabLayout.getTabAt(pos).getCustomView();
                // set tabs text color and icon red
                ((TextView) view.findViewById(R.id.tv_tab)).setTextColor(getResources().getColor(R.color.forgot_password));
                ((ImageView) view.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(tabIcons[pos]));
                tabLayout.getTabAt(pos).setCustomView(view);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // set tabs text color and icon red
                View view = (View) tabLayout.getTabAt(pos).getCustomView();
                ((TextView) view.findViewById(R.id.tv_tab)).setTextColor(getResources().getColor(R.color.textColorTab));
                ((ImageView) view.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(utabIcons[pos]));
                tabLayout.getTabAt(pos).setCustomView(view);

//
//                switch (tab.getPosition()) {
//                    case 1:
//                        feeds_menu.setVisibility(View.GONE);
//                        break;
//                    case 2:
//                        feeds_menu.setVisibility(View.GONE);
//                        break;
//                }


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                if (pos == 0) {

                }

            }
        });


    }

    // this method set swipe function in this activity
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Recent_Updates(), "ONE");
        adapter.addFragment(new Recent_Updates(), "TWO");
        adapter.addFragment(new Recent_Updates(), "THREE");

        viewPager.setAdapter(adapter);
    }

    // set custom tabs
    private void setupTabIcons(int pos) {

        View tabOne = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        ((TextView) tabOne.findViewById(R.id.tv_tab)).setText(getString(R.string.feeds));
        ((ImageView) tabOne.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(R.mipmap.recent_black1));
        tabLayout.getTabAt(0).setCustomView(tabOne);

        View tabTwo = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        ((TextView) tabTwo.findViewById(R.id.tv_tab)).setText(getString(R.string.search));
        ((ImageView) tabTwo.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(R.mipmap.industries_black1));
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        View tabThree = (View) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        ((TextView) tabThree.findViewById(R.id.tv_tab)).setText(getString(R.string.activities));
        ((ImageView) tabThree.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(R.mipmap.maps_black1));
        tabLayout.getTabAt(2).setCustomView(tabThree);


        View view = (View) tabLayout.getTabAt(pos).getCustomView();
        ((TextView) view.findViewById(R.id.tv_tab)).setTextColor(getResources().getColor(R.color.forgot_password));
        ((ImageView) view.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(tabIcons[pos]));
        tabLayout.getTabAt(pos).setCustomView(view);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


//        final android.app.Dialog mDialog = MyDialog.appExitDialog("Are you sure you want to exit?", mActivity);
//        ((CustomTextView) mDialog.findViewById(R.id.yes)).setText("Yes");
//        ((CustomTextView) mDialog.findViewById(R.id.no)).setText("No");
//        (mDialog.findViewById(R.id.yes)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
//                startActivity(intent);
//                finish();
//                System.exit(0);
//
//            }
//        });
//
//        (mDialog.findViewById(R.id.no)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDialog.dismiss();
//            }
//        });

    }


    @Override
    public void changeTabPosition(int position) {
        //un-select previous tab
        View mView = tabLayout.getTabAt(pos).getCustomView();
        ((TextView) mView.findViewById(R.id.tv_tab)).setTextColor(getResources().getColor(R.color.textColorTab));
        ((ImageView) mView.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(utabIcons[pos]));
        tabLayout.getTabAt(pos).setCustomView(mView);

        //Select tab on provided position
        viewPager.setCurrentItem(position);
        View view = tabLayout.getTabAt(position).getCustomView();
        ((TextView) view.findViewById(R.id.tv_tab)).setTextColor(getResources().getColor(R.color.forgot_password));
        ((ImageView) view.findViewById(R.id.img_tab)).setImageDrawable(getResources().getDrawable(tabIcons[position]));
        tabLayout.getTabAt(position).setCustomView(view);

    }

    public void fillWithTestData() {


        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
////        ImageView activie_depentdent = (ImageView)header.findViewById(R.id.activie_dependent);
////        Button profile_edit       = (Button) header.findViewById(R.id.editbutton);
////        final CustomLayout headerView = (CustomLayout) header.findViewById(R.id.headerview);
////        final TextView firstname = (TextView) header.findViewById(R.id.navtextview);
////        final CircleImageView profile_image   = (CircleImageView) header.findViewById(R.id.profile_image);
//        dependent_recyclewView = (HorizontalListView) header.findViewById(R.id.dependent_recyclewView);
//        if (Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//        setListViewAdapter();
//        activie_depentdent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActiveDepentdentDialog();
//            }
//        });


        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
//                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


            }



        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });




        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(false);



    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        if (id==R.id.logout)
        {

        }

//        if (id == R.id.friends_nav) {
//
//            Intent i = new Intent(HomeScreen.this, kamptive.com.kamptive.activity.Friends.class);
//            startActivity(i);
//            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
//            finish();
//
//
//            // fragmentClass = Friends.class;
////         FriendsDialog();
////            navigationView.getMenu().getItem(0).setChecked(true);
//
////            Intent i =new Intent(HomeScreen.this, Add_Child.class);
////            startActivity(i);
//        }
//        else if (id == R.id.notification_nav) {
////             fragmentClass = Notification.class;
//            //  NotificationDialog();
//            Intent i = new Intent(HomeScreen.this, kamptive.com.kamptive.activity.Notification.class);
//            startActivity(i);
//            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
//            finish();
//            //    navigationView.getMenu().getItem(1).setChecked(true);
//
//
//        } else if (id == R.id.polling_summary_nav) {
//
//            Intent i = new Intent(HomeScreen.this, kamptive.com.kamptive.activity.Poll_Summary.class);
//            startActivity(i);
//            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
//            finish();
//
////             fragmentClass = Poll_Summary.class;
////          PollingSummaryDialog();
////            navigationView.getMenu().getItem(2).setChecked(true);
//        }
//        else if (id == R.id.logout)
//        {
//            final android.app.Dialog mDialog = MyDialog.logout("Are you sure you want to Logout?", HomeScreen.this);
//
//            (mDialog.findViewById(R.id.yes)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Logout(Utility.getSharedPreferences(HomeScreen.this,Constants.TOKEN_ID),Utility.getSharedPreferences(HomeScreen.this,Constants.CUSTOMER_ID),Constants.AXIS_API_logout);
//                    mDialog.dismiss();
//                }
//            });
//
//            (mDialog.findViewById(R.id.no)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mDialog.dismiss();
//                }
//            });
//
//
//
//        }
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.flContent, fragment)
//                .addToBackStack(null).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }
//


}
