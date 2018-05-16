package com.tqc.gdd01;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class GDD01 extends Activity
{

  public static boolean bIfDebug = false;
  public static String TAG = "HIPPO_DEBUG";
  boolean detailPage = false;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    if(savedInstanceState == null)
    {
      FragmentTransaction ft = getFragmentManager().beginTransaction();
      ListFragment listFragment = new ListFragment();
      ft.add(R.id.displayList, listFragment, "List_Fragment");
      ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
      ft.commit();
    }

    if(findViewById(R.id.displayDetail) != null)
    {
      // Landscape
      detailPage = true;
      getFragmentManager().popBackStack();

      // 主程式setContentView()之後，判斷橫式UI中ID為displayDetail的FrameLayout是否存在，置換不同的Fragment於其中
      DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.displayDetail);
      if(detailFragment == null)
      {
        // TO DO

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        detailFragment = new DetailFragment();
        ft.replace(R.id.displayDetail, detailFragment, "Detail_Fragment");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
      }
    }
  }

  public void onButtonClicked(String strText)
  {
    //  依據直式或橫式按鈕事件也不同，請為直式切換頁面Fragment，而橫式為置換右方FrameLayout。
    if(detailPage)
    {
      // Landscape
      //TO DO
      DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.displayDetail);
      detailFragment.updateDavidContent(strText);
    }
    else
    {
      FragmentTransaction ft = getFragmentManager().beginTransaction();
      DetailFragment detailFragment = new DetailFragment();
      detailFragment.setDavidContent(strText);
      ft.replace(R.id.displayList, detailFragment, "Detal_Fragment2");
      ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
      ft.addToBackStack(null);
      ft.commit();
    }
  }
}
