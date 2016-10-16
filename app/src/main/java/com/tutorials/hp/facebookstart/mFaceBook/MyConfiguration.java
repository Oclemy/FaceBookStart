package com.tutorials.hp.facebookstart.mFaceBook;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebookConfiguration;

/**
 * Created by Oclemmy on 5/3/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class MyConfiguration {

    Permission[] permissions=new Permission[]{Permission.EMAIL};
    static final String APP_ID="738596112948695";

    public SimpleFacebookConfiguration getMyConfigs()
    {
        SimpleFacebookConfiguration configs=new SimpleFacebookConfiguration.Builder()
                .setAppId(APP_ID)
                .setNamespace("facebookstart")
                .setPermissions(permissions)
                .build();

        return configs;
    }


}
