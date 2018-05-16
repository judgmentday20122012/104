package com.tqc.gdd01;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Hippo on 2015/8/17.
 */
public class ListFragment extends Fragment {
  public static boolean bIfDebug = false;
  public static String TAG = "HIPPO_DEBUG";
  public static GDD01 activity;

  private Button mButton01, mButton02;
  private View rootView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //呼叫 getActivity() 進行初始化
    activity=(GDD01)getActivity();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (container == null) {
      return null;
    }
    rootView = inflater.inflate(R.layout.list_view, container, false);
    ViewGroup p = (ViewGroup) rootView.getParent();
    if (p != null) {
      p.removeAllViewsInLayout();
    }
    return rootView;
    //return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mButton01 = (Button) rootView.findViewById(R.id.list_view_button1);
    mButton02 = (Button) rootView.findViewById(R.id.list_view_button2);
    mButton01.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        ListFragment.this.activity.onButtonClicked(getString(R.string.detail_body1));
      }
    });
    mButton02.setOnClickListener(new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        ListFragment.this.activity.onButtonClicked(getString(R.string.detail_body2));
      }
    });
  }
}