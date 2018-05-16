package com.tqc.gdd01;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hippo on 2015/8/17.
 */
public class DetailFragment extends Fragment
{
  public static boolean bIfDebug = false;
  public static String TAG = "HIPPO_DEBUG";
  private String mText = "";
  private View rootView;

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
    if (container == null)
    {
      return null;
    }
    rootView = inflater.inflate(R.layout.detail_view, container, false);
    ViewGroup p = (ViewGroup) rootView.getParent();
    if(p!=null)
    {
      p.removeAllViewsInLayout();
    }
    return rootView;
    //return super.onCreateView(inflater, container, savedInstanceState);
  }

  public void setDavidContent(String strText)
  {
    mText = strText;
  }

  public void updateDavidContent(String strText)
  {
    mText = strText;
    if(rootView!=null)
    {
      TextView mTextView01 = (TextView) rootView.findViewById(R.id.detail_view_textView2);
      mTextView01.setText(mText);
    }
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState)
  {
    super.onActivityCreated(savedInstanceState);
    if (savedInstanceState != null)
    {
      mText = savedInstanceState.getString(Constants.EXTRA_KEY_BUTTON_EVENT, "");
    }
    if(!mText.trim().equalsIgnoreCase("") && rootView!=null)
    {
      TextView mTextView01 = (TextView) rootView.findViewById(R.id.detail_view_textView2);
      mTextView01.setText(mText.trim());
    }
  }

  @Override
  public void onSaveInstanceState(Bundle outState)
  {
    super.onSaveInstanceState(outState);
    outState.putString(Constants.EXTRA_KEY_BUTTON_EVENT, mText);
  }

  @Override
  public void onAttach(Context context)
  {
    super.onAttach(context);
  }
}
