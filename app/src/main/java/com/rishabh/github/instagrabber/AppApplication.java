package com.rishabh.github.instagrabber;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;

/**
 * Created by rishabh on 9/3/17.
 */

public class AppApplication extends Application {
  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
    
  }
}
